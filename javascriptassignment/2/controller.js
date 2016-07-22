function c(val)
{
	document.getElementById("show").value=val;
}
function v(val)
{

	if(val == "sin" || val == "cos" || val == "tan") {
		document.getElementById("show").value = "Math." + document.getElementById("show").value + val;
	} else if(val == "e") {
		document.getElementById("show").value+="2.71828*";
	} else
		document.getElementById("show").value+=val;
}
function e() 
{ 
	try 
	{ 
		c(eval(document.getElementById("show").value)) 
	} 
	catch(e) 
	{
		c('Error') 
	} 
}  