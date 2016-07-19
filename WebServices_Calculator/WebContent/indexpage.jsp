<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><h1>Welcome to Calculator</h1>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculator</title>
</head>
<body>
		<form method="get" action="./Calculator">
			Enter Number 1:<input type="number" name="num1"></br>
			Enter Number 2:<input type="number" name="num2"></br>
			Operation: <select name="operator">
				<option value="addition">+</option>
				<option value="subtraction">-</option>
				<option value="multiplication">*</option>
				<option value="division">/</option>
			</select>
			</br>
			<input type="submit" value="go">
			</br>
		</form>
	</body>
</html>