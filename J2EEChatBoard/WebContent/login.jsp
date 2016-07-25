<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	
<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
	Name:<input type="text" name="name1"></input>
	Password:<input type="password" name="pass1"></input>
    <input type="button"  value="login"></input>
</form>
</body>
</html>