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
	if(request.getParameter("text1")=="" || request.getParameter("text2")==""){
		out.print("Enter some number:--");
	}else{
    float first   = Float.parseFloat(request.getParameter("text1"));
	float second = Float.parseFloat(request.getParameter("text2"));
	String act = request.getParameter("action");
	float answer=0;
	boolean flag=false;
	if (act == null) {
	    out.print("nothing is selected");
	} else if (act.equals("Add")) {
	    //add button was pressed
	    answer = first+second;
	} else if (act.equals("Subtract")) {
	    //subtract button was pressed
	    answer = first-second;
	} else if (act.equals("Multiply")) {
		answer = first*second;
	    //update button was pressed
	} else if (act.equals("Division")) {
		if(second==0){
		out.print("Can't Divide by Zero\n");flag=true;}
		else
		{
		answer = first/second;
		
		}
	    //update button was pressed
	} 
	if(flag==false)
	out.print("Your answer is "+ answer);
	}
%>
<br></br>
    <a href="Format.html">Try again?</a>
</body>
</html>
