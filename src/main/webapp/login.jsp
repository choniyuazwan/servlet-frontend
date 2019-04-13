<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>STI</title>
</head>
<body>

<%
    String message = (String) request.getAttribute("message");
    if (message != null && !message.equalsIgnoreCase("")) {
        out.print(message);
    }
%>

<form action="login" method="post">
    <table>
        <tr>
            <td>username</td>
            <td>:</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>password</td>
            <td>:</td>
            <td><input type="text" name="password"/></td>
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