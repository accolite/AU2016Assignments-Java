<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
b{
color: lightblue;
}
p{
color: red;
}]
</style>
</head>
<body>

<% if(session.getAttribute("user")==null){
		out.println("Please login first");	
	}
else{
		%>
		
		<table>
			<tr>
				<td> <div style="border:solid; width:300px; overflow-y: auto; height:550px" id="chatboard"></div> </td>
				<td> <div style="border:solid; text-align:center; width:150px; height:550px" id="activeusers"></div> </td>
			</tr>
			<tr> 
				<td> <input type="text" id="message" style="width:250px; padding:10px"> </td>
				<td> <input type="button" id="submit" value="POST" onclick="sendMessage()"></td>	
			</tr>
		</table>
		<a href="/ChatBoardSpring/app/logout"> Logout </a>
		<script src="/ChatBoardSpring/chatboard.js"></script>
		<% 	
}
%>

</body>
</html>