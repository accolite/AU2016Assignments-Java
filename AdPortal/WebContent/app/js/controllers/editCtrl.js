app.controller("editCtrl", ['$scope','$routeParams','editService', '$window', '$location', function ($scope,$routeparams,editService,$window, $location) {
	$scope.getPost = function(){
        $scope.categories=[];
        $scope.locations=[];
		$scope.postid=$routeparams.pid;
		  editService.getPost($scope.postid).
		   then(
		    function(successResponse){
                if(successResponse.data === "")
                    $location.path("/");
                 $scope.title=successResponse.data.title;
                 $scope.category=""+successResponse.data.category;
                 $scope.location=""+successResponse.data.location;
                 $scope.description=successResponse.data.description;
                 $scope.price=successResponse.data.price;
                 $scope.status=successResponse.data.status;
		    },
		    function(errorResponse){
		     //$scope.Title=undefined;
                $location.path("/"); 
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
        console.log("status is "+$scope.newstatus);
        var stat;
        if($scope.newstatus!=null&&$scope.newstatus){
            stat=2;
        }
        else{
            stat=1;
        }
        console.log("stat is "+stat);
    	editService.editPost($scope.postid,$scope.title,
        $scope.category,
        $scope.location,
        $scope.description,
        $scope.price,stat).then(
    		    function(successResponse){
    			         alert("Changes saved successfully");
                        $location.path("/");    
    			    },
    			    function(errorResponse){
    			         alert("Sorry. Something went wrong. Try again later");
                        $location.path("/");
    			    }
    			    );
        
    }
   
    $scope.getCategories();
    $scope.getLocations();
    $scope.fill();
    $scope.cancel= function(){
        $location.path("/"); 
    }
    $scope.reset = function(){
        $scope.fill();
    }
}]);