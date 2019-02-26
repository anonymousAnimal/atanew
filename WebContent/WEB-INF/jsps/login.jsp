<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<style type="text/css">
	.errstyle{
		color:red;
		font-style: italic;
	}
</style>
</head>
<body>
<h1 align="center">LOGIN</h1>
<f:form action="dologin" modelAttribute="credentialsBean">
<table align="center" >
<tr><td>UserID</td><td><f:input type="text" path="userID" /></td> <td><f:errors path="userID" cssClass="errstyle"/></td></tr>
<tr><td>Password</td><td><f:input type="password" path="password"/></td> <td><f:errors path="password" cssClass="errstyle"/></td></tr>
<tr><td><!-- <button type="submit">Login</button> --><input type="submit" value="login"/></td></tr>
<tr><td colspan=2><a href="register">New User?</a>Register Here</td></tr>
<tr><td colspan=2 class="errstyle">${msg}</td></tr>

</table>
</f:form>
</body>
</html>