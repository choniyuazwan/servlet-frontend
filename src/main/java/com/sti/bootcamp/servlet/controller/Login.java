package com.sti.bootcamp.servlet.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {
    public Login() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String resultPage = "/login.jsp";

        if ("userapp".equalsIgnoreCase(username) && "pwdapp".equalsIgnoreCase(password)) {
//			Cookie cookieUser = new Cookie("user", username);
//
//			response.addCookie(cookieUser);

            resultPage = "WEB-INF/home.jsp";

            request.getSession().setAttribute("user", username);
        } else {
            request.setAttribute("message", "invalid username or password");
        }

        RequestDispatcher view = request.getRequestDispatcher(resultPage);
        view.forward(request, response);
    }

}
