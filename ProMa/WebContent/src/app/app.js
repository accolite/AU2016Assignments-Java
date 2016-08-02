/**
* app Module
*
* Description
*/
angular.module('app', [
	'ngRoute',
	'mgcrea.ngStrap'
	])
	.config(function($routeProvider) {
		$routeProvider
			.when('/',
			{
				controller:'overviewController',
				templateUrl:'src/views/overview.html'
			})
			.when('/bu/:buid',
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
		$scope.modal = {
		  "title": "Title",
		  "content": "Hello Modal<br />This is a multiline message!"
		};
	})
	.controller('individualController', function($scope,$http,$routeParams){
		var url = "rest/projects/bus/" + $routeParams.buid;
		var promise = $http.get(url);
		promise.then(function(response){
			$scope.projects = response.data;
		})		
		$scope.buid = $routeParams.buid
	})
