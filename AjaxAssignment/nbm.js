<script>
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

var current = 1;

function doAjax(ind){


  var xmlhttp = getNewXmlHttp();

  if (current + ind < 1) {
    current = 4;
  }
  else if (current + ind > 4) {
    current = 0;
  }
  else {
    current += ind;
  }

  xmlhttp.onreadystatechange = function(){
    if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
      var content = JSON.parse(xmlhttp.responseText);
      document.getElementById("data").innerHTML = "<img  src=" + content.url+">"

    }  

  }
  var url = current + ".json";

  xmlhttp.open("GET",url,true);


  xmlhttp.send();
} 
</script>