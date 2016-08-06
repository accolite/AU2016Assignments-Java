app.controller("bannerCtrl",['$scope', 'BannerService', '$window', '$localStorage', '$modal', function($scope, BannerService, $window, $localStorage, $modal){
 
    $scope.name = "";
    $scope.email = "";

    
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
                $scope.name = response.data.username;
                $localStorage.id = response.data.userid;
                $scope.email = response.data.email;
                $localStorage.email = response.data.email;
                $localStorage.name = response.data.username;
                $localStorage.mobile = response.data.mobile;
                $localStorage.isAdmin = response.data.role === 2;
                console.log(response.data.role);
                console.log("Is Admin : "+$scope.isAdmin);
			}
		},function failure(response){
			console.log("Failed to get details");
		});
    
}]);