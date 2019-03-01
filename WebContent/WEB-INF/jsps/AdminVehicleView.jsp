<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/ATA/static/css/table.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/HeaderAdmin.jsp"></jsp:include>
<table cellspacing="10px" align="center">
<tr><th>VehicleID</th><th>Name</th><th>Type</th><th>RegistrationNo</th><th>SeatingCapacity</th><th>FarePerKm</th><th>Edit</th><th>Delete</th></tr>
	<c:forEach var="r"  items="${list}">
		<tr><td>${r.vehicleID}</td><td>${r.name}</td><td>${r.type}</td><td>${r.registrationNumber}</td><td>${r.seatingCapacity}</td><td>${r.farePerKM}</td><td><a href="modifyVehicle/${r.vehicleID}">Edit</a></td><td><a href="dodelVehicle/${r.vehicleID}">Delete</a></td></tr>
	</c:forEach>
</table>
</body>
</html>