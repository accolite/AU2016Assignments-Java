<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="get" action="./calculator">
                        Number 1 : <input type="text" name="no1"> <br>
                        Number 2 : <input type="text" name="no2"> <br> 
                        Operator : 
                        
                        <select name="opt">
                                <option value="p"> + </option>
                                <option value="m"> - </option>
                                <option value="mul"> * </option>
                                <option value="d"> / </option>
                                                                                                                                
                        </select>
                                
                        <br>
                        <input type="submit" value="Go">
                </form>

</body>
</html>