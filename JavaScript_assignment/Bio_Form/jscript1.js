function fname(obj){
	 var alpha = /^[a-zA-Z]+$/;  
     if (obj.value == "") {
        document.getElementById("one").innerHTML="";
        return false;
     }
     else if (!(obj.value).match(alpha)) {
		 console.log(obj.value);
        document.getElementById("one").innerHTML="Invalid  name (only alphabets are allowed)";      
       return false;
    }
   document.getElementById("one").innerHTML="";
   return true;
}

function full_name(obj){
	 var alpha = /^[a-zA-Z\s]+$/;  
     if (obj.value == "") {
        document.getElementById("two").innerHTML="";
        return false;
     }
     else if (!(obj.value).match(alpha)) {
        document.getElementById("two").innerHTML="Invalid full name (only space & alphabets are allowed)";       
        return false;
    }
   document.getElementById("two").innerHTML="";
   return true;
}


function e_mail(obj)
{
	
	var alpha = /^[a-zA-Z0-9_\.-]+@[a-zA-Z0-9]+\.[a-zA-Z]+$/;
	if (obj.value == "") {
        document.getElementById("four").innerHTML="";
		return false;
     }
     else if (!(obj.value).match(alpha)) {
        document.getElementById("four").innerHTML="Invalid Email";   
		return false;		
    }
   
	document.getElementById("four").innerHTML="";
	return true;
}


function agecheck(obj)
{
	
	if(obj.value == "")
	{
		document.getElementById("three").innerHTML="";
		return false;
	}
	else if((obj.value) > 0 &&  (obj.value) <= 150){
		document.getElementById("three").innerHTML="";
		//do nothing
		return true;
	}
	else
	{
		document.getElementById("three").innerHTML="Age can be between 1 to 150 only"; 
		return false;
	}
	
}

function addresscheck(obj)
{
	 var alpha = /^[a-z A-Z 0-9 \s \/ \: \- \,]+$/;  
     if (obj.value == "") {
        document.getElementById("five").innerHTML="";
		return false;
     }
     else if (!(obj.value).match(alpha)) {
		 document.getElementById("five").innerHTML="Address can not have special character other than /   :   -    ,"; 
		 return false;
    }
   document.getElementById("five").innerHTML="";
   return true;
}

function gen(obj)
{
	var str=(obj.value).toLowerCase();
	
	if(str == "")
	{
		document.getElementById("six").innerHTML="";
		return false ;
	}
	else if(str == "male" || str == "female" || str == "other")
	{
		document.getElementById("six").innerHTML="";
		return true;
	}
	else
	{
		document.getElementById("six").innerHTML="Gender can be Male,Female or Other";
		return false;
	}
	
}

function validate(){

	var a = fname(document.getElementById("firstname"));
	var b = full_name(document.getElementById("fullname"));
	var c = e_mail(document.getElementById("email"));
	var d = addresscheck(document.getElementById("address"));
	var e = gen(document.getElementById("gender"));
	var f = agecheck(document.getElementById("age"));
	if(a && b && c && d && e && f)
	{
		alert(" Success ");
	}
	else
	{	alert("Something went wrong");
	}
}

