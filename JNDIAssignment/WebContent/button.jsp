<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.au.hello.EmployeeDetails"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<% 

List<EmployeeDetails> emp=(List<EmployeeDetails>)request.getAttribute("EmpList");

EmployeeDetails details=new EmployeeDetails();
Iterator i=emp.iterator();

while(i.hasNext())
{
	details=(EmployeeDetails)i.next();
out.println(details.getUsername());
out.println(details.getPassword());
out.println(details.getEmail());
out.println(details.getAddress());
out.println("\n");
}

%>
	 <form action="/HelloWorld/AddEmployee.jsp" METHOD="POST">
           <!-- <INPUT TYPE="BUTTON" VALUE="Button 1" > --> 
            <input type="submit" value="Add">
     </form>  
</body>
</html>