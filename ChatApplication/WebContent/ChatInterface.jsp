
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

	  xmlhttp.open("GET", "http://localhost:8086/ChatApplication/ChatUpdate", true);
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

		  xmlhttp.open("GET", "http://localhost:8086/ChatApplication/ActiveUserUpdate", true);
		  xmlhttp.send();

		
	}
	
</script>
</head>
<body>
	<a href="Logout">Logout</a><br/><br/>
	<form method="post" action="SendMessage">
		
		<input type="hidden" id="hUsername" name="hUsername" value="<%=request.getParameter("username")%>"/>
		<textarea rows="20" cols="50">
		<div id="divMessages" name="divMessages"></div>
		</textarea>
		<textarea rows="20" cols="20" style="margin-left: 50px" id="taMessages" name="taMessages">
		<div id="divUsers" name="divUsers"></div>
		</textarea>
		<br/><br/>
		<input type="text" id="txtMessage" name="txtMessage" style="width: 360px" id="txtMessage" name="txtMessage"/>
		<input type="submit" id="sbtSend" name="sbtSend" value="Send"/>
	</form>
</body>
</html>