function fname()
{
	 var firstname = document.getElementById('firstname');
	 var alpha = /^[a-zA-Z]+$/;  
     if (firstname.value == "") {
        alert('Please enter Name');
        return false;
     }
     else if (!firstname.value.match(alpha)) {
        alert('Firstname can have only alphabets and NO spaces');       
        return false;
    }
    else 
    {
		return true;
	}
}

function name()
{
	 var fullname = document.getElementById('fullname');
	 var alpha = /^[a-zA-Z\s]+$/;  
     if (fullname.value == "") {
        alert('Please enter Full Name');
        return false;
     }
     else if (!fullname.value.match(alpha)) {
        alert('FullName can ONLY contain alphabets and spaces');       
        return false;
    }
    else 
    {
		return true;
	}
}
function email()
{
	var x=document.getElementById('email');
	var alpha = /^[a-zA-Z0-9_\.-]+@[a-zA-Z0-9]+\.[a-zA-Z]+$/;
	if (x.value == "") {
        alert('Please enter Email');
        return false;
     }
     else if (!x.value.match(alpha)) {
        alert('Enter a VALID Email id');       
        return false;
    }
    else 
    {
		return true;
	}
	
}

function address()
{
	var address = document.getElementById('address');
	 var alpha = /^[a-z A-Z 0-9 \s \/ \: \- \,]+$/;  
     if (address.value == "") {
        alert('Please enter Address');
        return false;
     }
     else if (!address.value.match(alpha)) {
        alert("Address CANT have special character other than \'/\',\':\',\'-\',\',\'");       
        return false;
    }
    else 
    {
		return true;
	}
	
}
function gender()
{
	var r = document.getElementById("gender");
	if(r.value == "")
	{
		alert("Please enter gender");
		return false;
	}
	else if(r.value == "Male" || r.value == "Female" || r.value == "Other")
	{
		return true;
	}
	else
	{
		alert("Gender can ONLY  be Male,Female or Other");
		return false;
	}
	
}
function age()
{
	var temp = document.getElementById('age');
	var age = document.getElementById('age').value;
	if(temp.value == "")
	{
		alert("Please enter age");
		return false;
	}
	else if(age > 0 &&  age <= 150){
		return true;
	}
	else
	{
		alert("Age can be between 1 to 150 only");
		return false;
	}
}

function formValidate(){
	/*if(fname() && name() && email() && address() && gender()&& age())
	{
		alert(" Success : Your Details are recorded");
	}
	else
	{	alert("Something went wrong");
	}*/
	a = fname();
	b = name();
	c = email();
	d = address();
	e = gender();
	f = age();
	if(a && b && c && d && e && f)
	{
		alert(" Success : Your Details are recorded");
	}
	else
	{	alert(" Failed to Record.Something went wrong");
	}
}