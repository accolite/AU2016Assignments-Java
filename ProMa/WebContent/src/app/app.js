/**
* app Module
*
* Description
*/
angular.module('app', [
	'ngRoute',
	'mgcrea.ngStrap',
	'ngAnimate'
	])
	.config(function($routeProvider,$locationProvider) {
		$routeProvider
			.when('/',
			{
				controller:'overviewController',
				templateUrl:'src/views/overview.html'
			})
			.when('/bu/:buid/:buname',
			{
				controller:'individualController',
				templateUrl:'src/views/individual.html'
			})
			.otherwise({redirectTo: '/'});
	})
	.controller('overviewController', function($scope,$http,$location,$alert){
		var url = "rest/projects/status";
		var promise = $http.get(url);
		promise.then(function(response){
			$scope.projects = response.data;
		})		
		
		var roleurl = "rest/roles"
		var rolepromise = $http.get(roleurl);
		rolepromise.then(function(response){
			$scope.roles = response.data;
		})
		
		var usersUrl = "rest/users"
		var usersPromise = $http.get(usersUrl);
		usersPromise.then(function(response){
			$scope.users = response.data;
		})


		$scope.convertAnUser = function(){
			var userdata = $scope.fields;
			var convertUserUrl = "rest/users/convertToAdmin";
			var convertuserpromise = $http.post(convertUserUrl,userdata);			
			convertuserpromise.then(function(response){
				$alert({duration:3,container:'body', content: 'Wololo', placement: 'top-right', type: 'success', show: true});
				// console.log('User Converted woohoo')
			})
		}; 
		
		$scope.addABU =  function(){
			var budata = $scope.fields;
			var addBUUrl = "rest/bus";
			addBUPromise = $http.post(addBUUrl,budata);
			addBUPromise.then(function(response){
				console.log(response.data);
				$alert({duration:3,container:'body', content: 'BU Added', placement: 'top-right', type: 'success', show: true});
			});

		};

	})
	.controller('individualController', function($scope,$http,$routeParams,$alert,$modal){
		$scope.buname = $routeParams.buname;
		var url = "rest/projects/bus/" + $routeParams.buid;
		var promise = $http.get(url);
		promise.then(function(response){
			$scope.projects = response.data;
		})		
		$scope.buid = $routeParams.buid

		$scope.addAProject = function(){
			var projectData = $scope.fields;
			var addProjectURL = "rest/projects"
			var addProjectPromise = $http.post(addProjectURL,projectData);
			addProjectPromise.then(function(response){
				console.log('Project added woohoo')
			})

		}

		var clientsUrl = "rest/clients"
		var clientsPromise = $http.get(clientsUrl);
		clientsPromise.then(function(response){
			$scope.clients = response.data;
		})

		var usersUrl = "rest/users"
		var usersPromise = $http.get(usersUrl);
		usersPromise.then(function(response){
			$scope.users = response.data;
		})

		var addBUHeadModal = $modal({template:'src/views/modals/admin-add-bu-head-form.html', show:false});

		$scope.showBUHeadModal = function(){
		    addBUHeadModal.$promise.then(addBUHeadModal.show);
		}

		$scope.addABUHead = function(){
			var buHead = $scope.fields;
			var buHeadURL = "rest/bus/" + $scope.buid + "/buheads"
			var buHeadPromise = $http.post(buHeadURL,buHead);
			buHeadPromise.then(function(response){
				$alert({duration:3,container:'body', content: 'Wohoo Bu Head Added', placement: 'top-right', type: 'success', show: true});
				console.log("added bu heaad woohoo");
			})
		}

	})
