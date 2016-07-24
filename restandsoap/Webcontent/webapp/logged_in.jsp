<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% session.setAttribute("username", request.getParameter("username"));
session.setAttribute("id", request.getParameter("id"));
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><% if(session.getAttribute("username")!=null)
out.println(session.getAttribute("username")); %> Logged in</title>

<script type="text/javascript" src="js/jquery-latest.min.js"></script>

</head>



<body <% if(session.getAttribute("username")!=null) %>data-id=<% out.println(session.getAttribute("id"));%>>
<% if(session.getAttribute("username")!=null){ %>
	<div id="actions" style="float:left">
		<div id="action1">
			<h3>New Post : </h3>
			<input type="text" id="newPost">
			<button id="newPostbtn">Post</button>
		</div>
		<div id="action2">
			<h3>All Posts by me: </h3>
			<button id="allPostbtn">Get all posts</button>
		</div>
		<div id="action3">
			<h3>Comment on particular post: </h3>
			<input type="text" id="commentOnPostId" placeholder="enter post id"><br/>
			<input type="text" id="commentAdd" placeholder="enter comment"><br/>
			<button id="commentOnPost">Comment</button>
		</div>
		<div id="action4">
			<h3>New Like on particular post: </h3>
			<input id="likeOnPostId" type="text" placeholder="Enter Post id">
			<button id="likeOnPost">Like post</button>
		</div>
		<div id="action5">
			<h3>View all comments on a particular message: </h3>
			<input type="text" id="postCommentsId" placeholder="Enter Post Id">
			<button id="getCommentsOnPost">Get Comments</button>
			
		</div>
		<div id="action6">
			<h3>View all likes on post</h3>
			<input type="text" id="postLikesId" placeholder="Enter Post Id">
			<button id="getLikesOnPost">Get Likes</button>
		</div>
		<div id="action7">
			<div>
				<h3>Delete my Post</h3>
				<input type="text" id="postIdDelete" placeholder="Enter Post Id">
				<button id="deletePost">Delete Post</button>
			</div>
			<div>
				<h3>Delete my Comment</h3>
				<input type="text" id="commentIdDelete" placeholder="Enter Comment Id">
				<button id="deleteComment">Delete Comment</button>
			</div>
			<div>
				<h3>Delete my Like</h3>
				<input type="text" id="likeIdDelete" placeholder="Enter Like Id">
				<button id="deleteLike">Delete Like</button>
			</div>
		</div>
		
		
		<div id="action8">
			<h3>To add a user as a friend : </h3>
			<input type="text" id="newFriendName" placeholder="Enter friend name">
			<button id="addFriend">Add friend</button>
		</div>
		
		<div id="action9">
			<h3>To delete a user as a friend : </h3>
			<input type="text" id="oldFriendName" placeholder="Enter friend name">
			<button id="deleteFriend">Delete friend</button>
		</div>
		
		<div id="action10">
			<h3>Show posts of friend : </h3>
			<input type="text" id="friendNamePosts" placeholder="Enter friend name">
			<button id="showFriendPosts">Show posts of friend</button>
		</div>
			
		
		<div id="action11">
			<h3>Show friends of friend : </h3>
			<input type="text" id="friendNameFriends" placeholder="Enter friend name">
			<button id="showFriendFriends">Show Friends of friend</button>
		</div>
		
	</div>
	<div id="responseDiv" style="float:left">
		
	</div>
	<% } else{
		out.println("Invalid user session");	
	}%>
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>