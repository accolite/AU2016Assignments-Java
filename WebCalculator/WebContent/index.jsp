<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Awesome Calculator</title>
<link href="assets/css/bootstrap.min.css" rel="stylesheet">

</head>


<body class="jumbotron" style="padding:50px">
<h1>Awesome Calculator</h1>
<form action="" method="post" class="form-inline">
	<input type="text" id="param1" name="param1" class="form-control" placeholder="Operand 1" required>
	<select id="operation" name="op" class="form-control">
	<option value="1">+</option>
	<option value="2">-</option>
	<option value="3">*</option>
	<option value="4">/</option>
	</select>
	<input type="text" id="param2" name="param2" class="form-control" placeholder="Operand 2" required>
	<input type="submit" value="GO" class="btn btn-success">
</form>


<%
if(request.getMethod().equals("POST")){
	double param1 = Double.parseDouble(request.getParameter("param1"));
	double param2 = Double.parseDouble(request.getParameter("param2"));
	out.print("<div class=\"well\" style='width:30%'>" );
	out.print("Answer : ");
	int op = Integer.parseInt(request.getParameter("op"));
	switch(op){
	case 1:
		out.println(param1 + param2);
		break;
	case 2:
		out.println(param1 - param2);
		break;
	case 3:
		out.println(param1 * param2);
		break;
	case 4:
		double ans=0; 
		try{
			ans = param1 / param2;		
		} catch(Exception e){
			out.println("MATH ERROR");
		}
		out.println(ans);
		break;
	default:
		break;
	}
	out.print("</div>");
}
%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>