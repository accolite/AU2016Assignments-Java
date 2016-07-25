<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><% if(session.getAttribute("username")!=null)
out.println(session.getAttribute("username")); %> Logged in</title>

<script type="text/javascript" src="js/jquery-latest.min.js"></script>

</head>

<body <% if(session.getAttribute("username")!=null) %>data-id=<%= session.getAttribute("id") %>>
<% if(session.getAttribute("username")!=null){ %>
	<div>
		<button id="logout">Logout</button>
	</div>
	<div id="actions" style="height:auto">
		
		<div style="float:left;width:68%;border:1px solid; border-radius:3px;position:relative">
			<h3>All Posts</h3>
			<div id="allPosts">
				
			</div>
		</div>
		<div style="width:2%"></div>
		<div style="float:left;width:29%;border:1px solid; border-radius:3px;position:relative">
			<h3>Active users </h3>
			<div id="activeUsers">
			
			</div>
		</div>
		
	</div>
	<div></div>
	<div style="width:95%;border:1px solid; border-radius:3px;height:auto;position:relative">
		<div id="action1" style="text-align:center">
			<h3>New Post : </h3>
			<input type="text" id="newPost" style="width:50%">
			<button id="newPostbtn">Post</button>
		</div>
	</div>
	<% } else{
		out.println("Invalid user session");	
	}%>
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>