$(document).ready(function(){

	$("#sendbutton").click(function(){

		var x = { username:$("#userbox").val(),	msg:$("#msgbox").val() }

		$.ajax({
		    url: 'doChat',
		    type: 'POST',
		    data: x,
		    async: false,
		    success: function(data) {
		        $("#msg").html(data);
		    }
		});
		$("#msgbox").val("");
	});

	var msgpoll = function(){
		$.get( "doChat", function( data ) {
			$("#msg").html(data);
		});
	}
	

	var usrpoll = function(){
		$.get( "fetchUser", function( data ) {
			$("#usr").html(data);
		});
	}
	setInterval(msgpoll, 2000);
	setInterval(usrpoll, 2000);
});