app.factory('editService',function($http){
    return{
        getCategories : function(){
            return $http.get('/AdPortal/rest/getcategories');
        },
        getLocations : function(){
            return $http.get('/AdPortal/rest/getlocations');
        },
        getPost : function(postid){
            var req = {
                method: 'GET',
                url: '/AdPortal/rest/getpost?postid='+postid,
            }
            return $http(req);
        },
        editPost : function(postid, title, categoryid, locationid, description, price,statusid){
            var postData = {};
            postData.postid = postid;
            postData.title = title;
            if(price)
                postData.price = price;
            if(description)
                postData.description = description;
            postData.location = locationid;
            postData.category = categoryid;
            postData.status=statusid;
            var req = {
                method: 'POST',
                url: '/AdPortal/rest/editpost',
                headers: {
                    'Content-Type': "application/json"
                },
                data: angular.toJson(postData),
                transformRequest: angular.identity
            }
            return $http(req);
        }
}});