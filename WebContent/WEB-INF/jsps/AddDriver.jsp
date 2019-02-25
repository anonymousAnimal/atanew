<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addDriver1">
<table align="center">
<tr><td>DriverName:<input type="text"  name="name"></td></tr>
<tr><td>Street:<input type="text" name="street"></td></tr>
<tr><td>Location:<input type="text" name="location"></td></tr>
<tr><td>City:<input type="text" name="city"></td></tr>
<tr><td>State: <input type="text"  name="state"></td></tr>
<tr><td>Pincode:<input type="text"  name="pincode"></td></tr>
<tr><td>MobileNo:<input type="text"  name="mobileNo"></td></tr>
<tr><td>LicenseNumber:<input type="text"  name="licenseNumber"></td></tr>
<tr><td><input type="submit" value="Add Driver"></td></tr>
</table>
</form>
${msg}
${driverBean.driverID}
</body>
</html>