<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculator</title>
</head>
<body>
<FORM ACTION="./HelloServlet" METHOD="POST">
            <CENTER>
                <H1>The JSP Calculator</H1>
                <INPUT TYPE="TEXT" NAME="op1" VALUE="" required>
                <BR>
                
                <BR>
                <INPUT TYPE="TEXT" NAME="op2" VALUE="" required>
                <BR>
                
                <input type="radio" name="ch" value="add" checked> Addition<br>
 				 <input type="radio" name="ch" value="sub"> Subtract<br>
  				<input type="radio" name="ch" value="mul"> Multiply<br>
  				<input type="radio" name="ch" value="div"> Divide<br>
                <INPUT TYPE="SUBMIT" name="submit">
               
            </CENTER>
 </FORM>
</body>
</html>