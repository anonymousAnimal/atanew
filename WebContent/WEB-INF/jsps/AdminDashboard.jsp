<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin DashBoard</title>
</head>
<body>
	<div align="right" ><button onclick="window.location = '../logout'">logout</button></div>
	<div align="center">
	<h1> Welcome Admin !!!</h1>
	<h2>Please choose below tasks : </h2>
	<a href="AddDriver">Add </a><a href=""> Modify/Delete</a> Driver<br>
	<a href="AddVehicle">Add </a><a href=""> Modify/Delete</a> Vehicle<br>
	<a href="CreateRoute">Add </a><a href=""> Modify/Delete</a> Route<br>
	<a href="">Allot Driver to Booking</a><br>
	</div>
</body>
</html>