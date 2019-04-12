package com.sti.bootcamp.servlet.controller.spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sti.bootcamp.servlet.dao.CustomerDao;
import com.sti.bootcamp.servlet.model.Customer;

@Controller
public class CustomerController {
	@Autowired(required=false)
	private Customer customer;
	
	@Autowired
	private CustomerDao customerDao;
	
	@RequestMapping("/customer-list")
	public ModelAndView getCustomers() {
		List<Customer> data = customerDao.getList();
		return new ModelAndView("customer-list", "data", data);
	}
	
	@GetMapping("/customer")
	public ModelAndView getCustomer(@RequestParam(name="id") Integer id) {
		return new ModelAndView("customer", "data", customerDao.getById(id));
	}
	
	@GetMapping("/customer-input")
	public String inputCustomer() {
		return "customer-input";
	}
	
	@PostMapping("/customer")
	public String saveCustomer(ModelMap modelMap, @ModelAttribute("customer") Customer customer) throws ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = sdf1.parse("29-11-1954");
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
		String dateString = sdf1.format(sqlStartDate);
		customer.setBirthdate(dateString);
		
		Customer savedCustomer = customerDao.save(customer);
		modelMap.addAttribute("data", savedCustomer);
		modelMap.addAttribute("message", "success created");
		return "customer";
	}

//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
	
}
