/**
 * 
 */

angular.module('EventManagment', ['directive.g+signin','ui.bootstrap','ngMaterial'])
.config(function($mdThemingProvider) {
  $mdThemingProvider.theme('default')
    .primaryPalette('cyan')
    .accentPalette('teal')
    .warnPalette('red')
    .backgroundPalette('grey')
    .dark();
  })
.controller('EventController', ['$scope','$rootScope','$http', function($scope,$rootScope,$http){
	$scope.flag1 = true;
	$scope.flag2 = false;
	
  
	
	$scope.change = function() {
		if($scope.flag1) {
			$scope.flag2 = true;
			$scope.flag1 = false;
		} else {
			$scope.flag2 = false;
			$scope.flag1 = true;
		}
	}

	$scope.event={
		name:'',
		description:'',
		venue:'',
		startTime:'',
		endTime:'',
		type:'Individual',
		organizerName:'',
		organizerEmail:''

	}

	$scope.events = [
		{name:'Tecnobooz',
		description:'Tech event of IIITA',
		venue:'CC3',
		startTime:'9:30',
		endTime:'12:30',
		type:'Individual',
		organizerName:'Aarvind',
		organizerEmail:'arvind@accolitelabs.com'},
	{name:'httpsss',
		description:'Tech event of IIITA',
		venue:'CC3',
		startTime:'9:30',
		endTime:'12:30',
		type:'Individual',
		organizerName:'Sumeet',
		organizerEmail:'sumeet@accolitelabs.com'},
	{name:'Alkhwarizam',
		description:'Coding event of IIITA',
		venue:'CC3',
		startTime:'9:30',
		endTime:'12:30',
		type:'Group',
		organizerName:'Pawan',
		organizerEmail:'pawan@accolitelabs.com'},
	{name:'Techkriti',
		description:'Web desiging event of IIITA',
		venue:'CC3',
		startTime:'9:30',
		endTime:'12:30',
		type:'Group',
		organizerName:'Ravi',
		organizerEmail:'ravi@accolitelabs.com'},
	{name:'Perplexes',
		description:'Tech event of IIITA',
		venue:'CC3',
		startTime:'9:30',
		endTime:'12:30',
		type:'Individual',
		organizerName:'Aakash',
		organizerEmail:'Aakash@accolitelabs.com'},
	{name:'Tecnobooz',
		description:'Tech event of IIITA',
		venue:'CC3',
		startTime:'9:30',
		endTime:'12:30',
		type:'Individual',
		organizerName:'Aarvind',
		organizerEmail:'arvind@accolitelabs.com'},
	{name:'Tecnobooz',
		description:'Tech event of IIITA',
		venue:'CC3',
		startTime:'9:30',
		endTime:'12:30',
		type:'Individual',
		organizerName:'Aarvind',
		organizerEmail:'arvind@accolitelabs.com'},
	{name:'Tecnobooz',
		description:'Tech event of IIITA',
		venue:'CC3',
		startTime:'9:30',
		endTime:'12:30',
		type:'Individual',
		organizerName:'Aarvind',
		organizerEmail:'arvind@accolitelabs.com'},
	{name:'Tecnobooz',
		description:'Tech event of IIITA',
		venue:'CC3',
		startTime:'9:30',
		endTime:'12:30',
		type:'Individual',
		organizerName:'Aarvind',
		organizerEmail:'arvind@accolitelabs.com'},
	{name:'httpsss',
		description:'Tech event of IIITA',
		venue:'CC3',
		startTime:'9:30',
		endTime:'12:30',
		type:'Individual',
		organizerName:'Aarvind',
		organizerEmail:'arvind@accolitelabs.com'}

	]

	$scope.currentPage = 1;
  	$scope.numPerPage = 6;
  	$scope.maxSize = 5;

  	$scope.numPages = function () {
    	return Math.ceil($scope.events.length / $scope.numPerPage);
  	};
  
  	$scope.$watch('currentPage + numPerPage', function() {
    	var begin = (($scope.currentPage - 1) * $scope.numPerPage)
    	, end = begin + $scope.numPerPage;
    
   	 $scope.filterevents = $scope.events.slice(begin, end);
  });


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

