<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="/ATA/js/bookvehicle.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book vehicle</title>
</head>
<body onload="checkajax()">
<jsp:include page="/HeaderUser.jsp"></jsp:include>

	<f:form action="Page2" modelAttribute="reservationBean" method="POST">
	journey date : <f:input  type="date" path="journeyDate" ></f:input>
	
	<!-- dropdown sourcelist -->Source : 
		<select id = "selectsourcelist"  onchange="getDestination(this.value, 'divdestination')" name="source">
		<option id="0" value="NONE">NONE</option>
		<c:forEach var="s" items="${sourcelist}">
			<option id="${s}" value="${s}" label="${s}">${s}</option>
		</c:forEach>
		</select>
		
		<!-- dropdown destination list -->Destination : 
		<div id= "divdestination" >
		<select id ="destinationlist" disabled="disabled" >
			<option id= "0" value="NONE">NONE</option>
		</select>
		</div>
		
		<!-- boarding and droppoint input text -->
		BoardingPoint : <f:input type="text" name="txtboardingPoint" path="boardingPoint"/><br>
		DestinationPoint: <f:input type="text" name="txtdestinationPoint" path="dropPoint"/><br>
		
		<!-- radio button for vehicle list -->
		<!-- <input type="radio" name="radiovehiclecriteria"  id="bytype" value="type" onclick="getvehicles('divvehicle')"> type
		<input type="radio" name="radiovehiclecriteria" id="byseat" value="seat" onclick="getvehicles('divvehicle')"> seat -->
		
		typelist : 
		<select id = "selecttypelist"  onchange="getVehicles('selecttypelist','selectseatlist', 'divvehicle')" ;">
		<option id="NONE" label="NONE" value="">NONE</option>
		<c:forEach var="s" items="${typelist}">
			<option id="${s}" value="${s}" label="${s}">${s}</option>
		</c:forEach>
		<option id="ALL" label="ALL" value="">ALL</option>
		</select>
		<br>
		<br>
		seatlist : 
		<select id = "selectseatlist"  onchange="getVehicles('selecttypelist','selectseatlist', 'divvehicle')" ;">
		<option id="NONE" label="NONE" value="NONE">NONE</option>
		<c:forEach var="s" items="${seatlist}">
			<option id="${s}" value="${s}" label="${s}">${s}</option>
		</c:forEach>
		<option id="ALL" label="ALL" value="">ALL</option>
		</select>
		
		
		<br>
		<!-- vehicle list  -->
		<div name="divvehicle" id="divvehicle" >
		<select name="vehicleid" id="selectvehiclelist" disabled="disabled" >
			<option id="0" value="" label="NONE">NONE</option>
		</select>
		</div>
		
		
		<f:button name="submit" >proceed>>></f:button>
	</f:form>
</body>
</html>