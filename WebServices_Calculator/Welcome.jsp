<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculator</title>
</head>
<body>
<form method="post" action="http://localhost:8080/SimpleCalculator/Calculator">
     Enter your first number : <input type="text" name="number1"> <br>
     Enter your second number : <input type="text" name="number2"> <br> 
     Choose the Operation to be performed :     
     <select name="operator">
             <option value="sum"> + </option>
             <option value="difference"> - </option>
             <option value="product"> * </option>
             <option value="divide"> / </option>                                                                                                           
     </select>
     <input type="submit" value="Go">
      Result is: <span id="result">${result}</span>       
     <br>
</form>
</body>
</html>