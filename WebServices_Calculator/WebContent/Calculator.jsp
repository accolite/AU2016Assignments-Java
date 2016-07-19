<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculator Web App</title>
</head>
<body>
        
        <form name="form1" method="post">
            <input name="Value1">
            <input name="Value2">
            <input type="submit" name="button" value="ADD">
            <input type="submit" name="button" value="SUB">
            <input type="submit" name="button" value="MUL">
            <input type="submit" name="button" value="DIV">
           
        </form>
        
        <% 
            if(request.getParameter("button") != null) {
        %>
        <% String s = request.getParameter("button");
           Float Value1,Value2;
           if(request.getParameter("Value1").equals("")) { Value1 = 0.0F; } else Value1 = Float.valueOf(request.getParameter("Value1"));
           if(request.getParameter("Value2").equals("")) { Value2 = 0.0F; } else Value2 = Float.valueOf(request.getParameter("Value2"));
           if (s.equals("ADD")) {
               out.println("Result is " + (Value1 + Value2));
           }
           else if (s.equals("SUB")) {
               out.println("Result is " + (Value1-Value2));
           }
           else if(s.equals("MUL")) {
               out.println("Result is " + (Value1*Value2));
           }
           else if(s.equals("DIV")) {
               out.println("Result is " + (Value1/Value2));
           }
        
        %>
        <%
            }
        %>
        
        
</body>
</html>