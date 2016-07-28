<%@page import="model.Manager"%>
<%@ page import="model.Employee" %>
<%@page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager Page</title>
</head>

<body>
<% 
	Manager manager=(Manager) request.getSession().getAttribute("EMPLOYEE_LIST");
%>
<h1>Manager Page</h1>
<br>
<br>

<table border="1">
    <th>
        Employee ID
    </th>
    <th>
        Employee Name
    </th>
    <th>
        Employee Email
    </th>
	<th>
        Employee Address
    </th>
    
    <%
    List<Employee> emp=manager.getEmployeeList();
    for(int i=0;i<emp.size();i++){ %>
    <tr>
    	<td><%= emp.get(i).getEmployeeId()%></td>
    	<td><%= emp.get(i).getName()%></td>
        <td><%= emp.get(i).getEmail()%></td>
        <td><%= emp.get(i).getAddress()%></td>
    </tr>
	<% } %>
</table>
<br/>
<br/>
<form method="get" action="AddEmployee.jsp">
    <input style="margin-left: 100px" type="submit" value="Add Employee"/>
</form>


</body>
</html>
