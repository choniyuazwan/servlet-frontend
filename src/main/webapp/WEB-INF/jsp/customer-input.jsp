<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring</title>
</head>
<body>

<form action="customer.html" method="post" modelAttribute="customer">
	<table>
		<tr>
			<td>First Name</td>
			<td>:</td>
			<td><input type="text" name="firstName" /> </td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td>:</td>
			<td><input type="text" name="lastName" /> </td>
		</tr>
		<tr>
			<td>Username</td>
			<td>:</td>
			<td><input type="text" name="username" /> </td>
		</tr>
		<tr>
			<td>Phone Type</td>
			<td>:</td>
			<td><input type="text" name="phoneType" /> </td>
		</tr>
		<tr>
			<td>Phone Number</td>
			<td>:</td>
			<td><input type="text" name="phoneNumber" /> </td>
		</tr>
		<tr>
			<td>
				<button type="submit">Submit</button>
			</td>
		</tr>
	</table>
</form>

</body>
</html>