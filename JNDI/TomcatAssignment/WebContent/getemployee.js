
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


function employees(){

  var xmlhttp = getNewXmlHttp1();

  xmlhttp.onreadystatechange = function(){
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
		
      document.getElementById("iemp").innerHTML=xmlhttp.responseText  ;
	  
	  
	  
      
    }  
  }

  xmlhttp.open("POST","emp",true);

	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");


  xmlhttp.send();
  
}
/**
 * 
 */