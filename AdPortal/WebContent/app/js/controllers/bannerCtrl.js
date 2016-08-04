app.controller("bannerCtrl",['$scope', 'BannerService', '$window', '$localStorage', function($scope, BannerService, $window, $localStorage){
 
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
                $localStorage.email = response.data.email;
                $localStorage.name = response.data.username;
                $localStorage.isAdmin = response.data.role === 2;
                console.log(response.data.role);
                console.log("Is Admin : "+$scope.isAdmin);
			}
		},function failure(response){
			console.log("Failed to get details");
		});
}]);