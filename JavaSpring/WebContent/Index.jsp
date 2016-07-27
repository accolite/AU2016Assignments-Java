<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Chat Box!</h1>
	<%
    out.println("First page");
    if((session.getAttribute("user")== null ) || (session.getAttribute("user")== "")){
     %>Login First!
	</br>
	<a href="Login.jsp">Login Here!</a> <br>
	<a href="Register.jsp">Register Here!</a>
	<% } else {
        %>
	Welcome! 
	<%=session.getAttribute("user") %>
	<a href="Logout.jsp">Logged out</a>
	<%
        }
    %>
	
</body>
</html>