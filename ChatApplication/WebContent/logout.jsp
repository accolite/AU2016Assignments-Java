<%@page import="java.util.List"%>
<%
List<String> l =(List<String>) request.getServletContext().getAttribute("usersLoggedin");
l.remove(session.getAttribute("user"));

session.invalidate();
response.sendRedirect("index.jsp");

%>