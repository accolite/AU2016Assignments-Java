function load() {
	/*var data="{"referenceWebPage":"Google","description":"An image","deatiledInfo":"Its an image","image":"Hydrangeas.jpg"},
		{"referenceWebPage":"Pictures","description":"An image","deatiledInfo":"Its an image","image":"Jellyfish.jpg"},
		{"referenceWebPage":"Images","description":"An image","deatiledInfo":"Its an image","image":"Koala.jpg"},
		{"referenceWebPage":"Abcd","description":"An image","deatiledInfo":"Its an image","image":"Lighthouse.jpg"},
		{"referenceWebPage":"efgh","description":"An image","deatiledInfo":"Its an image","image":"Penguins.jpg"}"*/
	var text = '{"name":"John Johnson","street":"Oslo West 16","phone":"555 1234567"}';	
	var mydata = JSON.parse(text);
	alert(mydata[0].name);
	alert(mydata[0].street);
}