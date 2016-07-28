<%@page import="com.au.tomcatassignment.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Employee Details</h1>
<%
	Employee emp=(Employee)request.getAttribute("empObj");
	
	out.print("EMP ID\t");
	out.print("EMP NAME\t");
	/* out.print("PasswordID\t"); */
	out.print("ROLE\t");
	out.print("EMAIL\t");
	out.println("\n");
	
		
	out.print(emp.getEmpId()+"\t");
	out.print(emp.getEmpName()+"\t");
	/* out.print(emp.getPassword()+"\t"); */
	out.print(emp.getRole()+"\t");
	out.print(emp.getEmail()+"\t");
	out.println("\n");
	
%>
</body>
</html>