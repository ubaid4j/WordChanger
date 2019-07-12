package com.ubaid.app.doa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.springframework.stereotype.Repository;

@Repository
public class Helper
{
	int change(String oldWord, String newWord, File file) throws Exception
	{
		int found = -1;
		int lineNumber = 0;
		File tempFile = new File(file.getParent() + "/temp.sh");
		boolean tempFileExistance = tempFile.exists();
		if(!tempFileExistance)
			tempFile = change(tempFile);
		tempFile.createNewFile();
		//when the old word matches then change it newWord
		boolean existance = file.exists();
		if(!existance)
			file = change(file);
		
//		System.out.println("43: " + file.exists());
//		System.out.println("44: " + tempFile.exists());
		FileReader fileReader = new FileReader(file.getAbsolutePath());
		FileWriter fileWriter = new FileWriter(tempFile);
		BufferedReader reader = new BufferedReader(fileReader);
		BufferedWriter writer = new BufferedWriter(fileWriter);
		String line = reader.readLine();
		lineNumber++;
		while(line != null)
		{
			if(line.contains(oldWord))
			{
				line = line.replace(oldWord, newWord);
				found = lineNumber;
			}										
			writer.append(line + "\r\n");
			line = reader.readLine();
			lineNumber++;
		}
		writer.flush();

		reader.close();
		writer.close();

		//delete the previous file 
		file.delete();
		
		//create the new file
		tempFile.renameTo(file);
		return found;
	}

	private File change(File file)
	{
		String[] fileParts = file.getAbsolutePath().split("[\\\\/]");
		String path = "";
		for(String parts : fileParts)
		{
			path += parts.trim() + "/";
		}
		return new File(path);
	}

}
