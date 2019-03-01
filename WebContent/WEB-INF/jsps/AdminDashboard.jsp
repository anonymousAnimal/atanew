<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin DashBoard</title>
</head>
<body>
	<jsp:include page="/HeaderAdmin.jsp"/>
	<div align="center">
	<h1> Welcome Admin !!!</h1>
	<h2>Please choose below tasks : </h2>
	<!-- <a href="/ATA/Admin/addDriver">Add </a> <a href="driverEditDelete">  Modify/Delete</a> Driver<br>
	<a href="/ATA/Admin/addVehicle">Add </a><a href="vehicleEditDelete"> Modify/Delete</a> Vehicle<br>
	<a href="/ATA/Admin/addroute">Add </a><a href="goToEditDelete"> Modify/Delete</a> Route<br> -->
	<a href="/ATA/Admin/ShowUnallotedDrivers">Allot Driver to Booking</a><br><br>
	<a href="/ATA/Admin/AdminView">View Booking Details </a><br><br> 
	
	<h5 style="color:green;">${msg}</h5>
	</div>
	
</body>
</html>