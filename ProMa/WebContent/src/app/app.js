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
	.config(function($routeProvider) {
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
	.controller('overviewController', function($scope,$http){
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
		
		$scope.addAnUser = function(){
			var userdata = $scope.fields;
			var addUserUrl = "rest/users";
			var adduserpromise = $http.post(addUserUrl,userdata);			
			adduserpromise.then(function(response){
				console.log('User added woohoo')
			})
		} 
		
	})
	.controller('individualController', function($scope,$http,$routeParams){
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
	})
