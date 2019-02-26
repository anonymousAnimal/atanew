<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<body>
<%-- <form action="Logout" >
<button type="submit">logout</button> </form>--%>
<jsp:include page="/Header.jsp"></jsp:include>

<h1>Your Details : </h1>
<table align="center">
<tr><td>UserID</td><td>${profileBean.userID}</td></tr>
<tr><td>firstname</td><td>${profileBean.firstName}</td></tr>
<tr><td>lastname</td><td>${profileBean.lastName}</td></tr>
<tr><td>date of birth</td><td>${profileBean.dateOfBirth}</td></tr>
<tr><td>gender</td><td>${profileBean.gender}</td></tr>
<tr><td>street</td><td>${profileBean.street}</td></tr>
<tr><td>location</td><td>${profileBean.location}</td></tr>
<tr><td>city</td><td>${profileBean.city}</td></tr>
<tr><td>state</td><td>${profileBean.state}</td></tr>
<tr><td>pincode</td><td>${profileBean.pincode}</td></tr>
<tr><td>mobileno</td><td>${profileBean.mobileNo}</td></tr>
<tr><td>emailID</td><td>${profileBean.emailID}</td></tr>
<tr><td><button onclick="history.go(-1)">Go to DashBoard</button></td></tr>
</table>

</body>
</html>