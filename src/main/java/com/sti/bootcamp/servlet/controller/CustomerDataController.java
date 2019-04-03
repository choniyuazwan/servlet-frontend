package com.sti.bootcamp.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sti.bootcamp.servlet.model.Customer;

/**
 * Servlet implementation class CustomerDataController
 */
@WebServlet(urlPatterns="/customer/data")
public class CustomerDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerDataController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = new Customer();
		customer.setCustomerNumber(1);
		customer.setFirstName("Roy");
		
		ObjectMapper mapper = new ObjectMapper();
		response.getWriter().println(mapper.writeValueAsString(customer));
		
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = new Customer();
		customer.setCustomerNumber(1);
		customer.setFirstName(request.getParameter("nama"));

		ObjectMapper mapper = new ObjectMapper();
		response.getWriter().println(mapper.writeValueAsString(customer));
		
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

	}

}
