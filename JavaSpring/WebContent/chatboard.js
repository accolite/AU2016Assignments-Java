
var xmlhttp;
var xmlhttpc;
var xmlhttpa;
   
    
callBack = function(){
	  chatboardCallBack();
}

chatboardCallBack = function(){
	if (xmlhttpc.readyState==4 && xmlhttpc.status==200){
		document.getElementById("chatboard").innerHTML = xmlhttpc.responseText;
    }
}
    
activeListCallBack = function(){
	if (xmlhttpa.readyState==4 && xmlhttpa.status==200){
		document.getElementById("activeusers").innerHTML = xmlhttpa.responseText;
    }
}







updateChatboard = function(){
	xmlhttpc = new XMLHttpRequest();
	xmlhttpc.open("GET","/ChatRoom/chats",true);
	xmlhttpc.onreadystatechange = chatboardCallBack;
	xmlhttpc.send();
}

updateActiveList = function(){
	xmlhttpa = new XMLHttpRequest();
	xmlhttpa.open("GET","/ChatRoom/Users",true);
	xmlhttpa.send();
	xmlhttpa.onreadystatechange = activeListCallBack;
}

sendMessage = function(){
	xmlhttp = new XMLHttpRequest();
	var msg = document.getElementById("message").value;
	if(msg.trim() !== ''){
		xmlhttp.open("GET","/ChatRoom/post?msg="+msg,true);
		xmlhttp.onreadystatechange = callBack;
		xmlhttp.send();
	}

}

setInterval(updateChatboard, 1000);
setInterval(updateActiveList, 1000);