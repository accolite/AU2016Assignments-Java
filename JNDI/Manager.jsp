<%@page import="java.util.Iterator"%>
<%@page import="com.au.tomcat.assignment.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager</title>
</head>
<body>
<% List<Employee> emps = (List<Employee>)request.getAttribute("employees"); %>
<table>
<% for(Employee emp: emps){ %>
<tr> 
 <td> <%=emp.getEmployeeID() %> </td>
 <td> <%=emp.getEmployeeName() %> </td> 
 <td> <%=emp.getEmployeeMail() %> </td>
</tr>
<%}%>
</table>
<input type="button"  value="add"  id="myButton" onclick="addEmployee()"/>
<script>
function addEmployee(){
document.getElementById("myButton").onclick = function () {
    location.href = "EmployeeForm.html";
};
}
</script>
</body>
</html>