package com.ubaid.app.doa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.springframework.stereotype.Repository;

/**
 * This class help the File_DAO to change the content of file
 * @author UbaidurRehman
 *
 */
@Repository
public class Helper
{
	int change(String oldWord, String newWord, File file) throws Exception
	{
		//for result if old word match then found will greater than 0
		int found = -1;
		int lineNumber = 0;
		//creating temp file for holding being processed file contents
		File tempFile = new File(file.getParent() + "/temp.sh");
		
		/**
		 * ----------------------I don't Know What happened here---------------------------------
		 * 
		 * The files which are tempFile and actual file are not existed. As File~file is being
		 * extracted from the list of its parent directory. Its strange 
		 * 
		 * The extracted path from the directory is path/to /file.sh
		 * 
		 * --------------------------------------------------------------------------------------
		 */
		
		//checking if files are existed else correcting their path
		boolean tempFileExistance = tempFile.exists();
		if(!tempFileExistance)
			tempFile = change(tempFile);
		tempFile.createNewFile();
		boolean existance = file.exists();
		if(!existance)
			file = change(file);

		//creating reader and writer
		FileReader fileReader = new FileReader(file.getAbsolutePath());
		FileWriter fileWriter = new FileWriter(tempFile);
		BufferedReader reader = new BufferedReader(fileReader);
		BufferedWriter writer = new BufferedWriter(fileWriter);

		//reading line
		String line = reader.readLine();
		lineNumber++;
		
		//loop where each line is inserted in writer from reader
		while(line != null)
		{
			//if match then modifying line and
			if(line.contains(oldWord))
			{
				line = line.replace(oldWord, newWord);
				found = lineNumber;
			}										
			writer.append(line + "\r\n");
			line = reader.readLine();
			lineNumber++;
		}
		
		//flushing & closing
		writer.flush();
		reader.close();
		writer.close();

		//delete the previous file 
		file.delete();
		
		//create the new file
		tempFile.renameTo(file);
		return found;
	}

	/**
	 * correcting the path
	 * @param file
	 * @return file
	 */
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
