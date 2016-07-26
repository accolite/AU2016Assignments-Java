<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% if(session.getAttribute("user")==null){
		out.println("Please login first");	
	}
else{
		%>
		
		<table>
			<tr>
				<td> <div width="100%"  id="chatboard" readonly></div> </td>
				<td> <div width="100%"  id="activeusers" readonly></div> </td>
			</tr>
			<tr> 
				<td> <input type="text" id="message" style="width:100%; padding:10px"> </td>
				<td align="right"> <input type="button" id="submit" value="POST" onclick="sendMessage()">
			</tr>
		</table>
		<a href="/ChatBoard/logout"> Logout </a>
		<script src="chatboard.js"></script>
		<% 	
}
%>

</body>
</html>