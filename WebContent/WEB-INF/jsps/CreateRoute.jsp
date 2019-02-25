<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="doRoute">
Source:<input type="text"  name="source">
Destination:<input type="text" name="destination">
Distance:<input type="text" name="distance">
TravelDuration:<input type="text" name="travelduration">
<input type="submit" value="Add Route">
</form>
${msg}
${routeBean.routeID}
</body>
</html>