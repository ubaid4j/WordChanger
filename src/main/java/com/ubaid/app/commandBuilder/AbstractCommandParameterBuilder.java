package com.ubaid.app.commandBuilder;

public abstract class AbstractCommandParameterBuilder extends AbstractBuilder
{
	@Override
	public String getParam(String args[])
	{
		int baseIndex = find(args, getBaseIndex());
		int second = find(args, getSecondIndex());
		int third = find(args, getThirdIndex());
		
		
		int nextNeighborIndex = nextNeighbor(baseIndex, second, third);
		if(nextNeighborIndex != -1)
		{
			return buildString(args, baseIndex, nextNeighborIndex);			
		}
		
		return buildString(args, baseIndex, args.length + 1);
	}	

	protected abstract String getBaseIndex();
	protected abstract String getSecondIndex();
	protected abstract String getThirdIndex();
}
