<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="jfunc.js"></script>
<style>
	.fl{
		float:left;
	}
	.row:after {
	     visibility: hidden;
	     display: block;
	     font-size: 0;
	     content: " ";
	     clear: both;
	     height: 0;
	     }
	.row { display: inline-block; }
	/* start commented backslash hack \*/
	* html .row { height: 1%; }
	.row { display: block; }
</style>
</head>
<body>


Hello <%=session.getAttribute("user") %> <a href="logout.jsp">Log out</a>

	<div class="container" style="width:500px;height:320px;margin:100px auto;">
		<div class="row">
			<div class="fl" style="width:80%">
				<div id="msg" style="height:300px;border:1px solid black;overflow-y:scroll;">
			
				</div>	
				<div>
					<br>
					<input type="text" id="msgbox" style="width:80%"> : 
					<input type="hidden" value='<%=session.getAttribute("user") %>'	id="userbox">
					<button id="sendbutton">Post</button>
				</div>
			</div>
			<div class="fl" style="width:19%">
				<div id="usr" style="width:100px;height:320px;border:1px solid black;">
			
		</div>
			</div>

		</div>	


		



		
	</div>
</body>
</html>