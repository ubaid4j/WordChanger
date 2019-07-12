package com.ubaid.app.commandBuilder;

import org.springframework.stereotype.Repository;

@Repository
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
