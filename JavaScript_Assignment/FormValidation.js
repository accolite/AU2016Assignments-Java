function formValidation()  
{    
var firstname = document.bioform.firstname; 
var fullname = document.bioform.fullname; 
var add = document.bioform.Address;      
var msex = document.bioform.male;  
var fsex = document.bioform.female; 
var other = document.bioform.others;
var email = document.bioform.email;
var age = document.bioform.age;
if(allLetter(firstname))  
{  
if(allLetterAndSpace(fullname))
{
if(alphanumeric(add))  
{   
if(allnumeric(age))  
{  
if(ValidateEmail(email))  
{  
if(validsex(msex,fsex,other))  
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
var letters = /^[a-zA-Z ]*$/;;  
if(name.value.match(letters))  
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
var letters = /^[A-Za-z]+$/;  
if(name.value.match(letters))  
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
var letters = /^[0-9a-zA-Z]+$/;  
if(add.value.match(letters))  
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

function validsex(umsex,ufsex,others)  
{  
x=0;  
  
if(umsex.checked)   
{  
x++;  
} 
if(ufsex.checked)  
{  
x++;   
}  
if(others.checked)
{
x++;
}
if(x==0)  
{  
alert('Select Male/Female/others');  
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