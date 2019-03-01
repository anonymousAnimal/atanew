<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/ATA/static/css/table.css" />
<style>
	table, th, td{
		border: 1px solid black;
		border-collapse:collapse;
		
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Available vehicles and routes</title>
</head>
<body>
<jsp:include page="/HeaderUser.jsp"></jsp:include>
	
	<table align="center">
	<caption>List of Vehicles</caption>
	<tr><th>VehicleID</th><th>Name</th><th>Type</th><th>RegistrationNumber</th><th>SeatingCapacity</th><th>FarePerKM</th></tr>
	<c:forEach var="r" items="${vehicleList}">
		<tr><td>${r.getVehicleID() }</td><td>${r.getName() }</td><td>${r.getType() }</td><td>${r.getRegistrationNumber() }</td><td>${r.getSeatingCapacity() }</td><td>${r.getFarePerKM() }</td></tr>
	</c:forEach>
	</table>
	
	<br>
	<br>
	<br>
	
	<table align="center">
	<caption>List of Routes</caption>
	<tr><th>RouteID</th><th>Source</th><th>Destination</th><th>Distance</th><th>TravelDuration</th></tr>
	<c:forEach var="r" items="${routeList}">
		<tr><td>${r.getRouteID() }</td><td>${r.getSource()}</td><td>${r.getDestination()}</td><td>${r.getDistance() }</td><td>${r.getTravelduration() }</td></tr>
	</c:forEach>
	</table>
	<br>
	<br>
	<center><button onclick="history.go(-1)">Goto Dashboard</button></center>
</body>
</html>