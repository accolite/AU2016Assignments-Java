var input="0";
	var match=/^[0-9]*\\.?[0-9]*$/g;
	

function populate(val)
{
	
	
		if(input==""){input="0";}
		
		input+=val.value;

		document.getElementById("input").value=input;
}
function calculate()
{
	try{
	var output=eval(document.getElementById("input").value);
	document.getElementById("input").value=output;
	input=output;
}
	catch(e)
	{
		document.getElementById("input").value="";
		input="";
	}

}
function clear1()
{
	input="";
		document.getElementById("input").value="";

}
function backspace()
{
	document.getElementById("input").value=document.getElementById("input").value.substring(0, input.length - 1);
		input=	document.getElementById("input").value;


}
function divide_by_one()
{

	input=eval(1/document.getElementById("input").value);
	if(isNaN(input)||input=="Infinity"){
			document.getElementById("input").value="";
		input="";
		}
	else
	{
			document.getElementById("input").value=input;
	}
}