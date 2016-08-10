app.controller("adminCtrl", ['$scope','$location','$window','AdminService','$filter', function ($scope, $location,$window, AdminService,$filter) {
    //
    $scope.flag = [1,0,0,0,0];
    $scope.loaddiv = function(index) {
      for(var i = 0; i < 5; i++) {
        if(i == index) {
          $scope.flag[i] = 1;
        } else {
          $scope.flag[i] = 0;
        }
      }
    }
    //
    $scope.newlocationname;
    $scope.newcategoryname;
    $scope.categories;
    $scope.locations;
    $scope.admins;
    $scope.blacklists;
    $scope.normalusers;
    $scope.users;
    $scope.init=function(){
        $scope.newlocationname = "";
        $scope.newcategoryname = "";
    };
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
       console.log("creating category "+ $scope.newlocationname);
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
        console.log("creating category "+$scope.newcategoryname);
        if(!$scope.newcategoryname){
            alert("Invalid Category");
            return;
        }
        $scope.newcategoryname=$scope.newcategoryname.trim();
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
                    alert("Successfully added Category");
                    $location.path("/");
              },
              function(errorResponse){
                    alert("Sorry. Something went wrong. Try again later");
                    $location.path("/");
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
                    alert("Successfully added location");
                    $location.path("/");
                },
              function(errorResponse){
                   alert("Sorry. Something went wrong. Try again later");
                    $location.path("/");
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
                    alert("Made admin");
                    $location.path("/");
                    //successResponse.data;
                },
                function(errorResponse){
                    alert("Sorry. Try again later");
                    $location.path("/");
                    //successResponse.data;
                }
            );
        //console.log(userId);
    };
    $scope.blacklist=function(){
        console.log("Asdfdsf");
        console.log($scope.userforblacklist);
        AdminService.blacklist($scope.userforblacklist).
            then(
                function(SuccessResponse){
                    alert("User added to blacklist");
                    $location.path("/");
                    //successResponse.data;
                },
                function(errorResponse){
                    alert("Sorry. Something went wrong. Try again later");
                    $location.path("/");
                    //successResponse.data;
                }
            );
    }
    $scope.unblacklist=function(){
        console.log($scope.userforunblacklist);
        AdminService.unblacklist($scope.userforunblacklist).
            then(
                function(SuccessResponse){
                    alert("User removed from blacklist");
                    $location.path("/");
                    //successResponse.data;
                },
                function(errorResponse){
                    alert("Sorry. Something went wrong. Try again later");
                    $location.path("/");
                    //successResponse.data;
                }
            );
    }
    
    $scope.formatAdminUser=function(model){
        for (var i=0; i< $scope.users.length; i++) {
         if (model === $scope.users[i].username) {
           $scope.userforadmin = $scope.users[i].userid;
           return model;
         }
       }
    }
    
    $scope.formatBlacklistUser=function(model){
        for (var i=0; i< $scope.users.length; i++) {
         if (model === $scope.users[i].username) {
           $scope.userforblacklist = $scope.users[i].userid;
           return model;
         }
       }
    }
    
    $scope.formatUnblacklistUser=function(model){
        for (var i=0; i< $scope.blacklists.length; i++) {
         if (model === $scope.blacklists[i].username) {
           $scope.userforunblacklist = $scope.blacklists[i].userid;
           return model;
         }
       }
    }
    
    $scope.init();
    $scope.test();
    $scope.getCategories();
    $scope.getLocations();
    //$scope.getAdmins();
    $scope.getBlacklists();
    $scope.getUsers();
}]);
