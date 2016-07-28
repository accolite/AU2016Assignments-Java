<%--
  Created by IntelliJ IDEA.
  User: Mitul Kapoor
  Date: 7/28/2016
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>

<h1>Add Employee</h1>
<br>
<br>

<form method="post" action="AddEmployeeServlet">
    Employee Name: <input type="text" id="txtName" name="txtName"/>
    Employee Email: <input type="text" id="txtEmail" name="txtEmail"/>
    Employee Address: <textarea rows="4" cols="50" id="taAddress" name="taAddress"></textarea>
    <input type="submit" value="Add"/>
</form>


</body>
</html>
