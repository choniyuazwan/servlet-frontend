package com.sti.bootcamp.servlet.dao.impl;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sti.bootcamp.servlet.dao.CustomerDao;
import com.sti.bootcamp.servlet.model.Customer;
import com.sti.bootcamp.servlet.model.dto.CommonResponse;

public class CustomerDaoWsImpl implements CustomerDao {
	
	private static final ObjectMapper MAPPER = new ObjectMapper();//boleh dibuat static final, karena object mapper thread-safe
	private static final ParameterizedTypeReference<CommonResponse<Customer>> PARAMETERIZED_TYPE_COMMON_RESP_CUSTOMER = new ParameterizedTypeReference<CommonResponse<Customer>>() {};
	private static final TypeReference<CommonResponse<List<Customer>>> TYPE_COMMON_RESP_CUSTOMERS = new TypeReference<CommonResponse<List<Customer>>>() {};
	private static final TypeReference<CommonResponse<Customer>> TYPE_COMMON_RESP_CUSTOMER = new TypeReference<CommonResponse<Customer>>() {};
	
	@Override
	public List<Customer> getList() {
		List<Customer> list=null;
		
		RestTemplate restTemplate = new RestTemplate();
		String getCustomersUrl = "http://localhost:8180/customers";//untuk sample masih hardcode, untuk real project sebaiknya dibuatkan di properties atau enum

		//contoh menggunakan getForEntity --> otomatis menggunakan method GET
		ResponseEntity<String> response = restTemplate.getForEntity(getCustomersUrl, String.class);
		
		if(response.getStatusCode()!=HttpStatus.OK) {//gunakan ResponseEntity agar dapat validasi HTTP Status terlebih dahulu
			System.out.println(String.format("error %s", response.getStatusCodeValue()));
		}else if(StringUtils.isEmpty(response.getBody())) {
			System.out.println("response null");
		}else {
			try {
				//contoh untuk GET dengan mengambil response dalam bentuk String terlebih dahulu (response.getBody), baru diconvert ke dalam object menggunakan ObjectMapper
				CommonResponse<List<Customer>> respBody = MAPPER.readValue(response.getBody(), TYPE_COMMON_RESP_CUSTOMERS);
				if(!respBody.getResponseCode().equalsIgnoreCase("01")) {
					System.out.println(String.format("failed with message %s", respBody.getResponseMessage()));
				}else {
					list = respBody.getData();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return list;
	}

	@Override
	public Customer getById(int customerNumber) {
		Customer customer = null;
		
		RestTemplate restTemplate = new RestTemplate();
		String getCustomerUrl = String.format("http://localhost:8180/customer/%s", customerNumber);//untuk sample masih hardcode, untuk real project sebaiknya dibuatkan di properties atau enum
		
		//contoh menggunakan exchange --> HTTP method dapat disesuaikan
		ResponseEntity<CommonResponse<Customer>> response = restTemplate.exchange(
				  getCustomerUrl,
				  HttpMethod.GET,
				  null,
				  PARAMETERIZED_TYPE_COMMON_RESP_CUSTOMER);
		
		if(response.getStatusCode()!=HttpStatus.OK) {
			System.out.println(String.format("error %s", response.getStatusCodeValue()));
		} else if(StringUtils.isEmpty(response.getBody())) {
			System.out.println("response null");
		} else {
			//contoh untuk GET dengan langsung menerima response body dalam bentuk POJO (tidak perlu menggunakan ObjectMapper lagi)
			CommonResponse<Customer> respBody = response.getBody();
			if(!respBody.getResponseCode().equalsIgnoreCase("01")) {
				System.out.println(String.format("failed with message %s", respBody.getResponseMessage()));
			}else {
				customer = respBody.getData();
			}
		}
		
		return customer;
	}

	@Override
	public Customer save(Customer customer) {
		Customer savedCustomer = null;
		
		RestTemplate restTemplate = new RestTemplate();
		String postCustomerUrl = "http://localhost:8180/customer";//untuk sample masih hardcode, untuk real project sebaiknya dibuatkan di properties atau enum
		
		//contoh menggunakan postForEntity, silahkan explore lebih lanjut untuk metode2 lain seperti postForObject, postForLocation
		ResponseEntity<String> response = restTemplate.postForEntity(URI.create(postCustomerUrl), customer, String.class);
		
		if(response.getStatusCode()!=HttpStatus.OK) {
			System.out.println(String.format("error %s", response.getStatusCodeValue()));
		} else if(StringUtils.isEmpty(response.getBody())) {
			System.out.println("response null");
		} else {
			CommonResponse<Customer> respBody;
			try {
				respBody = MAPPER.readValue(response.getBody(), TYPE_COMMON_RESP_CUSTOMER);
				
				if(!respBody.getResponseCode().equalsIgnoreCase("01")) {
					System.out.println(String.format("failed with message %s", respBody.getResponseMessage()));
				}else {
					savedCustomer = respBody.getData();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return savedCustomer;
	}

	@Override
	public Customer delete(Customer customer) {
		Customer deletedCustomer = null;
		
		RestTemplate restTemplate = new RestTemplate();
		String getCustomerUrl = String.format("http://localhost:8180/customer/%s", customer.getCustomerNumber());//untuk sample masih hardcode, untuk real project sebaiknya dibuatkan di properties atau enum
		
		//contoh menggunakan exchange --> HTTP method dapat disesuaikan
		ResponseEntity<CommonResponse<Customer>> response = restTemplate.exchange(
				  getCustomerUrl,
				  HttpMethod.DELETE,
				  null,
				  PARAMETERIZED_TYPE_COMMON_RESP_CUSTOMER);
		
		if(response.getStatusCode()!=HttpStatus.OK) {
			System.out.println(String.format("error %s", response.getStatusCodeValue()));
		} else if(StringUtils.isEmpty(response.getBody())) {
			System.out.println("response null");
		} else {
			CommonResponse<Customer> respBody = response.getBody();
			if(!respBody.getResponseCode().equalsIgnoreCase("01")) {
				System.out.println(String.format("failed with message %s", respBody.getResponseMessage()));
			}else {
				deletedCustomer = respBody.getData();
			}
		}
		
		return deletedCustomer;
	}

}
