<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>AU assignment - Mitul Kapoor</title>
</head>
<body>

<center>
    <h2>Calculator Assignment - Mitul Kapoor</h2>
    <h3>
        <form:form action="/Compute" method="get" modelAttribute="number">
        Number 1 : <input type="text" id="number1" name="number1" onblur="checkIfNumber1()"/>
        <br>
        <br>
        Number 2 : <input type="text" id="number2" name="number2" onblur="checkIfNumber2()"/>
            <br>
            <br>

            <select id="operation" name="operation" onchange="">
                <option value="+">+(Add)</option>
                <option value="-">-(Subtract)</option>
                <option value="*">*(Multiply)</option>
                <option value="/">/(Divide)</option>
            </select>
            <br>
            <br>
           <input type="submit" value="Compute Result" />
            <br>
        </form:form>

    </h3>
</center>
</body>

<script>
    function checkIfNumber1(){
          var x = document.getElementById("number1").value;
            if (isNaN(x))
            {
                alert("Must input numbers");
                return false;
            }
    }

    function checkIfNumber2(){
        var x = document.getElementById("number2").value;
        if (isNaN(x))
        {
            alert("Must input numbers");
            return false;
        }
    }

</script>

</html>