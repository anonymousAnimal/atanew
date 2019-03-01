<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/ATA/static/css/cards.css" />
<meta charset="ISO-8859-1">
<title>User Dashboard</title>
</head>
<body>
<jsp:include page="/HeaderUser.jsp"/>
<h2>Welcome ${profileBean.getFirstName()} ${profileBean.getLastName()}</h2> 
<!-- <div align="right"><button onclick="window.location='../logout'">logout</button></div> -->


<div class="card" onclick="" style="display:block-inline" >
<a href = "Profile">
  <img src="/ATA/static/images/male_avatar.png" alt="Avatar" style="width:100%" ></a>
  <div class="container" >
  <h4 >
  <a href = "Profile">
  <b>Profile</b> 
  </a>
  </h4>
  </div>
</div>

<div class="card" onclick="" style="display:block-inline" >
<a href = "ViewVehiclesAndRoutes">
  <img src="/ATA/static/images/male_avatar.png" alt="Avatar" style="width:100%" ></a>
  <div class="container" >
  <h4 >
  <a href = "ViewVehiclesAndRoutes">
  <b>vehicles/routes details</b> 
  </a>
  </h4>
  </div>
</div>


<div class="card" onclick="" style="display:block-inline" >
<a href = "/ATA/Booking/BookVehicle">
  <img src="/ATA/static/images/male_avatar.png" alt="Avatar" style="width:100%" ></a>
  <div class="container" >
  <h4 >
  <a href = "/ATA/Booking/BookVehicle">
  <b>book vehicle</b> 
  </a>
  </h4>
  </div>
</div>

<div class="card" onclick="" style="display:block-inline" >
<a href = "/ATA/Booking/CancelBooking">
  <img src="/ATA/static/images/male_avatar.png" alt="Avatar" style="width:100%" ></a>
  <div class="container" >
  <h4 >
  <a href = "/ATA/Booking/CancelBooking">
  <b>cancel booking
  </b> 
  </a>
  </h4>
  </div>
</div>

<div class="card" onclick="" style="display:block-inline" >
<a href = "/ATA/Booking/ViewBooking">
  <img src="/ATA/static/images/male_avatar.png" alt="Avatar" style="width:100%" ></a>
  <div class="container" >
  <h4 >
  <a href = "/ATA/Booking/ViewBooking">
  <b>View/Print Booking Details</b> 
  </a>
  </h4>
  </div>
</div>


<!-- <div align="center">
please choose below options :<br>
<a href="Profile">View Profile</a><br><br>
<a href="ViewVehiclesAndRoutes">view vehicles/Route Details</a><br><br>
<a href="/ATA/Booking/BookVehicle">Book Vehicle</a><br><br>
<a href="/ATA/Booking/CancelBooking">Cancel Booking</a><br><br>
<a href="/ATA/Booking/ViewBooking">View/Print Booking Details</a><br><br>
</div> -->
</body>
</html>