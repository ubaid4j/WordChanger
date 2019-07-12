package com.ubaid.app.doa.service;

/**
 * 
 * @author UbaidurRehman
 *
 */
public interface CommandService
{
	/**
	 * 
	 * @param args
	 * @return directory from the command
	 */
	public String getDir(String[] args);
	
	/**
	 * 
	 * @param args
	 * @return return old name from the command
	 */
	public String getOldName(String[] args);
	
	
	/**
	 * 
	 * @param args
	 * @return return new name from the command
	 */
	public String getNewName(String[] args);
}
