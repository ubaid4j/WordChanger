package com.ubaid.app.doa.service;

import java.io.File;
/**
 * 
 * @author UbaidurRehman
 *
 */
public interface FileService
{
	
	/**
	 * change the old words in new words in the given file
	 * @param file
	 * @param oldWord
	 * @param newWord
	 */
	public void change(File dir, String oldWord, String newWord) throws Exception;

}
