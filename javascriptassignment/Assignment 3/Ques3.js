/**
 * Created by Mitul Kapoor on 7/22/2016.
 */
varlist=readHugeList();
varnextListItem=function(){
    varitem=list.pop();
    if(item){
//processthelistitem...
        setTimeout(nextListItem,0);
    }
};