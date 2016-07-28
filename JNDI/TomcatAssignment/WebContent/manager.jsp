<%@page import="com.au.servlet.bean.Employee"%>
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

<% List<Employee> emps = (List<Employee>)request.getAttribute("emps"); %>


List of employees in the db <br/>
<table>
<tr> <td> ID </td> <td> Name </td> <td> Designation </td> <td> Email ID </td> </tr>
<% for(Employee emp: emps){ %>
<tr> 
	<td> <%=emp.getId() %> </td>
	<td> <%=emp.getName() %> </td>	
	<td> <%=emp.getDesignation() %> </td>	
	<td> <%=emp.getEmail() %> </td>
</tr>
<%}
%>
</table>
<br/>
<a href="addnew.jsp"><input type = "button" value="Add new employee"></a> <br/><br/>
</body>
</html>