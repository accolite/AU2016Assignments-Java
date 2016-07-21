
//Get all buttons
var list = document.getElementsByClassName('calculableInput');

//Buttons not to be shown at input
var listExcluded = ['<-','CE','C','+-','sqrt','1/x','=']
var x = [].slice.call(list);
x.forEach(function(obj){
	obj.addEventListener('click', function(){
		if(!(listExcluded.includes(obj.value)))
			document.getElementById('calculable').value+=obj.value;
	});
});

document.getElementById('equal').addEventListener('click', function(){
		evaluateValue();
	});


document.getElementById('back').addEventListener('click', function(){
		let value = document.getElementById('calculable').value;
    	document.getElementById('calculable').value = value.substr(0, value.length - 1);
	});

document.getElementById('CE').addEventListener('click', function(){
		document.getElementById('calculable').value="";
	});


document.getElementById('C').addEventListener('click', function(){
		document.getElementById('calculable').value="";
		document.getElementById('entries').innerHTML="";
	});

document.getElementById('plusminus').addEventListener('click', function(){
		let temp=document.getElementById('calculable').value;
		document.getElementById('calculable').value=-parseInt(temp);
		evaluateValue();
	});

document.getElementById('sqrt').addEventListener('click',function(){
	evaluateValue();
	let temp=document.getElementById('calculable').value;
	document.getElementById('entries').innerHTML = 'sqrt('+temp+')';
	document.getElementById('calculable').value = Math.sqrt(temp);
});

document.getElementById('reciprocate').addEventListener('click',function(){
	evaluateValue();
	let temp=document.getElementById('calculable').value;
	document.getElementById('entries').innerHTML = '1/'+temp;
	document.getElementById('calculable').value = 1/(temp);
});

function evaluateValue(){
	try{
		let temp = document.getElementById('calculable').value;
		document.getElementById('entries').innerHTML=temp;
		document.getElementById('calculable').value = eval(temp);
	}catch(exception){
		alert("Not a valid expression")
		document.getElementById('calculable').value = '';
	}
}