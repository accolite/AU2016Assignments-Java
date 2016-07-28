
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
  


employeeCallBack = function(){
	if (xmlhttpc.readyState==4 && xmlhttpc.status==200){
		document.getElementById("empDetail").innerHTML = xmlhttpc.responseText;
    }
}




/*
updateActiveList = function(){
	xmlhttpa = new XMLHttpRequest();
	xmlhttpa.open("GET","/ChatBoard/activelist",true);
	xmlhttpa.send();
	xmlhttpa.onreadystatechange = activeListCallBack;
}

sendMessage = function(){
	xmlhttp = new XMLHttpRequest();
	var msg = document.getElementById("message").value;
	if(msg.trim() !== ''){
		xmlhttp.open("GET","/ChatBoard/post?msg="+msg,true);
		xmlhttp.onreadystatechange = callBack;
		xmlhttp.send();
	}

}
*/


updateEmployeeDetail = function(){
	xmlhttpc = new XMLHttpRequest();
	xmlhttpc.open("GET","/TomcatAssignment/employee",true);
	xmlhttpc.onreadystatechange = employeeCallBack;
	xmlhttpc.send();
}



updateChatboard = function(){
	xmlhttpc = new XMLHttpRequest();
	xmlhttpc.open("GET","/TomcatAssignment/manager",true);
	xmlhttpc.onreadystatechange = chatboardCallBack;
	xmlhttpc.send();
}


sendMessage = function(){
	xmlhttp = new XMLHttpRequest();
	var msg = document.getElementById("message").value;
	if(msg.trim() !== ''){
		xmlhttp.open("GET","/ChatBoard/post?msg="+msg,true);
		xmlhttp.onreadystatechange = callBack;
		xmlhttp.send();
	}

}

