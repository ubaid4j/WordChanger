package com.ubaid.app.commandBuilder;

import org.springframework.stereotype.Repository;

@Repository
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
