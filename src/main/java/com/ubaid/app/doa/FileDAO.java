package com.ubaid.app.doa;

import java.io.File;

public interface FileDAO
{
	/**
	 * change the old words in new words in the given file
	 * @param file
	 * @param oldWord
	 * @param newWord
	 */
	public void change(File dir, String oldWord, String newWord) throws Exception;
}
