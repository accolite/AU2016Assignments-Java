<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculate</title>
</head>
<body>
	<form name="Name Input Form" action="CalculateServlet" method="get">
        <table>
			<tr>
			<th>
            	Number 1
            </th>
            
            <th>
            	Number 2:
            </th>
            </tr>
            <tr>
            	<td>
            		<input type="text" name="number1" />
            	</td>
           
            	<td>
            		<input type="text" name="number2" />
            	</td>
           	</tr>
           	<tr>
           		<td>
           			<input type="radio" name="operation" value="sum">Sum
           			<br/>
           			<input type="radio" name="operation" value="difference">Subtract
           		</td>
           		<td>
           			<input type="radio" name="operation" value="multiply">Multiply
	           		<br/>
           			<input type="radio" name="operation" value="divide">Divide
           		</td>
           	</tr>
           	<tr>
           		<td>
            		<input type="submit" value="Operate" />
            	</td>
            </tr>
        </table>
    </form>
 <div id="result">
  <pre>
      ${requestScope.utilOutput}
  </pre>
</div>
	  
    
    
</body>
</html>