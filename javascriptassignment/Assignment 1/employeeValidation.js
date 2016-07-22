function check()
{
	
	var firstName=document.getElementById("txtFirstName").value;
	var fullName=document.getElementById("txtFullName").value;
	var emailId=document.getElementById("txtEmailId").value;
	var age=document.getElementById("txtAge").value;
	var gender=document.getElementsByName("radioGender").value;
	var address=document.getElementById("taAddress").value;
	
	var i=0;
			
			
			if(firstName == "" || firstName == null){
				document.getElementById("divFirstName").innerHTML="Please Fill First Name";
				i=1;
			} 
			else if(!(/^[a-zA-Z]+$/.test(firstName))) {
				document.getElementById("divFirstName").innerHTML="Name can contain only alphabets";
				i=1;
			}else{
				document.getElementById("divFirstName").innerHTML="";
			}

			if(fullName == "" || fullName == null){
				document.getElementById("divFullName").innerHTML="Please Fill Last Name";
				i=1;
			} 
			else if(!(/^[a-zA-Z\s]+$/.test(fullName))) {
				document.getElementById("divFullName").innerHTML="Name can contain only alphabets";
				i=1;
			}else{
				document.getElementById("divFullName").innerHTML="";
			}
			
			if(emailId == "" || emailId == null){
				document.getElementById("divEmailId").innerHTML="Please Fill Email";
				i=1;
			} 
			else if(!(/^[a-zA-Z0-9_\.-]+@[a-zA-Z0-9]+\.[a-zA-Z]+$/.test(emailId))) {
				document.getElementById("divEmailId").innerHTML="Not Valid email";
				i=1;
			}else{
				document.getElementById("divEmailId").innerHTML="";
			}

			
			if(age == "" || age == null){
				document.getElementById("divAge").innerHTML="Please Fill age";
				i=1;
			} else {
				parsedAge = parseInt(age);
				if(!(/^[0-9]+/.test(age))) {
			
					document.getElementById("divAge").innerHTML="Not Valid age";
					i=1;
				}
				else
				{
					if(parsedAge < 1 || parsedAge > 126) {
						document.getElementById("divAge").innerHTML="Be realistic. Dont Lie.";
						i=1;
					}else{
						document.getElementById("divAge").innerHTML="";
					}
				}
			}
			
		
			if(address == "" || address == null || address == undefined){
				document.getElementById("divAddress").innerHTML="Please Fill address";
				i=1;
			} 
			else if(!(/^[\d\w/:-,]+$/.test(address))) {
				document.getElementById("divAddress").innerHTML="Not Valid address";
				i=1;
			}else{
				document.getElementById("divAddress").innerHTML="";
			}
			
			if(i==1)
				return false;
			else
				return true;
}