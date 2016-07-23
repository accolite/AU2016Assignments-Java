<!DOCTYPE>
<html>
<body>
<script>
function myFunction(choice) {
	
	 var xhttp;
	 var json;
 if (window.XMLHttpRequest) {
   // code for modern browsers
   xhttp = new XMLHttpRequest();
   } else {
   // code for IE6, IE5
   xhttp = new ActiveXObject("Microsoft.XMLHTTP");
 }
 xhttp.onreadystatechange = function() {
	 //alert(xhttp.status+"");
   if (xhttp.readyState == 4 && xhttp.status == 200) {
	  //json=JSON.parse(xhttp.responseText);
	  //alert("hi");
	  document.getElementById("did").innerHTML=xhttp.responseText+"";
	  //document.getElementById("ims").src=json.src;
	  /*
	  if(lr=='getallmessages'){
		  
	  document.getElementById("did").innerHTML = "getallmcalled";//"Source="+json.src+"</br>Description="+json.desc+"</br>Link="+json.link+"</br>Details="+json.det;
	  
	  }
	  else{
	  document.getElementById("demo").innerHTML = xhttp.responseText;
	  }
	  */
	  //alert("hi");
	  
   }
	
 };
	if(choice==="getallmessages"){
	xhttp.open("GET", "http://localhost:8082/messanger/webapi/messages/getallmessages", true);
	
	xhttp.send();
	}
	
	if(choice=="getcommentsbyid"){
		xhttp.open("GET", "http://localhost:8082/messanger/webapi/messages/getcomments/"+document.getElementById("msgid").value, true);
		
		xhttp.send();
	}
	if(choice=="addlikebyid"){
		xhttp.open("GET", "http://localhost:8082/messanger/webapi/messages/getlikes/"+document.getElementById("msgidl").value, true);
		
		xhttp.send();
	}
	if(choice=="addmessages"){
		alert("hi");
		xhttp.open("GET", "http://localhost:8082/messanger/webapi/messages/addmessage?id="+document.getElementById("msgmai").value+"&content="+document.getElementById("msgmam").value+"&owner="+document.getElementById("msgmao").value, true);
		console.log("http://localhost:8082/messanger/webapi/messages/addmessage?id="+document.getElementById("msgmai").value+"&content="+document.getElementById("msgmam").value+"&owner="+document.getElementById("msgmao").value+"");
		xhttp.send();
		
	}
	if(choice=="addlikes"){
		xhttp.open("GET", "http://localhost:8082/messanger/webapi/messages/addlikebyid?id="+document.getElementById("lkmi").value+"&owner="+document.getElementById("lko").value, true);
		xhttp.send();
	}
	if(choice="addcomment"){
		xhttp.open("GET", "http://localhost:8082/messanger/webapi/messages/addcommentbyid?id="+document.getElementById("acmi").value+"&content="+document.getElementById("acc").value+"&owner="+document.getElementById("aco").value, true);
		xhttp.send();
	}
	/*
	if(lr=="left"){
	if(num>1){
	num--;
	}
	else{
	num=5;
	}
	xhttp.open("GET", num+".txt", true);
	xhttp.send();
	}
	if(lr=='desc'){
	xhttp.open("GET", num+".txt", true);
	xhttp.send();
	}
	*/
}
</script>
</body>
<body>
<table style="width:100%" cell-padding="20">
<tr>
<td style="width:50%;vertical-align: text-top" >
<table style="width:100%">
<tr>
<td colspan=2 style="width:100%;vertical-align: text-top" align="center"  >
<button onclick="myFunction('getallmessages')" >Get All Messages</button>
</td>
</tr>
  <tr>
    <td style="width:50%">
Message id for comment: 
</td>
<td style="width:50%">
<input type="text" id="msgid">
</td>
  </tr>
  <tr>
  <td colspan=2 style="width:100%;vertical-align: text-top" align="center"  >
<button onclick="myFunction('getcommentsbyid')" >Get Comments</button>
</td>
</tr>
<tr>
    <td style="width:50%">
Message id: 
</td>
<td style="width:50%">
<input type="text" id="msgmai">
</td>
<td>
Message:
</td>
<td style="width:50%">
<input type="text" id="msgmam">
</td>

  </tr>
  </td>
<td>
Message owner:
</td>
<td style="width:50%">
<input type="text" id="msgmao">
</td>

  </tr>
  </td>
<td>
  </tr>
  <tr>
  <td colspan=2 style="width:100%;vertical-align: text-top" align="center"  >
<button onclick="myFunction('addmessages')" >Add Messages</button>
</td>
</tr>
<tr>
    <td style="width:50%">
Message id for likes: 
</td>
<td style="width:50%">
<input type="text" id="msgidl">
</td>
  </tr>
  <tr>
  <td colspan=2 style="width:100%;vertical-align: text-top" align="center"  >
<button onclick="myFunction('getlikesbyid')" >Get likes</button>
</td>
</tr>
<tr>
    <td style="width:50%">
Message id: 
</td>
<td style="width:50%">
<input type="text" id="lkmi">
</td>
<tr>
    <td style="width:50%">
like owner: 
</td>
<td style="width:50%">
<input type="text" id="lko">
</td>
  </tr>
  </tr>
  <tr>
  <td colspan=2 style="width:100%;vertical-align: text-top" align="center"  >
<button onclick="myFunction('addlikebyid')" >Add like</button>
</td>
</tr>
<tr>
    <td style="width:50%">
Message id: 
</td>
<td style="width:50%">
<input type="text" id="acmi">
</td>
<td>
Comment:
</td>
<td style="width:50%">
<input type="text" id="acc">
</td>

  </tr>
  </td>
<td>
Message owner:
</td>
<td style="width:50%">
<input type="text" id="aco">
</td>

  </tr>
  </td>
<td>
  </tr>
  <tr>
  <td colspan=2 style="width:100%;vertical-align: text-top" align="center"  >
<button onclick="myFunction('addmessages')" >Add Messages</button>
</td>
</tr>
</table>
</td>
<td style="width:50%">
<table style="width:100%">
  <div id="did">
</div>
  </tr>
</td>
</tr>

</table>
</body>
</html>

