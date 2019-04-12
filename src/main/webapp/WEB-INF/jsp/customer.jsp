<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring</title>
</head>
<body>
	<div>
		<h3>Customer</h3>
		${message }
		<table>
			<tr>
				<td>Customer Number</td>
				<td>:</td>
				<td>${data.cif}</td>
			</tr>
			<tr>
				<td>First Name</td>
				<td>:</td>
				<td>${data.firstname}</td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td>:</td>
				<td>${data.lastname}</td>
			</tr>
			<tr>
				<td>Username</td>
				<td>:</td>
				<td>${data.username}</td>
			</tr>
		</table>
	</div>
</body>
</html>