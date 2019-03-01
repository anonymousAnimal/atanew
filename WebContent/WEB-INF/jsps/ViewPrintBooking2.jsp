<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/ATA/static/css/table.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View print booking details</title>
</head>
<body>
<h1 align="center" >Automated Travel Agency Project</h1>
	
<table align="center" >
<caption align="top" style="color:red;">Reservation Details</caption>
<tr><th>UserID:</th><th>${reservationBean.userID}</th></tr>
<tr><th>reservationID:</th><th>${reservationBean.reservationID}</th></tr>
<tr><th>booking date:</th><th>${reservationBean.bookingDate}</th></tr>
<tr><th>journey date:</th><th>${reservationBean.journeyDate}</th></tr>
<tr><th>boarding Point:</th><th>${reservationBean.boardingPoint}</th></tr>
<tr><th>drop point:</th><th>${reservationBean.dropPoint}</th></tr>
<tr><th>booking status:</th><th>${reservationBean.bookingStatus}</th></tr>
<tr><th>Booking amount (Paid):</th><th>${reservationBean.totalFare}</th></tr>
</table>
<div align="center"><button onclick="window.print()" >Print details</button></div>
</body>
</html>