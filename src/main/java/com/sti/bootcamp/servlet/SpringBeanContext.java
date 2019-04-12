package com.sti.bootcamp.servlet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.sti.bootcamp.servlet.dao.CustomerDao;
import com.sti.bootcamp.servlet.dao.impl.CustomerDaoWsImpl;
import com.sti.bootcamp.servlet.model.Customer;

public class SpringBeanContext {
	
	@Bean
	public ViewResolver viewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public CustomerDao customerDao() {
		return new CustomerDaoWsImpl();
	}
	
}
