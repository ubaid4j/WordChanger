package com.ubaid.app;

public class App
{
	public static void main(String [] args)
	{
		System.out.println("Will start soon");		
		App app = new App();
		app.app(args);
	}
	
	private void app(String[] commands)
	{
		int dir1 = find(commands, "-d");
		int old1 = find(commands, "-o");
		int new1 = find(commands, "-n");

		String dir = commands[dir1 + 1];
		String old = commands[old1 + 1];
		String newW = commands[new1 + 1];
		
		if(!dir.equals(null) && !old.equals(null) && !newW.equals(null))
		{
			System.out.println(dir);
			System.out.println(old);
			System.out.println(newW);
		}
		else
		{
			System.out.println("use to following command");
			System.out.println("java -jar WordChanger-1.jar -d '/path/to/folder/' -o 'oldWord' -n 'NewWord'");
		}
		
	}
	
	private int find(String[] args, String command)
	{
		int index = 0;
		for(String com : args)
		{
			++index;
			if(com.equals(command))
				return index;
		}
		
		return -1;
	}
}
