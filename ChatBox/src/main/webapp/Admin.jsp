<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>

function getNewXmlHttp() {
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlhttp;
}	
function filter() {

	var xmlhttp1 = getNewXmlHttp();
	//alert(id + " " + profilename);
	//window.alert("Hi");

	var words = document.getElementById("filter").value;
	
	xmlhttp1.onreadystatechange = function() {
		if (xmlhttp1.readyState == 4 && xmlhttp1.status == 200) {
			location.href = "http://localhost:8010/messanger/Login.html";
			
			
		}
	}
	xmlhttp1.open("POST",
			"http://localhost:8010/messanger/Filter?words="+words , true);
	xmlhttp1.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded");
	xmlhttp1.send();
}
</script>
</head>

<body>
hello admin
enter the words to be filtered separated by commas;
<input type="text" id="filter">
	<br>
<input type="submit" value="filter" onclick="filter()">
	<br>
</body>
</html>