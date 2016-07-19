<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function isNumberKey(evt){
    var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode > 31 && (charCode != 46 &&(charCode < 48 || charCode > 57))){
    	
    	return false;
    }
    else if(charCode == 46 ){
    	document.getElementById("hidden").value = "Float";
		//document.getElementById("decimal").value="yes";
	}
    //else if(charCode == 46 && (document.getElementById("decimal").value =="yes")){
    //	return false;
    //}
    	return true;
}
</script>
</head>
<body>
	
	<h1>Welcome to Calculator Program</h1>
	<form action="calculate.jsp" method="get">
	<fieldset>
	<legend>Calculator</legend>
	Number 1:<br /><input  id="num" name="integer1" required onkeypress="return isNumberKey(event)"></input><br /><br />
	Number 2:<br /><input id="num" name="integer2" required onkeypress="return isNumberKey(event)"></input><br /><br />
	Operation: <br /><select name="operation">
		<option value="add">Add</option>
		<option value="subtract">Subtract</option>
		<option value="multiply">Multiply</option>
		<option value="divide">Divide</option>
	</select><br /><br />
	<input id="hidden" type="hidden" name="type" value="Integer" />
	<input id="decimal1" type="hidden" value="no" />
	<input id="decimal2" type="hidden" value="no" />
	<input type="submit" value="calculate">

	</fieldset>
	</form>
	<%
 	//String string = request.getHeader("Referer");
 	//out.println(string);
 	String string = request.getHeader("Referer");
	//System.out.println(string);
 	if(string != null && string.contains("http://localhost:8080/SimpleCalc/"))
 	out.println("Result is: "+request.getParameter("result"));
 	/*
 	if(string.equals("http://localhost:8080/SimpleCalc/"))
 	{
	
 		out.println("Result is"+request.getParameter("result"));
 	}*/
	%>
	
	
</body>
</html>
