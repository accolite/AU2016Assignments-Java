var s="";

function disp(obj){
		var i=obj.id;
		if(i=='equal'){
			try {
				s=eval(document.getElementById("display").value);
			} catch (e) {
				if (e instanceof SyntaxError) {
					alert(e.message);
				}
			}
			
			document.getElementById("display").value=s;
		}else if(i=='clear'){
			s="";
			document.getElementById("display").value=s;
		}else{
			var a=document.getElementById(i).getAttribute("value");
			console.log(a);
			s+=a;
			document.getElementById("display").value=s;
		}
	};