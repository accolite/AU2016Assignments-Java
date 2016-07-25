<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chat Application</title>
</head>
<script>
<script type="text/javascript" src="Start.js">
</script>
</head>
<body>
Welcome <%=session.getAttribute("user") %>

	<div class="container">
		<div class="row">
			<div style="float:left;">
				<div id="msg">
			
				</div>	
				<div>
					<br>
					<input type="text" id="msgbox"> : 
					<input type="hidden" value='<%=session.getAttribute("user") %>'	id="userbox">
					<button id="sendbutton">Post</button>
				</div>
			</div>
			<div style="float:left;">
				<div id="usr">
			
		</div>
			</div>

		</div>	


		



		
	</div>
</body>
</html>