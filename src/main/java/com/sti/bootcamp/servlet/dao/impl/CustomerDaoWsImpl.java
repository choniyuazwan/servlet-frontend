package com.sti.bootcamp.servlet.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sti.bootcamp.servlet.DbUtil;
import com.sti.bootcamp.servlet.dao.CustomerDao;
import com.sti.bootcamp.servlet.model.Customer;

public class CustomerDaoWsImpl implements CustomerDao {
	
	@Autowired
	private DbUtil dbUtil;

	@Override
	public List<Customer> getList() {
		List<Customer> list = new ArrayList<Customer>();
		Customer cus  = new Customer();
		cus.setCustomerNumber(45);
		cus.setFirstName("Indonesia");
		list.add(cus);
		return list;
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
