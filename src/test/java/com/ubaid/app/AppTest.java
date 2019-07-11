package com.ubaid.app;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
	
	
	void cTest1()
	{
		builder = new DirectoryParameterBuilder();
		assertEquals("/this/path", builder.getParam(command4.split(" ")).trim());
	}
	
	void cTest2()
	{
		builder = new OldWordParameterBuilder();
		assertEquals("gpu = no", builder.getParam(command1.split(" ")).trim());		
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
