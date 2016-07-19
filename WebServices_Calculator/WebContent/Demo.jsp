<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form name="Calculator" action="./CalculateServlet">

<table border="2">

<tr>
<td colspan="4"><input type="label" name="labelInput1" id="labelInput1" value="Input 1" disabled="disabled">
<input type="text" name="display1" id="display1"></td>
</tr>

<tr>
<td colspan="4"><input type="label" name="labelInput2" id="labelInput2" value="Input 2" disabled="disabled">
<input type="text" name="display2" id="display2"></td>
</tr>

<tr>
<td colspan="4">
<select name="option">
	<option value="add">+</option>
	<option value="subtract">-</option>
	<option value="multiply">*</option>
	<option value="divide">/</option>
</select>
</td>
</tr>

<tr>
<td><input type="button" value="6" name="button6" id="button6"></td>
<td><input type="button" value="5" name="button5" id="button5"></td>
<td><input type="button" value="4" name="button4" id="button4"></td>
<td><input type="button" value="-" name="button-" id="button-"></td>
</tr>

<tr>
<td><input type="button" value="3" name="button3" id="button3"></td>
<td><input type="button" value="2" name="button2" id="button2"></td>
<td><input type="button" value="1" name="button1" id="button1"></td>
<td><input type="button" value="*" name="button*" id="button*"></td>
</tr>

<tr>
<td><input type="button" value="C" name="buttonC" id="buttonC"></td>
<td><input type="button" value="0" name="button0" id="button0"></td>
<td><input type="submit" value="=" name="button=" id="button="></td>
<td><input type="button" value="/" name="button/" id="button/"></td>
</tr>

</table>

</form>


</body>
</html>