<%@page import="com.au.tomcatassignment.Employee"%>
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
<%-- <c:forEach items="${empList}" var="dList">
<tr>
    <td></td>
    <td>${dList.empId}</td>
    <td>${dList.empName}</td>
    <td>${dList.password}</td>
    <td>${dList.role}</td>
    <td>${dList.email}</td>
</tr>
</c:forEach> --%>

<%
	List<Employee> list=(List<Employee>)request.getAttribute("empList");
	Employee emp;
	
	out.print("EMP ID\t");
	out.print("EMP NAME\t");
	out.print("PasswordID\t");
	out.print("ROLE\t");
	out.print("EMAIL\t");
	
	for(int i=0;i<list.size();i++)
	{
		emp=list.get(i);	
		out.print(emp.getEmpId()+"\t");
		out.print(emp.getEmpName()+"\t");
		out.print(emp.getPassword()+"\t");
		out.print(emp.getRole()+"\t");
		out.print(emp.getEmail()+"\t");
		out.print("");
	}
	
%>
<hr>
<hr>
<form action="newEmployee" method="post">
Employee Name: <input type="text" name="name">
Employee Password: <input type="password" name="pass">
Employee Role: <input type="text" name="role">
Employee Email: <input type="text" name="email">
<input type="submit" value="submit">
</form>

</body>
</html>