angular.module('Search', [])
.controller('SearchController', ['$scope','$rootScope','$http', function($scope,$rootScope,$http){
 $scope.searchResult = {};
 $scope.user_id = 0;
 $scope.title = '';
 var counter = 1;
 $scope.tempUser='';
 $scope.arr = [];
 $scope.username = [{name:''}];
 
 $scope.increaseArray = function() {
		 arr.push($scope.tempUser);
	 }
 $scope.addInput = function(divName){
	 $scope.username.push({name:''});
         /*var newdiv = document.createElement('div');
         newdiv.innerHTML ="<a style='font-size:26px;font-weight:bold;color:black'>UserName</a>  " +"<input type='text' ng-model='tempUser' onblur='increaseArray()' name='myInputs[]' style='padding-right: 36px;width:40%;height:10%'>";
         document.getElementById(divName).appendChild(newdiv);
        counter++;*/
    
};
 $scope.loadResult = function() {
	
	 $http({
         method : 'GET',
         url : 'http://localhost:8080/VideoPO/spr/SearchTitle'
     }).then(function successCallback(response) {
         
     }, function errorCallback(response) {
         console.log(response.statusText);
     });
 }
 
 $scope.takeSearch = function(id, title) {

	 $http({
         method : 'GET',
         url : 'http://localhost:8080/VideoPO/spr/SearchTitle?id='+ id+'&title='+title
     }).then(function successCallback(response) {
    	 $scope.searchResult = response.data;
     }, function errorCallback(response) {
         console.log(response.statusText);
     });
 }
 $scope.topicSearch = function(id, topic) {

	 $http({
         method : 'GET',
         url : 'http://localhost:8080/VideoPO/spr/SearchTopic?id='+ id+'&topic='+topic
     }).then(function successCallback(response) {
    	 $scope.searchResult = response.data;
     }, function errorCallback(response) {
         console.log(response.statusText);
     });
 }
 $scope.eventSearch = function(id, event) {

	 $http({
         method : 'GET',
         url : 'http://localhost:8080/VideoPO/spr/SearchEvent?id='+ id+'&event='+event
     }).then(function successCallback(response) {
    	 $scope.searchResult = response.data;
     }, function errorCallback(response) {
         console.log(response.statusText);
     });
 }
 $scope.dateSearch = function(id, event) {

	 $http({
         method : 'GET',
         url : 'http://localhost:8080/VideoPO/spr/SearchEvent?id='+ id+'&event='+event
     }).then(function successCallback(response) {
    	 $scope.searchResult = response.data;
     }, function errorCallback(response) {
         console.log(response.statusText);
     });
 }
 $scope.CreateGroup = function(group_name, group_admin) {

	 $http({
         method : 'GET',
         url : 'http://localhost:8081/VideoPO/spr/createGroup?group_name='+group_name+'&admin_name='+group_admin
     }).then(function successCallback(response) {
    	 $scope.searchResult = response.data;
     }, function errorCallback(response) {
         console.log(response.statusText);
     });
 }
}])