package com.sti.bootcamp.servlet.security;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest servletRequest = (HttpServletRequest)request;
		if(servletRequest.getRequestURL().toString().endsWith("login") || servletRequest.getRequestURL().toString().endsWith("login.jsp") || servletRequest.getRequestURL().toString().endsWith("index.jsp")) {
			chain.doFilter(request, response);
		}else {
			//Cookie[] cookies = servletRequest.getCookies();
			boolean authenticated = false;
//			for (Cookie cookie : cookies) {
//				if(cookie.getName().equalsIgnoreCase("user")) {
//					authenticated = true;
//					break;
//				}
//			}
			if(servletRequest.getSession().getAttribute("user")!=null) {
				authenticated = true;
			}
			if(authenticated) {
				chain.doFilter(request, response);
			}else {
				RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
		        view.forward(request, response);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
