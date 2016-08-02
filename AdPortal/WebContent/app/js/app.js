"use strict";

var app = angular.module("adportal",['ngRoute', 'mgcrea.ngStrap', 'rzModule']);


app.config(['$routeProvider',function($routeProvider){
    
    $routeProvider.when('/',{
        templateUrl: 'templates/home.html',
        controller: 'homeCtrl'
    }).when('/edit',{
        templateUrl: 'templates/edit.html',
        controller: 'editCtrl'
    })
    

}]);

app.directive('minPost', [function () {
	return {
		restrict: 'E',
		scope: {
			post: '=' 
		},
		templateUrl: 'templates/minPost.html'
	};
}])