app.controller("homeCtrl", ['$scope', 'HomeService','$modal', '$localStorage', '$window', function ($scope,HomeService, $modal, $localStorage, $window) {
    
// $scope.message = "This is the home page";
    $scope.contactModal;
    $scope.filtercategoryname;
    $scope.filterlocationname;
    $scope.categories=[];
    $scope.locations=[];
    $scope.subscribedCategories=[];
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
    if(!$scope.filtercategoryname)
      $scope.category = undefined; 
  if(!$scope.filterlocationname)
      $scope.location = undefined; 
  HomeService.getAllPosts($scope.title,$scope.category,$scope.location,$scope.min,$scope.max).
   then(
    function(successResponse){
    
     $scope.posts=successResponse.data;
        console.log($scope.posts);
    },
    function(errorResponse){
     $scope.posts=undefined;
    }
    );
 };
 $scope.showPopup = function(postid){
     $scope.cpost = _.filter($scope.posts, function(p){ return p.postid == postid});
     modal = $modal({
         title: 'Details', 
         templateUrl: 'templates/popup.html',
         scope: $scope
     });
     
     modal.$promise.then(modal.show);
 };
 
 $scope.reset = function(){
     delete $scope.title;
     delete $scope.category;
     delete $scope.location;
     delete $scope.min;
     delete $scope.max;
     delete $scope.filtercategoryname;
     delete $scope.filterlocationname;
     $scope.getAllPosts();
 };
 
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
 };
  
  $scope.getContactInfo= function(postid){
  HomeService.getContactInfo(postid).
    then(
     function(successResponse){
         $scope.contactDetails.email = successResponse.data[0];
         $scope.contactDetails.mobile = successResponse.data[1];
         $scope.cpostid = postid;
     },
     function(errorResponse){
         $scope.contactDetails = undefined;
     }
     );
  }
 
  $scope.contactPopup = function(postid){
      $scope.contactDetails.message = "";
      $scope.getContactInfo(postid);
      $scope.contactModal = $modal({
         title: 'Contact', 
         templateUrl: 'templates/contactpopup.html',
         scope: $scope
     });
     
     $scope.contactModal.$promise.then($scope.contactModal.show);
  };
  
  $scope.contact = function(){
      console.log($scope.cpostid+""+$scope.contactDetails.message);
      HomeService.contact($scope.cpostid, $scope.contactDetails.message).
        then(
         function(successResponse){
             $scope.contactModal.hide();
         },
         function(errorResponse){
             $scope.contactModal.hide();
         });
  };
    $scope.formatLoc = function(model) {
      for (var i=0; i< $scope.locations.length; i++) {
         if (model === $scope.locations[i].locationname) {
           $scope.location = $scope.locations[i].locationid
           return model;
         }
       }
};

      $scope.formatCat = function(model) {
          console.log(model);
      for (var i=0; i< $scope.categories.length; i++) {
         if (model === $scope.categories[i].categoryname) {
           $scope.category = $scope.categories[i].categoryid;
             console.log($scope.category);
           return model;
         }
       }
};
  
    $scope.getCategories();
    $scope.getLocations();
    $scope.getAllPosts();
}]);