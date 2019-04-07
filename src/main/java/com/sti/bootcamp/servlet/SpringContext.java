package com.sti.bootcamp.servlet;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages= {"com.sti.bootcamp.servlet.controller.spring"})
@Import(SpringBeanContext.class)
public class SpringContext {
	
}
