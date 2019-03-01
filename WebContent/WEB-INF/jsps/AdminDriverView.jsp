<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/ATA/static/css/table.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/HeaderAdmin.jsp"/>
<table cellspacing="10px" align="center">
<tr><th>DriverID</th><th>Name</th><th>Street</th><th>Location</th><th>City</th><th>State</th><th>Pincode</th><th>MobileNumber</th><th>LicenseNo.</th><th>Edit</th><th>Delete</th></tr>
	<c:forEach var="r"  items="${list}">
		<tr><td>${r.driverID}</td><td>${r.name}</td><td>${r.street}</td><td>${r.location}</td><td>${r.city}</td><td>${r.state}</td><td>${r.pincode}</td><td>${r.mobileNo}</td><td>${r.licenseNumber}</td><td><a href="modifyDriver/${r.driverID}">Edit</a></td><td><a href="dodelDriver/${r.driverID}">Delete</a></td></tr>
	</c:forEach>
</table>
</body>
</html>