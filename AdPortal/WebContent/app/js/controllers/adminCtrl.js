app.controller("adminCtrl", ['$scope','$location','$window','AdminService', function ($scope, $location,$window, AdminService) {
    
    $scope.addCategory = function(category){
        AdminService.addCategory(category).
         then(
              function(successResponse){
                  console.log("done");
               //$window.location.reload();
              },
              function(errorResponse){
                  console.log("not done");
               //$window.location.reload();
              }
          );
    },
   $scope.addLocation=function(location){
        AdminService.addLocation(location).
             then(
              function(successResponse){
               //$window.location.reload();
              },
              function(errorResponse){
               //$window.location.reload();
              }
          );
    }
}]);
