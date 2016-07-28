<%@page import="com.au.assignment.jndi.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<%
Employee e=(Employee)request.getAttribute("emp");

	out.print(e.getUsername()+" ");
	out.print(e.getPassword()+" ");
	out.print(e.getEmailid()+" ");
	out.print(e.getAddress()+" ");
	out.println("\n");



%>
</html>