<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Calculator</title>
</head>
<%
 	String operation = request.getParameter("operation");
	String op1 = request.getParameter("op1");
	String op2 =  request.getParameter("op2");
	if( operation != null && ( operation.equals("add") || operation.equals("sub") || operation.equals("mul") || operation.equals("div") ) )
	{
		if( operation.equals("add") )
		{
			out.println("RESULT: " + ( Float.parseFloat( op1 ) + Float.parseFloat( op2 ) ) );
		}	
		else if( operation.equals("sub") )
		{
			out.println("RESULT: " + ( Float.parseFloat( op1 ) - Float.parseFloat( op2 ) ) );
		}
		else if( operation.equals("mul") )
		{
			out.println("RESULT: " + ( Float.parseFloat( op1 ) * Float.parseFloat( op2 ) ) );
		}
		else if( operation.equals("div") )
		{
			if( Float.parseFloat( op2 ) == 0 )
			{
				out.println("Division by zero is not defined");
				return;
			}
			out.println("RESULT: " + ( Float.parseFloat( op1 ) / Float.parseFloat( op2 ) ) );
		}
	}
%>

<body>
<form name="Calculator" action="Calc.jsp" method="post">
<h1> Calculator </h1>
	<br>
    <input type="number" step="0.01" name="op1">
    <br>
    <select name="operation">
	<option>add</option>
	<option>sub</option>
	<option>mul</option>
	<option>div</option>
	</select>
	<br>
    <input type="number" step="0.01" name="op2">
    <br>
 <input type="submit" >
</form>
</body>
</html>