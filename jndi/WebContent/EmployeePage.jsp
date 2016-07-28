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
function viewEmployee(){

	  var xmlhttp1 = getNewXmlHttp();
	   xmlhttp1.onreadystatechange = function(){
		   if (xmlhttp1.readyState==4 && xmlhttp1.status==200)
		    {
		  	 var metaData=xmlhttp1.responseText;
		  	 document.getElementById("details").innerHTML=metaData;
	      	//if(metaData=="manager")
	  		//		window.location="http://localhost:8080/TomcatDemo/ManagerPage.jsp";
			//else if(metaData=="employee")
			//		window.location="http://localhost:8080/TomcatDemo/EmployeePage.jsp";
		    }
	   }
	  //var name=document.getElementById("name").value;
	  //var password=document.getElementById("password").value;
	  var url="http://localhost:8080/TomcatDemo/EmployeePage";
	  
	  xmlhttp1.open("GET",url,true);
	  xmlhttp1.setRequestHeader("Content-type","application/text;charset=UTF-8");
	  xmlhttp1.send();
}
</script>
</head>
<body>
<h1>Welcome Employee</h1>
	<input type="button" value="ShowDetails" onClick="viewEmployee()">
	<h2>Details:</h2>
<div id="details">
</div>
</body>
</html>