<%@ page import="com.mitul.chat.model.ChatManager" %>
<%@ page import="com.mitul.chat.model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Spring 4 MVC - HelloWorld Index Page</title>
</head>
<body>

<form action="/chat" method="post">
<input type="submit" value="Start Chat"/>
</form>
</body>
</html>