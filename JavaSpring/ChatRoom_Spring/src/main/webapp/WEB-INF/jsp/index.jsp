<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chatter Box</title>
</head>
<body>
	<form action="login" method="POST">
		<input type="hidden" value="login" name="mode">
		<input type="text" name="username" value="" placeholder="Harry Potter" />
		<br>
		<input type="password" name="password" placeholder="sethumadi" value="sethumadi" />
		<br>
		<input type="button" name="login" value="LogIn" />
		<br>
		<input type="button" name="register" value="Register"/>
		<br>
		<input type="button" name="admin" value="Admin"/>
	</form>
	<script type="text/javascript">
		document.getElementsByName("login")[0].onclick =function(){
			document.getElementsByName("mode")[0].value="login";
			document.getElementsByTagName("form")[0].submit();
		}
		document.getElementsByName("register")[0].onclick=function(){
			document.getElementsByName("mode")[0].value="register";
			document.getElementsByTagName("form")[0].submit();
		}
		document.getElementsByName("admin")[0].onclick=function(){
			document.getElementsByName("mode")[0].value="admin";
			document.getElementsByTagName("form")[0].submit();
		}
	</script>
</body>
</html>