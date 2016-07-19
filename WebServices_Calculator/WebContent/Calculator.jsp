<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Basic Calculator</title>
</head>
<body>
<%
	String operator=request.getParameter("operation");
	String number1=request.getParameter("num1");
	String number2=request.getParameter("num2");
	if(operator!=null||operator=="add"||operator=="subt"||operator=="mul"||operator=="div"){
		
		if(operator.equals("add")){
			int i=Integer.parseInt(number1)+Integer.parseInt(number2);
			out.println("Result: "+i);
		}else if(operator.equals("subt")){
			int i=Integer.parseInt(number1)-Integer.parseInt(number2);
			out.println("Result: "+i);
			
		}else if(operator.equals("mul")){
			int i=Integer.parseInt(number1)*Integer.parseInt(number2);
			out.println("Result: "+i);
			
		}else if(operator.equals("Div")){
			if(number2.equals("0"))
				out.println("Invalid Input");
			else{
				float i=Float.parseFloat(number1)/Float.parseFloat(number2);
				out.println("Result: "+i);
			}
			
		}
	}
 %>
<form action="/WebServices_Calculator/Calculator.jsp" method="POST" >
First Number:
<br>
<input type="text" name="num1">
<br>
Second  Number:
<br>
<input type="text" name="num2">
<br>
<br>
<select name="operation">
  <option value="add" selected>Addition</option>
  <option value="subt">Subtraction</option>
  <option value="mul">Multiply</option>
  <option value="Div">Divide</option>
</select>
<input type="submit" value="Submit" />
</form>
<br>


</body>
</html>