package com.ubaid.app.commandBuilder;

/**
 * This is AbtractBuilder class having some fundamental methods and it 
 * implements the Builder interface which have change method
 * @author UbaidurRehman
 *
 */
public abstract class AbstractBuilder implements Builder
{	
	/**
	 * 
	 * @param args ~ the array of arguments
	 * @param command ~ the command to find
	 * @return the first index of command parameter
	 * if find(['-o', 'ubaid', 'ur', 'rehman'], -o) then it will return 1
	 * if find(['-o', 'ubaid', 'ur', 'rehman', '-d', '/path/to/], -d) then return 5
	 * if find(['-0', 'ubaid', 'ur', 'rehman', '-d', '/path/to/], -l) then reutnr -1
	 */
	public int find(String[] args, String command)
	{
		int index = 0;
		for(String com : args)
		{
			++index;
			if(com.equals(command))
				return index;
		}
		return -1;
	}
	

	protected String getOldBar() {
		return "-o";
	}
	protected String getNewBar() {
		return "-n";
	}
	protected String getDirBar() {
		return "-d";
	}
	
	/**
	 * check rep:
	 * base, first second will be positive
	 * 
	 * @param base
	 * @param first
	 * @param second
	 * @return which is near to base [first or second]
	 */
	public int nextNeighbor(int base, int first, int second)
	{
		int min = min(first, min(second, base));
		int max = max(first, max(second, base));
		
		if(base == min)
		{
			return min(first, second);
		}
		else if(base == max)
		{
			return -1;
		}
		else
		{
			return max(first, second);
		}
			
	}
	
	/**
	 * 
	 * @param first
	 * @param second
	 * @return max one
	 */
	private int max(int first, int second)
	{
		if(first > second)
		{
			return first;
		}
		else
		{
			return second;
		}
	}
	
	/**
	 * 
	 * @param first
	 * @param second
	 * @return min one
	 */
	private int min(int first, int second)
	{
		if(first < second)
		{
			return first;
		}
		else
		{
			return second;
		}
	}
	
	
	/**
	 * 
	 * @param args ~ the array of arguments
	 * @param start ~ the index of command for which the word is being produced
	 * @param end ~ the index of very next command
	 * @return the full parameter of an command
	 */
	public String buildString(String[] args, int start, int end)
	{
		String param = "";
		
		for(int i = start; i < end - 1; i++)
		{
			param += args[i] + " ";
		}

		return param;
	}

	/**
	 * @param args ~ args from the main adn 
	 * @return the parameter of desired bar [-d, -o, -n]
	 */
	public abstract String getParam(String[] args);	
}
