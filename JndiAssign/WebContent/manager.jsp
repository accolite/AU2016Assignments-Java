<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Choose action : <input type = "button" value = "register new employee" id = "register" onclick = "forward(this);"></input>
	<input type = "button" value = "see list of all employees" id = "view" onclick = "forward(this);"></input>
</body>
<script>
		function forward(obj){
			if(obj.id == 'register')
				{
					window.location.href = "http://localhost:8080/JndiAssign/registerEmployee.jsp";
				}
			else{
					window.location.href = "http://localhost:8080/JndiAssign/seeList";
			}
			
		}
</script>
</html>