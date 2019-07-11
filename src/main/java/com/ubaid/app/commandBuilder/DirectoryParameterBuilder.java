package com.ubaid.app.commandBuilder;

public class DirectoryParameterBuilder extends AbstractCommandParameterBuilder
{

	@Override
	protected String getBaseIndex()
	{
		return getDirBar();
	}

	@Override
	protected String getSecondIndex()
	{
		return getNewBar();
	}

	@Override
	protected String getThirdIndex()
	{
		return getOldBar();
	}

}
