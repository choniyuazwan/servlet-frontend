<%@page import="com.sti.bootcamp.servlet.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer</title>
</head>
<body>
	<h3>
		Hello,  
		<%
			Customer customer = (Customer)request.getAttribute("customer");
			
		%>
		<%= customer.getFirstName() %>
		[<%= customer.getCustomerNumber() %>]
	</h3>
</body>
</html>