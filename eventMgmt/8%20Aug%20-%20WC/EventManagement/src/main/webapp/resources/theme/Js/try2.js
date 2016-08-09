/**
 * Angular chat2 try
 */

angular.module( 'BasicChat', ['chat', 'ngAnimate', 'ui.bootstrap'])
	.controller( 'chatControl', [ 'Messages', '$scope',
function( Messages, $scope ) {
    
    $scope.event={
    		name:'',
    		description:'',
    		venue:'',
    		start_time:'',
    		end_time:'',
    		type:'individual'
    	}

    
    $scope.messages = [
               		{
               			eventType:'eventType',
               			name:'Tecnobooz',
                		description:'Tech event of IIITA',
                		venue:'CC3',
                		startTime:'9:30',
                		endTime:'12:30',
                		type:'Individual',
                		organizerName:'Aarvind',
                		organizerEmail:'arvind@accolitelabs.com'},
                	{
                			eventType:'eventType',
                		name:'httpsss',
                		description:'Tech event of IIITA',
                		venue:'CC3',
                		startTime:'9:30',
                		endTime:'12:30',
                		type:'Individual',
                		organizerName:'Sumeet',
                		organizerEmail:'sumeet@accolitelabs.com'},
                	{
                			eventType:'eventType',
                   			name:'Alkhwarizam',
                		description:'Coding event of IIITA',
                		venue:'CC3',
                		startTime:'9:30',
                		endTime:'12:30',
                		type:'Group',
                		organizerName:'Pawan',
                		organizerEmail:'pawan@accolitelabs.com'},
                	{
                			eventType:'eventType',
                			name:'Techkriti',
                		description:'Web desiging event of IIITA',
                		venue:'CC3',
                		startTime:'9:30',
                		endTime:'12:30',
                		type:'Group',
                		organizerName:'Ravi',
                		organizerEmail:'ravi@accolitelabs.com'},
                	{
                			eventType:'eventType',
                   			name:'Perplexes',
                		description:'Tech event of IIITA',
                		venue:'CC3',
                		startTime:'9:30',
                		endTime:'12:30',
                		type:'Individual',
                		organizerName:'Aakash',
                		organizerEmail:'Aakash@accolitelabs.com'},
                	{
                			eventType:'eventType',
                   			name:'Tecnobooz',
                		description:'Tech event of IIITA',
                		venue:'CC3',
                		startTime:'9:30',
                		endTime:'12:30',
                		type:'Individual',
                		organizerName:'Aarvind',
                		organizerEmail:'arvind@accolitelabs.com'},
                	{
                			eventType:'eventType',
                   			name:'Tecnobooz',
                		description:'Tech event of IIITA',
                		venue:'CC3',
                		startTime:'9:30',
                		endTime:'12:30',
                		type:'Individual',
                		organizerName:'Aarvind',
                		organizerEmail:'arvind@accolitelabs.com'},
                	{
                			eventType:'eventType',
                   			name:'Tecnobooz',
                		description:'Tech event of IIITA',
                		venue:'CC3',
                		startTime:'9:30',
                		endTime:'12:30',
                		type:'Individual',
                		organizerName:'Aarvind',
                		organizerEmail:'arvind@accolitelabs.com'},
                	{
                			eventType:'eventType',name:'Tecnobooz',
                		description:'Tech event of IIITA',
                		venue:'CC3',
                		startTime:'9:30',
                		endTime:'12:30',
                		type:'Individual',
                		organizerName:'Aarvind',
                		organizerEmail:'arvind@accolitelabs.com'},
                	{
                			eventType:'eventType',name:'httpsss',
                		description:'Tech event of IIITA',
                		venue:'CC3',
                		startTime:'9:30',
                		endTime:'12:30',
                		type:'Individual',
                		organizerName:'Aarvind',
                		organizerEmail:'arvind@accolitelabs.com'}

                	];
    
    $scope.status="";
    var chatmessages = document.querySelector(".chat-messages");
    
    // Receive Messages
    Messages.receive(function(message){
        $scope.messages.push(message);
        setTimeout( function() {
            chatmessages.scrollTop = chatmessages.scrollHeight;
        }, 10 );
    });

    // Send Messages
    $scope.send = function() {
        Messages.send({ data : $scope.textbox });
        $scope.status = "sending";
        $scope.textbox = "";
        setTimeout( function() { $scope.status = "" }, 1200 );
    };
} ] );