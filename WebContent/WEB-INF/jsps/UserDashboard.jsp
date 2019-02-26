<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Dashboard</title>
</head>
<body>
<h2>Welcome ${profileBean.getUserID()}</h2> 
<div align="right"><button onclick="window.location='../logout'">logout</button></div>
<div align="center">
please choose below options :<br>
<a href="Profile">View Profile</a><br>
<a href="">view vehicles/Route Details</a><br>
<a href="">Book Vehicle</a><br>
<a href="">Cancel Booking</a><br>
<a href="">View/Print Booking Details</a><br>
</div>
</body>
</html>