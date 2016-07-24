/**
 * Main custom JS
 */

$(document).ready(function(){
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
    
});