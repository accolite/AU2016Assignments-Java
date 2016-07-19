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
	String string = request.getHeader("Referer");
	//System.out.println(string);
	String type=request.getParameter("type");
	//out.println(type);
	String redirectURL = "http://localhost:8080/SimpleCalc/";
	if(type.equals("Float")){
		double result = 0.0;
		double num1 = Double.parseDouble(request.getParameter("integer1"));
		double num2 = Double.parseDouble(request.getParameter("integer2"));
		String operation = request.getParameter("operation");
		if(operation.equals("add")){
			result = num1+num2;
		}
		else if(operation.equals("subtract")){
			result = num1-num2;
		}
		else if(operation.equals("divide")){
			if(num2!=0.0)
			result = num1/num2;
			else
				response.sendRedirect(redirectURL+"index.jsp?result="+"second number should not be 0");
		}
		else if(operation.equals("multiply")){
			result = num1*num2;
		}
		out.println(result);
		response.sendRedirect(redirectURL+"index.jsp?result="+result);
	}
	else{
		int result = 0;
		int num1 = Integer.parseInt(request.getParameter("integer1"));
		int num2 = Integer.parseInt(request.getParameter("integer2"));
		String operation = request.getParameter("operation");
		if(operation.equals("add")){
			result = num1+num2;
		}
		else if(operation.equals("subtract")){
			result = num1-num2;
		}
		else if(operation.equals("divide")){
			result = num1/num2;
		}
		else if(operation.equals("multiply")){
			if(num2!=0)
			result = num1*num2;
			else
				response.sendRedirect(redirectURL+"index.jsp?result="+"second number can't be 0");
		}
		out.println(result);
		response.sendRedirect(redirectURL+"index.jsp?result="+result);
	}
	//out.println(result);
	 //String redirectURL = "http://localhost:8080/SimpleCalc/";
	  //  response.sendRedirect(redirectURL);
%>
</body>
</html>
