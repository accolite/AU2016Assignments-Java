"use strict";

var app = angular.module("adportal",['ngRoute', 'mgcrea.ngStrap', 'rzModule']);


app.config(['$routeProvider',function($routeProvider){
    
    $routeProvider.when('/',{
        templateUrl: 'templates/home.html',
        controller: 'homeCtrl'
    }).when('/edit',{
        templateUrl: 'templates/edit.html',
        controller: 'editCtrl'
    }).when('/new',{
        templateUrl: 'templates/newpost.html',
        controller: 'newPostCtrl'
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


app.directive('showErrors', function(){
    return{
        restrict: 'A',
        require: '^form',
        link: function (scope, el, attrs, formCtrl) {
            var inputEl   = el[0].querySelector("[name]");
            var inputNgEl = angular.element(inputEl);
            var inputName = inputNgEl.attr('name');
            inputNgEl.bind('blur', function() {
                el.toggleClass('has-error', formCtrl[inputName].$invalid);
            });
            scope.$on('show-errors-check-validity', function() {
                el.toggleClass('has-error', formCtrl[inputName].$invalid);
            });
        }
    }
});
