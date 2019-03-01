<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>view details</title>
</head>
<body>
<jsp:include page="/HeaderUser.jsp"></jsp:include>
<div align="center">
	
	<form action="doViewBooking" target="_blank">
	Select Your Option Below : 
	<select name=reservationId>
		<c:forEach var="r" items="${reservationList}">
			<option id='${r.reservationID}' label="${r.reservationID} ${r.journeyDate} ${r.boardingPoint}-${r.dropPoint }" value="${r.reservationID}">  ${r.reservationID} ${r.journeyDate} ${r.boardingPoint}-${r.dropPoint }</option>
		</c:forEach>
	</select>
	<br><br><br>
	<input type="submit" value="view/print details">
	</form>
</div>
</body>
</html>