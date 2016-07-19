<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculator</title>
</head>
<body>

<form name="Calculator" action="./CalculateServlet" method="post">

<input type="label" name="labelInput1" id="labelInput1" value="Input 1" disabled="disabled">
<input type="text" name="display1" id="display1"/>

<br/>
<br/>
<select name="option" style=" margin-left: 120px">
	<option value="add" selected="selected">+</option>
	<option value="subtract">-</option>
	<option value="multiply">*</option>
	<option value="divide">/</option>
</select>
<br/>
<br/>
<input type="label" name="labelInput2" id="labelInput2" value="Input 2" disabled="disabled">
<input type="text" name="display2" id="display2"/>
<br/>
<br/>
<input type="submit" value="Result" name="result" id="result" style=" margin-left: 120px"/>


</form>


</body>

</html>