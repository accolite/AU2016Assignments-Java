app.controller("profileCtrl", ['$scope','$location','$localStorage', '$window','ProfileService','$filter', function ($scope, $location, $localStorage, $window, ProfileService,$filter) {
    $scope.$storage = $localStorage;
    $scope.newMobile = "";
//    
     $scope.getCategories = function(){
          ProfileService.getCategories().
           then(
            function(successResponse){
                $scope.categories=successResponse.data;
                $scope.unsubscribedcategories = $scope.categories.filter(function(cat1) {
                  for (var i in $scope.subscribedCategories) {
                    if (cat1.categoryid === $scope.subscribedCategories[i].categoryid) { return false; }
                  };
                  return true;
                });
            },
            function(errorResponse){
                $scope.categories=undefined;
            });
     };
    
    $scope.getSubscribedCategories = function(){
          ProfileService.getSubscribedCategories().
           then(
            function(successResponse){
                $scope.subscribedCategories=successResponse.data;
                $scope.unsubscribedcategories = $scope.categories.filter(function(cat1) {
                  for (var i in $scope.subscribedCategories) {
                    if (cat1.categoryid === $scope.subscribedCategories[i].categoryid) { return false; }
                  };
                  return true;
                });
            },
            function(errorResponse){
                $scope.subscribedCategories=undefined;
            });
     };
    
    $scope.updateMobile =function(){
        console.log("Going to change to "+$scope.newMobile);
        ProfileService.updateProfile($scope.newMobile).then(
            function(successResponse){
                $window.location.reload();
            },
            function(errorResponse){
                $window.location.reload();
            }
        );
    };
    
    $scope.subscribe = function(categoryid){
        ProfileService.subscribe(categoryid).then(
            function(successResponse){
                $window.location.reload();
            },
            function(errorResponse){
                $window.location.reload();
            }
        );
    }
    
    $scope.unsubscribe = function(categoryid){
       ProfileService.unsubscribe(categoryid).then(
            function(successResponse){
                $window.location.reload();
            },
            function(errorResponse){
                $window.location.reload();
            }
        );
    }
    
    
    $scope.getSubscribedCategories();
    $scope.getCategories();
    
}]);
