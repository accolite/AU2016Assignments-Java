<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculator</title>
</head>
<body>
	<%
		Double op1 = Double.parseDouble(request.getParameter("op1"));
		Double op2 = Double.parseDouble(request.getParameter("op2"));
		String action = request.getParameter("action");
		if (action.equals("Add")) {
			out.println(op1+op2);
		} else if (action.equals("Subtract")) {
			out.println(op1-op2);
		} else if (action.equals("Multiply")) {
			out.println(op1*op2);
		} else if (action.equals("Divide")) {
			if(op2==0){
				out.println("Cannot Divide with Zero");
			}
			else{
				out.println(op1/op2);
			}
		}
	%>
</body>
</html>