<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<!-- <div style="background-image: url('paper.gif'); background-color: #000000;">
	<h2 align="center" style="color:#000000">Welcome to ATA</h2>
	</div>
	<div align="right"><button  onclick="window.location = '/ATA/logout'">LOGOUT</button></div> -->
	
	<!-- navigation bar  -->
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/ATA/">ATA</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/ATA/User/Dashboard">Home</a></li>
     <!--  <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
      <li><a href="#">Page 2</a></li> -->
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/ATA/register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="/ATA/logout"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>


</body>
</html>