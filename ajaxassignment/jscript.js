
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
var counter1 = 0;
function doAjax(obj){

  var xmlhttp = getNewXmlHttp();

  var operation = obj.id;
 
  if(operation=="prev"){
	  counter1=(--counter1)%4;
	  if(counter1<0)
		  counter1=3;
  }  
  else{
	  counter1=(++counter1)%4;
  }
  

  xmlhttp.onreadystatechange = function(){
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
		
		
		var obj=JSON.parse(xmlhttp.responseText);
		
      document.getElementById("image").src=obj.url  ;
	  document.getElementById("url").innerHTML=obj.webpage;
	  document.getElementById("desc").innerHTML=obj.description;
	  document.getElementById("detail").innerHTML=obj.details;
	  
	  //document.getElementById("url").innerHTML=name[parseInt(xmlhttp.responseText)];
	  
      
    }  
  }

  xmlhttp.open("POST","slider.php",true);

	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");

  
  var queryParams ="number=" + counter1; 
  xmlhttp.send(queryParams);
  
}
