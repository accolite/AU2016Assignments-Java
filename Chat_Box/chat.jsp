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
<input type="button" class="btn btn-default" value="logout" onclick="logout()" id="logout" /><br/>
The messages are:<br/><textarea rows="10" cols="5"  class="form-control"  id="chat"></textarea>
Enter your message:<br/><input type="textbox"  class="form-control"  id="message" />
<input type="button" class="btn btn-default" value="send" onclick="sendMessage()"/><br/>
<!--<textarea rows="10" cols="5"  class="form-control"  id="users"></textarea>-->
<div id="users"></div>
<script>
     var interval=1000;
        setInterval(getMessage, interval);
        setInterval(getActiveUsers,interval); 
    var sendMessage=function ()
    {
        var xmlhttp =new XMLHttpRequest();
        var messageToSend=document.getElementById("message").value;
         xmlhttp.open("GET","http://localhost:8081/ChatBoxAssignment/Message?message="+messageToSend,true);
        xmlhttp.send();
        //setting interval between calls as 30 seconds
        
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
    
    function getMessage()
    {
        console.log("getmessage=====");
        var xmlhttp =new XMLHttpRequest();
        xmlhttp.open("GET","http://localhost:8081/ChatBoxAssignment/Message?message=",true);
        xmlhttp.send();
        xmlhttp.onreadystatechange = function(){
            if (xmlhttp.readyState==4 && xmlhttp.status == 200)
                {
                    var messageToSet="";
                     messageToSet=xmlhttp.responseText;
                    document.getElementById("chat").value=messageToSet;
                    //document.getElementById("message").value="";
                }
        }
    };
    
    
    function getActiveUsers(){
        var xmlhttp =new XMLHttpRequest();
        xmlhttp.open("GET","http://localhost:8081/ChatBoxAssignment/ActiveUsers",true);
        xmlhttp.send();
        xmlhttp.onreadystatechange = function(){
            if (xmlhttp.readyState==4 && xmlhttp.status == 200)
                {
                    var response=xmlhttp.responseText;
//                    var activeUsers= response[0];
//                    var currentUser=response[1];
//                    for(var i=0;i<activeUsers.length;i++)
//                        {
//                            if(activeUsers[i] == currentUser)
//                                {
//                                    activeUsers[i]="<b>"+currentUser+"</b";
//                                    break;
//                                }
//                        }
                    console.log(response);
                    document.getElementById("users").innerHTML=response;
                }
    }
    };
    
    function logout()
    {
//        document.getElementById("logout").onclick=function()
//        {
            location.href="http://localhost:8081/ChatBoxAssignment/Logout";
       // }
//        var xmlhttp =new XMLHttpRequest();
//        xmlhttp.open("GET","http://localhost:8081/ChatBoxAssignment/Logout",true);
//        xmlhttp.send();
//        xmlhttp.onreadystatechange = function(){
//            if (xmlhttp.readyState==4 && xmlhttp.status == 200)
//                {
//                    console.log("logged out");
//                }
//        }
    }
//    var interval=1000;
//        setInterval(getMessage, interval);
//        setInterval(getActiveUsers,interval);    
    </script>
</body>
</html>