<%@page import="com.au.servlet.bean.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% Employee emp = (Employee)request.getAttribute("emp"); %>

<h2> Your details </h2>

<label>Emp ID: </label> <span> <%=emp.getId() %></span><br/>
<label>Name: </label> <span> <%=emp.getName() %></span><br/>
<label>Designation: </label> <span> <%=emp.getDesignation() %></span><br/>
<label>Email ID: </label> <span> <%=emp.getEmail() %></span><br/>

<br/>


</body>
</html>