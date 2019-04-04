package com.sti.bootcamp.servlet.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sti.bootcamp.servlet.DbUtil;
import com.sti.bootcamp.servlet.dao.CustomerDao;
import com.sti.bootcamp.servlet.model.Customer;

public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private DbUtil dbUtil;

	@Override
	public List<Customer> getList() {
		return dbUtil.getListCustomer();
	}

	@Override
	public Customer getById(int customerNumber) {
		return dbUtil.getListCustomer().get(customerNumber);
	}

	@Override
	public Customer save(Customer customer) {
		return customer;
	}

	@Override
	public Customer delete(Customer customer) {
		return customer;
	}

}
