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
        }
}});