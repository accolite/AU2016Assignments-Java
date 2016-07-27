var xmlhttp;
var xmlhttpc;
var xmlhttpa;
if (window.XMLHttpRequest)
{
  xmlhttp=new XMLHttpRequest();
}
else
{
 xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
}
if (window.XMLHttpRequest)
{
  xmlhttpc=new XMLHttpRequest();
}
else
{
 xmlhttpc=new ActiveXObject("Microsoft.XMLHTTP");
}
if (window.XMLHttpRequest)
{
  xmlhttpa=new XMLHttpRequest();
}
else
{
 xmlhttpa=new ActiveXObject("Microsoft.XMLHTTP");
}
    
callBack = function(){
   chatboardCallBack();
}

chatboardCallBack = function(){
 if (xmlhttpc.readyState==4 && xmlhttpc.status==200){
  document.getElementById("msg").innerHTML = xmlhttpc.responseText;
    }
}
    
activeListCallBack = function(){
 if (xmlhttpa.readyState==4 && xmlhttpa.status==200){
  document.getElementById("usr").innerHTML = xmlhttpa.responseText;
    }
}

updateChatboard = function(){
 xmlhttpc = new XMLHttpRequest();
 xmlhttpc.open("GET","http://localhost:8082/ChatApp/Chat",true);
 xmlhttpc.onreadystatechange = chatboardCallBack;
 xmlhttpc.send();
}

updateActiveList = function(){
 xmlhttpa = new XMLHttpRequest();
 xmlhttpa.open("GET","http://localhost:8082/ChatApp/Users",true);
 xmlhttpa.send();
 xmlhttpa.onreadystatechange = activeListCallBack;
}

sendMessage = function(){
 xmlhttp = new XMLHttpRequest();
 var msg = document.getElementById("msgbox").value;
 if(msg.trim() !== ''){
 // xmlhttp.open("GET","Chat",true);
  xmlhttp.open("POST","http://localhost:8082/ChatApp/Chat?msg="+msg,true);
  xmlhttp.onreadystatechange = callBack;
  //xmlhttp.send("msg=" + msg);
  xmlhttp.send();
 }

}

setInterval(updateChatboard, 1000);
setInterval(updateActiveList, 1000);