package com.ubaid.app.doa;


import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ubaid.app.Config;

/**
 * Testing DAO Work
 * @author UbaidurRehman
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
class FileDAOImpTest 
{
	FileDAO fileDAO;
	
	@BeforeAll()
	void before()
	{
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(Config.class);
		fileDAO = context.getBean("fileDAOImp", FileDAO.class);
		context.close();
	}
	
	@Test
	void testChange()
	{
		ClassLoader loader = getClass().getClassLoader();
		String dirS = loader.getResource("nnet2").getFile();
		File file = new File(dirS);
		if(!file.exists())
			fail(file.getAbsolutePath() + " not exists");
		
		try
		{
			fileDAO.change(file, "use_gpu=no", "use_gpu=yes");	
			fileDAO.change(file, "use_gpu= no ", "use_gpu=yes");	
			fileDAO.change(file, "use_gpu=\"no\"", "use_gpu=\"yes\"");
			fileDAO.change(file, "use_gpu = \"no\"", "use_gpu = \"yes\"");
			fileDAO.change(file, "use_gpu = \"no\"", "use_gpu = \"yes\"");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail(e);
		}
	}

}
