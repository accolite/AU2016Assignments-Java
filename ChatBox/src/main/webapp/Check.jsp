<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
function myFunction() {
    setInterval(function(){ 
    	alert("Hi");

		var xmlhttp1 = getNewXmlHttp();
		//alert(id + " " + profilename);
		xmlhttp1.onreadystatechange = function() {
			if (xmlhttp1.readyState == 4 && xmlhttp1.status == 200) {
				var metaData = xmlhttp1.responseText;

				document.getElementById("Messages").innerHTML = metaData;
			}
		}

		xmlhttp1.open("GET", "http://localhost:8010//messanger/Message", true);
		xmlhttp1.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xmlhttp1.send();
    }, 3000);
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<button onclick="myFunction()">Try it</button>
<div id="Messages"></div>
</body>
</html>