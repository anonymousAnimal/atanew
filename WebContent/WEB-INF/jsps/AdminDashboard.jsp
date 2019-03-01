<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/ATA/static/css/cards.css" />
<meta charset="ISO-8859-1">
<title>Admin DashBoard</title>
</head>
<body>
	<jsp:include page="/HeaderAdmin.jsp"/>
	<center>
	<h1> Welcome Admin !!!</h1>
	<h2>Please choose below tasks : </h2>
	<h3 align="center" style="color:green;">${msg}</h3>
	</center>


<div class="card"  style="display:block-inline" >
<a href = "/ATA/Admin/ShowUnallotedDrivers">
  <img src="/ATA/static/images/driver.png" alt="Avatar" style="width:100%" ></a>
  <div class="container" >
  <h4 >
  <a href = "/ATA/Admin/ShowUnallotedDrivers">
  <b>Allot Driver to Booking</b> 
  </a>
  </h4>
  </div>
</div>


	<div class="card"  style="display:block-inline" >
<a href = "/ATA/Admin/AdminView">
  <img src="/ATA/static/images/viewbooking.png" alt="Avatar" style="width:100%" ></a>
  <div class="container" >
  <h4 >
  <a href = "/ATA/Admin/AdminView">
  <b>View Booking Details</b> 
  </a>
  </h4>
  </div>
</div>


	<!-- <a href="/ATA/Admin/addDriver">Add </a> <a href="driverEditDelete">  Modify/Delete</a> Driver<br>
	<a href="/ATA/Admin/addVehicle">Add </a><a href="vehicleEditDelete"> Modify/Delete</a> Vehicle<br>
	<a href="/ATA/Admin/addroute">Add </a><a href="goToEditDelete"> Modify/Delete</a> Route<br> 
	<a href="/ATA/Admin/ShowUnallotedDrivers">Allot Driver to Booking</a><br><br>
	<a href="/ATA/Admin/AdminView">View Booking Details </a><br><br> -->
	
	
</body>
</html>