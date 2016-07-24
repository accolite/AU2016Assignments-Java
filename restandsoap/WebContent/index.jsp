<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chat Application</title>

<script src="validation.js"> 
</script>

</head>

<body onload="populate()">
<form>
<div id="divListUser"></div>
<div id="message"><textarea rows="4" cols="50" id="taMessage" name="taMessage"></textarea></div>
<br/>
<br/>

<input type="button" name="btnAddMessage" id="btnAddMessage" value="Add Message" style="margin-left: 300px" onclick="addMessage()"/>
<br/>
<br/>
<input type="button" name="btnViewAllMessages" id="btnViewAllMessages" value="View all Messages" style="margin-left: 150px" onclick="viewAllMessages()"/>
<div id="allMessages"></div>

</form>
</body>
</html>