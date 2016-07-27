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
		String userid = request.getParameter("userid");
		if (userid.length() > 0) {
			ServletContext sc = request.getServletContext();
			if (sc.getAttribute("RegisteredUsers") == null)
				sc.setAttribute("RegisteredUsers", "");
			sc.setAttribute("RegisteredUsers", sc.getAttribute("RegisteredUsers") + "," + userid);

			response.sendRedirect("index.jsp");
		}
	%>

</body>
</html>