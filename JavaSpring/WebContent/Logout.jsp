<%@page import="java.util.List"%>
<%
List<String> l =(List<String>) request.getServletContext().getAttribute("usersLoggedin");
l.remove(session.getAttribute("user"));
session.setAttribute("user", null);

session.invalidate();
response.sendRedirect("Index.jsp");
%>
