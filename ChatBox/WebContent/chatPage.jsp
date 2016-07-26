<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Chat</title>
<meta charset="ISO-8859-1">
<script>
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

	var request = 0;
function sendMessage(){

	  var xmlhttp1 = getNewXmlHttp();
	   xmlhttp1.onreadystatechange = function(){
		  // alert("Msg Added");
	   }
	  var message=document.getElementById("msg").value;
	  //var user="Jegan";//=document.getElementById("password").value;
	  var url="http://localhost:8080/ChatBox/MessageServlet?message="+message;
	  
	  xmlhttp1.open("GET",url,true);
	  xmlhttp1.setRequestHeader("Content-type","application/text;charset=UTF-8");
	  xmlhttp1.send();
}

setInterval(function updateMessage(){
	var xmlhttp1 = getNewXmlHttp();
	xmlhttp1.onreadystatechange = function(){
		  if (xmlhttp1.readyState==4 && xmlhttp1.status==200)
		    {
			  var metaData=xmlhttp1.responseText;
		      document.getElementById("Messages").innerHTML=metaData;
		    }  
		  }
	  var url="http://localhost:8080/ChatBox/UpdateMessageServlet";
	  xmlhttp1.open("GET",url,true);
	  xmlhttp1.setRequestHeader("Content-type","application/text;charset=UTF-8");
	  xmlhttp1.send();
},1000);

setInterval(function updateActiveUsers(){
	var xmlhttp1 = getNewXmlHttp();
	xmlhttp1.onreadystatechange = function(){
		  if (xmlhttp1.readyState==4 && xmlhttp1.status==200)
		    {
			  var metaData=xmlhttp1.responseText;
		      document.getElementById("Users").innerHTML=metaData;
		     }  
		  }
	  //document.getElementById("loggedUser").innerHTML=session.getAttribute("username");
	  var url="http://localhost:8080/ChatBox/UpdateUserServlet";
	  xmlhttp1.open("GET",url,true);
	  xmlhttp1.setRequestHeader("Content-type","application/text;charset=UTF-8");
	  xmlhttp1.send();
},1000);




</script>
</head>
<body>
	<h1>Welcome to J-Chat </h1>
	<h2  id="loggedUser"><%= session.getAttribute("username") %></h2>
	<script></script>
	<div style="float:left">
		<div style="width:300px;height:300px;float:left;align:center;border-style:solid;overflow:scroll;margin:20px 30px 20px 20px">
			<div style="text-size:20px;font-weight:bold">Messsages:</div><br/>
				<div id="Messages"></div>
		</div>
		
		<div style="width:250px;height:300px;float:left;align:center;border-style:solid;overflow:scroll;margin:20px 30px 20px 20px">
			<div style="text-size:20px;font-weight:bold">Active Users:</div>
				<div id="Users"></div>
		</div>
		<form method="get" action="http://localhost:8080/ChatBox/LogoutServlet">
		<div style="text-size:20px;float:left;font-weight:bold">
				<input type="submit" value="Logout" id="logout">
		</div>
		</form>
	</div>
	<br/>
	<div style="width:700px;height:100px;float:left;align:center;border-style:solid">
			<div style="width:400px;height:50px;float:left;align:center;margin:20px 30px 20px 20px">
				<input type="text" id="msg" placeholder="Enter new Message"></textarea>
			</div>
			<div style="text-size:20px;float:right;font-weight:bold;margin:20px 30px 20px 20px">
				<input type="button" value="Send" id="send" onClick="sendMessage()">
			</div>
		</div>
</body>
</html>