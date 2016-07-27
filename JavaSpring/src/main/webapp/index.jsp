<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Chatbox Application</title>
<style>
body {
	background-color: purple;
	color: white;
	font-family: sans-serif;
	text-align: center
}

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
	<h1>Welcome to Chatbox Application Landing Page</h1>
	<%
		if ((session.getAttribute("userid") == null || session.getAttribute("userid") == "")) {
			out.println("<br>You are not logged in<br>");
			out.println("<br><a class='button1' href='login.html'>Please Login</a></br>");
			out.println("<br><a class='button1' href='register.html'>Please Register</a></br>");
		} else {
			out.println("You are logged in. Welcome " + session.getAttribute("userid")
					+ "<br> Will now redirect to chatbox");
			out.println("<br> <a href='logout.jsp' class='button1'>Log out</a><br>");
			out.println("<br> <a href='chatapp.jsp' class='button1'>Go To Chat Application</a><br>");
		}
	%>

	<script>
		function BanWords() {
			var xhttp;
			xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (xhttp.readyState == 4 && xhttp.status == 200) {
					console.log(xhttp);
					document.getElementById("ChatString").innerHTML = xhttp.responseText;
				}
			};
			var words = document.getElementById("words").value;
			var url = "http://localhost:8080/ChatApplication/AdminBan?words="
					+ words;
			console.log(url);
			xhttp.open("POST", url, true);
			xhttp.send();
		}
	</script>
	Banned Words
	<input type="text" id="words">
	<br>
	<input type="button" id="postdata" onclick="BanWords()" value="send"
		class="button1">

</body>
</html>