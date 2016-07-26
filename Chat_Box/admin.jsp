<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Admin Page</title>
</head>
<body>
<h1>Welcome admin</h1>
<form action="http://localhost:8081/ChatBoxAssignment/Admin" method="post">
Enter the words comma seperated which are not accepted:<br/>
<textarea rows="10" cols="5"  class="form-control"  name="words"></textarea>
 <button type="submit" class="btn btn-default">Submit</button>
</form>
</body>
</html>