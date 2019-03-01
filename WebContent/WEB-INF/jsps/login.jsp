<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="/ATA/static/css/login.css" />
<title>Login</title>
<style type="text/css">
	.errstyle{
		color:red;
		font-style: italic;
	}
</style>

</head>
<body>
<div class="background-wrap">
  <div class="background"></div>
</div>
<div class="inset">
<f:form action="dologin" modelAttribute="credentialsBean" id="accesspanel" >
<h1 id="litheader">Automation Travel Agency</h1>
<table align="center" >
<tr><td>UserID</td><td><f:input id="userId" type="text" path="userID" required="true"/></td> </tr>
<tr><td>Password</td><td><f:input id="password" type="password" path="password" required="true"/></td> </tr>
<tr><td ><input type="submit" value="Login" class="btn btn-primary btn-block btn-large"/></td></tr>
<tr><td colspan=2 align="center"><p class="p-container"><a href="register">New User?</a></p></td></tr>
<tr><td colspan=2 class="errstyle">${msg}</td></tr>
</table>
</f:form>
</div>
</body>
</html>