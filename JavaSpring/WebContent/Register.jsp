<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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

	function doAjax(obj) {

		var xmlhttp = getNewXmlHttp();
		var number1 = document.getElementById('text1').value;
		var number2 = document.getElementById('text2').value;
		
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			}
		}

		xmlhttp.open("POST", "DispatcherServelet", true);
		xmlhttp.send();
	}
</script>

</head>
<body align="center">

	<form action="Register" method="post" id="form 1">
		Name:<input type="text" value="" name="Name" /> <br><br>Username:<input
			type="text" value="" name="userid" /> <br><br>Password:<input
			type="password" value="" name="password" /><br><br> <input type="submit"
			value="Register" name="Submit" id="frm1" />
	</form>

</body>
</html>