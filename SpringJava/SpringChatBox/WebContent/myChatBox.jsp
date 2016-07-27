<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: skyblue;">

<% if(session.getAttribute("user")==null){
		out.println("Please login first");	
	}
else{
		%>
		<!-- 
		<table>
			<tr>
				<td> <div width="100%" height="100%" id="chatboard" readonly></div> </td>
				<td> <div width="100%" height="100%" id="activeusers" readonly></div> </td>
			</tr>
			<tr> 
				<td> <input type="text" id="message" style="width:100%; padding:10px"> </td>
				<td align="right"> <input type="button" id="submit" value="POST" onclick="sendMessage()">
			</tr>
		</table> -->
		


<div style="height: 500px; width: 500px; margin-left: 450px; background-color: white; margin-top:50px;  opacity: 0.9; padding: 10px;
    filter: alpha(opacity=30);">
	<div style="height: 40px; line-height: 2;color: white; background-color: #0033cc; text-align:center; font-size:20px; font-weight: bold;"> Chat Board <right> <a style="color:white; font-size:13px; margin-left: 150px;line-height: 2.9;position: absolute;" href="/ChatBoard/logout"> Logout </a></right></div>
	<div style="width:68%;float: left; border-right:1px solid blue;" id="chatboard"></div>
	<div style="width:29%; float: left; margin-left:10px;" id="activeusers"></div>
	<div style="float:left; width :98%;"> 
		<input type="text" id="message" style=" width:96%; padding:10px"> <br> <br>
		<center> <input type="button" id="submit" value="POST" onclick="sendMessage()"></center>
	</div>
	

</div>


		<script src="chatboard.js"></script>
		<% 	
}
%>

</body>
</html>