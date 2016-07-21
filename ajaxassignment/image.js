var val=0;
function prevImage() {
	
	
	var xmlhttp;
	if (window.XMLHttpRequest)
	{
	  xmlhttp=new XMLHttpRequest();
	}
	else
	{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			
			var images=JSON.parse(xmlhttp.responseText);
		  var number=document.getElementById("txtNumber");
		  //var val=number.value;
		 val=(val-1);
		 if(val<0)
			 val=7;
		 document.getElementById("image").innerHTML = "<input type='text' hidden name='txtNumber' id='txtNumber' value='"+(val)+"'/><br/><img src='"+images.pic[val].url+"' alt='Could not load image' style='width:100%;height:500px;'/><br/><br/><br/>Name: <input type='label' id='labelName' value='"+images.pic[val].name+"'/><br/>Description: <input type='label' id='labelDescrition' value='"+images.pic[val].description+"'/><br/>";
		  
			
		}	
	}
	
  xmlhttp.open("GET", "jsonData.json", true);
  xmlhttp.send();
  
}

function nextImage() {

	var xmlhttp;
	if (window.XMLHttpRequest)
	{
	  xmlhttp=new XMLHttpRequest();
	}
	else
	{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xmlhttp.onreadystatechange = function() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		var images=JSON.parse(xmlhttp.responseText);

		
	  var number=document.getElementById("txtNumber");
	  //var val=number.value;
	  val=(val+1);
	  
	  if(val>7)
		  val=0;
	  
	  document.getElementById("image").innerHTML = "<input type='text' hidden name='txtNumber' id='txtNumber' value='"+val+"'/><br/><img src='"+images.pic[val].url+"' alt='Could not load image' style='width:100%;height:500px;'/><br/><br/><br/>Name: <input type='label' id='labelName' value='"+images.pic[val].name+"'/><br/>Description: <input type='label' id='labelDescrition' value='"+images.pic[val].description+"'/><br/>";;
	  
	  
		
    }
  }
  xmlhttp.open("GET", "jsonData.json", true);
  xmlhttp.send();
}


