<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="DispatcherServelet" method="post">
		Username:<input type="text" value="" name="userid" /><br><br> Password:<input
			type="password" value="" name="password" /> 
			<br><br>
			<input type="radio" name="usertype" value="user" checked> User 
			<input type="radio" name="usertype" value="admin"> Admin <br><br>
			<input type="submit" value="Login" name="Submit" id="frm1" />
	</form>

</body>
</html>