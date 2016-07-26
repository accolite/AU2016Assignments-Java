<%@page import="java.util.Hashtable"%> <%@page contentType="text/html" pageEncoding="UTF-8"%> <%@page import="java.util.Map"%> <%@page import="java.util.HashMap"%>

<!Doctype html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
function myfunc()
{
	setInterval(updateusers, 1000);
	setInterval(updatechats, 1000);
	}
function updateusers()
{
	var xhttp;
    xhttp = new XMLHttpRequest();
    console.log(xhttp);
    xhttp.onreadystatechange = function() {
      if (xhttp.readyState == 4 && xhttp.status == 200) {
        console.log( xhttp );
        var str=xhttp.responseText;
        console.log(str);
        document.getElementById("active_users").innerHTML = xhttp.responseText;
      }
    };

    xhttp.open("GET", "http://localhost:8080/ChatServer/OnLoad",true);
    xhttp.send();
}
function updatechats()
{
	var xhttp;
    xhttp = new XMLHttpRequest();
    console.log(xhttp);
    xhttp.onreadystatechange = function() {
      if (xhttp.readyState == 4 && xhttp.status == 200) {
        console.log( xhttp );
        var str=xhttp.responseText;
        console.log(str);
        document.getElementById("messages").innerHTML = xhttp.responseText;
      }
    };

    xhttp.open("GET", "http://localhost:8080/ChatServer/OnLoadChat",true);
    xhttp.send();
}

	
	
function sendMessage()
{
	var xhttp;
    xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function() {
    	console.log(xhttp.status);
      if (xhttp.readyState == 4 && xhttp.status == 200) {
        console.log( xhttp );
        //document.getElementById("getAll").innerHTML = xhttp.responseText;
      }
    };

    xhttp.open("POST", "http://localhost:8080/ChatServer/AddChat?new_chat=" + document.getElementById("new_chat").value ,true);
    xhttp.send();
}


</script>
</head>
<body onload="myfunc()">
Chats till now:
<div id="messages"></div>
List of active users:
<div id="active_users">
</div>
<form action="" method="POST">
<input type="text" id="new_chat" value="">
<input type="button" id="send" onclick="sendMessage()" value="send">
</form>
<form action="./Close" method="POST">
Logout:
<input type="submit" value="close"> 
</form>
</body>
</html>