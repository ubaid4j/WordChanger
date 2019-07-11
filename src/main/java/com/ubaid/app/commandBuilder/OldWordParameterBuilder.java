package com.ubaid.app.commandBuilder;

public class OldWordParameterBuilder extends AbstractCommandParameterBuilder {

	@Override
	protected String getBaseIndex()
	{
		return getOldBar();
	}

	@Override
	protected String getSecondIndex()
	{
		return getNewBar();
	}

	@Override
	protected String getThirdIndex()
	{
		return getDirBar();
	}

}
