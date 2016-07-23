$(document).ready(function(){

	$("#getMessagesButton").click(function(){

		$.get( "webapi/messages", function( data ) {

			var msgs = "";
			for (var i = 0; i < data.length; i++) {

				msgs += data[i].body + "--- by user id " + data[i].author + "<br>";
			}
			$( "#result" ).html(msgs);
		});

	});
	
	
	$("#viewLikesButton").click(function(){

		var mid = $("#likemsgview").val();
		$.get( "webapi/messages/" + mid + "/likes", function( data ) {

			var msgs = "";
			for (var i = 0; i < data.length; i++) {

				msgs += data[i].userId + "<br>";
			}
			$( "#result" ).html(msgs);
		});

	});
	
	$("#viewCommentsButton").click(function(){

		var mid = $("#commentmsgview").val();
		$.get( "webapi/messages/" + mid + "/comments", function( data ) {

			var msgs = "";
			for (var i = 0; i < data.length; i++) {

				msgs += data[i].userId + ":" + data[i].body +"<br>";
			}
			$( "#result" ).html(msgs);
		});

	});

	populate = function() {
		var userOptions = "";
		$.get( "webapi/users", function( data ) {
	
			for (var i = 0; i < data.length; i++) {
	
				userOptions += "<option value='"+ data[i].id +"'>" + data[i].name + "</option>";
			}
			console.log(userOptions);
			$(".userSelect").html(userOptions);
		});
		
		var msgOptions = "";
		$.get( "webapi/messages", function( data ) {
	
			for (var i = 0; i < data.length; i++) {
	
				msgOptions += "<option value='"+ data[i].id +"'>" + data[i].body + "</option>";
			}
			$(".msgSelect").html(msgOptions);
	
		});
	}
	
	$("#addMessagesButton").click(function(){
		var obj = { author : $("#useridmsg").val() , body : $("#bodymsg").val() };

		$.ajax({
		    url: 'webapi/messages',
		    type: 'POST',
		    data: JSON.stringify(obj),
		    contentType: 'application/json; charset=utf-8',
		    dataType: 'json',
		    async: false,
		    success: function(data) {
		        $("#result").html("Created with ID " + data.id +":" + data.body );
		    }
		});
		populate();

	});

	$("#addCommentsButton").click(function(){
		var obj = { userId : $("#useridcmt").val() , body : $("#addcommenttb").val() , msgId : $("#addCommentselect").val()};

		$.ajax({
		    url: 'webapi/messages/' + $("#addCommentselect").val() + '/comments',
		    type: 'POST',
		    data: JSON.stringify(obj),
		    contentType: 'application/json; charset=utf-8',
		    dataType: 'json',
		    async: false,
		    success: function(data) {
		        $("#result").html("Created with ID " + data.id +":" + data.body );
		    }
		});
		populate();

	});

		$("#addLikeButton").click(function(){
		var obj = { userId : $("#useridlk").val() , msgId : $("#addlikeselect").val()};

		$.ajax({
		    url: 'webapi/messages/' + $("#addlikeselect").val() + '/likes',
		    type: 'POST',
		    data: JSON.stringify(obj),
		    contentType: 'application/json; charset=utf-8',
		    dataType: 'json',
		    async: false,
		    success: function(data) {
		        $("#result").html("Created with ID " + data.id);
		    }
		});
		populate();

	});
	populate();

});