/**
 * Main custom JS
 */

$(document).ready(function(){
	
	/**
	 * Login
	 * input: username
	 * Output: successful login - logged_in with session
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
     * Action 1- New Post
     * input: post string and id of requesting user
     * output: successful - content of post
     * output: unsuccessful - status
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

    

    $("#newPostbtn").click(function(){
        		var post_content=$("#newPost").val().toString();
        		var user_id = $("body").attr("data-id").toString();
        
        		$.post("NewPost", {"user_id" : user_id, "post_content" : post_content}, 
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
     * Action 2- All posts by user
     * input_param: user id of requesting user
     * output: successful - list of users
     * output: unsuccessful - status
     */
    window.setInterval(function(){
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
    					$('#allPosts').append("<div>"+v["user_name"]+":"+v["post_content"]+"</div>");
    				});
    			}
    },"json");
    }, 3000);
   
    /**
     * Action 11 - Show friends of friends
     * input: username of friend
     * output: successful - Friends of friends
     * output: unsuccessful - status
     */
    window.setInterval(function(){
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
    					$('#activeUsers').append("<div>"+v["user_name"]+"</div>");
    				});
    			}
    },"json");
    }, 3000);
    
});