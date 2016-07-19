<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<%
String op1=request.getParameter("op1");
String op2=request.getParameter("op2");
String operation=request.getParameter("operation");
if(operation!=null&&!op2.equals("")&&!op1.equals("")){
	if(operation.equals("add")){
		out.println(Double.parseDouble(op1)+Double.parseDouble(op2));
	}
	else if(operation.equals("sub")){
		out.println(Double.parseDouble(op1)-Double.parseDouble(op2));
	}
	else if(operation.equals("mul")){
		out.println(Double.parseDouble(op1)*Double.parseDouble(op2));
	}
	else{
		if(Double.parseDouble(op2)==0)
			out.println("operand 2 must not be 0");
		else
		    out.println(Double.parseDouble(op1)/Double.parseDouble(op2));
	}
}

%>
<body>
	<FORM ACTION="Calculator.jsp" METHOD="POST">
		<CENTER>
			<H1>The JSP Calculator</H1>
			<INPUT TYPE="NUMBER" NAME="op1" > 
			    <BR> <select
				    name="operation">
					<option value="add">addition</option>
					<option value="sub">substraction</option>
					<option value="mul">multiply</option>
					<option value="div">divide</option>
			    </select> <BR>
			 <INPUT TYPE="NUMBER" NAME="op2"> <BR>
			<INPUT TYPE="SUBMIT" VALUE="Do Operation">
		</CENTER>
	</FORM>
</body>
</html>