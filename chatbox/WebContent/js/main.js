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
    $("#submitbtn").click(function(){
        var u_name = $("#username").val();
        var pwd = $("#password").val();
        $.post("Login", {"username" : u_name, "password" : pwd}, 
        		function(data){
        			if(data.status == "true"){
        				location.href="logged_in.jsp";
        			}else if(data.status == "admin"){
        				location.href="admin.jsp";
        			}
        			else{
        				$('#error').html(data.content)
        			}
        },"json");
    });
    
    /**
     * Register
	 * input: username
	 * input: password
	 * Output: successful login - logged_in with session
	 * Output: unsuccessful login - invalid/empty/already registered error
     */
    $("#registerbtn").click(function(){
        
    	var u_name = $("#username").val();
        var pwd = $("#password").val();
        $.post("Register", {"username" : u_name, "password" : pwd}, 
        		function(data){
        			if(data.status == "true"){
        				location.href="logged_in.jsp";
        			}
        			else{
        				$('#error').html(data.content)
        			}
        },"json");
    	
    });
    
    /**
     * Logout
     * input: click on logout
     * output: Successful - session invalidated and sent to index
     * output: unsuccessful - if session was invalidated before logout. Refresh to see login
     */
    
    $("#logout").click(function(){
		var user_id = $("body").attr("data-id").toString();

		$.post("Logout", {"user_id" : user_id}, 
        		function(data){
        			if(data.status == "true"){
        				location.href="index.jsp";
        			}
        			else{
        				alert(data.content);
        			}
        },"json");
});

    /**
     * New Post
     * input: post string and id of requesting user
     * output: successful - content of post
     * output: unsuccessful - status
     */
    

    $("#newPostbtn").click(function(){
        		var post_content=$("#newPost").val().toString();
        		var user_id = $("body").attr("data-id").toString();
        
        		$.post("NewPost", {"user_id" : user_id, "post_content" : post_content}, 
                		function(data){
                			if(data.status == "true"){
                				alert(data.post_content+ " added");
                			}
                			else{
                				$.each(data, function(k, v) {
                					alert(v);
                				});
                			}
                },"json");
    });
    
    /**
     * All Posts
     * input: none
     * output: all posts and log in/log outs of current server session
     */
    function allPOSTS(){
	    var user_id = $("body").attr("data-id").toString();

			$.get("AllPosts", {"user_id" : user_id}, 
	    		function(data){
	    			if(data["-1"]!=null){
	    				$('#allPosts').html(data["-1"]["post_contents"]);
	    			}else if(data["-2"]!=null){
	    				$('#allPosts').html(data["-2"]["post_contents"]);
	    			}else if(data["-3"]!=null){
	    				$('#allPosts').html(data["-3"]["post_contents"]);
	    			}else{
	    				$('#allPosts').html("");
	    				$.each(data, function(k, v) {
	    				    //display the key and value pair
	    					if(v["removed"]!=null) $('#allPosts').append(v["removed"]);
	    					else if(v["added"]!=null) $('#allPosts').append(v["added"]);
	    					else $('#allPosts').append("<div style='float:clear'>"+v["user_name"]
	    					+"<div><div style='float:left'>"+v["post_content"]
	    					+"</div><div style='float:right'>"+v["time_posted"]
	    					+"</div></div></div><br/>");
	    				});
	    			}
	    },"json");
	}
    
    /**
     * Active users
     * Current active users at service
     */
    function activeUSERS(){
    	var user_id = $("body").attr("data-id").toString();

		$.get("AllUsers", {"user_id" : user_id}, 
    		function(data){
    			if(data["-1"]!=null){
    				$('#activeUsers').html(data.response);
    			}else if(data["-2"]!=null){
    				$('#activeUsers').html(data.response);
    			}else if(data["-3"]!=null){
    				$('#activeUsers').html(data.response);
    			}else{
    				$('#activeUsers').html("");
    				$.each(data, function(k, v) {
    				    //display the key and value pair
    					$('#activeUsers').append("<div>"+v+"</div>");
    				});
    			}
    },"json");
    
    }
    /**
     * Call every 2 seconds to update details
     */
    window.setInterval(allPOSTS, 2000);
    window.setInterval(activeUSERS, 2000);
   
    
});