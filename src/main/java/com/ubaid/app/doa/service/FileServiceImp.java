package com.ubaid.app.doa.service;

import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubaid.app.doa.FileDAO;

/**
 * 
 * @author UbaidurRehman
 *
 */
@Service
public class FileServiceImp implements FileService
{

	@Autowired
	private FileDAO fileDAO;
	
	@Override
	public void change(File dir, String oldWord, String newWord) throws Exception
	{
		fileDAO.change(dir, oldWord, newWord);
	}

}
