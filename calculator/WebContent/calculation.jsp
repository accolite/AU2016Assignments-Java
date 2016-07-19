<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculator Web Application</title>
<sript src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<body>
<form id="calculator" >
    <p>
        <input name="left"> <br>
        <input name="right"> <br>
        
      
        <select name="opt">
                                <option value="add"> addition </option>
                                <option value="sub"> subtraction </option>
                                <option value="mult"> Multiplication </option>
                                <option value="div"> division </option>
                                                                                                                                
                        </select>
                                
                        <br>
                        <br>
        
        <input type="submit" value="Calculator" name="button"> 
    </p>
    
    
</form>

<% 

	if(request.getParameter("opt") != null) {
	String s  = request.getParameter("opt");
	int left ,right;
	if(request.getParameter("left").equals("")) {left=0;} else left = Integer.valueOf(request.getParameter("left"));
	if(request.getParameter("right").equals("")) {right=0;} else right = Integer.valueOf(request.getParameter("right"));
	
	if(s.equals("add")) {
	    out.println(left +right);	
	} 
	if(s.equals("sub")) {
	    out.println(left -right);	
	} 
	if(s.equals("mult")) {
	    out.println(left *right);	
	} 
	if(s.equals("div")) {
	    out.println(left /right);	
	} 
	}
%>


</body>
</html>