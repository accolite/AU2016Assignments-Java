<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login to My ChatBox Application</title>
</head>
<body>
	<%
		String userid = request.getParameter("userid");
		String redirect = "";
		ServletContext sc = request.getServletContext();
		if (sc.getAttribute("RegisteredUsers") != null) {
			String regusers = (String) sc.getAttribute("RegisteredUsers");
			if (sc.getAttribute("ActiveUsers") == null)
				sc.setAttribute("ActiveUsers", "");
			out.println(regusers);
			String[] regusersArray = regusers.split(",");
			for (int b = 0; b < regusersArray.length; b++) {
				out.println(regusersArray[b] + "<br>");
				if (userid.toLowerCase().equals(regusersArray[b].toLowerCase())) {
					session.setAttribute("userid", userid);
					redirect = "index.jsp";
					sc.setAttribute("ActiveUsers", sc.getAttribute("ActiveUsers") + "," + userid);
					break;
				} else {
					redirect = "login.html";
				}
			}
			if (!redirect.equals("index.jsp"))
				out.println(" <script> alert('invalid login') </script>");
			response.sendRedirect(redirect);
		}
	%>

</body>
</html>