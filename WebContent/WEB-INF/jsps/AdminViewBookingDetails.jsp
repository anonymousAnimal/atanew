<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/ATA/static/css/table.css" />
<script type="text/javascript" src="/ATA/js/AllotDriver.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="checkAjax()">

<jsp:include page="/HeaderAdmin.jsp"></jsp:include>
<div id="result" align="center">

<table>
<tr>
<td>Source</td><td><select name="sourcename" id="source" onchange="getDestination(this.value)"> 
<option value="NONE" label="Select Source"></option>
<c:forEach var="s" items="${sourceSet}">
<option value="${s}">${s}</option>
</c:forEach>
</select></td>
</tr>

<tr>
<td>Destination</td><td><div id="destdiv">
<select name="destinationname" id="destination" disabled="disabled">
	<option id= "0" value="NONE">NONE</option>
</select>
</div>
</td></tr>

<tr>
<td>Journey Date</td><td><input type="date" name="journeyDate" id="journeyDate" ></td></tr>
</table>
<br><button onclick="viewBooking('journeyDate','source','destination')">View Details</button>
</div>

</body>
</html>