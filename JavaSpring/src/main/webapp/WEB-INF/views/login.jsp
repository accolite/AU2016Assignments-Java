<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
		<form action="logged" method="post">
			<fieldset>
				<center><label>USER LOGIN<br></label>
					UserId:&nbsp&nbsp<input type="text"name="id"><br>
					Password:&nbsp<input type="password" name="password"><br>
				</center>
				<center><input type = "submit" value = "login"></center>
			</fieldset>
		</form>
		<br>
		<form action="Register" method="post">
			<fieldset><center><label>Register<br></label>
				UserId:&nbsp&nbsp<input type="text"name="adminid"><br>
				Password:&nbsp<input type="password" name="adminpassword"><br>	
				</center>
				<center><input type = "submit" value = "login"></center>
			</fieldset>
		</form>
		<form action="ChatBox" method="post">
			<fieldset><center><label>CHAT Application<br></label>
				UserId:&nbsp&nbsp<input type="text"name="adminid"><br>
				Password:&nbsp<input type="password" name="adminpassword"><br>	
				</center>
				<center><input type = "submit" value = "login"></center>
			</fieldset>
		</form>
	</body>
</html>