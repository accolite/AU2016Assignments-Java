
var name = prompt("Please enter your name");
if(name === 'null') name="Rajesh"; /* If no username entered, will take default*/
document.getElementById("name").innerHTML = "Welcome, "+name;

xmlhttp=new XMLHttpRequest();

callBackAll = function () {
	
	 if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    	
    	var result = JSON.parse(xmlhttp.responseText);
    	

    	var table = document.createElement("TABLE");
    	// table.border = "1";

    	var row = table.insertRow(-1);
        var headerCell = document.createElement("TH");
	    headerCell.innerHTML = "MsgID";
	    row.appendChild(headerCell);
        headerCell = document.createElement("TH");
	    headerCell.innerHTML = "Message";
	    row.appendChild(headerCell);
        headerCell = document.createElement("TH");
	    headerCell.innerHTML = "Created By";
	    row.appendChild(headerCell);
	    //Get the count of columns.
	    var rowCount = result.length;
	    

	    l1="<a href='details.html?user="+name+"&id=";
	    l2="' target='_blank'>";
	    l3="</a>";

 		if(rowCount>0)
 		{
		    var row;
		    var cell;
		    for (var i = rowCount-1 ; i >= 0 ; i--) 
		    {
		        row = table.insertRow(-1);
		        cell = row.insertCell(-1);
		        cell.innerHTML = l1+result[i].msgid+l2+result[i].msgid+l3;
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

/* Service to Get all Messages from the server*/
getAllMessages = function () {
	xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = callBackAll;
	xmlhttp.open("GET","http://localhost:8080/restandsoap/webapi/all",true);
	xmlhttp.send();
}

getAllMessages();

/* Service to post a new message */
postMessage = function () {
	xmlhttp1 = new XMLHttpRequest();
	var msg = {};
	msg.creator = name;
	msg.message = document.getElementById("message").value;
	document.getElementById("message").value="";
	
	xmlhttp1.onreadystatechange = callBackPostMessage;
	xmlhttp1.open("POST","http://localhost:8080/restandsoap/webapi/add",true);
	xmlhttp1.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
	xmlhttp1.send(JSON.stringify(msg));
}

callBackPostMessage = function(){
	if (xmlhttp1.readyState==4 && xmlhttp1.status==200){
		 getAllMessages();
	 }
}