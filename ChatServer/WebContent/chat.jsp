
<!Doctype html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
input[name="button"]{
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
}
 input[name="button3"]{
     line-height: 12px;
    
     
     font-family: tahoma;
     margin-top: 1px;
     margin-right: 2px;
     position:absolute;
     top:0;
     right:0;
 }
body {
    font:12px arial;
    color: #222;
    text-align:center;
    padding:35px; }
  
form, p, span {
    margin:0;
    padding:0; }
  
input { font:12px arial; }
  
a {
    color:#0000FF;
    text-decoration:none; }
  
    a:hover { text-decoration:underline; }
  
#wrapper, #loginform {
    margin:0 auto;
    padding-bottom:25px;
    background:#EBF4FB;
    width:504px;
    border:1px solid #ACD8F0; }
  
#loginform { padding-top:18px; }
  
    #loginform p { margin: 5px; }
  
#messages ,#active_users{
    text-align:left;
    margin:0 auto;
    margin-bottom:25px;
    padding:10px;
    background:#fff;
    height:270px;
    width:430px;
    border:1px solid #ACD8F0;
    overflow:auto; }
#active_users{
    text-align:left;
    margin:0 auto;
    margin-bottom:25px;
    padding:10px;
    background:#fff;
    height:100px;
    width:430px;
    border:1px solid #ACD8F0;
    overflow:auto; }   
  
#usermsg {
    width:395px;
    border:1px solid #ACD8F0; }
  
#submit { width: 60px; }
  
.error { color: #ff0000; }
  
#menu { padding:12.5px 25px 12.5px 25px; }
  
.welcome { float:left; }
  
.logout { float:right; }
</style>
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

    xhttp.open("GET", "http://localhost:8082/ChatServer/OnLoad",true);
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

    xhttp.open("GET", "http://localhost:8082/ChatServer/OnLoadChat",true);
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

    xhttp.open("POST", "http://localhost:8082/ChatServer/AddChat?new_chat=" + document.getElementById("new_chat").value ,true);
    xhttp.send();
}


</script>
</head>
<body onload="myfunc()">
<form action="./Close" method="POST">
<input type="submit" value="Logout" name="button" > 
</form>
<h3>Chats till now:</h3><br>
<div id="messages" >
</div>
<h3>List of active users:</h3>
<div id="active_users">
</div>
<br>

<form action="" method="POST">
<input type="text" id="new_chat" value="" size="63" style="height:40px" >
<input type="button" id="send" onclick="sendMessage()" value="Send" name="button">
</form>


</body>
</html>