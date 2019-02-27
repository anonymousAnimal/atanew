<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book vehicle</title>
</head>
<body>
	<f:form action="">
		<f:select path="vehicleId">
			<f:option value="NONE" label="Select"/>
			<f:options items="avail" />
		</f:select>
	</f:form>
</body>
</html>