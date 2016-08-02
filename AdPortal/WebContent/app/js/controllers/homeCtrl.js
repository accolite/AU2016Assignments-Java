app.controller("homeCtrl", ['$scope', 'HomeService', function ($scope,HomeService) {
    
// $scope.message = "This is the home page";

    $scope.min=0;
    $scope.max=10000;
    $scope.sliderOptions = {
        floor: 0,
        ceil: 10000,
        step: 100
    }
    
 $scope.getCategories = function(){
  HomeService.getCategories().
   then(
    function(successResponse){
     $scope.categories=successResponse.data;
    },
    function(errorResponse){
     $scope.categories=undefined;
    }
    );
 };
 $scope.getLocations=function(){
  HomeService.getLocations().
   then(
    function(successResponse){
     $scope.locations=successResponse.data;
        console.log("loc"+$scope.locations)
    },
    function(errorResponse){
     $scope.locations=undefined;
    }
    );
 };
 $scope.getAllPosts =function(){ 
     
  HomeService.getAllPosts($scope.title,$scope.category,$scope.location,$scope.min,$scope.max).
   then(
    function(successResponse){
     $scope.posts=successResponse.data;
    },
    function(errorResponse){
     $scope.posts=undefined;
    }
    )
 }

 $scope.reset = function(){
     delete $scope.title;
     delete $scope.category;
     delete $scope.location;
     delete $scope.min;
     delete $scope.max;
     $scope.getAllPosts();
 }
 
    $scope.getCategories();
    $scope.getLocations();
    $scope.getAllPosts();
}]);