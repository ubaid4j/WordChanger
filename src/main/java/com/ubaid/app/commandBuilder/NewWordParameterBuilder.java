package com.ubaid.app.commandBuilder;

import org.springframework.stereotype.Repository;

@Repository
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
