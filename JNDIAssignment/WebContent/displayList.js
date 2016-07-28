EmployeeCallBack = function(){
	if (xmlhttpc.readyState==4 && xmlhttpc.status==200){
		document.getElementById("emplist").innerHTML = xmlhttpc.responseText;
    }
}

UpdateEmployeeList = function(){
	xmlhttpc = new XMLHttpRequest();
	xmlhttpc.open("GET","/JNDI/ManagerServlet",true);
	xmlhttpc.onreadystatechange = EmployeeCallBack;
	xmlhttpc.send();
}