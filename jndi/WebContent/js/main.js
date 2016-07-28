/**
 * Main custom JS
 */

$(document).ready(function(){
	
	/**
	 * Login
	 * input: username
	 * input: password
	 * Output: successful login - logged_in with session
	 * Output: successful admin login - logged_in with admin session
	 * Output: unsuccessful login - invalid/empty error
	 */
    $("#login").click(function(){

        $.post("Login", {}, 
        		function(data){
        			$('#bodyLogin').html("");
        			$('#bodyLogin').append('<div id="response"></div>');
        			$.each(data, function(k, v) {
        				if(k=="-25"){
        					$.each(v, function(key, value) {
            					$('#response').append("<h1>"+key+":"+value+"</h1><br/>");
            					if(key=="MANAGER"){

            	        			$('#response').append("<div> <input id='name' type='text' placeholder='Enter name'/><br/>");
            	        			$('#response').append("<input id='email' placeholder='Enter email' type='email'/><br/>");
            	        			$('#response').append("<input id='age' type='number' placeholder='Age'/><br/>");
            	        			$('#response').append("<input id='designation' placeholder='Designation' type='text'/><br/>");
            	        			$('#response').append("<button id='addEmployee'>Add</button>");
            	        			$('#response').append("<script type='text/javascript' src='js/main.js'></script>");
            	        			$('#response').append("</div>");
            					}
            				});
        				}
        				else{
        					$('#response').append("<div>");
	        				$.each(v, function(key, value) {
	        					$('#response').append("<b>"+key+"</b>:"+value+"<br/>");
	        				});
	        				$('#response').append("<br/></div>");
        				}
        			});
        			
        },"json");
    });
    
    $("#addEmployee").click(function(e){
    	e.preventDefault();
    	var name = $('#name').val().trim();
    	var email = $('#email').val().trim();
    	var age = $('#age').val();
    	var designation = $('#designation').val().trim();
    	
        $.post("Add", {name: name, email:email, age:age, designation:designation}, 
        		function(data){
        			alert(data.status);
    	});
    });
    
    
});