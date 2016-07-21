var list = readHugeList();
var nextListItem = function() {
var item = list.pop();
if (item) {
// process the list item...
setTimeOut(nextListItem(),0);
}
};

The stack overflow in the above problem is caused beacuse of having all the nextListItem functions in the stack and waiting for them 
to complete. If we somehow make the stack area empty then the problem is solved. This can be achieved by using event loops. By having 
the nextListItem functions in event queue rather than a stack area we can overcome the stack overflow problem. To send the funtion to
event queue we are registring it with a timeout event using setTimeOut method. After the event occurs the function is moved from event table 
to event queue. Now when the nextListItem funciton finishes it job for the first time the called method will be waiting in the event queue.
The javascript engine selects the nextListItem function from event queue, places it in the stack and executes. So at any point of time there 
are only two copies of the funciton one in stack and one in event queue. So the stack overflow problem is solved.    