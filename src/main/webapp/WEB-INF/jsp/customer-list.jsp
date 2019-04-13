<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer</title>
</head>
<body>
	<div>
		<h3>Customer List</h3>
		<table>
			<c:forEach var="cus" items="${data}">
				<tr>
					<td>${cus.cif}</td>
					<td>${cus.firstname}</td>
					<td>${cus.lastname}</td>
					<td>${cus.username}</td>
					<td>${cus.birthdate}</td>
					<td>${cus.password}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>