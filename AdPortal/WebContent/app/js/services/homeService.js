app.factory('HomeService',function($http){
    return{
        getCategories : function(){
            return $http.get('/AdPortal/rest/getcategories');
        },
        getLocations : function(){
            return $http.get('/AdPortal/rest/getlocations');
        },
        getAllPosts : function(title, category, location, minPrice, maxPrice){
            
            var url = '/AdPortal/rest/getallposts?';
            if(title)
                url += 'title='+title+'&';
            if(category)
                url += 'category='+category+'&';
            if(location)
                url += 'location='+location+'&';
            if(minPrice)
                url += 'minPrice='+minPrice+'&';
            if(maxPrice)
                url += 'maxPrice='+maxPrice+'&';
            
            return $http.get(url);
        },
        deletepostbyid : function(postid){
         var req = {
                    method: 'POST',
                    url: '/AdPortal/rest/deletepost',
                    headers: {
                        'Content-Type': "application/json"
                    },
                    data: angular.toJson(postid),
                    transformRequest: angular.identity
                }
                return $http(req);
        },
        getContactInfo : function(postid){
            return $http.get('/AdPortal/rest/getcontactinfo?postid='+postid);
        },
        contact : function(postid, message){
             var paramsData = { postid: postid, message: message};
            var req = {
                    method: 'POST',
                    url: '/AdPortal/rest/deletepost',
                    headers: {
                        'Content-Type': "application/json"
                    },
                    params: paramsData,
                    transformRequest: angular.identity
                }
                return $http(req);
        }
}});