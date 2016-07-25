<%@page import="java.util.List"%>
<%
List<String> l =(List<String>) request.getServletContext().getAttribute("usersLoggedin");
l.remove(session.getAttribute("user"));
request.getServletContext().setAttribute("chatString",request.getServletContext().getAttribute("chatString") + "<br>" + session.getAttribute("user") + " has left <br>");
session.setAttribute("user", null);
session.invalidate();
response.sendRedirect("index.jsp");

%>