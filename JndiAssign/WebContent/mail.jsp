<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload = "load();">
	<form action="sendMail" method="post">
		from:<input type="text" name="from" id = "from" readonly><br>
		to:<input type="text" name="to"><br>
		subject:<input type="text" name="subject"><br> 
		content:<input type="text" name="content"><br> 
		<input type="submit" value="submit">
	</form>
	<script>
	function load(){
		var email = <%= request.getAttribute("email")%>;
		document.getElementById("from").value = "vishalgoyal2612@gmail.com";
		document.getElementById("to").value = email;
	}
	</script>
</body>
</html>