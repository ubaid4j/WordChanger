package com.ubaid.app;


import java.io.File;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ubaid.app.doa.service.CommandService;
import com.ubaid.app.doa.service.FileService;

/**
 * This is our main class which initiate the Config class for Configuration and Component Scan
 * @author UbaidurRehman
 *
 */
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
	
	
	/**
	 * main method
	 * @param commands
	 * @throws Exception
	 */
	public void app(String[] commands) throws Exception
	{
		//getting context
		AnnotationConfigApplicationContext context 
			= new AnnotationConfigApplicationContext(Config.class);
		
		try
		{
			//service for getting commands paramters
			CommandService cSer = context.getBean("commandServiceImp", CommandService.class);
			
			//file service which change the word
			FileService fileSer = context.getBean("fileServiceImp", FileService.class);
			
			//getting commands parameters
			String dir = cSer.getDir(commands).trim();
			String oldWord = cSer.getOldName(commands).trim();
			String newWord = cSer.getNewName(commands).trim();

			//checking if the directory exists [provided by the user]
			File directory = new File(dir);
			if(!directory.exists())
				throw new IllegalArgumentException();
				
			//calling method to change the words
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
