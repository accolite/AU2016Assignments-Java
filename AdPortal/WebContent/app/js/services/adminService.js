app.factory('AdminService',function($http){
    return{
        getCategories : function(){
            return $http.get('/AdPortal/rest/getcategories');
        },
        getLocations : function(){
            return $http.get('/AdPortal/rest/getlocations');
        },
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
        },
        getBlacklists: function(){
         var req = {
                    method: 'GET',
                    url: '/AdPortal/rest/getblacklists'
                }
                return $http(req);
        },
        getAdmins: function(){
         var req = {
                    method: 'GET',
                    url: '/AdPortal/rest/getadmins'
                }
                return $http(req);
        },
        getUsers: function(){
         var req = {
                    method: 'GET',
                    url: '/AdPortal/rest/getusers'
                }
                return $http(req);
        },
        makeAdmin: function(userId){
            var req={
                    method: 'POST',
                    url: '/AdPortal/rest/makeadmin',
                    data: angular.toJson(userId),
                    transformRequest: angular.identity   
            }
            return $http(req);
        },
        blacklist: function(userId){
            var req={
                    method: 'POST',
                    url: '/AdPortal/rest/blacklist',
                    data: angular.toJson(userId),
                    transformRequest: angular.identity   
            }
            return $http(req);
        },
        unblacklist: function(userId){
            var req={
                    method: 'POST',
                    url: '/AdPortal/rest/unblacklist',
                    data: angular.toJson(userId),
                    transformRequest: angular.identity   
            }
            return $http(req);
        }
        
}});