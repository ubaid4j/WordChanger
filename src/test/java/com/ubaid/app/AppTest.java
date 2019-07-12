package com.ubaid.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.ubaid.app.commandBuilder.Builder;
import com.ubaid.app.commandBuilder.DirectoryParameterBuilder;
import com.ubaid.app.commandBuilder.NewWordParameterBuilder;
import com.ubaid.app.commandBuilder.OldWordParameterBuilder;

@TestInstance(value = Lifecycle.PER_CLASS)
class AppTest
{
	private final int totalCommand = 4;
	private String command1 = "-d /this/path -o gpu = no -n gpu = yes ";
	private String command2 = "-d /this/path -n gpu = yes -o gpu = no";
	private String command3 = "-o gpu = no -n gpu = yes -d /this/path";
	private String command4 = "-o gpu = no -d /this/path -n gpu = yes";
	private String[] commands_arr;
	
	private Builder builder;
	private App app;
	
	@BeforeAll
	public void init()
	{
		app = new App();
	}
	
	@Test
	public void appTest()
	{
		ClassLoader loader = getClass().getClassLoader();
		String dirS = loader.getResource("nnet2").getFile();
		File file = new File(dirS);
		String testCommand = String.format("-d %s -o gpu = no -n gpu=yes",
				file.getAbsolutePath());
		try
		{
			app.app(testCommand.split(" "));
		}
		catch (Exception e)
		{
			fail(e);
		}
	}
	
	@BeforeAll
	void set()
	{
		commands_arr = new String[totalCommand];
		commands_arr[0] = command1;
		commands_arr[1] = command2;
		commands_arr[2] = command3;		
		commands_arr[3] = command4;
		
	}
	

	@Test
	void dirTest()
	{
		builder = new DirectoryParameterBuilder();
		initTest("/this/path");
	}

	@Test
	void newWordTest()
	{
		builder = new NewWordParameterBuilder();
		initTest("gpu = yes");
	}

	@Test
	void oldWordTest()
	{
		builder = new OldWordParameterBuilder();
		initTest("gpu = no");
	}
	
	void initTest(String matchWord)
	{
		for(int i = 0; i < totalCommand; i++)
		{
			String[] args = commands_arr[i].split(" ");
			String result = builder.getParam(args).trim();
			assertEquals(matchWord, result);
		}		
	}

}
