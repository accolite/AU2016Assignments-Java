/**
 * 
 */

angular.module('EventManagment', ['directive.g+signin','ui.bootstrap'])
.controller('EventController', ['$scope','$rootScope','$http', function($scope,$rootScope,$http){
	$scope.flag1 = true;
	$scope.flag2 = false;
	$scope.flag = 0;
	
  
	



	$scope.event={
		
		name:'',
		description:'',
		type:'individual',
		start_time:0,
		end_time:0,
		venue:''
	}

	$scope.group = {name:'',points:''}
	$scope.groups = ['a','b','c','d'];
	

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
	$scope.deleteEvent = function(index) {
		$scope.events.splice(index,1);
	}

	$scope.row = 0;
	$scope.view = false;
	$scope.editmode = function() {

		$scope.view = !$scope.view;
	}
	$scope.colorRow = function(index){
		$scope.flag = index;
        $scope.row = index;
    }    

	
	$scope.organizer=[{email:""}]
	$scope.addorganizer = function() {
		$scope.organizer.push({email:""});
	}

	$scope.addevent = function() {
	
		var objectPojo = {'event':$scope.event,'organizers':$scope.organizer};
	    	$http({
	            method : 'POST',
	            url : 'addEvent',
	            data: objectPojo
	        }).then(function successCallback(response) {
	        	$scope.userType = response.data;
	        	
	        }, function errorCallback(response) {
	            console.log(response.statusText);
	           
	        });
	}


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
	$scope.userType = '';
	$scope.$on('event:google-plus-signin-success', function (event,authResult) {
	    // Send login to server or save into cookie
	    var profile = authResult.getBasicProfile();
	    var emailid = profile.getEmail();
	    $scope.arr = emailid.split("@");
	    $scope.length = $scope.arr.length;
	    if($scope.arr[$scope.length-1] == 'accolitelabs.com' || $scope.arr[$scope.length-1] == 'accoliteindia.com' || $scope.arr[$scope.length-1] == 'accolite.com' ) {
	    	var googlePojo = {"id":profile.getId(), "email":profile.getEmail(), "name":profile.getName(), "given_name":profile.getGivenName(), "family_name":profile.getFamilyName()};
	    	$http({
	            method : 'POST',
	            url : 'login',
	            data: googlePojo
	        }).then(function successCallback(response) {
	        	$scope.userType = response.data;
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
	  
	  
}])

.filter('startFrom', function() {
  return function(input, start) {
	  if (!input || !input.length) { return; }
    start = +start; //parse to int
    return input.slice(start);
  }
});