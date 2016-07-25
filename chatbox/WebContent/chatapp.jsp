<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chat Application</title>
<h1>MY CHAT APPLICATION</h1>
<head>
<style>
.button1 {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
}
</style>
</head>
<body>
	<h3>Logged in as</h3>
	<h1>
		<%
			out.println(session.getAttribute("userid"));
		%>
		<a href="logout.jsp" class="button1"> Logout </a>
	</h1>
	<br> Type Message
	<input type="text" id="new_comment">
	<br>
	<input type="button" id="postdata" onclick="PostComment()" value="send"
		class="button1">

	<br>
	<br>
	<h2>CHAT SO FAR:</h2>
	<div id="ChatString"
		style="background-color: purple; color: white; width: 70%; height: 500px; font-size: 25px; float: left">
		<%
			ServletContext sc = request.getServletContext();
			out.println(sc.getAttribute("ChatString"));
		%>
	</div>
	<br>
	<b> Active Users </b>
	<div id="ActiveUsers"
		style="background-color: yellow; font: black; width: 30%; height: 500px; font-size: 25px; float: left">
		<%
			out.println(sc.getAttribute("ActiveUsers"));
		%>
	</div>

	<script>
		function PostComment() {
			var xhttp;
			xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (xhttp.readyState == 4 && xhttp.status == 200) {
					console.log(xhttp);
					document.getElementById("ChatString").innerHTML = xhttp.responseText;
				}
			};
			var comm = document.getElementById("new_comment").value;
			var uname = document.getElementById("username").value;
			var msg = document.getElementById("new_comment").value;
			var url = "http://localhost:8080/ChatApplication/ChatString?uname="
					+ uname + "&message=" + msg;
			console.log(url);
			xhttp.open("POST", url, true);
			xhttp.send();
		}

		function GetComment() {
			var xhttp;
			xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (xhttp.readyState == 4 && xhttp.status == 200) {
					console.log(xhttp);
					document.getElementById("ChatString").innerHTML = xhttp.responseText;
				}
			};
			var url = "http://localhost:8080/ChatApplication/ChatString";
			xhttp.open("GET", url, true);
			xhttp.send();
		}

		function setActiveUsers() {
			var xhttp;
			xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (xhttp.readyState == 4 && xhttp.status == 200) {
					console.log(xhttp);
					document.getElementById("ActiveUsers").innerHTML = xhttp.responseText;
				}
			};
			var url = "http://localhost:8080/ChatApplication/ActiveUsers";
			xhttp.open("GET", url, true);
			xhttp.send();
		}

		setInterval(GetComment, 3000);
		setInterval(setActiveUsers, 3000);
	</script>

	<input type="hidden" value='<%=session.getAttribute("userid")%>'
		id="username">


</body>
</html>