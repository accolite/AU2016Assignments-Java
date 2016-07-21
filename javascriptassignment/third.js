var list=readHugeList();

var nextListItem=function(){
	var item=list.pop();
	if(item){
		//processthelistitem...
		//Set Timeout for 4ms to slightly avoid stack overflow effect
		setTimout(nextListItem, 4);
	}
};