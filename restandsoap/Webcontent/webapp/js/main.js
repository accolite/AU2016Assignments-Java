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
        var txt = $("#username").val();
        $.ajax({
        	contentType:"text/plain", 
        	data:txt, 
        	dataType:"text",
        	url:"webapi/login", 
        	type:"POST", 
        	async:true, 
        	success: function(result){
               $('#error').html(result);

               if(result=="emptyNotAccepted"){}
               else if(result=="invalid"){}
               
               else location.href = "logged_in.jsp?username="+txt+"&id="+result;
        	}
        });
    });
    
    /**
     * Register
	 * input: username
	 * Output: successful login - logged_in with session
	 * Output: unsuccessful login - invalid/empty/already registered error
     */
    $("#registerbtn").click(function(){
        var txt = $("#username").val();
        $.ajax({
        	contentType:"text/plain", 
        	data:txt, 
        	dataType:"text",
        	url:"webapi/register", 
        	type:"POST", 
        	async:true, 
        	success: function(result){
               $('#error').html(result);
               if(result=="emptyNotAccepted"){}
               else if(result=="invalid"){}
               else if(result=="alreadyRegistered"){}
               else location.href = "logged_in.jsp?username="+txt+"&id="+result;
        	}
        });
    });
    
    /**
     * Action 1- New Post
     * input: post string and id of requesting user
     * output: successful - content of post
     * output: unsuccessful - status
     */
    $("#newPostbtn").click(function(){
        var post = { 
        		"post_content":$("#newPost").val().toString(),
        		"user_id":$("body").attr("data-id").toString()
        }
        
        alert(post.user_id)
        $.ajax({
        	contentType:"application/json", 
        	data:JSON.stringify(post), 
        	dataType:"json",
        	url:"webapi/newPost", 
        	type:"POST", 
        	async:true, 
        	success: function(result){
               $('#responseDiv').html(result.post_content);
        	}
        });
    });
    
    /**
     * Action 2- All posts by user
     * input_param: user id of requesting user
     * output: successful - list of users
     * output: unsuccessful - status
     */
    $("#allPostbtn").click(function(){
        user = {
        		"user_id" : $("body").attr("data-id").toString()
        }
        $.ajax({ 
        	dataType:"json",
        	url:"webapi/allPosts/"+$("body").attr("data-id").toString(), 
        	type:"GET", 
        	async:true, 
        	success: function(result){
    			$('#responseDiv').html("");
        		for(i=0;i<result.length;i++){
        			$('#responseDiv').append(result[i].post_content+"<br>");
        		}
        	}
        });
    });
    
    /**
     * Action 3 - Comment on post
     * input: id of post
     * output: successful - comment added
     * output: unsuccessful - status
     */
    $("#commentOnPost").click(function(){
        var comment = { 
        		"post_id":$("#commentOnPostId").val().toString(),
        		"user_id":$("body").attr("data-id").toString(),
        		"comment":$("#commentAdd").val().toString()
        }
        
        $.ajax({
        	contentType:"application/json", 
        	data:JSON.stringify(comment), 
        	dataType:"json",
        	url:"webapi/addComments", 
        	type:"POST", 
        	async:true, 
        	success: function(result){
               $('#responseDiv').html(result.comment);
        	}
        });
    });
    
    /**
     * Action 4 - Like on Post 
     * input: id of post
     * output: successful - like added
     * output: unsuccessful - status by id value
     */
    $("#likeOnPost").click(function(){
        var like = { 
        		"post_id":$("#likeOnPostId").val().toString(),
        		"user_id":$("body").attr("data-id").toString()
        }
        
        $.ajax({
        	contentType:"application/json", 
        	data:JSON.stringify(like), 
        	dataType:"json",
        	url:"webapi/addLikes", 
        	type:"POST", 
        	async:true, 
        	success: function(result){
        		if(result.like_id == -3)
        			$('#responseDiv').html("Invalid request");
        		else if(result.like_id == -2)
        			$('#responseDiv').html("Not a friend");
        		else if(result.like_id == -1)
        			$('#responseDiv').html(" You have already liked this post "+result.post_id);
        		else
        			$('#responseDiv').html(" You liked this post "+result.post_id);
        		
        	}
        		
        });
    });
    
    /**
     * Action 5 - Get all comments on post
     * input: id of comment
     * output: successful - all comments on post
     * output: unsuccessful - status
     */
    $("#getCommentsOnPost").click(function(){
        $.ajax({ 
        	dataType:"json",
        	url:"webapi/allComments/"+$("#postCommentsId").val().toString(), 
        	type:"GET", 
        	async:true, 
        	success: function(result){
    			$('#responseDiv').html("");
        		for(i=0;i<result.length;i++){
        			$('#responseDiv').append(result[i].comment+"<br>");
        		}
        	}
        });
    });
    
    /**
     * Action 6 -  Get all likes on post
     * input: id of likes
     * output: successful - all likes on post
     * output: unsuccessful - status
     */
    $("#getLikesOnPost").click(function(){
        $.ajax({ 
        	dataType:"json",
        	url:"webapi/allLikes/"+$("#postLikesId").val().toString(), 
        	type:"GET", 
        	async:true, 
        	success: function(result){
        		if(result[0].like_id == -2)
        			$('#responseDiv').html("Invalid request");
        		else if(result[0].like_id == -1)
        			$('#responseDiv').html("No likes to show");
        		else{
        			$('#responseDiv').html("");
        			for(i=0;i<result.length;i++)
        				$('#responseDiv').append(result[i].user_id+ " has liked this<br>");
        		}
        	}
        });
    });
    
    /**
     * Action 7i - Delete a post
     * input_params: post id and requesting user user_id
     * output: successful - post deleted
     * output: unsuccessful - status
     */
    $("#deletePost").click(function(){
        $.ajax({ 
        	dataType:"json",
        	url:"webapi/delete/deletePost/"+$("body").attr("data-id").toString()+"/"+$("#postIdDelete").val().toString(),
        	type:"DELETE", 
        	async:true, 
        	success: function(result){
        			$('#responseDiv').html(result.post_content);
        	}
        });
    });
    
    /**
     * Action 7ii - Delete a comment
     * input_params: comment id and requesting user user_id
     * output: successful - comment deleted
     * output: unsuccessful - status
     */
    $("#deleteComment").click(function(){
        $.ajax({ 
        	dataType:"json",
        	url:"webapi/delete/deleteComment/"+$("body").attr("data-id").toString()+"/"+$("#commentIdDelete").val().toString(),
        	type:"DELETE", 
        	async:true, 
        	success: function(result){
        			$('#responseDiv').html(result.comment);
        	}
        });
    });
    
    /**
     * Action 7iii - Delete a like
     * input_params: like id and requesting user user_id
     * output: successful - like deleted
     * output: unsuccessful - status by id
     */
    $("#deleteLike").click(function(){
        $.ajax({ 
        	dataType:"json",
        	url:"webapi/delete/deleteLike/"+$("body").attr("data-id").toString()+"/"+$("#likeIdDelete").val().toString(),
        	type:"DELETE", 
        	async:true, 
        	success: function(result){
        			if(result.like_id == -1)
        				$('#responseDiv').html("Like not available to you");
        			else if(result.like_id == -2)
        				$('#responseDiv').html("Invalid session");
        			else if(result.like_id == -3)
        				$('#responseDiv').html("Invalid request");
        			else
        				$('#responseDiv').html(result.like_id+" was deleted");
        			
        	}
        });
    });
    
    /**
     * Action 8 - Add a friend
     * input: username of friend
     * output: successful - user was added as friend
     * output: unsuccessful - status
     */
    $("#addFriend").click(function(){
        var user = {
        		"user_id" : $("body").attr("data-id").toString()
        }
        
        $.ajax({
        	contentType:"application/json", 
        	data:JSON.stringify(user), 
        	dataType:"json",
        	url:"webapi/addFriend/"+$("#newFriendName").val().toString(), 
        	type:"POST", 
        	async:true, 
        	success: function(result){
               $('#responseDiv').html(result.name);
        	}
        });
    });
    
    /**
     * Action 9 - Remove a friend
     * input: username of friend
     * output: successful - user was removed as friend
     * output: unsuccessful - status
     */
    $("#deleteFriend").click(function(){
        $.ajax({ 
        	dataType:"json",
        	url:"webapi/delete/deleteFriend/"+$("body").attr("data-id").toString()+"/"+$("#oldFriendName").val().toString(),
        	type:"DELETE", 
        	async:true, 
        	success: function(result){
        			$('#responseDiv').html(result.name);
        			
        	}
        });
    });
    
    /**
     * Action 10 - show Posts of friend
     * input: username of friend
     * output: successful - Posts of friend
     * output: unsuccessful - status
     */
    $("#showFriendPosts").click(function(){
        
        $.ajax({ 
        	dataType:"json",
        	url:"webapi/allPosts/"+$("body").attr("data-id").toString()+"/"+$("#friendNamePosts").val().toString(), 
        	type:"GET", 
        	async:true, 
        	success: function(result){
    			$('#responseDiv').html("");
        		for(i=0;i<result.length;i++){
        			$('#responseDiv').append(result[i].post_content+"<br>");
        		}
        	}
        });
    });
    
    /**
     * Action 11 - Show friends of friends
     * input: username of friend
     * output: successful - Friends of friends
     * output: unsuccessful - status
     */
    $("#showFriendFriends").click(function(){
        
        $.ajax({ 
        	dataType:"json",
        	url:"webapi/allFriends/"+$("body").attr("data-id").toString()+"/"+$("#friendNameFriends").val().toString(), 
        	type:"GET", 
        	async:true, 
        	success: function(result){
    			$('#responseDiv').html("");
        		for(i=0;i<result.length;i++){
        			$('#responseDiv').append(result[i].name+"<br>");
        		}
        	}
        });
    });
    
});