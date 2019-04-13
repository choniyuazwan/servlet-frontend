package com.sti.bootcamp.servlet;

import com.sti.bootcamp.servlet.dao.AccountDao;
import com.sti.bootcamp.servlet.dao.CustomerDao;
import com.sti.bootcamp.servlet.dao.impl.AccountDaoWsImpl;
import com.sti.bootcamp.servlet.dao.impl.CustomerDaoWsImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

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

    @Bean
    public AccountDao accountDao() {
        return new AccountDaoWsImpl();
    }

}
