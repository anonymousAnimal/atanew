<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="/ATA/static/Basic.css" />
<title>Login</title>
<style type="text/css">
	.errstyle{
		color:red;
		font-style: italic;
	}
</style>
</head>
<body>
<div class="login">
<h1>Automation Travel Agency</h1>
<h1>Login</h1>
<f:form action="dologin" modelAttribute="credentialsBean">
<table align="center" >
<tr><td>UserID</td><td><f:input type="text" path="userID" id="u"/></td> <td><f:errors path="userID" cssClass="errstyle"/></td></tr>
<tr><td>Password</td><td><f:input type="password" path="password" id="p"/></td> <td><f:errors path="password" cssClass="errstyle"/></td></tr>
<tr><td><!-- <button type="submit">Login</button> --><input type="submit" value="login" class="btn btn-primary btn-block btn-large"/></td></tr>
<tr><td colspan=2><a href="register">New User?</a>Register Here</td></tr>
<tr><td colspan=2 class="errstyle">${msg}</td></tr>

</table>
</f:form>
</div>
</body>
</html>