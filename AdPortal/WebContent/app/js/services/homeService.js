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
        }
}});