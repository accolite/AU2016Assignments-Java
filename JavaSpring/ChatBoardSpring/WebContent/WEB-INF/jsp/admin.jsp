<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<label><%
	String[] words = (String[])request.getAttribute("wordslist");
	out.print("Restricted words");
	if(words != null){
		for(String word: words)
			out.print("  <fieldset><b>"+ word +"</b></fieldset>");
	}
	out.println();
	%></label>
	<form action="/ChatBoardSpring/app/addrw" method="GET">
		Restricted words: <input type="text" minlength=2 style="margin:10px" maxlength=20 name="words" required>(Comma seperated)<br/>
		<input type="submit" value="Submit"><br/><br/><a href="/ChatBoardSpring/app/logout">Logout</a>
	</form>

</body>
</html>