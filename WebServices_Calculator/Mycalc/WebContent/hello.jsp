<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello world</title>
</head>
<body>
<h2> Nishant Calculator</h2>
<html>

<%
String operation=request.getParameter("operation");
//float a=Float.parseFloat(request.getParameter("op1"));
//float b=Float.parseFloat(request.getParameter("op2"));
String s1=request.getParameter("op1");
String s2=request.getParameter("op2");
//out.println( s1 + " " + s2 + " " + operation );
if(operation!=null&&!s1.equals("")&&!s2.equals("")){
	float a=Float.parseFloat(s1);
	float b=Float.parseFloat(s2);
	if(operation.equals("+"))
	{
		out.println(request.getParameter("op1")+" "+request.getParameter("operation")+" "+request.getParameter("op2")+" = "+ (a+b));
	}
	else if(operation.equals("-")){
		out.println(request.getParameter("op1")+" "+request.getParameter("operation")+" "+request.getParameter("op2")+" = "+ (a-b));
	}
	else if(operation.equals("x")){
		out.println(request.getParameter("op1")+" "+request.getParameter("operation")+" "+request.getParameter("op2")+" = "+ (a*b));
	}
	else if(operation.equals("/")){
		if(b==0){
			out.println("Divide by zero error");
		}
		else{
			out.println(request.getParameter("op1")+" "+request.getParameter("operation")+" "+request.getParameter("op2")+" = "+ (a/b));
		}
	}
}

%>
<body>
<form action="/Mycalc/hello.jsp" method="POST">
<input type="number" name="op1" step="any" >
<select name="operation" >      
<option> + </option>      
<option> - </option>      
<option> x </option>  
<option> / </option>
</select>   
<input type="number" name="op2" step="any"/>

<input type="submit" value="Submit" />
</form>
</body>
</html>

</body>
</html>