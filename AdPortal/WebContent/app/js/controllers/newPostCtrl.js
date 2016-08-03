app.controller("newPostCtrl", ['$scope','$location','NewPostService', function ($scope, $location, NewPostService) {
    
    $scope.title = "";
    $scope.category = "";
    $scope.location = "";
    $scope.description = "";
    $scope.price = "";
    
    $scope.getCategories = function(){
        NewPostService.getCategories().
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
        NewPostService.getLocations().
             then(
              function(successResponse){
               $scope.locations=successResponse.data;
                },
              function(errorResponse){
               $scope.locations=undefined;
              }
          );
    };
 
    $scope.reset = function(){
        $scope.title = "";
        $scope.category = "";
        $scope.location = "";
        $scope.description = "";
        $scope.price = "";
    }
    
    $scope.submit=function(){
        
        $scope.$broadcast('show-errors-check-validity');
        
        if ($scope.form.$invalid) { 
            alert("Please check the details you have entered");
            return; 
        }
        
        NewPostService.addNewPost($scope.title,
            $scope.category,
            $scope.location,
            $scope.description,
            $scope.price).then(
              function(successResponse){
                   console.log("Ticket ID is "+successResponse.data);
                   console.log("Success");
                   $location.path("/");
               },
               function(errorResponse){
                 console.log("Failed");
                   $scope.reset();
               }
            );
 
    }
    $scope.getCategories();
    $scope.getLocations();
}]);
