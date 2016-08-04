app.factory('NewPostService',function($http){
    return{
        getCategories : function(){
            return $http.get('/AdPortal/rest/getcategories');
        },
        getLocations : function(){
            return $http.get('/AdPortal/rest/getlocations');
        },
        addNewPost : function(title, categoryid, locationid, description, price){

            var postData = {};
            postData.title = title;
            if(price)
                postData.price = price;
            if(description)
                postData.description = description;
            postData.location = locationid;
            postData.category = categoryid;
            
            var req = {
                method: 'POST',
                url: '/AdPortal/rest/addpost',
                headers: {
                    'Content-Type': "application/json"
                },
                data: angular.toJson(postData),
                transformRequest: angular.identity
            }
            return $http(req);
        }
}});