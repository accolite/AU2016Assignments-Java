function validateForm(form) {

    var firstname = document.getElementById("firstname").value;
    if(firstname == "" || firstname == null){
        alert("Please Fill First Name");
        return false;
    } 
    if(!(/^[a-zA-Z]+$/.test(firstname))) {
        alert("Name can contain only alphabets");
        return false;
    }

    var lastname = document.getElementById("lastname").value;
    if(lastname == "" || lastname == null){
        alert("Please Fill Full Name");
        return false;
    } 
    if(!(/^[a-zA-Z\s]+$/.test(lastname))) {
        alert("Name can contain only alphabets");
        return false;
    }
    var emailid = document.getElementById("emailid").value;
    if(emailid == "" || emailid == null){
        alert("Please Fill Email");
        return false;
    } 
    if(!(/^[a-zA-Z0-9_\.-]+@[a-zA-Z0-9]+\.[a-zA-Z]+$/.test(emailid))) {
        alert("Not Valid email");
        return false;
    }

    var age = document.getElementById("age").value;
    if(age == "" || age == null){
        alert("Please Fill age");
        return false;
    } 
    if(!(/^[0-9]+/.test(age))) {
        alert("Not Valid age");
        return false;
    }
    parsedAge = parseInt(age)
    if(parsedAge < 1 || parsedAge > 126) {
        alert("Be realistic. Dont Lie.");
        return false;
    }
    
    var address = document.getElementById("address").value;
    if(address == "" || address == null || address == undefined){
        alert("Please Fill address");
        return false;
    } 
    if(!(/^[\d\w/:-,]+$/.test(address))) {
        alert("Not Valid address");
        return false;
    }



}
