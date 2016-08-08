/**
 * 
 */

angular.module( 'EventManagement', ['chat', 'directive.g+signin', 'ngAnimate', 'ui.bootstrap', 'ngMaterial'])
	
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
  .controller( 'EventController', [ 'Messages', '$scope', '$rootScope', '$http',
function( Messages, $scope, $rootScope, $http ) {
	$scope.flag1 = true;
	$scope.flag2 = false;
	$scope.flag = 0;
	$scope.global = $rootScope;
	$scope.flag4 =0;
	
	$scope.person = {name:'', email_id:''}

	$scope.global.participantGroupName = "";


	$scope.event={
		
		name:'',
		description:'',
		type:'individual',
		start_time:0,
		end_time:0,
		venue:''
	}

	$scope.group = {name:'',points:''}
	
	$scope.findRow = function(id){
		var elementPos = $scope.groups.map(function(x) {return x.group.group_id; }).indexOf(id);
		$scope.flag4 = elementPos;
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
		            url : 'viewGroups/'+$scope.events[$scope.flag].event._id,
		        }).then(function successCallback(response) {
		        	$scope.groups = response.data;
		        }, function errorCallback(response) {
		            console.log(response.statusText);
		        });
		}
		/*
		 * Add points
		 */
		
		$scope.addpoints = function() {
			$http({
		            method : 'POST',
		            url : 'addPoints/'+$scope.events[$scope.flag].event._id+"/"+$scope.groups[$scope.flag4].group_id+"/"+$scope.group.points,
		        }).then(function successCallback(response) {
		        	$scope.status = response.data;
		        }, function errorCallback(response) {
		            console.log(response.statusText);
		        });
		}
		
		/*
		 * Add organizer for update
		 */
		$scope.addorganizer1 = function() {
			$scope.events[$scope.flag].organizers.push({email:""});
		}
		$scope.removeRow = function(email){				
			var index = -1;		
			var comArr = eval( $scope.events[$scope.flag].organizers );
			for( var i = 0; i < comArr.length; i++ ) {
				if( comArr[i].email === email ) {
					index = i;
					break;
				}
			}
			if( index === -1 ) {
				alert( "Something gone wrong" );
			}
			$scope.events[$scope.flag].organizers.splice( index, 1 );		
		};
		
		/*
		 * update - event
		 */
		$scope.updateEvent = function() {
		
			var objectPojo = {'event':$scope.events[$scope.flag].event,'organizers':$scope.events[$scope.flag].organizers};
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
			
		    	$http({
		            method : 'POST',
		            url : 'updateEvent',
		            data: objectPojo
		        }).then(function successCallback(response) {
		        	
		            alert("updated event");     	
		        }, function errorCallback(response) {
		            console.log(response.statusText);
		           
		        });
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
		$scope.flag = elementPos;
        $scope.row = index;
    }    

	
	
/*
 * Events - control
 */
	/*
	 * Get all events
	 */
	$scope.getallevents = function() {
		$http({
	            method : 'GET',
	            url : 'viewEvent',
	        }).then(function successCallback(response) {
	        	$scope.events = response.data;
	        }, function errorCallback(response) {
	            console.log(response.statusText);
	        });
	}
	
	/*
	 * Delete event
	 */
	$scope.deleteEvent = function(index) {
		//alert();
		//Item to be deleted
		
		$http({
            method : 'POST',
            url : 'deleteEvent/'+$scope.events[$scope.flag].event._id
        }).then(function successCallback(response) {
    		$scope.events.splice(index,1);
        	
        }, function errorCallback(response) {
            console.log(response.statusText);
           
        });
	}


	/*
	 * Add organizers
	 */
	$scope.organizer=[{email:""}]
	$scope.addorganizer = function() {
		$scope.organizer.push({email:""});
	}

	
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
		
	    	$http({
	            method : 'POST',
	            url : 'addEvent',
	            data: objectPojo
	        }).then(function successCallback(response) {
	        	$scope.events.push(response.data);
	        	
	        }, function errorCallback(response) {
	            console.log(response.statusText);
	           
	        });
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
			$scope.participants[i].participant.event_id=$scope.events[$scope.flag].event._id;
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
	        	alert("success");
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
	        	
	        }, function errorCallback(response) {
	            console.log(response.statusText);
	           
	        });
		}else{
			alert("Enter proper email id");
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
	 * Pagination details
	 */
	
	$scope.currentPage = 0;
  	$scope.pageSize = 12;

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
	    	$http({
	            method : 'POST',
	            url : 'login',
	            data: googlePojo
	        }).then(function successCallback(response) {
	        	$scope.user = response.data;
	        	location.reload();
	        }, function errorCallback(response) {
	            console.log(response.statusText);
	            location.reload();
	        });
		}
	

	    else {
	    	alert("invalid user");
	    }
		
	  });
	  $scope.$on('event:google-plus-signin-failure', function (event,authResult) {
	    // Auth failure or signout detected
	  });
	  
	  /*
	    * log out functionality
	    */
	   $scope.logout = function (){
	    $http({
	             method : 'GET',
	             url : 'logout'
	         }).then(function successCallback(response) {
	          alert(" logged out successfully");
	         }, function errorCallback(response) {
	             console.log(response.statusText);
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