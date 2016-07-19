<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculator Application</title>
</head>
<body>
<form action="Calculator.jsp" method="get">

<center><table><tr>
<td>Enter operand 1:</td>
<td><input type="text" name="input1"></input></td></tr>
<tr>
<td>Enter operand 2:</td>
<td><input type="text" name="input2"></input></td></tr>

<tr><td>Choose operation:
<input type="radio" name="operation" value="Add">Addition
<input type="radio" name="operation" value="Sub">Subtraction
<input type="radio" name="operation" value="Mul">Multiplication
<input type="radio" name="operation" value="Div">Division</td></tr>

<tr><td><input type="submit" value="Calculate"></input></td></tr>
</table>
</center>

</form>
</body>
</html>