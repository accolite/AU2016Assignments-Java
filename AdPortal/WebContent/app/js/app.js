"use strict";

var app = angular.module("adportal",['ngRoute', 'ngAnimate', 'mgcrea.ngStrap' , 'rzModule', 'ngStorage']);


app.config(['$routeProvider',function($routeProvider){
    
    $routeProvider.when('/',{
        templateUrl: 'templates/home.html',
        controller: 'homeCtrl'
    }).when('/edit/:pid',{
        templateUrl: 'templates/edit.html',
        controller: 'editCtrl',
        notForBlacklisted: true
    }).when('/new',{
        templateUrl: 'templates/newpost.html',
        controller: 'newPostCtrl',
        notForBlacklisted: true
    }).when('/profile',{
        templateUrl: 'templates/profile.html',
        controller: 'profileCtrl'
    }).
    when('/admin',{
        templateUrl: 'templates/admin.html',
        controller: 'adminCtrl',
        adminOnly: true
    }).
    otherwise({
        redirectTo: '/'
    });

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

app.directive("fileread", [
  function() {
    return {
      scope: {
        fileread: "="
      },
      link: function(scope, element, attributes) {
        element.bind("change", function(changeEvent) {
          var reader = new FileReader();
          reader.onload = function(loadEvent) {
            scope.$apply(function() {
              scope.fileread = loadEvent.target.result;
            });
          }
          reader.readAsDataURL(changeEvent.target.files[0]);
        });
      }
    }
  }
]);