<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/ATA/static/css/Basic1.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<body>
<%-- <form action="Logout" >
<button type="submit">logout</button> </form>--%>

<jsp:include page="/HeaderUser.jsp"></jsp:include>

<h1>Your Details : </h1>

<div class="container">
<h1 id="main-title">Your Details : </h1>
<table align="center">
<tr><td><b>UserID</b></td><td>${profileBean.userID}</td></tr>
<tr><td><b>Firstname</b></td><td>${profileBean.firstName}</td></tr>
<tr><td><b>Lastname</b></td><td>${profileBean.lastName}</td></tr>
<tr><td><b>Date of birth</b></td><td>${profileBean.dateOfBirth}</td></tr>
<tr><td><b>Gender</b></td><td>${profileBean.gender}</td></tr>
<tr><td><b>Street</b></td><td>${profileBean.street}</td></tr>
<tr><td><b>Location</b></td><td>${profileBean.location}</td></tr>
<tr><td><b>City</b></td><td>${profileBean.city}</td></tr>
<tr><td><b>State</b></td><td>${profileBean.state}</td></tr>
<tr><td><b>Pincode</b></td><td>${profileBean.pincode}</td></tr>
<tr><td><b>Mobileno</b></td><td>${profileBean.mobileNo}</td></tr>
<tr><td><b>EmailID</b></td><td>${profileBean.emailID}</td></tr>
<tr><td><button onclick="history.go(-1)" id="a-submit">Go to DashBoard</button></td></tr>
</table>
</div>
</body>
</html>