<!DOCTYPE html>
<html>
<head>
	<title>Mini Facebook</title>
	<script type="text/javascript">
	
		var userid = 0;
		
		function getUserId(){
			userid = prompt("enter your userid");
		}
	
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
			var message = document.getElementById("messageBox").value;
			var xmlhttp = getNewXmlHttp();


			xmlhttp.onreadystatechange = function(){
			  if (xmlhttp.readyState==4 && xmlhttp.status==200)
			    {
			      //document.getElementById("myDiv").innerHTML +=  number1 + " " + operation + " " + number2 + " = " + xmlhttp.responseText + "<br/>";
			      //document.getElementById("timings").innerHTML +=  "Request " + curNo + " Completed @ " + new Date() + "<br/>";
			    	var text = xmlhttp.responseText;
			    	console.log("hello");
			    	alert(text);
			    }  
			  }

			  xmlhttp.open("POST","http://localhost:8080/restassignment/webapi/messages/create?uid="+userid+"&content="+message,true);

  xmlhttp.setRequestHeader("Content-type","text/plain");
  xmlhttp.setRequestHeader("Accept","text/plain");
  
 // var queryParams = "uid=1" + "&content=" + message; 
  xmlhttp.send();

		}

		function getMessages(){
			var userID = document.getElementById("userID").value;
			var xmlhttp = getNewXmlHttp();

console.log(userID);
			xmlhttp.onreadystatechange = function(){
			  if (xmlhttp.readyState==4 && xmlhttp.status==200)
			    {	var text = xmlhttp.responseText;
			    	console.log(typeof text);
			    	console.log("hello");
			    	var json = JSON.parse(text);
			    	//var len = json.array.length;
			    	//console.log(json[0].msgid);
			    	var len = json.length;
			    	//console.log(len);
			    	//shareInfoLen = Object.keys(json.shareInfo[0]).length;
			    	//console.log(shareInforLen);
			    	var i = 0;
			    	var showMsg = document.getElementById("showMessages");
			    	
			    	var childCount = showMsg.childElementCount;
			    	//console.log(childCount);
			    	
			    	while(i < childCount){
			    		//console.log("in childcount");
			    		showMsg.removeChild(showMsg.childNodes[0]);
			    		i++;
			    	}
			    	
			    	i = 0;
			    	
			    	while(i < len){
			    		//console.log("in while");
			    		var firstDiv = document.createElement("div");
			    		var para = document.createElement("p");
			    		para.innerHTML = json[i].msgcontent;
			    		console.log(json[i].msgcontent);
			    		
			    		firstDiv.appendChild(para);
			    		var like = document.createElement("input");
			    		like.setAttribute("type","button");
			    		like.setAttribute("value","like");
			    		like.setAttribute("name",json[i].msgid);
			    		like.setAttribute("onClick","addLike(this)");
			    		firstDiv.appendChild(like);
			    		showMsg.appendChild(firstDiv);
			    		i++;
			    	}
			    	
			    	console.log("hello after adding");
			    	
			    	//alert(text);
			    }  
			  }

			  xmlhttp.open("POST","http://localhost:8080/restassignment/webapi/messages?id="+userID,true);

  xmlhttp.setRequestHeader("Content-type","text/plain");
  xmlhttp.setRequestHeader("Accept","text/plain");
  
  
  xmlhttp.send();

		}
		
		
		function getComments(){
			var msgID = document.getElementById("msgIDComment").value;
			var xmlhttp = getNewXmlHttp();

			//console.log(userID);
			xmlhttp.onreadystatechange = function(){
			  if (xmlhttp.readyState==4 && xmlhttp.status==200)
			    {	var text = xmlhttp.responseText;
			    	console.log(typeof text);
			    	console.log("hello");
			    	var json = JSON.parse(text);
			    	//var len = json.array.length;
			    	//console.log(json[0].msgid);
			    	var len = json.length;
			    	//console.log(len);
			    	//shareInfoLen = Object.keys(json.shareInfo[0]).length;
			    	//console.log(shareInforLen);
			    	var i = 0;
			    	var showCmt = document.getElementById("showComments");
			    	
			    	var childCount = showCmt.childElementCount;
			    	//console.log(childCount);
			    	
			    	while(i < childCount){
			    		//console.log("in childcount");
			    		showCmt.removeChild(showCmt.childNodes[0]);
			    		i++;
			    	}
			    	
			    	i = 0;
			    	
			    	while(i < len){
			    		console.log("in while");
			    		var firstDiv = document.createElement("div");
			    		var para = document.createElement("p");
			    		para.innerHTML = json[i].cmt;
			    		console.log(json[i].cmt,i);
			    		
			    		firstDiv.appendChild(para);
			    		//var like = document.createElement("input");
			    		//like.setAttribute("type","button");
			    		//like.setAttribute("value","like");
			    		//like.setAttribute("name",json[i].msgid);
			    		//like.setAttribute("onClick","addLike(this)");
			    		//firstDiv.appendChild(like);
			    		showCmt.appendChild(firstDiv);
			    		i++;
			    	}
			    	
			    	console.log("hello after adding");
			    	
			    	//alert(text);
			    }  
			  }

			  xmlhttp.open("POST","http://localhost:8080/restassignment/webapi/messages/getComments?msgid="+msgID,true);

  xmlhttp.setRequestHeader("Content-type","text/plain");
  xmlhttp.setRequestHeader("Accept","text/plain");
  
  
  xmlhttp.send();

		}
		
		
		

		function getLikes(){
			var msgID = document.getElementById("msgIDLike").value;
			var xmlhttp = getNewXmlHttp();

			//console.log(userID);
			xmlhttp.onreadystatechange = function(){
			  if (xmlhttp.readyState==4 && xmlhttp.status==200)
			    {	var text = xmlhttp.responseText;
			    	console.log(typeof text);
			    	console.log("hello");
			    	var json = JSON.parse(text);
			    	//var len = json.array.length;
			    	//console.log(json[0].msgid);
			    	var len = json.length;
			    	//console.log(len);
			    	//shareInfoLen = Object.keys(json.shareInfo[0]).length;
			    	//console.log(shareInforLen);
			    	var i = 0;
			    	var showLike = document.getElementById("showLikes");
			    	
			    	var childCount = showLike.childElementCount;
			    	//console.log(childCount);
			    	
			    	while(i < childCount){
			    		//console.log("in childcount");
			    		showLike.removeChild(showCmt.childNodes[0]);
			    		i++;
			    	}
			    	
			    	i = 0;
			    	
			    	while(i < len){
			    		console.log("in while");
			    		var firstDiv = document.createElement("div");
			    		var para = document.createElement("p");
			    		para.innerHTML = json[i].userid;
			    		console.log(json[i].userid,i);
			    		
			    		firstDiv.appendChild(para);
			    		//var like = document.createElement("input");
			    		//like.setAttribute("type","button");
			    		//like.setAttribute("value","like");
			    		//like.setAttribute("name",json[i].msgid);
			    		//like.setAttribute("onClick","addLike(this)");
			    		//firstDiv.appendChild(like);
			    		showLike.appendChild(firstDiv);
			    		i++;
			    	}
			    	
			    	console.log("hello after adding");
			    	
			    	//alert(text);
			    }  
			  }

			  xmlhttp.open("POST","http://localhost:8080/restassignment/webapi/messages/getLikes?msgid="+msgID,true);

  xmlhttp.setRequestHeader("Content-type","text/plain");
  xmlhttp.setRequestHeader("Accept","text/plain");
  
  
  xmlhttp.send();

		}
		
		

		function addComment(){
			var msgid = document.getElementById("msgID").value;
			var cmt = document.getElementById("newcomment").value;
			var xmlhttp = getNewXmlHttp();
			
			xmlhttp.onreadystatechange = function(){
				  if (xmlhttp.readyState==4 && xmlhttp.status==200)
				    {
					  var text = xmlhttp.responseText;
				    	console.log("hello");
				    	alert(text);  
				    }  
				  }

			xmlhttp.open("POST","http://localhost:8080/restassignment/webapi/messages/comment?msgid="+msgid+"&userid="+userid+"&comment="+cmt,true);


				  xmlhttp.setRequestHeader("Content-type","text/plain");

				  
			
				  xmlhttp.send();
			
		}
		
		function addLikeWithId(){
			var msgid = document.getElementById("msgLikeID").value;
			var xmlhttp = getNewXmlHttp();
			
			xmlhttp.onreadystatechange = function(){
				  if (xmlhttp.readyState==4 && xmlhttp.status==200)
				    {
					  var text = xmlhttp.responseText;
				    	console.log("hello");
				    	alert(text);  
				    }  
				  }

			xmlhttp.open("POST","http://localhost:8080/restassignment/webapi/messages/like?msgid="+msgid+"&userid="+userid,true);


				  xmlhttp.setRequestHeader("Content-type","text/plain");

				  
			
				  xmlhttp.send();
		}
		
		
		function createAccount(){
			var name = document.getElementById("name").value;
			var xmlhttp = getNewXmlHttp();
			
			xmlhttp.onreadystatechange = function(){
				  if (xmlhttp.readyState==4 && xmlhttp.status==200)
				    {
					  var text = xmlhttp.responseText;
				    	console.log("hello");
				    	alert("your id is "+text+" "+(typeof text));
				    	userid = (+text);
				    }  
				  }

			xmlhttp.open("POST","http://localhost:8080/restassignment/webapi/messages/createaccount?name="+name,true);


				  xmlhttp.setRequestHeader("Content-type","text/plain");

				  
			
				  xmlhttp.send();
		}

	</script>
</head>
<body onLoad="getUserId()">
<div id="createAccount">
	<input type="text" name="name" id="name">
	<input type="button" name="newAccount" value="create account" onClick="createAccount()">
</div>

<h3>Create Message</h3>
<div id="createMessage">
	Message: <input type="text" id="messageBox" name="messageBox"><br/>
	<input type="button" name="sendMessage" id="sendMessage" value="send" onClick="sendMessage()">
</div>

<br />
<br />
<h3>View Message</h3>
<div id="viewMessages">
	UserID: <input type="text" name="userID" id="userID">
	<input type="button" name="sendUID" id="sendUID" value="send" onClick="getMessages()">
</div>

<div id="showMessages">

</div>
<br />
<br />

<h3>Add Comment</h3>
<div id="addComment">
	MessageID: <input type="text" name="messageID" id="msgID"><br />
	Comment: <input type="text" name="comment" id="newcomment"><br />
	<input type="button" name="send" value="addComment" onClick="addComment()">
</div>
<br />
<br />

<h3>Add Like</h3>
<div id="addLike">
	MessageID: <input type="text" name="messageID" id="msgLikeID"><br />
	<input type="button" name="send" value="Like" onClick="addLikeWithId()">
</div>
<br />
<br />
<h3>View Comments</h3>
<div id="viewComments">
	MsgID: <input type="text" name="msgID" id="msgIDComment">
	<input type="button" name="sendMID" id="sendMID" value="send" onClick="getComments()">
</div>

<div id="showComments">

</div>
<br />
<br />
<h3>View Likes</h3>
<div id="viewLikes">
	MsgID: <input type="text" name="msgID" id="msgIDLike">
	<input type="button" name="sendMID" id="sendMID" value="send" onClick="getLikes()">
</div>

<div id="showLikes">

</div>

</body>
</html>