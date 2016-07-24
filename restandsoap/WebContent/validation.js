/**
 * 
 */

function populate()
{
	
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
			
			var users=JSON.parse(xmlhttp.responseText);
			var data="";
			data="Users: <select id='users'> ";
			for(i=0;i<users.lstUser.length;i++)
			{
				
				data+="<option value='"+users.lstUser[i].personId+"'>"+users.lstUser[i].personName+"</option>";
			}
			data+=" </select>";
			document.getElementById("divListUser").innerHTML=data;
		  
		}	
	}
	
  xmlhttp.open("GET", "http://localhost:8086/webserviceassignment/webapi/facebookAssignment/viewAllUsers", true);
  xmlhttp.send();
}

function addMessage()
{
	
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
			alert("5");
			document.getElementById("taMessage").value="";
		}	
	}
	//xmlhttp.send(" { \"messageID\":" + messageID+" ,\"message\":" + "\"" +message + "\"" +", \"personID\":" + personID + "}");
	xmlhttp.open("POST","http://localhost:8086/webserviceassignment/webapi/facebookAssignment/addMsg",true);
	xmlhttp.setRequestHeader("Content-type", "application/json");
    //xmlhttp.setRequestHeader("Accept", "text/plain");
    
	
	var val=document.getElementById("users").value;
	//var queryParams = "{'message':'"+document.getElementById("taMessage").value+"', 'personId':'"+val+"'}";
	
	xmlhttp.send("{ \"message\":"+ document.getElementById("taMessage").value +", \"personId\":"+ val + "}");
}

function viewAllMessages()
{
	
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
			
			var messages=JSON.parse(xmlhttp.responseText);
			var data="";
			data="Messages: <br/><br/>";
			for(i=0;i<messages.lstMessage.length;i++)
			{
				
				data+="<fieldset>";
				data+=messages.lstMessage[i].message;
				data+="<br/><br/><input type='button' style='margin-left: 50px' value='Like' onclick='addLike("+messages.lstMessage[i].messageId+")'/>";
				data+="<input type='button' value='Show All Likes' onclick='showAllLikes("+messages.lstMessage[i].messageId+")'/><br/><br/>";
				data+="<div id='allLikes'></div>";
				data+="<input type='text' value='Add Comment.....' id='comment"+messages.lstMessage[i].messageId+"' name='comment"+messages.lstMessage[i].messageId+"'/><br/>"; 
				data+="<input type='button' style='margin-left: 50px' value='Comment' onclick='addComment("+messages.lstMessage[i].messageId+")'/>";
				data+="<input type='button' value='Show All Comments' onclick='viewAllComments("+messages.lstMessage[i].messageId+")'/><br/><br/>";
				data+="<div id='allComments'></div>";
				data+="</fieldset>";
			}
			document.getElementById("allMessages").innerHTML=data;
		  
		}	
	}
  
	xmlhttp.open("GET", "http://localhost:8086/webserviceassignment/webapi/facebookAssignment/viewAllMsgs", true);
	xmlhttp.send();
  
}

function viewAllComments(id)
{
	
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
			
			var comments=JSON.parse(xmlhttp.responseText);
			var data="";
			data="<fieldset><legend>Comments</legend>";
			for(i=0;i<comments.lstComment.length;i++)
			{
				
				data+=comments.lstComment[i].comment;
				data+="<br/><br/>";
			}
			data+="</fieldset>";
			document.getElementById("allComments").innerHTML=data;
		  
		}	
	}
  
	xmlhttp.open("GET", "http://localhost:8086/webserviceassignment/webapi/facebookAssignment/viewAllComms", true);
	xmlhttp.send();
  
}

function showAllLikes(id)
{
	
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
			
			var likes=JSON.parse(xmlhttp.responseText);
			var data="";
			data+="<fieldset>";
			data+="<legend>Likes</legend>"
			
			for(i=0;i<likes.lstLike.length;i++)
			{
				
				data+=likes.lstLike[i].personId;
				data+="<br/>";
				
			}
			data+="</fieldset>";
			document.getElementById("allLikes").innerHTML=data;
		  
		}	
	}
  
	xmlhttp.open("GET", "http://localhost:8086/webserviceassignment/webapi/facebookAssignment/viewAllLis", true);
	xmlhttp.send();
  
}

function addComment(id)
{
	
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
			alert("5");
			document.getElementById("comment"+id).value="Add comment.....";
		}	
	}
	alert("1");
	xmlhttp.open("POST","http://localhost:8086/webserviceassignment/webapi/facebookAssignment/addCommentOnMsg",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	alert("2");
	var value=document.getElementById("users").value;
	var queryParams = "{'comment':'"+document.getElementById("comment"+id).value+"', 'personId':'"+value+"', 'messageId:'"+id+"'}"; 
	xmlhttp.send(queryParams);
	alert("3");
}


function addLike(id)
{
	
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
			alert("Added");
			
		}	
	}
	alert("1");
	xmlhttp.open("POST","http://localhost:8086/webserviceassignment/webapi/facebookAssignment/addLikeOnMsg",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	alert("2");
	var value=document.getElementById("users").value;
	var queryParams = "{'personId':'"+value+"', 'messageId:'"+id+"'}"; 
	xmlhttp.send(queryParams);
	alert("3");
}
