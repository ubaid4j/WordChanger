package com.ubaid.app.doa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ubaid.app.commandBuilder.Builder;

@Service
public class CommandServiceImp implements CommandService
{

	@Autowired
	@Qualifier("directoryParameterBuilder")
	Builder b1;
	
	@Autowired
	@Qualifier("oldWordParameterBuilder")
	Builder b2;
	
	@Autowired
	@Qualifier("newWordParameterBuilder")
	Builder b3;

	
	@Override
	public String getDir(String[] args) 
	{
		return b1.getParam(args);
	}

	@Override
	public String getOldName(String[] args)
	{
		return b2.getParam(args);
	}

	@Override
	public String getNewName(String[] args)
	{
		return b3.getParam(args);
	}

}
