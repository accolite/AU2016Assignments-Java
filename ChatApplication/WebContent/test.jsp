<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	ServletContext sc = request.getServletContext();
	
	out.println("registered ,<br><br>");
	List<String> allUsers  = (List<String>) sc.getAttribute("usersList");
	if(allUsers != null){
		for(String s : allUsers){
			out.println(s + "<br>");
		}
	}
	out.println("loggedin ,<br><br>");
	List<String> loggedinUsers  = (List<String>) sc.getAttribute("usersLoggedin");
	if(loggedinUsers != null){
		for(String s : loggedinUsers){
			out.println(s + "<br>");
		}
	}
	
	out.println("Banned ,<br><br>");
	List<String> bannedWords  = (List<String>) sc.getAttribute("bannedWords");
	if(bannedWords != null){
		for(String s : bannedWords){
			out.println(s + "<br>");
		}
	}

%>
</body>
</html>