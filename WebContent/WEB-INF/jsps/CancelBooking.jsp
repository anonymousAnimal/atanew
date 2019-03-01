<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/ATA/static/css/table.css" />
<script type="text/javascript" src="/ATA/js/bookvehicle.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancel Booking</title>
</head>
<body onload="checkajax()">
	<jsp:include page="/HeaderUser.jsp"></jsp:include>
	<div align="center">
	<table>
	<caption>Booking Details : </caption>
	<tr>
		<th>ReservationID</th><th>User ID</th><th>RouteID</th><th>BookingDate</th>
		<th>JourneyDate</th><th>Vehicle ID</th>
		<th>Driver ID</th><th>Booking Status</th><th>Total Fare</th>
		<th>Boarding point</th><th>Drop point</th>
	</tr>
	
	<c:forEach var="rb" items="${reservationList }">
			
			<tr id="${rb.getReservationID() }">
				<td>${rb.getReservationID() }</td><td>${rb.getUserID() }</td><td>${rb.getRouteID() }</td>
				<td>${rb.getBookingDate() }</td><td>${rb.getJourneyDate() }</td><td>${rb.getVehicleID() }</td>
				<td>${rb.getDriverID() }</td><td>${rb.getBookingStatus() }</td><td>${rb.getTotalFare() }</td>
				<td>${rb.getBoardingPoint() }</td><td>${rb.getDropPoint() }</td> 
				<td><Button onclick="cancelBooking('${rb.getReservationID()}');">Delete!</Button></td>
			</tr>
		
	</c:forEach>
	
	</table>
	
	<br><br><!-- <button onclick="history.go(-1)">&lt;&lt;&lt;</button>&nbsp;&nbsp;&nbsp; --><button onclick="history.go(-1)">Go To DashBoard</button>
	</div>
	
	<br><br><div id = "msg"></div>
</body>
</html>