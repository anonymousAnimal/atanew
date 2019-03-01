<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/ATA/static/css/Basic1.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	.error{
		color:red;
		font-style:italic;
	}
</style>
</head>
<body>
<div class="container">
<h1 id="main-title">Registration Form</h1>
 <p id="subtitle">It only takes a minute!</p>
<f:form action="doregister" modelAttribute ="profileBean" method="POST">
<table align="center">

<tr><td><b>First Name</b></td><td> <f:input type="text" path="firstName" id="pl_first_name"></f:input></td><td><f:errors path = "firstName" cssClass="error"/></td></tr>


<tr><td><b>Last Name</b></td><td><f:input type="text" path="lastName"></f:input></td><td><f:errors path = "lastName" cssClass="error"/></td></tr>
<tr><td><b>Date of Birth</b></td><td><f:input  type="date" path="dateOfBirth" ></f:input></td><td><f:errors path = "dateOfBirth" cssClass="error"/></td></tr>
<!-- <tr><td>Date of Birth</td><td><input type="text" name="dob"/></td></tr> -->
<tr><td><b>Street</b></td><td><f:input type="text" path="street"></f:input></td><td><f:errors path = "street" cssClass="error"/></td></tr>
<tr><td><b>Gender</b></td><td><f:radiobutton path="gender" value="M" />Male &nbsp;<f:radiobutton path="gender" value="F" />Female</td>
<td><f:errors path = "gender" cssClass="error"/></td>
</tr>
<tr><td><b>Location</b></td><td><f:input type="text" path="location"></f:input></td><td><f:errors path = "location" cssClass="error"/></td></tr>
<tr><td><b>City</b></td><td><f:input type="text" path="city"></f:input></td><td><f:errors path = "city" cssClass="error"/></td></tr>
<tr><td><b>State</b></td><td><f:input type="text" path="state"></f:input></td><td><f:errors path = "state" cssClass="error"/></td></tr>
<tr><td><b>Pincode</b></td><td><f:input type="text" path="pincode"></f:input></td><td><f:errors path = "pincode" cssClass="error"/></td></tr>
<tr><td><b>Mobile no</b></td><td><f:input type="text" path="mobileNo"></f:input></td><td><f:errors path = "mobileNo" cssClass="error"/></td></tr>
<tr><td><b>Email</b></td><td><f:input type="text" path="emailID"></f:input></td></tr>
<tr><td><b>Password </b></td><td><f:input type="password" path="password"></f:input></td><td><f:errors path = "password" cssClass="error"/></td></tr>
<tr><td><input type="submit" value="Signup" id="a-submit"></td></tr>
<tr><td colspan="2"><a href="login">Already a user?Login here</a></td></tr>

</table>
</f:form>

</div>
</body>
</html>