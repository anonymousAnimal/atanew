<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/ATA/static/css/table.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit/Delete</title>
</head>
<body>
<jsp:include page="/HeaderAdmin.jsp"/>
<table cellspacing="10px" align="center">
<tr><th>RouteID</th><th>Source</th><th>Destination</th><th>Distance</th><th>TravelDuration</th><th>Edit</th><th>Delete</th></tr>
	<c:forEach var="r"  items="${list}">
		<tr><td>${r.routeID}</td><td>${r.source}</td><td>${r.destination}</td><td>${r.distance}</td><td>${r.travelduration}</td><td><a href="domodify/${r.routeID}">Edit</a></td><td><a href="dodelRoute/${r.routeID}">Delete</a></td></tr>
	</c:forEach>
</table>
</body>
</html>