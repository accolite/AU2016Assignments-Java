<%@page import="java.util.Iterator"%>
<%@page import="com.au.assignment.jndi.Employee"%>
<%@page import="java.util.List"%>
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
List<Employee> e=(List<Employee>)request.getAttribute("employeeList");
Employee emp=new Employee();
Iterator i=e.iterator();
while(i.hasNext())
{
	emp=(Employee)i.next();
	out.print(emp.getUsername()+" ");
	out.print(emp.getPassword()+" ");
	out.print(emp.getEmailid()+" ");
	out.print(emp.getAddress()+" ");
	out.println("<br>");
	out.println("\n");
}


%>
<form action="AddNewEmployee.jsp">
<input type="submit" value="create New Employee" >
</form>

</body>
</html>



		
		

