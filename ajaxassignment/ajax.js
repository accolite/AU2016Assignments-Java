var counter = 1;
function getNewXmlHttp()
{
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
function display()
{
	var xmlhttp = getNewXmlHttp();
	xmlhttp.onreadystatechange = function(){
	if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
		
		var obj = JSON.parse(xmlhttp.responseText);
		console.log(obj);
		document.getElementById('1').style.visibility = 'visible';
		document.getElementById('2').style.visibility = 'visible';
		document.getElementById('3').style.visibility = 'visible';
		document.getElementById('1').innerHTML = "Description:" + " " + "<b>" + obj[0].desc + "</b>";
		document.getElementById('2').innerHTML = " Webpage:" + " " + obj[0].webpage;
		document.getElementById('3').innerHTML = " Detailed Info: " + " " + obj[0].info;
    }  
  }
	xmlhttp.open("GET","server.php?index="+counter,true);
	xmlhttp.send();
	
}
function loadNext(){
	
	
	//console.log("Hi");
	var xmlhttp = getNewXmlHttp();
	
	counter++;
	xmlhttp.onreadystatechange = function(){
	if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
		
		var obj = JSON.parse(xmlhttp.responseText);
		console.log(obj);
		document.getElementById('image_slider').src = obj[0].url;
		document.getElementById('1').style.visibility = 'hidden';
		document.getElementById('2').style.visibility = 'hidden';
		document.getElementById('3').style.visibility = 'hidden';
    }  
  }
	xmlhttp.open("GET","server.php?index="+counter,true);
	xmlhttp.send();
  
	
}

function loadPrev(){
	
	var xmlhttp = getNewXmlHttp();
	counter--;
	xmlhttp.onreadystatechange = function(){
	if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
		
		var obj = JSON.parse(xmlhttp.responseText);
		document.getElementById('image_slider').src = obj[0].url;
		document.getElementById('1').style.visibility = 'hidden';
		document.getElementById('2').style.visibility = 'hidden';
		document.getElementById('3').style.visibility = 'hidden';
    }  
  }
	xmlhttp.open("GET","server.php?index="+counter,true);
	xmlhttp.send();
}