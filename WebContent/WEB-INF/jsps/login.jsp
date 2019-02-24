<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1 align="center">LOGIN</h1>
<f:form action="dologin" modelAttribute="cb">
<table align="center" >
<tr><td><f:input type="text" path="userID" /></td></tr>
<tr><td><f:input type="password" path="password"/></td></tr>
<tr><td><f:button name="submit">Login</f:button></td></tr>
<tr><td><a href="register">New User?</a>Register Here</td></tr>
<tr><td colspan=2>${msg}</td></tr>

</table>
</f:form>
</body>
</html>