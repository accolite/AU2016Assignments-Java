<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta charset="ISO-8859-1">  
<title>Servlet Login</title>  
</head>  
<body>  
<form action="/ChatBox/CheckStatus" method="Post">
 UserName: <input type="text" name="username">
 Password: <input type="text" name="password"><br>
  <input type="radio" name="option" value="login"> Login<br>
  <input type="radio" name="option" value="register"> Register<br>
  <input type="radio" name="option" value="admin"> Admin
  <br>
  <input type="submit" value="Submit"> </form>
</body>  
</html>  