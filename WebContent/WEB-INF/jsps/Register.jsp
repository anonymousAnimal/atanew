<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

</style>
</head>
<body>
<f:form action="doregister" modelAttribute ="profileBean" method="POST">
<table align="center">
<tr><td>First Name</td><td> <f:input type="text" path="firstName"></f:input></td></tr>
<tr><td>Last Name</td><td><f:input type="text" path="lastName"></f:input></td></tr>
<tr><td>Date of Birth</td><td><f:input type="date" path="dateOfBirth" ></f:input></td></tr>
<!-- <tr><td>Date of Birth</td><td><input type="text" name="dob"/></td></tr> -->
<tr><td>Street</td><td><f:input type="text" path="street"></f:input></td></tr>
<tr><td>Gender</td><td><f:radiobutton path="gender" value="M" />Male &nbsp;<f:radiobutton path="gender" value="F" />Female</td></tr>
<tr><td>Location</td><td><f:input type="text" path="location"></f:input></td></tr>
<tr><td>City</td><td><f:input type="text" path="city"></f:input></td></tr>
<tr><td>State</td><td><f:input type="text" path="state"></f:input></td></tr>
<tr><td>Pincode</td><td><f:input type="text" path="pincode"></f:input></td></tr>
<tr><td>Mobile no</td><td><f:input type="text" path="mobileNo"></f:input></td></tr>
<tr><td>Email</td><td><f:input type="text" path="emailID"></f:input></td></tr>
<tr><td>Password </td><td><f:input type="password" path="password"></f:input></td></tr>
<tr><td><input type="submit" value="Signup" ></td></tr>
<tr><td colspan="2"><a href="login">Already a user?Login here</a></td></tr>

</table>
</f:form>
</body>
</html>