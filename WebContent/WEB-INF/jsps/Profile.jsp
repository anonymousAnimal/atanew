<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<body>
<f:form action="logout" modelAttribute="profileBean">
<button type="submit">logout</button>

<h1>My Profile</h1>
<table align="center">
<tr><td>${profileBean.userID}</td></tr>
<tr><td>${profileBean.firstName}</td></tr>
<tr><td>${profileBean.lastName}</td></tr>
<tr><td>${profileBean.dateOfBirth}</td></tr>
<tr><td>${profileBean.gender}</td></tr>
<tr><td>${profileBean.street}</td></tr>
<tr><td>${profileBean.location}</td></tr>
<tr><td>${profileBean.city}</td></tr>
<tr><td>${profileBean.state}</td></tr>
<tr><td>${profileBean.pincode}</td></tr>
<tr><td>${profileBean.mobileNo}</td></tr>
<tr><td>${profileBean.emailID}</td></tr>

</table>
</f:form>
</body>
</html>