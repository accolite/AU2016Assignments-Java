<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/AdminServlet" method="post">
<h1>Enter comma separated list of prohibited words</h1>
<textarea rows="4" cols="50" style="margin-left: 100px" id="taBannedWords" name="taBannedWords"></textarea><br/><br/>
<input type="submit" value="Save" id="sbtSave" name="sbtSave" style="margin-left: 300px"/>
</form>
</body>
</html>