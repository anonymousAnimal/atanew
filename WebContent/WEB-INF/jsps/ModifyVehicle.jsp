<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/ATA/static/css/table.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/HeaderAdmin.jsp"></jsp:include>
<h1>Modify Vehicle</h1>
<f:form action="/ATA/Admin/modifyVehicle1" modelAttribute="vehicleBean" >
<table align="center">
<tr><td>VehicleID:<f:input type="text"  path="vehicleID" value="${vehicleBean.vehicleID}" readonly="true" /></td></tr>
<tr><td>VehicleName:<f:input type="text"  path="name" value="${vehicleBean.name}" /></td></tr>
<tr><td>VehicleType:<f:input type="text"  path="type" value="${vehicleBean.type}" /></td></tr>
<tr><td>VehicleRegistrationNumber:<f:input type="text"  path="registrationNumber" value="${vehicleBean.registrationNumber}" /></td></tr>
<tr><td>SeatingCapacity:<f:input type="text"  path="seatingCapacity" value="${vehicleBean.seatingCapacity}" /></td></tr>
<tr><td>FarePerKm:<f:input type="text"  path="farePerKM" value="${vehicleBean.farePerKM}" /></td></tr>

<tr><td><input type="submit" value="Modify Vehicle"></td></tr>
</table>
</f:form>
</body>
</html>