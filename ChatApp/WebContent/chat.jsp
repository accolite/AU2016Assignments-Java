<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ChatBox</title>
</head>
<body>
	<form action="/GroupWalaSkype/chat.jsp">
		<textarea rows="4" cols="50" id = "chatBox" name = "chat"></textarea>
		<input type="submit">
	</form>
	<%@ page import =  "java.util.ArrayList"%>
	<%@ page import =  "java.util.HashMap"%>
	<%
		session = request.getSession();
		String currUser = (String)session.getAttribute("currUser");
		System.out.println(currUser);
		HashMap<String,ArrayList<String>>userMessages = (HashMap<String,ArrayList<String>>)session.getAttribute("userMsgs");
		if(userMessages == null)
			userMessages = new HashMap<String,ArrayList<String>>();;
		
		String message  = request.getParameter("chat");
		
		ArrayList<String>currUserMsgs = userMessages.get(currUser);
		if(currUserMsgs == null)
			currUserMsgs = new ArrayList<String>();
		userMessages.remove(currUser);
		if(message != null)
			currUserMsgs.add(message);
		userMessages.put(currUser, currUserMsgs);
		session.setAttribute("userMsgs", userMessages);
		//response.sendRedirect("/GroupWalaSkype/chat.jsp");
		out.print(userMessages);
	%>
</body>
</html>