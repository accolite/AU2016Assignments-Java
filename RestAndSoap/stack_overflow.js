/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 21, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************
*/

var list = readHugeList();

var nextListItem=function(){
	var item=list.pop();

	if(item){
		setTimeout(nextListItem(),0);
	}
}