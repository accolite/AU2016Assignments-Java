<%--
  Created by IntelliJ IDEA.
  User: Mitul Kapoor
  Date: 7/28/2016
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="model.Employee"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
</head>
<body>
<form>
	<%
		Employee employee=(Employee) request.getSession().getAttribute("EMPLOYEE");
	%>
	<h1>Employee</h1>	
	<br/>
	<br/>
	Employee id : <%= employee.getEmployeeId() %>
	<br/>
	<br/>
	Employee Name : <%= employee.getName() %>
	<br/>
	<br/>
	Employee Email : <%= employee.getEmail() %>
	<br/>
	<br/>
	Employee Address : <%= employee.getAddress() %>
</form>
</body>
</html>
