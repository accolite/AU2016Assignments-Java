<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#Messages{
	font-size: 14px;
	font-weight: normal;
	resize: none;
	overflow-y: scroll;
	}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>






	
	function addMessage() {
		
		var xmlhttp1 = getNewXmlHttp();
		//alert(id + " " + profilename);

		var today = new Date();

		today = new Date();
		//var dateString = today.format("dd-m-yyyy HH:MM:ss");
		var message = document.getElementById("message").value;
		var m_id = document.getElementById("message_id").value;
		//console.log(message);
		alert("Hi");

		var u_id =<%=session.getAttribute("user_id")%>
		var name ="<%=session.getAttribute("name")%>";
		document.getElementById("msg").innerHTML = " ";

	
		var abc = JSON.stringify({
			"message_id" : m_id,
			"message" : message,
			"time" : "date",
			"name":name,
			"user_id":u_id
		});
		xmlhttp1.open("POST", "http://localhost:8010/messanger/Message?objarray="+abc, true);
		xmlhttp1.setRequestHeader("Content-type", "application/json");
		
		xmlhttp1.send();
	}
	
	
	function getNewXmlHttp() {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		return xmlhttp;
	}
	function myFunction() {
	    setInterval(function(){ 
	    	//alert("Hi");

			var xmlhttp1 = getNewXmlHttp();
			//alert(id + " " + profilename);
			xmlhttp1.onreadystatechange = function() {
				if (xmlhttp1.readyState == 4 && xmlhttp1.status == 200) {
					var metaData = xmlhttp1.responseText;
				//	console.log(metaData);
					document.getElementById("msg").innerHTML = metaData;
							

							
				}
			}
			xmlhttp1.open("GET", "http://localhost:8010//messanger/Message", true);
			xmlhttp1.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded");
			xmlhttp1.send();
	    }, 3000);
	}

	function myfunction2() {
	    setInterval(function(){ 
	    	//alert("Hi");

			var xmlhttp1 = getNewXmlHttp();
			//alert(id + " " + profilename);
			xmlhttp1.onreadystatechange = function() {
				if (xmlhttp1.readyState == 4 && xmlhttp1.status == 200) {
					var metaData = xmlhttp1.responseText;
				//	console.log(metaData);
					document.getElementById("names_list").innerHTML = metaData;
							

							
				}
			}

			xmlhttp1.open("GET", "http://localhost:8010//messanger/Listing", true);
			xmlhttp1.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded");
			xmlhttp1.send();
	    }, 3000);
	}
	
	function logout()
	{
		document.getElementById("msg").innerHTML = "";

		var xmlhttp1 = getNewXmlHttp();
		//alert(id + " " + profilename);
		var user="<%=session.getAttribute("name")%>";
		console.log(user);
		xmlhttp1.onreadystatechange = function() {
			if (xmlhttp1.readyState == 4 && xmlhttp1.status == 200) {
				var metaData = xmlhttp1.responseText;
			//	console.log(metaData);
				location.href = "http://localhost:8010/messanger/Login.html";
						

						
			}
		}
		xmlhttp1.open("GET", "http://localhost:8010//messanger/Logout?user="+user, true);
		xmlhttp1.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xmlhttp1.send();
	}

</script>
</head>
<body onload="myFunction(),myfunction2()">
	<p>
		<td>Username:</td>
		<td><%=session.getAttribute("name")%></td>
	
	<div
		style="width: 200px; height: 200px; float: right; align: center; border-style: solid; margin: 20px 200px 20px 20px">
		<div style="text-size: 20px; font-weight: bold">List_of_users</div>

		<label id="names_list">Users</label>
	</div>
	<div id="added">${ Message}</div>

   <textarea id="msg" rows="15" cols="50" id="about" style="resize: none ;float:right;overflow-y: scroll;"></textarea>

	<input type="text" id="message" rows="10" cols="25"
		placeholder="Enter message">
	<br />
	<input type="text" id="message_id" rows="10" cols="25"
		placeholder="Enter message id">
	<br />

	<input type="submit" id="submit" rows="10" cols="25" value="add message"
		onclick="addMessage()">
		<input type="submit" id="logout" rows="10" cols="25" value="logout"
		onclick="logout()">
	<br />


</body>
</html>