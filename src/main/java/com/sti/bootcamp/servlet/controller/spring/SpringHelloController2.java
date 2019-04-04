package com.sti.bootcamp.servlet.controller.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sti.bootcamp.servlet.CounterUtil;
import com.sti.bootcamp.servlet.model.Customer;

@Controller
public class SpringHelloController2 {
	
	@Autowired
	private CounterUtil counterUtil;

	@Autowired(required=false)
	private Customer customer;
	
	@RequestMapping("/welcome2")
	public ModelAndView helloWorld() {
		String message = "<br><div style='text-align:center;'>"
				+customer.getFirstName()
				+counterUtil.getCounter()
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from SpringHelloController.java --> welcome**********</div><br><br>";
		return new ModelAndView("spring-welcome", "message", message);
	}
	
	@GetMapping("/welcome-message2")
	public String helloMessage(ModelMap model) {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from SpringHelloController.java --> welcome-message**********</div><br><br>";
		
		model.addAttribute("message", message);
		return "spring-welcome";
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CounterUtil getCounterUtil() {
		return counterUtil;
	}

	public void setCounterUtil(CounterUtil counterUtil) {
		this.counterUtil = counterUtil;
	}
	
}
