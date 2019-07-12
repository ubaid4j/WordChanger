package com.ubaid.app.commandBuilder;

/**
 * @author UbaidurRehman
 *
 */
public interface Builder
{
	/**
	 * @param args ~ args from the main adn 
	 * @return the parameter of desired bar [-d, -o, -n]
	 */
	public String getParam(String[] args);
}
