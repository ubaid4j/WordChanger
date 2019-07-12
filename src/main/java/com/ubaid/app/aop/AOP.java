package com.ubaid.app.aop;


import org.aspectj.lang.annotation.Pointcut;

/**
 * AOP abstract class, having a point cut expression which point to the change method of Helper
 * @author UbaidurRehman
 *
 */
public abstract class AOP
{
	@Pointcut("execution(int com.ubaid.app.doa.Helper.change(String, String, java.io.File) throws Exception)")
	public void changeInFileDAO() {}	
}

