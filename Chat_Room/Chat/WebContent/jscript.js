
function getNewXmlHttp(){
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


function active(){

  var xmlhttp = getNewXmlHttp();

  xmlhttp.onreadystatechange = function(){
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
		
      document.getElementById("auser").innerHTML=xmlhttp.responseText  ;
	  
	  
	  
      
    }  
  }

  xmlhttp.open("POST","ActiveUser",true);

	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");


  xmlhttp.send();
  
}
setInterval(active,1000);