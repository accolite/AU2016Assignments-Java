<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/RegisterUser" onsubmit="return check()">
<h1>Register yourself</h1>
<font color="red">
	<%if(request.getParameter("msg")!=null)
	{
		out.println(request.getParameter("msg"));
	}%>
</font><br/><br/>
Username: <input type="text" id="txtUsername" name="txtUsername" style="margin-left: 100px"/><br/><br/>
Password: <input type="password" id="txtPassword" name="txtPassword" style="margin-left: 100px"/><br/><br/>
Confirm Password: <input type="password" id="txtConfirmPassword" name="txtConfirmPassword" style="margin-left: 40px"/><br/><br/>
<input type="submit" id="sbtRegister" name="sbtRegister" value="Register" style="margin-left: 130px"/>
</form>
</body>
<script>
function check(){
	var usr=document.getElementById("txtUsername").value;
	var pwd=document.getElementById("txtPassword").value;
	var cpwd=document.getElementById("txtConfirmPassword").value;
	if(usr!=null && pwd!=null && cpwd!=null && usr!="" && pwd!="" && cpwd!="" && pwd==cpwd)
		return true;
	return false;
}
</script>
</html>