function validation(){
	var success=true;
	document.getElementById("e_fullname").style.display='none';
	document.getElementById("e_age").style.display='none';
	document.getElementById("e_firstname").style.display='none';
	document.getElementById("e_address").style.display='none';
	document.getElementById("e_email").style.display='none';



function hasWhiteSpace(s) {
  var pat=/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/g;
	return(pat.test(s));  
}
	var fullname = document.forms["myform"]["fullname"].value;
	var address= document.forms["myform"]["address"].value;
	var firstname= document.forms["myform"]["firstname"].value;
	var age= document.forms["myform"]["age"].value;;
	var email= document.forms["myform"]["email"].value;
	var patt = /^([a-zA-Z]+[ ]*)+$/g;
	var patt3 = /^[a-zA-Z]+$/g;
	var patt4 = /^([a-zA-Z/:,0-9])|(\-)+$/g;

	var patt2=/[1-9]+/g;
	
	if (patt.test(fullname)==false)
	{	document.getElementById("e_fullname").style.display="block"
		document.getElementById("e_fullname").innerHTML="please enter correct full name. It must contain only alphabets and spaces are allowed";
		success=false;
	}
	if(!patt2.test(age) || age>115)
	{
		document.getElementById("e_age").style.display="block"
		document.getElementById("e_age").innerHTML="please enter correct age. It must contain only numbers less than 115 are allowed";
				success=false;

	}
	if(!patt3.test(firstname))
	{
		document.getElementById("e_firstname").style.display="block"
		document.getElementById("e_firstname").innerHTML="please enter correct first name. It must contain only alphabets";		success=false;

	}
	if(!patt4.test(address))
	{
		document.getElementById("e_address").style.display="block"
		document.getElementById("e_address").innerHTML="please enter correct  format of address.";		success=false;

	}
	if(!hasWhiteSpace(email))
	{
		document.getElementById("e_email").style.display="block"
		document.getElementById("e_email").innerHTML="please enter correct email. It must not contain space";		success=false;

	}
	if(success==true)
	{
		document.getElementById("success").innerHTML="the validation is success";
	}

}
