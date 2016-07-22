
 function formValidation()  

{    
var firname = document.form1.firstname; 
var fullName = document.form1.fullname; 
var add = document.form1.address;      
var malesex = document.form1.male;  
var femalesex = document.form1.female;
var other= document.form1.other;
var email = document.form1.email;
var age = document.form1.age;
if(allLetter(firname))  
{  
if(allLetterAndSpace(fullName))
{
if(alphanumeric(add))  
{   
if(allnumeric(age))  
{  
if(ValidateEmail(email))  
{  
if(validsex(malesex,femalesex,other))  
{  
}  
}   
}  
}   
}  
}  
return false;  
}  

function allLetterAndSpace(name)  
{   
var chars = /^[a-zA-Z ]*$/;;  
if(name.value.match(chars))  
{  
return true;  
}  
else  
{  
alert('Username must have alphabet characters only');  
name.focus();  
return false;  
}  
}  


function allLetter(name)  
{   
var chars = /^[A-Za-z]+$/;  
if(name.value.match(chars))  
{  
return true;  
}  
else  
{  
alert('Username must have alphabet characters only');  
name.focus();  
return false;  
}  
}  

function alphanumeric(add)  
{   
var chars = /^[0-9a-zA-Z]+$/;  
if(add.value.match(chars))  
{  
return true;  
}  
else  
{  
alert('User address must have alphanumeric characters only');  
add.focus();  
return false;  
}  
}  

function ValidateEmail(email)  
{  
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
if(email.value.match(mailformat))  
{  
return true;  
}  
else  
{  
alert("You have entered an invalid email address!");  
email.focus();  
return false;  
}  
}  

function allnumeric(age)  
{   
var numbers = /^[0-9]+$/;  
if(age.value.match(numbers))  
{  
return true;  
}  
else  
{  
alert('Age must have numeric characters only');  
age.focus();  
return false;  
}  
}  

function validsex(umsex,ufsex,other)  
{  
x=0;  
  
if(umsex.checked)   
{  
x++;  
} if(ufsex.checked)  
{  
x++;   
} 
if(other.checked)
{
	x++;
}	
if(x==0)  
{  
alert('Select Male/Female/other');  
umsex.focus();  
return false;  
}
else if(x>1)
{
	alert('Select either  Male/Female/other');  
umsex.focus();  
return false; 
}	
else  
{  
alert('Form Successfully Submitted');  
window.location.reload()  
return true;
}  
}