<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="doRoute" method="POST">
Source:<input type="text"  name="source"><br>
Destination:<input type="text" name="destination"><br>
Distance:<input type="text" name="distance"><br>
TravelDuration:<input type="text" name="travelduration"><br>
<input type="submit" value="Add Route"><br>
</form>
${msg}
${routeBean.routeID}
</body>
</html>