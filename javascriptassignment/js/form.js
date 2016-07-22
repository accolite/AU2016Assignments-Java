function formValidate(){
	var firstName=document.getElementsByName("firstName")[0].value;
	if(firstName.search(/[^a-z]/i)>-1){
		alert("First Name should not contain numbers, spaces, special characters. It should only contain alphabets.")
		return;
	}	
	var fullName=document.getElementsByName("fullName")[0].value;
	if(fullName.search(/[^\sa-z]/i)>-1){
		alert("Full Name should only contain alphabets. Spaces are allowed.");
		return;
	}
	var emailId=document.getElementsByName("email")[0].value;
	if(emailId.search(/[\s]/)>-1){
		alert("Email Id cannot contain spaces.");
		return;
	}
	var address=document.getElementsByTagName("textarea")[0].value;
	if(address.search(/[^-\s/:,a-z0-9]/i)>-1){
		alert("Address, except '/', ':', '-', ',', no other special character should be allowed. Spaces are allowed.");
		return;
	}
	var gender=document.getElementsByName("gender")[0].value;
	if(gender!="male"&&gender!="female"&&gender!="others"){
		alert("Gender Should only accept 'male', 'female' or 'others' as values.");
		return;
	}
	var age=document.getElementsByName("age")[0].value;
	if(age<1||age==Infinity){
		alert("Age only Positive Finite Numbers allowed.");
		return;
	}
	document.getElementsByTagName("form")[0].submit();
}