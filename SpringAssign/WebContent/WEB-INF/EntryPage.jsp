<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form commandName="insertUser" method="POST" action="insertJdbcContact.do" id="userdetailsid" >		
 
			<fieldset>
				<legend>User details</legend>
				<ol>
					<li>
						<label for=name>Name</label>
						<form:input path="name"  type="text" placeholder="First and last name" />
					</li>
					
				</ol>
			</fieldset>
			
			<fieldset>
				<button type=submit>Save User Details!</button>
			</fieldset>
		</form:form>
</body>
</html>