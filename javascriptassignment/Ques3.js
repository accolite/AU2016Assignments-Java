/**
 * Created by Mitul Kapoor on 7/22/2016.
 */
varlist=readHugeList();
varnextListItem=function(){
    varitem=list.pop();
    if(item){
        setTimeout(nextListItem,0);
    }
};