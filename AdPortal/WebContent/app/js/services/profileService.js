app.factory('ProfileService',function($http){
    return{
        updateProfile : function(mobile){
            var req = {
				method: 'POST',
				url: '/AdPortal/updateprofile',
                data: angular.toJson(mobile),
                transformRequest: angular.identity
                
			};
            return $http(req);
        },
        getSubscribedCategories : function(){
            return $http.get('/AdPortal/rest/getsubscribedcategories');   
        },
        getCategories : function(){
            return $http.get('/AdPortal/rest/getcategories');
        },
        subscribe: function(categoryid){
            var req = {
				method: 'POST',
				url: '/AdPortal/subscribe',
                data: angular.toJson(categoryid),
                transformRequest: angular.identity
                
			};
            return $http(req);
        },
         unsubscribe: function(categoryid){
            var req = {
				method: 'POST',
				url: '/AdPortal/unsubscribe',
                data: angular.toJson(categoryid),
                transformRequest: angular.identity
                
			};
            return $http(req);
        }
}});