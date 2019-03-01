<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <link rel="stylesheet" type="text/css" href="/ATA/static/css/table.css" /> -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD Driver</title>
</head>
<body>
<jsp:include page="/HeaderAdmin.jsp"></jsp:include>
<h1>Add Driver</h1>
<form action="addDriver1" method="post">
<table align="center">
<tr><td>DriverName</td><td><input type="text"  name="name" required="true"></td></tr>
<tr><td>Street</td><td><input type="text" name="street" required="true"></td></tr>
<tr><td>Location</td><td><input type="text" name="location" required="true"></td></tr>
<tr><td>City</td><td><input type="text" name="city" required="true"></td></tr>
<tr><td>State</td><td> <input type="text"  name="state" required="true"></td></tr>
<tr><td>Pincode</td><td><input type="text"  name="pincode" required="true"></td></tr>
<tr><td>MobileNo</td><td><input type="text"  name="mobileNo" required="true"></td></tr>
<tr><td>LicenseNumber</td><td><input type="text"  name="licenseNumber" required="true"></td></tr>
<tr><td colspan="2"><input type="submit" value="Add Driver"></td></tr>
</table>
</form>
${msg}
${driverBean.driverID}
</body>
</html>