<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function getNewXmlHttp(){
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  return xmlhttp;
}
function login(){

	  var xmlhttp1 = getNewXmlHttp();
	   xmlhttp1.onreadystatechange = function(){
		   if (xmlhttp1.readyState==4 && xmlhttp1.status==200)
		    {
		  	 var metaData=xmlhttp1.responseText;
	      	if(metaData=="manager")
	  				window.location="http://localhost:8080/TomcatDemo/ManagerPage.jsp";
			else if(metaData=="employee")
					window.location="http://localhost:8080/TomcatDemo/EmployeePage.jsp";
		    }
	   }
	   var url="http://localhost:8080/TomcatDemo/LoginPage";
	  
	  xmlhttp1.open("GET",url,true);
	  xmlhttp1.setRequestHeader("Content-type","application/text;charset=UTF-8");
	  xmlhttp1.send();
}
</script>
</head>
<body>
	<h1>Welcome to Employee Portal</h1>
	<div style="align:center">
	<input type="submit" value="Login" onClick="login()"><br/><br/>
	</div> 
</body>
</html>