/**
 * 
 */

angular.module( 'EventManagement', ['chat', 'directive.g+signin', 'ngAnimate', 'ui.bootstrap', 'ngMaterial', 'angular-noty'])
	
	.config(function($mdThemingProvider) {
  $mdThemingProvider.theme('default')
    .primaryPalette('cyan',{
    	      'default': '800',
    	      'hue-1':'700'})
    .accentPalette('teal',{
    	'default': '700'})
    .warnPalette('red')
    .backgroundPalette('grey')
  })
  .controller( 'EventController', ['Messages', '$scope', '$rootScope', '$http', 'noty',
function( Messages, $scope, $rootScope, $http, noty) {
	$scope.flag1 = true;
	$scope.flag2 = false;
	$scope.flag = 0;
	$scope.flagLogout = 0;
	$scope.global = $rootScope;
	$scope.global.group_id =0;
	$scope.global.flag = 0;
	$scope.types=['individual','group'];
	$scope.groups = [];
	$scope.person = {name:'', email_id:''}
	$scope.user={};
	$scope.newGroup = 0;
	$scope.date = new Date();
	$scope.loginUser = '';

	$scope.global.participantGroupName = "";
	$scope.global.participantsEvents = [];

	$scope.event={
		
		name:'',
		description:'',
		type:'individual',
		start_time:0,
		end_time:0,
		venue:''
	}
	
	$scope.clearEvent = function(){
		$scope.event={
				name:'',
				description:'',
				type:'individual',
				start_time:0,
				end_time:0,
				venue:''
			}
	}

	$scope.clearAdmin = function(){
		$scope.admin = {
				name:'',
				email:''
			}
			
	}
	
	$scope.clearAddParticipant = function(){
		$scope.global.participantGroupName = "";
		$scope.participants = [{
			 "participant": {
			      "event_id": 0
			    },
			    "group": {
			      "group_name": ""
			    },
			    "user": {
			      "email": ""
			    }
		}];
	}
	
	$scope.clearAddPoints = function(){
		$scope.group = {group_name:'',points:0};
	}
	
	
	$scope.group = {group_name:'',points:0}
	
	$scope.showNotySuccess = function(msg) {

	    noty.showNoty({
	    text: msg,
	    ttl: 2000, //time to live in miliseconds
	    type: "success", //success, warning, default, gmail 
	    options: ['Dismiss'], 
	    optionsCallBack:  function callback(optionClicked, optionIndexClicked) {
	      //handling code for options clicked
	    }
	  })
	   }
	
	$scope.showNotyFailure = function(msg) {

	    noty.showNoty({
	    text: msg,
	    ttl: 2000, //time to live in miliseconds
	    type: "warning", //success, warning, default, gmail 
	    options: ['Dismiss'], 
	    optionsCallBack:  function callback(optionClicked, optionIndexClicked) {
	      //handling code for options clicked
	    }
	  })
	   }
	
	$scope.findRow = function(group_name){
		var elementPos = $scope.groups.map(function(x) {return x.group_name; }).indexOf(group_name);
		$scope.global.group_id = $scope.groups[elementPos].group_id;
		//alert(elementPos);
    }    
	
	/*
	 * Existing group and new group - controls
	 */
	$scope.existingGroup= function(){
		$scope.getallgroups();
		$scope.newGroup = 2;
	}
	
	$scope.newGroupForEvent= function(){
		$scope.newGroup = 1;
	}
	
	$scope.change = function(){
		if($scope.newGroup == 1){
			$scope.newGroup = 2;
		}else if($scope.newGroup == 2){
			$scope.newGroup = 1;
		}
	}
	
	
	/*
	 * participants - control
	 */
		/*
		 * Get all groups
		 */
		$scope.getallgroups = function() {
			$http({
		            method : 'POST',
		            url : 'viewGroups/'+$scope.events[$scope.global.flag].event._id,
		        }).then(function successCallback(response) {
		        	$scope.groups = response.data;
		        }, function errorCallback(response) {
		            $scope.showNotyFailure(response.statusText);
		        });
		}
		/*
		 * Add points
		 */
		
		$scope.addpoints = function() {
			if($scope.group.group_name!=""){
			$scope.findRow($scope.group.group_name);
			if($scope.group.points>0){
			$http({
		            method : 'POST',
		            url : 'addPoints/'+$scope.events[$scope.global.flag].event._id+"/"+$scope.global.group_id+"/"+$scope.group.points,
		        }).then(function successCallback(response) {
		        	if(response.data){
		        		$scope.status = response.data;
		        		$scope.showNotySuccess($scope.group.points + " added to " + $scope.group.group_name);
		        	}
		        	else
		        		$scope.showNotyFailure("Access denied")
		        }, function errorCallback(response) {
		        	$scope.showNotyFailure(response.statusText);
		        });
			}else{
				$scope.showNotyFailure("Enter positive points");
			}
			}else{
				$scope.showNotyFailure("please select proper group");
			}
		}
		
		/*
		 * Add organizer for update
		 */
		$scope.addorganizer1 = function() {
			$scope.events[$scope.global.flag].organizers.push({email:"",name:""});
		}
		$scope.removeRow1 = function(email){				
			var index = -1;		
			var comArr = eval( $scope.events[$scope.global.flag].organizers );
			for( var i = 0; i < comArr.length; i++ ) {
				if( comArr[i].email === email ) {
					index = i;
					break;
				}
			}
			if( index === -1 ) {
				$scope.showNotyFailure( "Something gone wrong" );
			}
			$scope.events[$scope.global.flag].organizers.splice( index, 1 );		
		};
		
		
		
		/*
		 * update - event
		 */
		$scope.updateEvent = function() {
		
			var objectPojo = {'event':$scope.events[$scope.global.flag].event,'organizers':$scope.events[$scope.global.flag].organizers};
			for(var i=0;i<objectPojo.organizers.length;i++){
				var value=objectPojo.organizers[i].email;
				var email = value.split("@");
			    var emailLength = email.length;
			    if(email[emailLength-1] == 'accolitelabs.com' || email[emailLength-1] == 'accoliteindia.com' || email[emailLength-1] == 'accolite.com' ) {
			    	continue;
			    }else{
			    	objectPojo.organizers.splice(i,1);
			    }
			}
			//alert(objectPojo.event.start_time+" "+objectPojo.event.end_time)
				if(objectPojo.event.start_time==0)
					objectPojo.event.start_time = new Date();
				if(objectPojo.event.end_time==0){
					objectPojo.event.end_time = new Date();
					objectPojo.event.end_time.setHours(objectPojo.event.end_time.getHours()+1)
				}
				if(objectPojo.event.end_time<=objectPojo.event.start_time){
					$scope.showNotyFailure("Event must atleast be 1 ms long");
				}
			else{
		    	$http({
		            method : 'POST',
		            url : 'updateEvent',
		            data: objectPojo
		        }).then(function successCallback(response) {
		        	$scope.editmode();
		        	if(response.data > 0){
		        		$scope.getallevents();
		        		$scope.showNotySuccess("Event " +$scope.events[$scope.global.flag].event.name + " updated");
		        	}
		        	else if(response.data == 0)
		        		$scope.showNotyFailure("Some organizers could not be added");
		        	else
		        		$scope.showNotyFailure("Access Denied")
		        }, function errorCallback(response) {
		        	$scope.showNotyFailure(response.statusText);
		        });
			}
		}
/*
 * On -click for navigation
 */
	$scope.row = 0;
	$scope.view = false;
	$scope.editmode = function() {
		$scope.view = !$scope.view;
	}
	$scope.colorRow = function(index, id){

		//Get altering variable - id
		$scope.view = false;
		var elementPos = $scope.events.map(function(x) {return x.event._id; }).indexOf(id);
		$scope.global.flag = elementPos;
        $scope.row = index;
    }    


	/*
	 * Admin - control
	 */
	$scope.addAdmin = function(){
		var email = $scope.admin.email.split("@");
		var emailLength = email.length;
	    if(email[emailLength-1] == 'accolitelabs.com' || email[emailLength-1] == 'accoliteindia.com' || email[emailLength-1] == 'accolite.com' ) {
	    	$http({
	            method : 'POST',
	            url : 'addAdmin',
	            data: $scope.admin
	        }).then(function successCallback(response) {
	        	if(response.data)
	        		$scope.showNotySuccess("Added "+$scope.admin.email);
	        	else
	        		$scope.showNotyFailure("Access denied");
	        }, function errorCallback(response) {
	        	$scope.showNotyFailure(response.statusText);
	        });
	    }
	    else
	    	$scope.showNotyFailure("Invalid email");	
	}
	
/*
 * Events - control
 */
	/*
	 * Get all events
	 */
	$scope.getallevents = function() {
		$scope.loginUser = localStorage.getItem("token1");
		$http({
	            method : 'GET',
	            url : 'viewEvent',
	        }).then(function successCallback(response) {
	        	$scope.events = response.data;
	        	for(var i in $scope.events){
	        		for(var j in $scope.events[i].organizers)
	        		if($scope.events[i].organizers[j].name == '' || $scope.events[i].organizers[j].name == null ){
	        			var email = $scope.events[i].organizers[j].email;
	        			var emailString = email.substring(0,email.indexOf("."));
	        			$scope.events[i].organizers[j].name = emailString;
	        		}
	        	}
	        	$scope.isOrganizer();
	        }, function errorCallback(response) {
	        	$scope.showNotyFailure(response.statusText);
	        });
	}
	
	/*
	 * Organizer population
	 */
	$scope.Organizer = [];
	$scope.isOrganizer = function(){
		var k1 = $scope.events.length;
		$scope.user = localStorage.getItem("token");
		for(var i = 0; i < k1; i++) {
			$scope.Organizer.push(false);
		}
 		for(var j = 0; j < k1; j++) {
 			for(var k = 0; k < $scope.events[j].organizers.length; k++) {
 				var aa = $scope.events[j].organizers[k].email;
				if($scope.user ==  aa) {
					$scope.Organizer[j] = true;
				}
			}
		}
	}
	
	
	/*
	 * Delete event
	 */
	$scope.deleteEvent = function(index) {
		//alert();
		//Item to be deleted
		
		$http({
            method : 'POST',
            url : 'deleteEvent/'+$scope.events[$scope.global.flag].event._id
        }).then(function successCallback(response) {
        	if(response.data){
	    		$scope.events.splice(index,1);
	        	$scope.global.flag=0;
	        	$scope.showNotySuccess("Deleted event");
        	}else{
        		$scope.showNotyFailure("Access denied");
        	}
        }, function errorCallback(response) {
        	$scope.showNotyFailure(response.statusText);
           
        });
	}


	/*
	 * Add organizers
	 */
	$scope.organizer=[{email:"",name:""}]
	$scope.addorganizer = function() {
		$scope.organizer.push({email:"",name:""});
	}
	

	$scope.removeRow = function(email){				
		var index = -1;		
		var comArr = eval( $scope.organizer );
		for( var i = 0; i < comArr.length; i++ ) {
			if( comArr[i].email === email ) {
				index = i;
				break;
			}
		}
		if( index === -1 ) {
			$scope.showNotyFailure( "Something gone wrong" );
		}
		$scope.organizer.splice( index, 1 );		
	};

	
	/*
	 * Add - event
	 */
	$scope.addevent = function() {
		
		var objectPojo = {'event':$scope.event,'organizers':$scope.organizer};
		for(var i=0;i<objectPojo.organizers.length;i++){
			var value=objectPojo.organizers[i].email;
			var email = value.split("@");
		    var emailLength = email.length;
		    if(email[emailLength-1] == 'accolitelabs.com' || email[emailLength-1] == 'accoliteindia.com' || email[emailLength-1] == 'accolite.com' ) {
		    	continue;
		    }else{
		    	objectPojo.organizers.splice(i,1);
		    }
		}
		if(objectPojo.event.start_time==0)
			objectPojo.event.start_time = new Date();
		if(objectPojo.event.end_time==0){
			objectPojo.event.end_time = new Date();
			objectPojo.event.end_time.setHours(objectPojo.event.end_time.getHours()+1)
		}
		if(objectPojo.event.end_time<=objectPojo.event.start_time)
			$scope.showNotyFailure("Event must atleast be 1 ms long");
		else if(objectPojo.event.name=='' || objectPojo.event.name==null)
			$scope.showNotyFailure("Name can't be empty");
		else{
			$http({
		            method : 'POST',
		            url : 'addEvent',
		            data: objectPojo
		        }).then(function successCallback(response) {
		        	
		        	if(response.data){
		        		$scope.events.push(response.data);
		        		$scope.getallevents();
		        		$scope.showNotySuccess("Added event "+$scope.event.name)
		        	}
		        	else
		        		$scope.showNotyFailure("access denied");
		        }, function errorCallback(response) {
		        	$scope.showNotyFailure(response.statusText);
		           
	        });
		}
	}
	
	/*
	 * Add participants
	 */
	
	
	$scope.participant={
			 "participant": {
			      "event_id": 0
			    },
			    "group": {
			      "group_name": ""
			    },
			    "user": {
			      "email": ""
			    }
	}
	
	$scope.participants=[$scope.participant]
	$scope.addparticipantAnother = function() {
		$scope.participants.push({
			 "participant": {
			      "event_id": 0
			    },
			    "group": {
			      "group_name": ""
			    },
			    "user": {
			      "email": ""
			    }
		});
	}
	
	$scope.addParticipants = function() {
		
		for(var i=0;i<$scope.participants.length;i++){
			$scope.participants[i].participant.event_id=$scope.events[$scope.global.flag].event._id;
			$scope.participants[i].group.group_name=$scope.global.participantGroupName;
			var value=$scope.participants[i].user.email;
			var email = value.split("@");
		    var emailLength = email.length;
		    if(email[emailLength-1] == 'accolitelabs.com' || email[emailLength-1] == 'accoliteindia.com' || email[emailLength-1] == 'accolite.com' ) {
		    	continue;
		    }else{
		    	$scope.participants.splice(i,1);
		    }
		}
		if($scope.participants.length>0){
	    	$http({
	            method : 'POST',
	            url : 'registerParticipant',
	            data: $scope.participants
	        }).then(function successCallback(response) {
	        	if(response.data!=0){
		        	$scope.getallevents();
		        	$scope.showNotySuccess("success");
		        	$scope.global.participantGroupName="";
	        	}
	        	else{
	        		$scope.showNotyFailure("Not all emails were added. Can't be added again");
	        	}
	        	$scope.participants=[{
					 "participant": {
					      "event_id": 0
					    },
					    "group": {
					      "group_name": ""
					    },
					    "user": {
					      "email": ""
					    }
			}];
	        	
	        	
	        }, function errorCallback(response) {
	        	$scope.showNotyFailure(response.statusText);
	           
	        });
		}else{
			$scope.showNotyFailure("Enter proper email id");
        	$scope.global.participantGroupName="";
			$scope.participants=[{
				 "participant": {
				      "event_id": 0
				    },
				    "group": {
				      "group_name": ""
				    },
				    "user": {
				      "email": ""
				    }
		}];
		}
	}
	
	/*
	 * Get all participants
	 */
	
	$scope.getAllParticipants = function(event_id){
		$http({
            method : 'GET',
            url : 'getAllParticipants/'+event_id,
        }).then(function successCallback(response) {
        	$scope.global.participantsEvents = response.data;
        	for(var i in $scope.global.participantsEvents){
        		if($scope.global.participantsEvents[i].user.name == '' || $scope.global.participantsEvents[i].user.name == null ){
        			var email = $scope.global.participantsEvents[i].user.email;
        			var emailString = email.substring(0,email.indexOf("."));
        			$scope.global.participantsEvents[i].user.name = emailString;
        		}
        	}
        }, function errorCallback(response) {
        	$scope.showNotyFailure(response.statusText);
        });
	}
	
	/*
	 * Pagination details
	 */
	
	$scope.currentPage = 0;
  	$scope.pageSize = 6;

  	$scope.numberOfPages = function() {

  		if(!$scope.events || !$scope.events.length) return;
    	return Math.ceil($scope.events.length / $scope.pageSize);
  	}

	$scope.admin = {
		name:'',
		email:''
	}
	
	
	
	/*
	 * Google-plus signin
	 */
	$scope.user={};
	$scope.$on('event:google-plus-signin-success', function (event,authResult) {
	    // Send login to server or save into cookie
	    var profile = authResult.getBasicProfile();
	    var emailid = profile.getEmail();
	    var email = emailid.split("@");
	    var emailLength = email.length;
	    if(email[emailLength-1] == 'accolitelabs.com' || email[emailLength-1] == 'accoliteindia.com' || email[emailLength-1] == 'accolite.com' ) {
	    	var googlePojo = {"id":profile.getId(), "email":profile.getEmail(), "name":profile.getName(), "given_name":profile.getGivenName(), "family_name":profile.getFamilyName()};
	    	if($scope.flagLogout==0){
	    	$http({
	            method : 'POST',
	            url : 'login',
	            data: googlePojo
	        }).then(function successCallback(response) {
	        	$scope.flagLogin = 1;
	        	$scope.user = response.data;
	        	var k = $scope.user.email;
	        	var u = $scope.user.name;
	        	localStorage.setItem("token", k);
	        	localStorage.setItem("token1", u);
				 //returns "xxx"
	        	location.reload();
	        }, function errorCallback(response) {
	        	$scope.showNotyFailure(response.statusText);
	            location.reload();
	        });
	    	}else{
	    		console.log("please press sign in");
	    	}
		}
	

	    else {
	    	$scope.showNotyFailure("invalid user");
	    }
		
	  });
	  $scope.$on('event:google-plus-signin-failure', function (event,authResult) {
	    // Auth failure or signout detected
	  });
	  
	  /*
	    * log out functionality
	    */
	   $scope.logout = function (){
		   $scope.flagLogout = 1;
	    $http({
	             method : 'GET',
	             url : 'logout',
	             headers: {
	                 'Content-Type': undefined
	             }
	         }).then(function successCallback(response) {
	        	 var auth2 = gapi.auth2.getAuthInstance();
                 auth2.signOut().then(function () {
                	 $scope.showNotySuccess('User signed out.');
                 });
	         }, function errorCallback(response) {
	        	 var auth2 = gapi.auth2.getAuthInstance();
                 auth2.signOut().then(function () {
                	 $scope.showNotySuccess('User signed out.');
                 });
	             console.log(response);
	             location.reload();
	         });
	   }
}])

.filter('startFrom', function() {

	/*
	 * Pagination
	 */
  return function(input, start) {
	  if (!input || !input.length) { return; }
    start = +start; //parse to int
    return input.slice(start);
  }
});