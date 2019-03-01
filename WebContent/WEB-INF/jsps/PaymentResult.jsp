
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/ATA/static/css/table.css" />
<meta charset="ISO-8859-1">
<title>${msg }</title>
</head>
<body>
	<h2 align="center">${msg}</h2>
	<div align="center">
		<table>
			<caption>Booking Details : </caption>
			<tr>
				<td>ReservationID</td><td>User ID</td><td>RouteID</td><td>BookingDate</td>
				<td>JourneyDate</td><td>Vehicle ID</td>
				<td>Driver ID</td><td>Booking Status</td><td>Total Fare</td>
				<td>Boarding point</td><td>Drop point</td>
			</tr>
			<tr>
				<td>${rb.getReservationID() }</td><td>${rb.getUserID() }</td><td>${rb.getRouteID() }</td>
				<td>${rb.getBookingDate() }</td><td>${rb.getJourneyDate() }</td><td>${rb.getVehicleID() }</td>
				<td>${rb.getDriverID() }</td><td>${rb.getBookingStatus() }</td><td>${rb.getTotalFare() }</td>
				<td>${rb.getBoardingPoint() }</td><td>${rb.getDropPoint() }</td>
			</tr>
		
		</table>
	</div>
	
	<br>
	<div align="center">
	<form action="/ATA/User/Dashboard" >
	<input type="submit" value="Go To DashBoard">
	</form>
	</div>
</body>
</html>