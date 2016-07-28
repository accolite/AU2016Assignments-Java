<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new employee</title>
</head>
<body>
<form action="/TomcatAssignment/addnew" method="POST">
	<label for="name">Name</label> <input type="text" name="name"/><br/>
	<label for="designation">Designation</label> <input type="text" name="designation"/><br/>
	<label for="email">Email ID</label> <input type="email" name="email"/><br/>
	<input type="submit" value="Add"/>
</form>
<br/><br/>


</body>
</html>