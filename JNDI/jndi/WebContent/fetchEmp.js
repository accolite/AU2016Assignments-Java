/**
 * 
 */

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


function getEmployees(){

  var xmlhttp = getNewXmlHttp();

  xmlhttp.onreadystatechange = function(){
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
  
      document.getElementById("01").innerHTML=xmlhttp.responseText  ;
    }  
  }

  xmlhttp.open("POST","FetchAllEmp",true);

 xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");


  xmlhttp.send();
  
}
/**
 * 
 */