<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>

<body>
<form method="post" action="UserAuthentication">
	<h1>Login!!!!!!!!!</h1>
	<font color="red">
	<%request.getParameter("msg"); %></font><br/><br/>
	Username: <input type="text" id="txtUsername" name="txtUsername"/><br/><br/>
	Password: <input type="password" id="txtPassword" name="txtPassword"/><br/><br/>
	<input type="submit" id="sbtLogin" name="sbtLogin" value="Login" style="margin-left: 100px"/>
</form>
</body>
</html>