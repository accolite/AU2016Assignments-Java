<!DOCTYPE html> 
<html>
<head> 
<meta charset=utf-8 /> 
<title>Calculator in JavaScript</title> 
<style type="text/css"> 
body {
font-family:arial;
	font-size:12;
	font-weight:bold;
	background-color:grey;
	margin: 30px;
	}
</style>
</head>
        <body>
                <form method="get" action="./CalculatorServlet">
                        Number 1 : <input type="text" name="no1"> <br>
                        Number 2 : <input type="text" name="no2"> <br> 
                        Operator : 
                        
                        <select name="opt">
                                <option value="plus"> + </option>
                                <option value="minus"> - </option>
                                <option value="mul"> * </option>
                                <option value="div"> / </option>
                                                                                                                                
                        </select>
                                
                        <br>
                        <input type="submit" value="Go">
                </form>
        </body>
</html>