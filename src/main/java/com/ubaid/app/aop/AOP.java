package com.ubaid.app.aop;


import org.aspectj.lang.annotation.Pointcut;

public abstract class AOP
{
	@Pointcut("execution(int com.ubaid.app.doa.Helper.change(String, String, java.io.File) throws Exception)")
	public void changeInFileDAO() {}	
}

