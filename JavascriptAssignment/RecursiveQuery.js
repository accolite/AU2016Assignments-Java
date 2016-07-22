var list=readHugeList();
var nextListItem=function(){
    var item=list.pop();
    if(item){
        setTimeout(nextListItem(),0);
    }
};