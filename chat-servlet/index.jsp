<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	.button{
		align:center;
		-webkit-appearance: button;
	    -moz-appearance: button;
	    appearance: button;
		display : inline;
	    text-decoration: none;
	    color: initial;
	    margin-right:15%;
	    border-left:15%;
	}
</style>
</head>
<body>
	<%
		response.addHeader("Hello", "hello");
		try{
			
		String user = (String)session.getAttribute("user");
		if( user != null){
			response.sendRedirect("http://localhost:8080/chat.html");
		}
		}
		catch(Exception e){
			System.out.println("Session not created");
		}
	%>
		<a href="register.html" class="button">Register</a>
		<a href="adminLogin.html" class="button">Admin</a>
		<a href="userLogin.html" class="button">Login</a>
</body>
</html>