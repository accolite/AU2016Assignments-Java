app.controller("profileCtrl", ['$scope','$location','$localStorage', '$window','ProfileService', function ($scope, $location, $localStorage, $window, ProfileService) {
    $scope.$storage = $localStorage;
    $scope.newMobile = "";
//    
    $scope.updateMobile =function(){
        console.log("Going to change to "+$scope.newMobile);
        ProfileService.updateProfile($scope.newMobile).then(
            function(successResponse){
                $window.location.reload();
            },
            function(errorResponse){
                $window.location.reload();
            }
        )
    }
}]);
