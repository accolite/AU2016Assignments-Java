app.factory('BannerService',function($http){
    return{
        logout : function(){
            var req = {
				method: 'POST',
				url: '/AdPortal/logout',
				headers : {
					'cache-control': 'private, max-age=0, no-cache',
					'Pragma': 'no-cache',
					'Expires': "Sat, 01 Dec 2001 00:00:00 GMT"}
			};
            return $http(req);
        },
        getUser : function(){
			var req = {
				method: 'GET',
				url: '/AdPortal/rest/user',
				headers: { 'X-Requested-With' :'XMLHttpRequest'}
			};
			return $http(req);
		}
}});