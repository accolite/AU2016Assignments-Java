<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculator</title>
</head>
<body>


<form name="form1" method="get" id="form1">
            <input name="num1" width="20" id="num1">
            <input name="num2" width="20" id="num2"> <br> <br>
            
			
            <input type="submit" name="button" value="+">
            <input type="submit" name="button" value="-">
            <input type="submit" name="button" value="*">
            <input type="submit" name="button" value="/">
            <br> <br> <hr>
        </form>
        
        <% 
        
            if(request.getParameter("button") != null) {
         String s = request.getParameter("button");
           int num1, num2;
           double num3;
           if(request.getParameter("num1").equals("")) { num1 = 0; } else num1 = Integer.valueOf(request.getParameter("num1"));
           if(request.getParameter("num2").equals("")) { num2 = 0; } else num2 = Integer.valueOf(request.getParameter("num2"));
           if (s.equals("+")) {
        	   num3 = num1 + num2;
               out.println("Result is " + num3);
           }
           else if (s.equals("-")) {
        	   num3 = num1 - num2;
               out.println("Result is " + num3);
           }
           else if(s.equals("*")) {
        	   num3 = num1 * num2;
               out.println("Result is " + num3);
           }
           else if(s.equals("/")) {
        	   num3 = num1 * 1.0 / num2;
               out.println("Result is " + num3);
           }
          
        
            }
         %>      
</body>
</html>