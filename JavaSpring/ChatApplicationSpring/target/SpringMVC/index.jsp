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