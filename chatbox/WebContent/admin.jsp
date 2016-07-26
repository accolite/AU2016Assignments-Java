<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin page</title>
</head>
<body>

<% if(session!=null && session.getAttribute("id")!=null && session.getAttribute("id").equals("admin")){
%>
	
	<script type="text/javascript" src="js/jquery-latest.min.js"></script>
	<div style="text-align:center">
		<div>
			<input id="blockedwords" type="text"></input>
			<button id="blockthese">Block</button>
		</div>
	
	<h1>ADMIN</h1>
	<script type="text/javascript" src="js/main.js"></script>
	</div>
<%}else{%>
	<h1> CANNOT ACCESS ADMIN </h1> 
	<% } %>
</body>
</html>