app.controller("adminCtrl", ['$scope','$location','$window','AdminService','$filter', function ($scope, $location,$window, AdminService,$filter) {
    $scope.categories;
    $scope.locations;
    $scope.admins;
    $scope.blacklists;
    $scope.normalusers;
    $scope.users;
    $scope.getCategories = function(){
        AdminService.getCategories().
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
        AdminService.getLocations().
             then(
              function(successResponse){
               $scope.locations=successResponse.data;
                },
              function(errorResponse){
               $scope.locations=undefined;
              }
          );
    };
    
        $scope.test= function(){console.log("passed");};
        
    $scope.addCategory = function(){
        $scope.newcategoryname=$scope.newcategoryname.trim();
        if(!$scope.newcategoryname){
            alert("Invalid Category");
            return;
        }
        console.log("OK");
        for(cat in $scope.categories){
            console.log($scope.categories[cat].categoryname);
            if($scope.newcategoryname === $scope.categories[cat].categoryname){
                alert("Category already exists!!!");
                return;
            }
        }
        
        AdminService.addCategory($scope.newcategoryname).
         then(
              function(successResponse){
                  console.log("done");
               $window.location.reload();
              },
              function(errorResponse){
                  console.log("not done");
               $window.location.reload();
              }
          );
    };
   $scope.addLocation=function(location){
        $scope.newlocationname=$scope.newlocationname.trim();
        if(!$scope.newlocationname){
            alert("Invalid Location");
            return;
        }
        console.log("OK");
        for(cat in $scope.locations){
            console.log($scope.locations[cat].locationname);
            if($scope.newlocationname === $scope.locations[cat].locationname){
                alert("Location already exists!!!");
                return;
            }
        }
        
        AdminService.addLocation($scope.newlocationname).
         then(
              function(successResponse){
                  console.log("done");
               $window.location.reload();
              },
              function(errorResponse){
                  console.log("not done");
               $window.location.reload();
              }
          );
    };
    $scope.getBlacklists=function(){
        AdminService.getBlacklists().
             then(
              function(successResponse){
               $scope.blacklists=successResponse.data;
//                  $scope.updatelists();
              },
              function(errorResponse){
               //$scope.blacklistUsers=null;
              }
          );
    };
    $scope.getAdmins=function(){
        AdminService.getAdmins().
             then(
              function(successResponse){
               $scope.admins=successResponse.data;
                  //$scope.updatelists();
              },
              function(errorResponse){
               //$scope.blacklistUsers=null;
              }
          );
    };
    $scope.getUsers=function(){
        AdminService.getUsers().
             then(
              function(successResponse){
               $scope.users=successResponse.data;
                  console.log("users");
                  console.log($scope.users);
//                  $scope.updatelists();
              },
              function(errorResponse){
               //$scope.blacklistUsers=null;
              }
          );
    };
    $scope.makeAdmin=function(){
        console.log($scope.userforadmin);
        AdminService.makeAdmin($scope.userforadmin).
            then(
                function(SuccessResponse){
                    $window.location.reload();
                    //successResponse.data;
                },
                function(errorResponse){
                    $window.location.reload();
                    //successResponse.data;
                }
            );
        //console.log(userId);
    };
    $scope.blacklist=function(){
        console.log($scope.userforblacklist);
        AdminService.blacklist($scope.userforblacklist).
            then(
                function(SuccessResponse){
                    $window.location.reload();
                    //successResponse.data;
                },
                function(errorResponse){
                    $window.location.reload();
                    //successResponse.data;
                }
            );
    }
    $scope.unblacklist=function(){
        console.log($scope.userforunblacklist);
        AdminService.unblacklist($scope.userforunblacklist).
            then(
                function(SuccessResponse){
                    $window.location.reload();
                    //successResponse.data;
                },
                function(errorResponse){
                    $window.location.reload();
                    //successResponse.data;
                }
            );
    }
    $scope.getCategories();
    $scope.getLocations();
    //$scope.getAdmins();
    $scope.getBlacklists();
    $scope.getUsers();
}]);
