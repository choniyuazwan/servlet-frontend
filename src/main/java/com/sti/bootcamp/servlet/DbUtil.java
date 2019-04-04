package com.sti.bootcamp.servlet;

import java.util.ArrayList;
import java.util.List;

import com.sti.bootcamp.servlet.model.Customer;

public class DbUtil {
	private static List<Customer> customers = null;
	
	public List<Customer> getListCustomer(){
		if(customers==null) {
			customers = new ArrayList<>();
			for (int i = 1; i <= 10; i++) {
				Customer cus = new Customer();
				cus.setCustomerNumber(i);
				cus.setFirstName("Customer "+i);
				customers.add(cus);
			}
		}
		return customers;
	}
}
