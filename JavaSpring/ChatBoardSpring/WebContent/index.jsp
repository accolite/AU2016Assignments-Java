<!DOCTYPE html>
<html>
<head>
	<title>Please login</title>
</head>
<body>
<form action="app/move" method="POST">
<label for="username">Username</label>
<input type="text" name="username" minlength="4" maxlength="10" required><br/>
<label for="password">Password</label>
<input type="password" name="password" minlength="4" maxlength="10" required><br/>
<label for="login">Login</label><input type="radio" name="operation" id="login" value="Login" checked="true"><br/>
<label for="register">Register</label><input type="radio" name="operation" id="register" value="Register"><br/>
<label for="admin">Admin login</label><input type="radio" name="operation" id="admin" value="Admin Login"><br/>
<input type="submit" name="go" value="GO">
</form>
</body>
</html>