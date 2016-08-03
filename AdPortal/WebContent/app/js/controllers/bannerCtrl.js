app.controller("bannerCtrl",['$scope', 'BannerService', '$window', function($scope, BannerService, $window){
 
    $scope.banner = {
        name : "Banner",
        src : "templates/banner.html"
    }
    
    $scope.logout = function(){
        console.log("Going to logout");
        BannerService.logout().success(function() {
	        $window.location.href="/AdPortal/";
	      }).error(function(data) {
	        console.log("Logout failed");
	      });
    }
    BannerService.getUser()
		.then(function success(response){
			if(!response.data){
				$scope.logout();
			}
			else{
				console.log("Success");
                $scope.email = response.data.email;
				$scope.name = response.data.username;
			}
		},function failure(response){
			console.log("Failed to get details");
		});
}]);