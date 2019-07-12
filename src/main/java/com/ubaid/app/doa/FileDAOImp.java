package com.ubaid.app.doa;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author UbaidurRehman
 *
 */

@Repository
public class FileDAOImp implements FileDAO
{
	@Autowired
	private Helper helper;
	
	@Override
	public void change(File dir, String oldWord, String newWord) throws Exception
	{
		//get all files in the directory
		File[] files = dir.listFiles();
		
		//read each file line by line 
		for(File file : files)
		{
			helper.change(oldWord, newWord, file);
		}
	}

}
