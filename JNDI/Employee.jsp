<%@page import="com.au.tomcat.assignment.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Employee emps = (Employee)request.getAttribute("employees"); %>
<table>
<tr> 
 <td> <%=emps.getEmployeeID() %> </td>
 <td> <%=emps.getEmployeeName() %> </td> 
 <td> <%=emps.getEmployeeMail() %> </td>
</tr>
</table>
</body>
</html>