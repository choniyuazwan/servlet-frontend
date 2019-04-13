package com.sti.bootcamp.servlet.security;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthenticationFilter implements Filter {

    public AuthenticationFilter() {

    }

    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // pass the request along the filter chain
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        if (servletRequest.getRequestURL().toString().endsWith("login") || servletRequest.getRequestURL().toString().endsWith("login.jsp") || servletRequest.getRequestURL().toString().endsWith("index.jsp")) {
            chain.doFilter(request, response);
        } else {
            //Cookie[] cookies = servletRequest.getCookies();
            boolean authenticated = false;
//			for (Cookie cookie : cookies) {
//				if(cookie.getName().equalsIgnoreCase("user")) {
//					authenticated = true;
//					break;
//				}
//			}
            if (servletRequest.getSession().getAttribute("user") != null) {
                authenticated = true;
            }
            if (authenticated) {
                chain.doFilter(request, response);
            } else {
                RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
                view.forward(request, response);
            }
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {

    }

}
