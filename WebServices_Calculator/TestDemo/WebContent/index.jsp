<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Calculator</title>
</head>
<body>
	<h1>Calculator</h1>
	<!-- form which contains interface for calculator, where it calls servlet Calculator if submitted-->
	<form method="get" action="./Calculate">
		<p>
			<!-- input field for first number -->
			<input type="number" name="number1" value=0 />
			<!-- select element to choose the operation -->
			<select	name="operation">
				<option value="a">+</option>
				<option value="s">-</option>
				<option value="m">*</option>
				<option value="d">/</option>
			</select>
			<!-- input element for second number -->
			<input type="number" name="number2" value=0 />
		</p>
		<p>
			<!-- submit button which pings server with given parameters -->
			<input type="submit" name="submit" />
		</p>
	</form>
</body>
</html>