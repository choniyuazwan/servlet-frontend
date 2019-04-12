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
			<td><input type="text" name="firstname" /> </td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td>:</td>
			<td><input type="text" name="lastname" /> </td>
		</tr>
		<tr>
			<td>Username</td>
			<td>:</td>
			<td><input type="text" name="username" /> </td>
		</tr>
		<tr>
			<td>Password</td>
			<td>:</td>
			<td><input type="text" name="password" /> </td>
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