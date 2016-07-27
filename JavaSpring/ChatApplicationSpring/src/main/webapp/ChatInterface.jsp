
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chat Interface</title>
<script>
	function update(){
		var xmlhttp;
		if (window.XMLHttpRequest)
		{
		  xmlhttp=new XMLHttpRequest();
		}
		else
		{
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				
				document.getElementById("divMessages").innerHTML=xmlhttp.responseText;
			  
			}	
		}

	  xmlhttp.open("GET", "http://localhost:8086/ChatApplicationSpring/ChatUpdate", true);
	  xmlhttp.send();

	}
	
	function updateUser(){
		
			var xmlhttp;
			if (window.XMLHttpRequest)
			{
			  xmlhttp=new XMLHttpRequest();
			}
			else
			{
				xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					
					document.getElementById("divUsers").innerHTML=xmlhttp.responseText;
				  
				}	
			}

		  xmlhttp.open("GET", "http://localhost:8086/ChatApplicationSpring/ActiveUserUpdate", true);
		  xmlhttp.send();

		
	}

	setInterval(update, 1000);
	setInterval(updateUser, 1000);
</script>
</head>
<body>
	<a href="Logout">Logout</a><br/><br/>
	<form method="post" action="/SendMessage">
		
		<input type="hidden" id="hUsername" name="hUsername" value="<%=request.getParameter("username")%>"/>
		<div>
			<div id="divMessages" name="divMessages" style="float: left;"></div>
			<div id="divUsers" name="divUsers" style="float: left; margin-left: 200px"></div>
		</div>
		<br/><br/>
		<div style="clear: both;">
			<input type="text" id="txtMessage" name="txtMessage" style="width: 360px" id="txtMessage" name="txtMessage"/>
			<input type="submit" id="sbtSend" name="sbtSend" value="Send"/>
		</div>
	</form>
</body>
</html>