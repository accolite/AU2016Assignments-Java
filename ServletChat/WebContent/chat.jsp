<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Chat Box <%= session.getAttribute("username") %></h1>
The messages are:<br/><textarea rows="10" cols="5"  class="form-control"  id="chat"></textarea>
Enter your message:<br/><input type="textbox"  class="form-control"  id="message" />
<input type="button" class="btn btn-default" value="send" onclick="sendMessage()"/>

<form action="http://localhost:8090/ServletChat" method="get()">
<button type="submit">Logout</button>
</form>
<script>
    function sendMessage()
    {
        var xmlhttp =new XMLHttpRequest();
        var messageToSend=document.getElementById("message").value;
         xmlhttp.open("GET","http://localhost:8090/ServletChat/Message?message="+messageToSend,true);
        xmlhttp.send();
        //setting interval between calls as 30 seconds
        var interval=30000;
        setInterval(getMessage, interval);
        
        xmlhttp.onreadystatechange = function(){
            if (xmlhttp.readyState==4 && xmlhttp.status == 200)
                {
                    var messageToSet="";
                     messageToSet=xmlhttp.responseText;
                    document.getElementById("chat").value=messageToSet;
                    document.getElementById("message").value="";
                }
        }
    }
    
    var getMessage=function()
    {
        var xmlhttp =new XMLHttpRequest();
        xmlhttp.open("GET","http://localhost:8081/ChatBoxAssignment/Message?message=",true);
        xmlhttp.send();
        xmlhttp.onreadystatechange = function(){
            if (xmlhttp.readyState==4 && xmlhttp.status == 200)
                {
                    var messageToSet="";
                     messageToSet=xmlhttp.responseText;
                    document.getElementById("chat").value=messageToSet;
                    document.getElementById("message").value="";
                }
        }
    };
    </script>
</body>
</html>