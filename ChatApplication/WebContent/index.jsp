<%@page import="com.accolite.java.ActiveUsers"%>
<%@page import="com.accolite.java.UserList"%>
<%@page import="com.accolite.java.MessageList"%>
<%@page import="java.util.ArrayList"%>
<%@page import= "java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chat Application</title>
</head>
<body>
<form>
	<%
		UserList usrlst=new UserList();
		ActiveUsers activeUsrlst=new ActiveUsers();
		MessageList msglst=new MessageList();
		ServletContext app=getServletConfig().getServletContext();
		if(app.getAttribute("USERS")==null)
			app.setAttribute("USERS", usrlst);
		if(app.getAttribute("MESSAGES")==null)
			app.setAttribute("MESSAGES", msglst);
		if(app.getAttribute("ACTIVE_USERS")==null)
			app.setAttribute("ACTIVE_USERS", activeUsrlst);
	%>
	
	<h1>Choose your input</h1>
	<font color="red">
	<%
		if(request.getParameter("msg")!=null)
		{
			out.println(request.getParameter("msg"));
		}
	%>
	</font><br/><br/>
	<input type="button" value="Register" style="margin-left: 100px" onclick="document.location.href='Register.jsp';"/><br/><br/>
	<input type="button" value="Admin" style="margin-left: 100px" onclick="document.location.href='Admin.jsp';"/><br/><br/>
	<input type="button" value="Login" style="margin-left: 100px"onclick="document.location.href='Login.jsp';"/><br/><br/>
</form>
</body>
</html>