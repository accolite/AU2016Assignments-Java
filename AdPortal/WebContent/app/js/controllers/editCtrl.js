app.controller("editCtrl", ['$scope','$routeParams','editService', '$window',function ($scope,$routeparams,editService,$window) {
	$scope.getPost = function(){
		$scope.postid=$routeparams.pid;
		  editService.getPost($scope.postid).
		   then(
		    function(successResponse){
                if(successResponse.data === "")
                    $window.location.href="/AdPortal/app/";
                 $scope.title=successResponse.data.title;
                 $scope.category=""+successResponse.data.category;
                 $scope.location=""+successResponse.data.location;
                 $scope.description=successResponse.data.description;
                 $scope.price=successResponse.data.price;
                 $scope.status=successResponse.data.status;
		    },
		    function(errorResponse){
		     //$scope.Title=undefined;
		    	$window.location.href="/AdPortal/app/";
		    }
		    );
		 };
		 
    $scope.fill = function(){
    	$scope.getPost();
    }
    
    $scope.getCategories = function(){
        editService.getCategories().
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
        editService.getLocations().
             then(
              function(successResponse){
               $scope.locations=successResponse.data;
                },
              function(errorResponse){
               $scope.locations=undefined;
              }
          );
    };
    
    //change status it is static integrated later
    $scope.submit=function(){
    	editService.editPost($scope.postid,$scope.title,
        $scope.category,
        $scope.location,
        $scope.description,
        $scope.price,0).then(
    		    function(successResponse){
    			     $window.location.href="/AdPortal/app/";
    			    },
    			    function(errorResponse){
    			     $window.location.href="/AdPortal/app/";
    			    }
    			    );
    }
    $scope.getCategories();
    $scope.getLocations();
    $scope.fill();
    $scope.cancel= function(){
        $window.location.href="/AdPortal/app/";
    }
    $scope.reset = function(){
        $scope.fill();
    }
}]);