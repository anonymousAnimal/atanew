<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Administrator</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<!-- <h2 align="center">Welcome to ATA</h2>
	<div align="right"><button  onclick="window.location = '/ATA/logout'">LOGOUT</button></div>
	<hr style="margin-top: 10px"/> -->
	
	<!-- navigation bar  -->
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/ATA/">ATA</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/ATA/Admin/Dashboard">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Route <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/ATA/Admin/addroute">Add</a></li>
          <li><a href="/ATA/Admin/goToEditDelete">Modify/Delete</a></li>
        </ul>
      </li>
      
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Driver<span class="caret"></span></a>
        <ul class="dropdown-menu">
         <li><a href="/ATA/Admin/addDriver">Add</a></li>
          <li><a href="/ATA/Admin/driverEditDelete">Modify/Delete</a></li>
        </ul>
      </li>
      
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Vehicle <span class="caret"></span></a>
        <ul class="dropdown-menu">
        <li><a href="/ATA/Admin/addVehicle">Add</a></li>
          <li><a href="/ATA/Admin/vehicleEditDelete">Modify/Delete</a></li>
        </ul>
      </li>
      
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/ATA/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>


</body>
</html>