app.factory('AdminService',function($http){
    return{
        addCategory : function(category){
         var req = {
                    method: 'POST',
                    url: '/AdPortal/rest/addcategory',
                    data: angular.toJson(category),
                    transformRequest: angular.identity
                }
                return $http(req);
        },
        addLocation : function(location){
         var req = {
                    method: 'POST',
                    url: '/AdPortal/rest/addlocation',
                    data: angular.toJson(location),
                    transformRequest: angular.identity
                }
                return $http(req);
        }
}});