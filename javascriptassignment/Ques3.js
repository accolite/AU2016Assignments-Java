/**
 * Created by Mitul Kapoor on 7/22/2016.
 */
var list=readHugeList();
var nextListItem=function(){
    var item=list.pop();
    if(item){
        setTimeout(nextListItem(),0);
    }
};
