<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	.div1 {
		float: left;
		width:500px;
		height:400px;
		overflow: scroll;
	}
	.div2 {
		float: left;
		width: 250px;
		height:300px;
		overflow: scroll;
	}
	.div3 {
		clear: both;
	}
</style>
<script type="text/javascript">
function getNewXmlHttp(){
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  return xmlhttp;
}
function sendMessage(message){
	var xmlhttp = getNewXmlHttp();
		xmlhttp.onreadystatechange = function(){
			if (xmlhttp.readyState==4 && xmlhttp.status==200){
				var response=xmlhttp.responseText.split(":::");
				document.getElementById("activeUsers").innerHTML=response[0];
				document.getElementById("messages").innerHTML=response[1];
			}  
		}
	var queryParams = "message=" + message;
	xmlhttp.open("POST","tweet",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send(queryParams);
}
function referesh(){
	var xmlhttp = getNewXmlHttp();
		xmlhttp.onreadystatechange = function(){
			if (xmlhttp.readyState==4 && xmlhttp.status==200){
				var response=xmlhttp.responseText.split(":::");
				document.getElementById("activeUsers").innerHTML=response[0];
				document.getElementById("messages").innerHTML=response[1];
			}  
		}
	xmlhttp.open("GET","feedme",true);
	xmlhttp.send();
}
</script>
</head>
<body>
	<h1><%= session.getAttribute("username")%></h1>
	<form action="logout" method="POST">
		<input type="submit" value="logout">
		<br>
	</form>
	<div class="div1">
		<p id="messages"></p>
	</div>
	<div class="div2">
		<p id="activeUsers"></p>
	</div>
	<div class="div3">
		<input type="text" name="message" placeholder="avada kedavra">
		<input type="button" name="send" value="send">
	</div>
	<script type="text/javascript">
		var message=document.getElementsByName("message")[0];
		document.getElementsByName("send")[0].onclick=function(){
			sendMessage(message.value);
		}
		<%-- if user logged in do create the referech event --%>
		if(<%= session.getAttribute("status").equals("loggedin") %>)
			setInterval(referesh,5000);
	</script>
</body>
</html>