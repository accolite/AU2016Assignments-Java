<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chat Board</title>

<script  type="text/javascript">
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

function sendMessage(){
	var xmlhttp1 = getNewXmlHttp();
		xmlhttp1.onreadystatechange = function(){
			if (xmlhttp1.readyState==4 && xmlhttp1.status==200){
				var response=xmlhttp1.responseText.split(":::");
				document.getElementById("Users").innerHTML=response[0];
				document.getElementById("Messages").innerHTML=response[1];
			}  
		}
	var message=document.getElementById("msg").value;
	var queryParams = "message=" + message;
	xmlhttp1.open("GET","SendMsg?"+queryParams,true);
	
	xmlhttp1.send();
}

function refresh(){
	var xmlhttp = getNewXmlHttp();
		xmlhttp.onreadystatechange = function(){
			if (xmlhttp.readyState==4 && xmlhttp.status==200){
				var response=xmlhttp.responseText.split(":::");
				document.getElementById("Users").innerHTML=response[0];
				document.getElementById("Messages").innerHTML=response[1];
			}  
		}
	xmlhttp.open("GET","Update",true);
	xmlhttp.send();
}

</script>


</head>
<body>
	<div style="float: left">
		<div
			style="width: 300px; height: 300px; float: left; align: center; border-style: solid; margin: 20px 30px 20px 20px">
			<div style="text-size: 20px; font-weight: bold" align="center">Messsages:</div>
			<div id="Messages" style="overflow: scroll"></div>
		</div>

		<div
			style="width: 250px; height: 300px; float: left; align: center; border-style: solid; margin: 20px 30px 20px 20px">
			<div style="text-size: 20px; font-weight: bold" align="center">Active Users:</div>
			<div id="Users" style="overflow: scroll"></div>
		</div>
		<div style="text-size: 20px; float: left; font-weight: bold">
			<form action="Logout" method="post">
			<input type="submit" value="Logout" id="logout" ">
			</form>
		</div>
	</div>
	<br />
	<div
		style="width: 700px; height: 100px; float: left; align: center; border-style: solid">
		<div
			style="width: 400px; height: 50px; float: left; align: center; margin: 20px 30px 20px 20px">
			<input type="text" value="" id="msg"
				placeholder="Enter Message" name="Message">
		</div>
		<div style="text-size: 20px; float: right; font-weight: bold">
			<input type="button" value="Send" id="Send" onClick="sendMessage()" >
		</div>
	</div>
	
	<script type="text/javascript">
	/* var msg=document.getElementsByName("Message");
	document.getElementsByName("send").onClick=function(){
		sendMessage(msg.value);
	}
 */		if(<%= session.getAttribute("status").equals("loggedin") %>)
			setInterval(refresh,2000);
	</script>
	
</body>
</html>