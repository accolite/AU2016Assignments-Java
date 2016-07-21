var slideIndex = 0;
		doAjax("one");

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

		function doAjax(option){

		  var xmlhttp = getNewXmlHttp();

		  xmlhttp.onreadystatechange = function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200)
		    {
		      parseJson(xmlhttp.responseText,option);
		    }  
		  }

		  xmlhttp.open("GET","images.php",true);
		  xmlhttp.send();

		}

		function parseJson(response,option)
		{			console.log("coming index"+slideIndex);

			if(option=='one')
			{
				slideIndex=0;
			}
			else if(option=='next' && slideIndex==2)
			{
				slideIndex=0;
			}
			else if(option=='prev' && slideIndex==0)
			{
				slideIndex=2;
			}
			else if(option=='next')
			{
				slideIndex++;
			}

			else if(option=='prev')
			{
				slideIndex--;
			}
			var images=JSON.parse(response);
			console.log(images);
			console.log(typeof images);
			console.log(slideIndex);
			console.log(images.IMG[slideIndex].image);
			document.getElementById("images").innerHTML="<img src=\""+images.IMG[slideIndex].image+"\" style=\"width:50% \">";
					document.getElementById("desc").innerHTML="";


		}
		function fetchdetails()
		{
			var xmlhttp = getNewXmlHttp();
		

		  xmlhttp.onreadystatechange = function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200)
		    {
		      details(xmlhttp.responseText);
		    }  
		  }

		  xmlhttp.open("GET","images.php",true);
		  xmlhttp.send();
		}
		function details(response)
		{
			var images=JSON.parse(response);
			console.log(slideIndex);
			console.log(images.IMG[slideIndex].image);
			document.getElementById("desc").innerHTML="the deatail of image <br>"+images.IMG[slideIndex].src+"<br>"+images.IMG[slideIndex].description;

		}