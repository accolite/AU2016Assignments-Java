app.controller("profileCtrl", ['$scope','$location','$localStorage', '$window','ProfileService','$filter', function ($scope, $location, $localStorage, $window, ProfileService,$filter) {
    $scope.statusname=["Open","Closed","Deleted"];
    console.log($scope.statusname[0]);
    $scope.$storage = $localStorage;
    $scope.newMobile = "";
    $scope.subscribedcategories = [];
    $scope.unsubscribedcategories=[];
    $scope.unsubcategoryid="";
    $scope.subcategoryid="";
    $scope.categories=[];
    $scope.flag1 = [true,false,false,false];
//    
    
    $scope.flag = [1,0,0,0];
    $scope.loaddiv = function(index) {
      for(var i = 0; i < 4; i++) {

        if(i == index) {
          $scope.flag[i] = 1;
          $scope.flag1[i] = true;
        } else {
          $scope.flag[i] = 0;
          $scope.flag1[i] = false;
        }
      }
    }
     $scope.getCategories = function(){
          ProfileService.getCategories().
           then(
            function(successResponse){
                $scope.categories=successResponse.data;
                $scope.unsubscribedcategories = $scope.categories.filter(function(cat1) {
                  for (var i in $scope.subscribedcategories) {
                    if (cat1.categoryid === $scope.subscribedcategories[i].categoryid) { return false; }
                  };
                  return true;
                });
            },
            function(errorResponse){
                $scope.categories=undefined;
            });
     };
    
    $scope.getSubscribedCategories = function(){
          ProfileService.getSubscribedCategories().
           then(
            function(successResponse){
                $scope.subscribedcategories=successResponse.data;
                $scope.unsubscribedcategories = $scope.categories.filter(function(cat1) {
                  for (var i in $scope.subscribedcategories) {
                    if (cat1.categoryid === $scope.subscribedcategories[i].categoryid) { return false; }
                  };
                  return true;
                });
            },
            function(errorResponse){
                $scope.subscribedcategories=undefined;
            });
     };
    
    $scope.updateMobile =function(){
        console.log("Going to change to "+$scope.newMobile);
        ProfileService.updateProfile($scope.newMobile).then(
            function(successResponse){
                alert("Successfully changed");
                $window.location.reload();
            },
            function(errorResponse){
                alert("Sorry. Something went wrong. Try again later");
                $location.path("/");
            }
        );
    };
    
    $scope.subscribe = function(){
        ProfileService.subscribe($scope.subcategoryid).then(
            function(successResponse){
                 alert("Subscription successful");
                $window.location.reload();
            },
            function(errorResponse){
                alert("Sorry. Something went wrong. Try again later");
                $location.path("/");
            }
        );
    }
    
    $scope.unsubscribe = function(){
       ProfileService.unsubscribe($scope.unsubcategoryid).then(
            function(successResponse){
                alert("Unubscription successful");
                $window.location.reload();
            },
            function(errorResponse){
                alert("Sorry. Something went wrong. Try again later");
                $location.path("/");
            }
        );
    }
    $scope.getUserPosts =function(){ 
     
  ProfileService.getUserPosts().
   then(
    function(successResponse){
     $scope.posts=successResponse.data;
        console.log($scope.posts);
    },
    function(errorResponse){
     $scope.posts=undefined;
    }
    );
 }
    $scope.deletepostbyid=function(postid){
  ProfileService.deletepostbyid(postid).
    then(
     function(successResponse){
      $window.location.href="/AdPortal/app/#/profile";
     },
     //please change it
     function(errorResponse){
      $window.location.href="/AdPortal/app/#/profile";
     }
     );
 };

      $scope.formatUnsubCat = function(model) {
          console.log(model);
      for (var i=0; i< $scope.subscribedcategories.length; i++) {
         if (model === $scope.subscribedcategories[i].categoryname) {
           $scope.unsubcategoryid = $scope.subscribedcategories[i].categoryid;
           return model;
         }
       }
};
     $scope.formatSubCat = function(model) {
          console.log(model);
      for (var i=0; i< $scope.unsubscribedcategories.length; i++) {
         if (model === $scope.unsubscribedcategories[i].categoryname) {
           $scope.subcategoryid = $scope.unsubscribedcategories[i].categoryid;
           return model;
         }
       }
};

    
    $scope.getSubscribedCategories();
    $scope.getCategories();
    $scope.getUserPosts();
    
}]);
