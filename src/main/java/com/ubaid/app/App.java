package com.ubaid.app;


import java.io.File;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ubaid.app.doa.service.CommandService;
import com.ubaid.app.doa.service.FileService;

public class App
{
	
	

	public static void main(String [] args)
	{

		App app = new App();
		try
		{
			app.app(args);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void runConfig()
	{
		AnnotationConfigApplicationContext context = 
		new AnnotationConfigApplicationContext(Config.class);
		context.close();
	}
	
	public void app(String[] commands) throws Exception
	{
		AnnotationConfigApplicationContext context 
			= new AnnotationConfigApplicationContext(Config.class);
		
		try
		{


			CommandService cSer = context.getBean("commandServiceImp", CommandService.class);
			FileService fileSer = context.getBean("fileServiceImp", FileService.class);
			
			String dir = cSer.getDir(commands);
			String oldWord = cSer.getOldName(commands);
			String newWord = cSer.getNewName(commands);

			File directory = new File(dir);
			if(!directory.exists())
				throw new IllegalArgumentException();
				
			fileSer.change(directory, oldWord, newWord);				
			
		}
		catch(ArrayIndexOutOfBoundsException arrEx)
		{
			System.out.println("Terminated");
			System.out.println("java -jar WordChanger-1.jar -d '/path/to/folder/' -o 'oldWord' -n 'NewWord'");			
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("Not a Directory");
			System.out.println("java -jar WordChanger-1.jar -d '/path/to/folder/' -o 'oldWord' -n 'NewWord'");			
		}
		finally {
			context.close();
		}
		
	}	
	
}
