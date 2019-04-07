<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring</title>
</head>
<body>
	<div>
		<h3>Customer List</h3>
		<table>
			<c:forEach var="cus" items="${data}">
				<tr>
					<td>${cus.customerNumber}</td>
					<td>${cus.firstName}</td>
					<td>${cus.lastName}</td>
					<td>${cus.username}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>