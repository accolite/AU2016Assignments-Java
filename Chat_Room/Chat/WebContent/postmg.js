
function getNewXmlHttp1(){
var xmlhttp;
if (window.XMLHttpRequest)
  {
  xmlhttp=new XMLHttpRequest();
  }
else
  {
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
  return xmlhttp;
}


function postmessages(){

  var xmlhttp = getNewXmlHttp1();
  var message=document.getElementById("umsg").value;
  

  xmlhttp.open("POST","Postmsg",true);

	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	
	var queryParams ="umsg=" + message; 

  xmlhttp.send(queryParams);
  
}

/**
 * 
 *//**
 * 
 */