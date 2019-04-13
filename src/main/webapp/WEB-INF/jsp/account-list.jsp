<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account</title>
</head>
<body>
<div>
    <h3>Account List</h3>
    <table>
        <c:forEach var="acc" items="${data}">
            <tr>
                <td>${acc.accountNumber}</td>
                <td>${acc.accountName}</td>
                <td>${acc.balance}</td>
                <td>${acc.openDate}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
