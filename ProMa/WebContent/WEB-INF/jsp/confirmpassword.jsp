<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function check()
{
	var pass=document.getElementById("newpassword").value;
	var confpass=document.getElementById("confirm_password").value;
	if(pass!=confpass)
		alert("Password doesnt match");
	
	}
</script>
</head>
<body>
<%
out.println("Hi"+request.getSession().getAttribute("username"));
%>
<br>
<form action="confirmfinal" method="post">
Password:    <input type="password" name="newpassword" value="" id="newpassword"><br><br>
Confirm Password:<input type="password" name="confirm_password" value="" onblur="check()" id="confirm_password"><br><br>
<input type="submit" value="Submit" name="button">
</form>

</body>
</html>