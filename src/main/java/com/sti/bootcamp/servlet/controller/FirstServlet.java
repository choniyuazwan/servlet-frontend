package com.sti.bootcamp.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sti.bootcamp.servlet.Util;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String global = request.getParameter("global");
        String attr = request.getParameter("nama");
        String sess = request.getParameter("sess");
        if(global!=null) {
        	Util.globalString.set(global);
        	Util.globalStaticString = global;
        }
        if(attr!=null)
        	request.setAttribute("name", attr);
        if(sess!=null)
        	request.getSession().setAttribute("sessName", sess);
		RequestDispatcher view = request.getRequestDispatcher("SecondServlet");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
