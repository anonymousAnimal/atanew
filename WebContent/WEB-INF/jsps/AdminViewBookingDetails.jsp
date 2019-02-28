<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="ATA/js/AllotDriver.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="checkAjax()">
<jsp:include page="/Header.jsp"></jsp:include>
<div id="result">

Source:<br>
<select name="sourcename" id="source" onchange="getDestination(this.value,'destdiv')"> 
<option value="NONE" label="Select Source"></option>
<c:forEach var="s" items="${SourceSet}">
<option value="${s}">${s}</option>
</c:forEach>
</select><br>

Destination:<br>
<div id="destdiv">
<select name="destinationname" id="destination" disabled="disabled">
	<option id= "0" value="NONE">NONE</option>
</select>
</div>


<br>Journey Date:<input type="date" name="journeyDate" id="journeydate" >
<br><button onclick="viewBooking('journeydate','source','destination')">View Details</button>
</div>

</body>
</html>