<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% int a=Integer.parseInt(request.getParameter("text1"));
int b=Integer.parseInt(request.getParameter("text2"));
String arg =request.getParameter("CLICK");
if(arg.equals("ADD"))
	out.println(a+b);
if(arg.equals("SUB"))
	out.println(a-b);
if(arg.equals("MUL"))
	out.println(a*b);
if(arg.equals("DIV"))
{
	if(b==0)
		out.println("zero not allowed");
	else
		out.println(a/b);
}
%>
</body>
</html>