<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="styles.css">
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="jfunc.js"></script>
</head>
<body>

<%
		    
		    if((session.getAttribute("user")!= null ) && (session.getAttribute("user")!= "")){
		     %>

<div class="row">
	<div style="float-right">
		<a href="logout.jsp" style="color:white">Log out</a>
	</div>
</div>
	<div class="container" style="width:500px;height:320px;margin:100px auto;">
		<div class="row">
			<div class="fl" style="width:80%">
				<div id="msg" style="height:300px;border:1px solid black;overflow-y:scroll;padding:10px;background-color:#eee">
			
				</div>	

			</div>
			<div class="fl" style="width:19%">
				<div id="usr" style="width:100px;height:310px;border:1px solid black;">
			
				</div>
			</div>
			

		</div>
		<div class="row">
			<div class="fl"  style="width:90%">
				<input type="text" id="msgbox" style="width:100%;">
				<input type="hidden" value='<%=session.getAttribute("user") %>'	id="userbox">
			</div>
			<div class="fr" style="width:10%">
				<button id="sendbutton" class="btn fr" >Post</button>
			</div>
		</div>			

	</div>
	<%
}
%>
</body>
</html>