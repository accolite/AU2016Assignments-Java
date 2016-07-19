<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>calculator</title>
</head>
<body>
	<b>Welcome to Calculator</b>
	<form action="Calculator" method="post">
		First Number<input name="value1" type="text"> Second Number<input
			name="value2" type="text"> 
			<Select name="operation">
			<option value="+">ADD</option>
			<option value="-">SUBTRACT</option>
			<option value="*">MULTIPLY</option>
			<option value="/">DIVIDE</option>
		</select> 
		<br><input name="submit" type="submit">
		<br>

	</form>
	<p>${result}<p>

</body>
</html>