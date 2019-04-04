package com.sti.bootcamp.servlet.dao;

import java.util.List;

import com.sti.bootcamp.servlet.model.Customer;

public interface CustomerDao {
	List<Customer> getList();
	Customer getById(int customerNumber);
	Customer save(Customer customer);
	Customer delete(Customer customer);
}
