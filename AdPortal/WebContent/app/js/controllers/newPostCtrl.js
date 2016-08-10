app.controller("newPostCtrl", ['$scope','$location','NewPostService', 'Upload', function ($scope, $location, NewPostService,Upload) {
    
    $scope.title = "";
    $scope.category = "";
    $scope.location = "";
    $scope.description = "";
    $scope.price = "";
    $scope.filesArray = [];
    $scope.categories=[];
    $scope.locations=[];
    
    $scope.getCategories = function(){
        NewPostService.getCategories().
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
        NewPostService.getLocations().
             then(
              function(successResponse){
               $scope.locations=successResponse.data;
                },
              function(errorResponse){
               $scope.locations=undefined;
              }
          );
    };
 
    $scope.reset = function(){
        //alert("hi");
        $scope.title = "";
        $scope.category = "";
        $scope.location = "";
        $scope.description = "";
        $scope.price = "";
    }
    
    /*$scope.submit=function(){
        
        $scope.$broadcast('show-errors-check-validity');
        
        if ($scope.form.$invalid) { 
            alert("Please check the details you have entered");
            return; 
        }
        
        NewPostService.addNewPost($scope.title,
            $scope.category,
            $scope.location,
            $scope.description,
            $scope.price).then(
              function(successResponse){
                   console.log("Ticket ID is "+successResponse.data);
                   console.log("Success");
                   $location.path("/");
               },
               function(errorResponse){
                 console.log("Failed");
                   $scope.reset();
               }
            );
 
    }*/
    
    $scope.submit=function(){
        
        $scope.$broadcast('show-errors-check-validity');
        
        if ($scope.form.$invalid) { 
            alert("Please check the details you have entered");
            return; 
        }
        console.log('file is ' );
        console.log($scope.filesArray);
        var postData = {};
        var imgToUpload = $scope.filesArray[0];
        postData.title = $scope.title;
        if($scope.price)
            postData.price = $scope.price;
        if($scope.description)
            postData.description = $scope.description;
        postData.location = $scope.location;
        postData.category = $scope.category;
        if(file){
            file.upload = Upload.upload({
              url: '/AdPortal/rest/addpost',
              file: imgToUpload,
              data: postData

            });
        }
        else{
            file.upload = Upload.upload({
              url: '/AdPortal/rest/addpost',
              data: postData

            });
        }
        file.upload.then(function(){
            alert("Your post is saved");
            $location.path("/");
        }, function(){
            alert("Your post is not saved. Please try again later");
            $location.path("/");
        })
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
    $scope.upload = function(files){
        $scope.filesArray.clear;
        for (var i = 0 ; i < files.length ; i++){
            $scope.filesArray.push(files[i])
        }
        console.log("files");
        console.log($scope.filesArray);
    }
    $scope.getCategories();
    $scope.getLocations();
}]);
