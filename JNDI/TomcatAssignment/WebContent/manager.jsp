<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: skyblue;" onload="updateChatboard()">

		
		


<div style="height: 500px; width: 500px; margin-left: 450px; background-color: white; margin-top:50px;  opacity: 0.9; padding: 10px;
    filter: alpha(opacity=30);">
	<div style="height: 40px; line-height: 2;color: white; background-color: #0033cc; text-align:center; font-size:20px; font-weight: bold;">Employee List </div>
	<div style="width:98%;float: left; border-right:1px solid blue;" id="chatboard"></div>
	
	<form action="manager" method="post"> 
		<label>User Name: </label> <br>
		<input type="text" name="username" style=" width:56%; padding:10px"> <br> <br>
		
		<label>Email: </label> <br>
		<input type="text" name="email" style=" width:56%; padding:10px"> <br> <br>
		
		<center> <input type="submit"  value="add kr de"></center>
	</form>
	

</div>


		<script src="chatboard.js"></script>
		

</body>
</html>