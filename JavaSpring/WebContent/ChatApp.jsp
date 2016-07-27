<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chat Application</title>
</head>
<script type="text/javascript" src="Start.js">
</script>
</head>
<body>
<h1 style="background-color:black; color:white; text-align:center;">Chat Application</h1>
Welcome <%=session.getAttribute("user") %>

	
	<div class="container">
		<div class="row">
			<div style="float:left;">
				<div id="msg">
			
				</div>	
				<div>
					<br>
					<input type="text" id="msgbox"> : 
					<input type="hidden" value='<%=session.getAttribute("user") %>'	id="userbox">
					<button id="sendbutton" onclick="sendMessage()">Post</button>
				</div>
			</div>
			<div>
				<h2 style="text-align:center; font-color:red;">Active Users:</h2>
				<div id="usr"style="text-align:center;">
			
				</div>
			</div>
		<a href="Logout.jsp">Log out</a>
		</div>	


		



		
	</div>
</body>
</html>