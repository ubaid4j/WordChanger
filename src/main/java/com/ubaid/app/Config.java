package com.ubaid.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.ubaid.app"})
@EnableAspectJAutoProxy
public class Config
{
	
}
