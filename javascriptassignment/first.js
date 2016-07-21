

function validate() {
	var c1 = validateFirstName();
	if(!c1)
		alert("First name can have only characters with no spaces");
	
	var c2 = validateLastName();
	if(!c2)
		alert("Last Name name can have only characters with no spaces");
	
	var c3 = validateFullName();
	if(!c3)
		alert("Full name can have only characters");
	
	var c4 = validateAddress();
	if(!c4)
		alert("Address must be proper");
	
	var c5 = validateAge();
	if(!c5)
		alert("Age must be a positive Integral Number");
	
	var c6 = validateEmail();
	if(!c6)
		alert("Not a proper email")

}

/*Only characters without space*/
function validateFirstName() {
	var reg = new RegExp("^[a-zA-Z]+$", "i");
	return reg.test(document.getElementById('firstName').value);
}

/*Only characters without space*/
function validateLastName() {
	var reg = new RegExp("^[a-zA-Z]+$", "i");
	return reg.test(document.getElementById('lastName').value);
}

/*Only characters with space*/
function validateFullName() {
	var reg = new RegExp("^[a-zA-Z ]+$", "i");
	return reg.test(document.getElementById('fullName').value);
}


/*Any character or numbers with -,:/ and space*/
function validateAddress(){
	var reg = new RegExp("^[a-zA-Z0-9\-:,\/ ]+$");
	return reg.test(document.getElementById('address').value);
}

/*A number and positive and reasonable*/
function validateAge(){
	var reg = new RegExp("^[0-9]+$");
	var age = document.getElementById('age').value;
	return age>0 && age<400 && reg.test(age);
}

/*Regexp from emailregex*/
function validateEmail(){
	var reg = new RegExp("^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$","i");
	return reg.test(document.getElementById('email').value);
}