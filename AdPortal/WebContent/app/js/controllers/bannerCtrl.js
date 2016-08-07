app.controller("bannerCtrl",['$scope', '$route', 'BannerService', '$window', '$localStorage', '$modal', '$rootScope', '$location', function($scope, $route, BannerService, $window, $localStorage, $modal, $rootScope, $location){
 
    $scope.name = "";
    $scope.email = "";
    $scope.isAdmin = false;
    
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
                $scope.isAdmin = response.data.role === 2;
                $localStorage.isBlacklisted = response.data.role === 3;
                console.log(response.data.role);
                console.log("Is Admin : "+$scope.isAdmin);
			}
		},function failure(response){
			console.log("Failed to get details");
		});
      
     $rootScope.$on('$locationChangeStart', function(event, next, current) {
		 var nextRoute = $route.routes[$location.path()];
		 if(nextRoute.adminOnly && !$localStorage.isAdmin){
			 event.preventDefault();
			 $location.path('/AdPortal/');
		 }
        if(nextRoute.notForBlacklisted && $localStorage.isBlacklisted){
			 event.preventDefault();
			 $location.path('/AdPortal/');
		 }
	});
                             
}]);