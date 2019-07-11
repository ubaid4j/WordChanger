package com.ubaid.app.commandBuilder;

public class NewWordParameterBuilder extends AbstractCommandParameterBuilder {

	@Override
	protected String getBaseIndex()
	{
		return getNewBar();
	}

	@Override
	protected String getSecondIndex()
	{
		return getDirBar();
	}

	@Override
	protected String getThirdIndex()
	{
		return getOldBar();
	}

}
