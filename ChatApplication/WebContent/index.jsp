<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>

<div style="width:100%">
	<div class="container1">
		<h1 style="text-align:center">Awesome Chat Board</h1>
		
			<%
		    
		    if((session.getAttribute("user")== null ) || (session.getAttribute("user")== "")){
		     %><p>You are not logged in</p>
			</br>
			<a href="login.jsp" class="btn">Please Login</a> 
			<a style="margin-left:150px;"href="register.jsp" class="btn">Please Register</a>
			<% } else {
		        %>
			<p>Welcome
				<%=session.getAttribute("user") %></p>
			<a href="chatbox.jsp" class="btn">Go to the Chatroom</a> 
			<a style="margin-left:150px;" href="logout.jsp" class="btn">Log out</a>
			<%
		        }
		    %>
		    </div>
</div>
</body>
</html>