package com.ubaid.app;

import java.util.Arrays;
import java.util.StringJoiner;

import com.ubaid.app.commandBuilder.Builder;
import com.ubaid.app.commandBuilder.DirectoryParameterBuilder;
import com.ubaid.app.commandBuilder.NewWordParameterBuilder;
import com.ubaid.app.commandBuilder.OldWordParameterBuilder;

public class App
{
	
	public static void main(String [] args)
	{
		System.out.println("Will start soon");		
		App app = new App();
		app.app(args);
	}
	
	public void app(String[] commands)
	{
		try
		{
			String dir = getDirectory(commands);
			String oldWord = getOldWord(commands);
			String newWord = getNewWord(commands);
			
			System.out.println(dir + "\n"  + oldWord + "\n" + newWord);
			
		}
		catch(ArrayIndexOutOfBoundsException arrEx)
		{
			System.out.println("Terminated");
			System.out.println("java -jar WordChanger-1.jar -d '/path/to/folder/' -o 'oldWord' -n 'NewWord'");			
		}
		
	}	
	
	
	private String getDirectory(String[] args)
	{
		Builder builder = new DirectoryParameterBuilder();
		return builder.getParam(args);
	}
	
	private String getOldWord(String[] args)
	{
		Builder builder = new OldWordParameterBuilder();
		return builder.getParam(args);
	}
	
	private String getNewWord(String[] args)
	{
		Builder builder = new NewWordParameterBuilder();
		return builder.getParam(args);
	}
}
