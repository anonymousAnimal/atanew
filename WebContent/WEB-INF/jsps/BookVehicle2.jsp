<%@taglib prefix = "f" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	your details are : 
	user id : ${credentialsBean.getUserID() }<br>
	Source : ${routeBean.getSource() }<br>
	Destination : ${routeBean.getDestination() }<br>
	Total Distance : ${routeBean.getDistance()}<br>
	boardingPoint : ${reservationBean.getBoardingPoint() }<br>
	dropingPoint : ${reservationBean.getDropPoint()}<br>
	vehicle : ${vehicleBean.getName() } (${vehicleBean.getType()}): Rs. ${vehicleBean.getFarePerKM()}/perkm<br>
	Total Fare : ${vehicleBean.getFarePerKM() * routeBean.getDistance()}<br>
	
	<f:form modelAttribute="paymentBean" action="CompletePayment" method="POST">
	creditcardnumber : <f:input  name="creditcardnumber" path="creditCardNumber"/>
	valid from : <f:input name="validfrom" path="validFrom"/>
	valid to : <f:input name="validto" path="validTo"/>
	
	<div id = "divbalinfo" hidden="true" > hello this is inside div</div>
	
	<button type="submit" >make payment</button>
	</f:form>
	

</body>
</html>