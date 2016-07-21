//
// Initial parameters
//


numImages = 5;
startImage = 1;
currentImage = 1;

/**
 * New XmlHttpRequest
 */

function getNewXmlHttp(){
  var xmlhttp;
  if (window.XMLHttpRequest)
    xmlhttp=new XMLHttpRequest();
  else
    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  return xmlhttp;
}

/**
 * Show more details
 */

function showMore() {

    var xmlhttp = getNewXmlHttp();
  
    var callBack = function(){
    if (xmlhttp.readyState==4 && xmlhttp.status==200)
      {
        let jsonResponse = JSON.parse(xmlhttp.responseText);
        let target = jsonResponse;

        /*set detail div and hide show more*/
        document.getElementById("detailDiv").innerHTML = target['detail'];
        document.getElementById("detailDiv").setAttribute('style','display:inline');
        document.getElementById("showMore").setAttribute('style','display:none');
        document.getElementById("showLess").setAttribute('style','display:inline'); 
      }

    }
    xmlhttp.onreadystatechange = callBack;
    xmlhttp.open("GET","backend.php?action=showMore&current="+currentImage,true);
    xmlhttp.send();

}

/**
 * Hide details
 */

function showLess() {
  document.getElementById("detailDiv").setAttribute('style','display:none');
  document.getElementById("showMore").setAttribute('style','display:inline');
  document.getElementById("showLess").setAttribute('style','display:none'); 
}


/**
 * Get Next Image
 */

function getNextImage(){
  var xmlhttp = getNewXmlHttp();
  showLess();
  console.log(currentImage);
  var callBack = function(){
    if (xmlhttp.readyState==4 && xmlhttp.status==200 && currentImage<=4)
      {
        currentImage+=1;
        let jsonResponse = xmlhttp.responseText;
        let target = JSON.parse(jsonResponse);
        document.getElementById("slideshow").setAttribute('src',"images/"+target['url']);
        document.getElementById("slideshow").setAttribute('alt',target['alt']);
        document.getElementById("caption").innerHTML = target['caption'];
        
        defaultBlock();
    }
    
  }

    if(currentImage<=numImages-1){
      xmlhttp.onreadystatechange = callBack;

      xmlhttp.open("GET","backend.php?action=next&current="+currentImage,true);
      xmlhttp.send();
    }

}

/**
 * Default block conditions - for first and last image.
 */

function defaultBlock() {
  if(currentImage==startImage){
          document.getElementById('previous').disabled = true;
        }
        else if(currentImage==numImages){
          document.getElementById('next').disabled = true;
        }
        else{
          document.getElementById('next').disabled = false;
          document.getElementById('previous').disabled = false;
        }
}

/**
 * get Previous image
 */

function getPreviousImage(){
  var xmlhttp = getNewXmlHttp();
  console.log(currentImage);
  showLess();
  var callBack = function(){
    if (xmlhttp.readyState==4 && xmlhttp.status==200 && currentImage>=startImage+1)
      {
        currentImage-=1;
        let jsonResponse = JSON.parse(xmlhttp.responseText);

        let target = jsonResponse;
        document.getElementById("slideshow").setAttribute('src',"images/"+target['url']);
        document.getElementById("slideshow").setAttribute('alt',target['alt']);
        document.getElementById("caption").innerHTML = target['caption'];

        defaultBlock();
      }

    
    }
    if(currentImage>=startImage+1){
      xmlhttp.onreadystatechange = callBack;

      xmlhttp.open("GET","backend.php?action=previous&current="+currentImage,true);
      xmlhttp.send();
    } 
}