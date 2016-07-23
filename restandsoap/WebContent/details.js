var Extract = (function(){
	var query = {}, pair, search = location.search.substring(1).split("&"), i = search.length;
	while (i--) {
	    pair = search[i].split("=");
	    query[pair[0]] = decodeURIComponent(pair[1].replace(/\+/g, '%20'));
	}
		 return query;
	})();

var name = Extract["user"];
var id = Extract["id"];
var xmlhttpm;
var xmlhttp;
var xmlhttpc;
var xmlhttpam;
var likedby =""


callBackPostLike = function(){
	if (xmlhttp.readyState==4 && xmlhttp.status==200){
		 getLikes();
	 }
}

/* Service to 'like' a message */
postLike = function () {
	xmlhttp1 = new XMLHttpRequest();
	var msg = {};
	msg.name = name;
	xmlhttp1.onreadystatechange = callBackPostLike;
	xmlhttp1.open("POST","http://localhost:8080/restandsoap/webapi/like/"+id,true);
	xmlhttp1.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
	xmlhttp1.send(JSON.stringify(msg));
}

callBackGetLikes = function () {
	if (xmlhttp.readyState==4 && xmlhttp.status==200){
		var result = JSON.parse(xmlhttp.responseText);
   
    	if(result.length>0) likedby = result.length+" like(s) by ";
    	for(i=0; i<result.length; i++){
    		if(name===result[i].name)
    			document.getElementById("likebutton").style.visibility="hidden";
    		likedby += result[i].name+ ", ";
    	}
    	document.getElementById("likedby").innerHTML = likedby+"</b>";
	}
}

/* Service to get all likes on a message*/
getLikes = function () {
	xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = callBackGetLikes;
	xmlhttp.open("GET","http://localhost:8080/restandsoap/webapi/likes/"+id,true);
	xmlhttp.send();
}


callBackAll = function () {
	 if (xmlhttpm.readyState==4 && xmlhttpm.status==200)
    {
   
    	var result = JSON.parse(xmlhttpm.responseText);
   
    	for(i=0; i<result.length; i++){
    
    		if(result[i].msgid == id){
    			document.getElementById("message").innerHTML = result[i].message;
    			return;
    		}
    	}	
    	document.getElementById("message").innerHTML = "Not found";
    } 	
}

/* Service to get message details */
getAllMessages = function () {
	xmlhttpm = new XMLHttpRequest();
	xmlhttpm.onreadystatechange = callBackAll;
	xmlhttpm.open("GET","http://localhost:8080/restandsoap/webapi/all",true);
	xmlhttpm.send();
}

callBackPostComment = function(){
	if (xmlhttpc.readyState==4 && xmlhttpc.status==200){
		 getAllComments();
	 }
}

/* Service to post a comment on a message */
postComment = function () {
	xmlhttpc = new XMLHttpRequest();
	var msg = {};
	msg.creator = name;
	msg.message = document.getElementById("comment").value;
	document.getElementById("comment").value="";
	xmlhttpc.onreadystatechange = callBackPostComment;
	xmlhttpc.open("POST","http://localhost:8080/restandsoap/webapi/addc/"+id,true);
	xmlhttpc.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
	xmlhttpc.send(JSON.stringify(msg));
}

/* Service to get all comments of a message*/
getAllComments = function () {
	xmlhttpam = new XMLHttpRequest();
	xmlhttpam.onreadystatechange = callBackMessages;
	xmlhttpam.open("GET","http://localhost:8080/restandsoap/webapi/comments/"+id,true);
	xmlhttpam.send();
}

callBackMessages = function () {
	 if (xmlhttpam.readyState==4 && xmlhttpam.status==200)
    {
   
    	var result = JSON.parse(xmlhttpam.responseText);
   

    	var table = document.createElement("TABLE");
    	
    	var row = table.insertRow(-1);
        var headerCell = document.createElement("TH");
        headerCell = document.createElement("TH");
	    headerCell.innerHTML = "Comment";
	    row.appendChild(headerCell);
        headerCell = document.createElement("TH");
	    headerCell.innerHTML = "Created By";
	    row.appendChild(headerCell);
	    var rowCount = result.length;
	  
 		if(rowCount>0)
 		{
		    var row;
		    var cell;
		    for (var i = rowCount-1; i >= 0; i--) 
		    {
		        row = table.insertRow(-1);
		        cell = row.insertCell(-1);
				cell.innerHTML = result[i].message;
		        cell = row.insertCell(-1);
		        cell.innerHTML = result[i].creator;
		    }
	 
	    	var tbl = document.getElementById("tbl");
	    	tbl.innerHTML = "";
	   		tbl.appendChild(table);
    	}
    } 	
}

getAllMessages();

getLikes();

getAllComments();