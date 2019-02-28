<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Dashboard</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<h2>Welcome ${profileBean.getFirstName()}[${profileBean.getUserID()}]</h2> 
<!-- <div align="right"><button onclick="window.location='../logout'">logout</button></div> -->
<div align="center">
please choose below options :<br>
<a href="Profile">View Profile</a><br><br>
<a href="ViewVehiclesAndRoutes">view vehicles/Route Details</a><br><br>
<a href="/ATA/Booking/BookVehicle">Book Vehicle</a><br><br>
<a href="/ATA/Booking/CancelBooking">Cancel Booking</a><br><br>
<a href="">View/Print Booking Details</a><br><br>
</div>
</body>
</html>