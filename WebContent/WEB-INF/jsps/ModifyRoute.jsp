<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/ATA/static/css/table.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/HeaderAdmin.jsp"></jsp:include>
<h1>Modify Route</h1>
<f:form action="/ATA/Admin/modifyRoute" modelAttribute="routeBean" >
<table align="center">
<tr><td>RouteID:<f:input type="text"  path="routeID" value="${routeBean.routeID}" readonly="true"/></td></tr>
<tr><td>Source:<f:input type="text" path="source" value="${routeBean.source}"/></td></tr>
<tr><td>Destination:<f:input type="text" path="destination" value="${routeBean.destination}"/></td></tr>
<tr><td>Distance:<f:input type="text" path="distance" value= "${routeBean.distance}"/></td></tr>
<tr><td>TravelDuration: <f:input type="text"  path="travelduration" value="${routeBean.travelduration}"/></td></tr>
<tr><td><input type="submit" value="Modify Route"></td></tr>
</table>
</f:form>
${msg}
</body>
</html>