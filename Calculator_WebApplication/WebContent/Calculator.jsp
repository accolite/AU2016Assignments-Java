<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String operand1 = request.getParameter("input1");
	String operand2 = request.getParameter("input2");
	String option = request.getParameter("operation");                
	if(option.equals("Add"))
      	 out.println(Integer.parseInt(operand1) + Integer.parseInt(operand2));
	else if(option.equals("Sub"))
      	 out.println(Integer.parseInt(operand1) - Integer.parseInt(operand2));
	else if(option.equals("Mul"))
   		 out.println(Integer.parseInt(operand1) * Integer.parseInt(operand2));
	else if(option.equals("Div"))
   		 out.println(Integer.parseInt(operand1) / Integer.parseInt(operand2));
%>
</body>
</html>