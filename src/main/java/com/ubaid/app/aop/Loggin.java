package com.ubaid.app.aop;

import java.io.File;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class Loggin extends AOP
{
	
	@Around("changeInFileDAO()")
	public Object logging(ProceedingJoinPoint joinPoint) throws Exception
	{
		Object[] args = joinPoint.getArgs();
		File file = (File) args[2];
		String OldWord = (String) args[0];
		String newWord = (String) args[1];
		
		String info = String.format("[INFO]: Searching %s "
				+ "in %s", OldWord, file.getAbsolutePath());
		System.out.println(info);

		return proceed(joinPoint, OldWord, newWord);
			
	}

	private Object proceed(ProceedingJoinPoint joinPoint, String OldWord, String newWord)
	{
		String info = null;
		Object result = null;			
		try
		{
			result = joinPoint.proceed();
			int found = (int) result;
			if(found > 0)
				info = String.format("[INFO]: %s Found at Line Number %d\n\tChanging to %s\n",
						OldWord, found, newWord);
			else
				info = String.format("[INFO]: Not0Found\n");
			System.out.println(info);
		}
		catch(Throwable exp)
		{
			result = exp.getMessage();
			System.out.println("[INFO]: " + result);
		}
		
		return result;
	}
	
}
