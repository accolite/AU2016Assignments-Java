
var xmlhttp;
var xmlhttpc;
var xmlhttpa;
   
    
callBack = function(){
	  chatboardCallBack();
}

chatboardCallBack = function(){
	if (xmlhttpc.readyState==4 && xmlhttpc.status==200){
		document.getElementById("chatboard").innerHTML = xmlhttpc.responseText.substring(1, xmlhttpc.responseText.length-1);
    }
	else if(xmlhttpc.status==500){
		window.location.href = "/ChatBoardSpring";
	}
}
    
activeListCallBack = function(){
	if (xmlhttpa.readyState==4 && xmlhttpa.status==200){
		console.log("afasdf");
		document.getElementById("activeusers").innerHTML = xmlhttpa.responseText.substring(1, xmlhttpa.responseText.length-1);
    }
}

updateChatboard = function(){
	xmlhttpc = new XMLHttpRequest();
	xmlhttpc.open("GET","/ChatBoardSpring/app/chats",true);
	xmlhttpc.onreadystatechange = chatboardCallBack;
	xmlhttpc.send();
}

updateActiveList = function(){
	xmlhttpa = new XMLHttpRequest();
	xmlhttpa.open("GET","/ChatBoardSpring/app/activelist",true);
	xmlhttpa.send();
	xmlhttpa.onreadystatechange = activeListCallBack;
}

sendMessage = function(){
	xmlhttp = new XMLHttpRequest();
	var msg = document.getElementById("message").value;
	document.getElementById("message").value = "";
	if(msg.trim() !== ''){
		xmlhttp.open("GET","/ChatBoardSpring/app/post?msg="+msg,true);
		xmlhttp.onreadystatechange = callBack;
		xmlhttp.send();
	}

}

setInterval(updateChatboard, 1000);
setInterval(updateActiveList, 1000);