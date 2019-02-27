<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<table cellspacing="10px" align="center">
<tr><th>ReservationID</th><th>UserID</th><th>RouteID</th><th>BookingDate</th><th>JourneyDate</th><th>VehicleID</th><th>DriverID</th><th>BookingStatus</th><th>TotalFare</th><th>BoardingPoint</th><th>DropPoint</th></tr>
	<c:forEach var="r"  items="${ReservationList}">
		<tr><td>${r.reservationID}</td><td>${r.userID}</td><td>${r.routeID}</td><td>${r.bookingDate}</td><td>${r.journeyDate}</td><td>${r.vehicleID}</td><td>${r.driverID}</td><td>${r.bookingStatus}</td><td>${r.totalFare}</td><td>${r.boardingPoint}</td><td>${r.dropPoint}</td></tr>
	</c:forEach>
</table>
</body>


</body>
</html>