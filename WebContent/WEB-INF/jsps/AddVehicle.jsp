<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/ATA/static/css/table.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/HeaderAdmin.jsp"></jsp:include>
<h1>ADD VEHICLE</h1>

<form action="addVehicle1" method="post">
<table align="center">
<tr><td>VehicleName:<input type="text"  name="name"></td></tr>
<tr><td>VehicleType:<input type="text" name="type"></td></tr>
<tr><td>RegistrationNo:<input type="text" name="registrationNumber"></td></tr>
<tr><td>SeatingCapacity:<input type="text" name="seatingCapacity"></td></tr>
<tr><td>FarePerKM:<input type="text"  name="farePerKM"></td></tr>
<tr><td><input type="submit" value="Add Vehicle"></td></tr>
</table>
</form>
${msg}
${vehicleBean.vehicleID}

</body>
</html>