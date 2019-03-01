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

	
	<div align="center">
	<f:form action="Page2" modelAttribute="reservationBean" method="POST">
	<table cellpadding="10px" cellspacing="20px">
	
	<tr><th>Journey date</th> <td><f:input  type="date" path="journeyDate" /></td></tr>
		
		
	<!-- dropdown sourcelist -->
		<tr><th>Source </th>
		<td><select id = "selectsourcelist"  onchange="getDestination(this.value, 'divdestination')" name="source" >
		<option id="0" value="NONE">NONE</option>
		<c:forEach var="s" items="${sourcelist}">
			<option id="${s}" value="${s}" label="${s}">${s}</option>
		</c:forEach>
		</select>
		</td></tr>
		<!-- dropdown destination list -->
		<tr></tr><tr></tr>
		 
		<tr>
		<th>Destination </th>
		<td>
		<div id= "divdestination" >
		<select id ="destinationlist" disabled="disabled">
			<option id= "0" value="NONE">NONE</option>
		</select>
		</div>
		</td></tr>
		
		
		<!-- boarding and droppoint input text -->
		
		<tr><th>BoardingPoint</th><td><f:input type="text" name="txtboardingPoint" path="boardingPoint" required="true"/></td></tr>
		<tr><th>DestinationPoint</th><th><f:input type="text" name="txtdestinationPoint" path="dropPoint" required="true"/></th></tr>
		
		<tr><th>Typelist </th>
		<th><select id = "selecttypelist"  onchange="getVehicles('selecttypelist','selectseatlist', 'divvehicle')" >
		<option id="NONE" label="NONE" value="">NONE</option>
		<c:forEach var="s" items="${typelist}">
			<option id="${s}" value="${s}" label="${s}">${s}</option>
		</c:forEach>
		<option id="ALL" label="ALL" value="">ALL</option>
		</select>
		</th></tr>
		
		<tr><th>Seatlist</th>
		<td><select id = "selectseatlist"  onchange="getVehicles('selecttypelist','selectseatlist', 'divvehicle')" >
		<option id="NONE" label="NONE" value="NONE">NONE</option>
		<c:forEach var="s" items="${seatlist}">
			<option id="${s}" value="${s}" label="${s}">${s}</option>
		</c:forEach>
		<option id="ALL" label="ALL" value="">ALL</option>
		</select>
		</td></tr>
		
		
		
		<!-- vehicle list  -->
		<tr><th>choose the vehicle </th>
		<td>
		<div name="divvehicle" id="divvehicle" >
		<select name="vehicleid" id="selectvehiclelist" disabled="disabled" >
			<option id="0" value="" label="NONE">NONE</option>
		</select>
		</div>
		</td>
		</tr>
		</table>
		<br>
		<f:button name="submit" >Proceed to Next Page</f:button>
		
	</f:form>
	</div>
</body>
</html>