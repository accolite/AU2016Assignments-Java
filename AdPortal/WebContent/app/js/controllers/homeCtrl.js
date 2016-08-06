app.controller("homeCtrl", ['$scope', 'HomeService','$modal', '$localStorage', '$window', function ($scope,HomeService, $modal, $localStorage, $window) {
    
// $scope.message = "This is the home page";
    $scope.contactModal;
    $scope.$storage = $localStorage;
    
    $scope.contactDetails = {};
    $scope.message=[];
    $scope.cpostid = "";
    
    $scope.min=0;
    $scope.max=10000;
    
    $scope.sliderOptions = {
        floor: 0,
        ceil: 10000,
        step: 100
    }
    
 $scope.getCategories = function(){
  HomeService.getCategories().
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
  HomeService.getLocations().
   then(
    function(successResponse){
     $scope.locations=successResponse.data;
        console.log("loc"+$scope.locations)
    },
    function(errorResponse){
     $scope.locations=undefined;
    }
    );
 };
 $scope.getAllPosts =function(){ 
     
  HomeService.getAllPosts($scope.title,$scope.category,$scope.location,$scope.min,$scope.max).
   then(
    function(successResponse){
     $scope.posts=successResponse.data;
    },
    function(errorResponse){
     $scope.posts=undefined;
    }
    )
 }

 $scope.showPopup = function(postid){
     $scope.cpost = _.filter($scope.posts, function(p){ return p.postid == postid});
     modal = $modal({
         title: 'Details', 
         templateUrl: 'templates/popup.html',
         scope: $scope
     });
     
     modal.$promise.then(modal.show);
 }
 
 $scope.reset = function(){
     delete $scope.title;
     delete $scope.category;
     delete $scope.location;
     delete $scope.min;
     delete $scope.max;
     $scope.getAllPosts();
 }
 
  $scope.deletepostbyid=function(postid){
  HomeService.deletepostbyid(postid).
    then(
     function(successResponse){
      $window.location.href="/AdPortal/app/";
     },
     //please change it
     function(errorResponse){
      $window.location.href="/AdPortal/app/";
     }
     );
 }
  
  $scope.getContactInfo= function(postid){
  HomeService.getContactInfo(postid).
    then(
     function(successResponse){
         $scope.contactDetails.email = successResponse.data[0];
         $scope.contactDetails.mobile = successResponse.data[1];
         $scope.cpostid = postid;
     },
     //please change it
     function(errorResponse){
         $scope.contactDetails = undefined;
     }
     );
  }
 
  $scope.contactPopup = function(postid){
      $scope.getContactInfo(postid);
      modal = $modal({
         title: 'Contact', 
         templateUrl: 'templates/contactpopup.html',
         scope: $scope
     });
     
     modal.$promise.then(modal.show);
  }
  
    $scope.getCategories();
    $scope.getLocations();
    $scope.getAllPosts();
}]);