package com.ubaid.app.aop;

import java.io.File;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * It will log about the changing activity which are being done in the FileDAO
 * @author UbaidurRehman
 *
 */

@Aspect
@Component
public class Loggin extends AOP
{
	
	/**
	 * 
	 * @param joinPoint
	 * @return object
	 * @throws Exception
	 */
	@Around("changeInFileDAO()")
	public Object logging(ProceedingJoinPoint joinPoint) throws Exception
	{
		//getting desired args
		Object[] args = joinPoint.getArgs();
		File file = (File) args[2];
		String OldWord = (String) args[0];
		String newWord = (String) args[1];
		
		//info
		String info = String.format("[INFO]: Searching %s "
				+ "in %s", OldWord, file.getAbsolutePath());
		System.out.println(info);

		//callign proceed method for further inquiry
		return proceed(joinPoint, OldWord, newWord);
			
	}

	/**
	 * 
	 * @param joinPoint
	 * @param OldWord
	 * @param newWord
	 * @return object
	 */
	private Object proceed(ProceedingJoinPoint joinPoint, String OldWord, String newWord)
	{
		String info = null;
		Object result = -1;			
		try
		{
			//getting result from the joinPoint [actually the Helper.Change method]
			result = joinPoint.proceed();
			
			//if it return greater than 0 then info about line number else not found printed
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
			result = -1;
			System.out.println("[Error]: " + exp.getMessage());
		}
		
		return result;
	}
	
}
