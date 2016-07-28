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
function addEmployee(){

	  var xmlhttp1 = getNewXmlHttp();
	   xmlhttp1.onreadystatechange = function(){
		   if (xmlhttp1.readyState==4 && xmlhttp1.status==200)
		    {
		  	 var metaData=xmlhttp1.responseText;
	      	if(metaData=="success"){
	  				window.location="http://localhost:8080/TomcatDemo/ManagerPage.jsp";
	      	}
			else if(metaData=="failed"){
					window.location="http://localhost:8080/TomcatDemo/ManagerPage.jsp";
		    }
	      }
	   }
	  var name=document.getElementById("name").value;
	  var id=document.getElementById("id").value;
	  var address=document.getElementById("address").value;
	  var email=document.getElementById("email").value;
	  
	  var url="http://localhost:8080/TomcatDemo/AddEmployee?name="+name+"&id="+id+"&address="+address+"&email="+email;
	  
	  xmlhttp1.open("GET",url,true);
	  xmlhttp1.setRequestHeader("Content-type","application/text;charset=UTF-8");
	  xmlhttp1.send();
}

function viewEmployee(){

	  var xmlhttp1 = getNewXmlHttp();
	   xmlhttp1.onreadystatechange = function(){
		   if (xmlhttp1.readyState==4 && xmlhttp1.status==200)
		    {
		  	 var metaData=xmlhttp1.responseText;
		  	document.getElementById("details").innerHTML=" ";
		  	document.getElementById("details").innerHTML=metaData;
	      	//if(metaData=="manager")
	  		//		window.location="http://localhost:8080/TomcatDemo/ManagerPage.jsp";
			//else if(metaData=="employee")
			//		window.location="http://localhost:8080/TomcatDemo/EmployeePage.jsp";
		    }
	   }
	  //var name=document.getElementById("name").value;
	  //var password=document.getElementById("password").value;
	  var url="http://localhost:8080/TomcatDemo/ViewEmployee";
	  
	  xmlhttp1.open("GET",url,true);
	  xmlhttp1.setRequestHeader("Content-type","application/text;charset=UTF-8");
	  xmlhttp1.send();
}
</script>
</head>
<body>
<h1>Welcome Manager</h1>
<div>
		<input type="textarea" id="name" rows="10" cols="25" placeholder="EmployeeName"><br/>
		<input type="textarea" id="id" rows="10" cols="25" placeholder="EmployeeID"><br/>
		<input type="textarea" id="address" rows="10" cols="25" placeholder="Address"><br/>
		<input type="textarea" id="email" rows="10" cols="25" placeholder="Email-id"><br/>
		<input type="button" value="Create Employee" onClick="addEmployee()">
		<input type="button" value="ViewAllEmployee" onClick="viewEmployee()">
</div>
<h2>Employees:</h2>
<div id="details">

</div>

</body>
</html>