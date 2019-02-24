<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<body>
<form action="logout">
<input type="submit" value="Logout" align="right">
</form>
<h1>My Profile</h1>
<table align="center">
<tr><td>${cust.userID}</td></tr>
<tr><td>${cust.firstName}</td></tr>
<tr><td>${cust.lastName}</td></tr>
<tr><td>${cust.dateOfBirth}</td></tr>
<%-- <tr><td>${cust.gender}</td></tr>
<tr><td>${cust.street}</td></tr>
<tr><td>${cust.location}</td></tr>
<tr><td>${cust.city}</td></tr>
<tr><td>${cust.state}</td></tr>
<tr><td>${cust.pincode}</td></tr>
<tr><td>${cust.mobileno}</td></tr>
<tr><td>${cust.emailid}</td></tr> --%>

</table>
</body>
</html>