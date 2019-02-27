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
	<f:form action=""  modelAttribute = "reservationBean">
	
	<!-- dropdown sourcelist -->
		<select id = "selectsourcelist"  onchange="getData(this.value, 'divdestination')">
		<option id="0" value="NONE">NONE</option>
		<c:forEach var="s" items="${sourcelist}">
			<option id="${s}" value="${s}" label="${s}"></option>
		</c:forEach>
		</select>
		
		<!-- dropdown destination list -->
		<div id= "divdestination">
		<select id ="destinationlist" disabled="disabled" >
			<option id= "0" value="NONE">NONE</option>
		</select>
		</div>
		
		<!-- boarding and droppoint input text -->
		BoardingPoint : <input type="text" name="txtboardingPoint"/>
		DestinationPoint: <input type="text" name="txtdestinationPoint"/>
		
		
		<!-- radio button for vehicle list -->
		<input type="radio" name="radiovehiclecriteria"  id="bytype" value="type" onselect="getvehicles(divvehicle) "> type
		<input type="radio" name="radiovehiclecriteria" id="byseat" value="seat" > seat
		
		<!-- vehicle list  -->
		<div id="divvehicle" >
		<select id="selectvehiclelist" disabled="disabled">
			<option id="0" value="NONE">NONE</option>
		</select>
		</div>
		
		
		<f:button name="submit" >proceed>>></f:button>
	</f:form>
</body>
</html>