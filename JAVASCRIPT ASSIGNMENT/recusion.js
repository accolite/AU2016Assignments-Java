var list = Array(50001).join('1.1').split('.');

var nextListItem = function() {
    var item = list.pop();

    if (item) { //should be list.length

        // recursion here!
        setTimeout( nextListItem, 0 );

    }
};
nextListItem();