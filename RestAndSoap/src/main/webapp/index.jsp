<html>
<head>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>

<title>AngularJS $http Rest</title>
<script type="text/javascript">
	var app = angular.module("CountryManagement", []);

	//Controller Part
	app
			.controller(
					"CountryController",
					function($scope, $http) {
						$scope.message = {
							msgid : '',
							userid : '',
							msg : "",
							likes : ""

						}
						$scope.comment = {
							msgid : '',
							userid : '',
							comment : ""

						}

						$scope.comment = false;
						$scope.messages = {};

						$scope.getAllMessages = function() {
							$http(
									{
										method : 'GET',
										url : 'http://localhost:8081/sumeet/rest/messages'
									}).then(function successCallback(response) {
								$scope.messages = response.data;
							}, function errorCallback(response) {
								console.log(response.statusText);
							});
						}
						$scope.getAllsMessages = function() {
							$http(
									{
										method : 'GET',
										url : 'http://localhost:8081/sumeet/rest/messages'
									}).then(function successCallback(response) {
								$scope.messages = response.data;
							}, function errorCallback(response) {
								console.log(response.statusText);
							});
							$scope.comment1 = true;
						}
						$scope.getAllComments = function() {
							$http(
									{
										method : 'GET',
										url : 'http://localhost:8081/sumeet/rest/messages/comment'
									}).then(function successCallback(response) {
								$scope.messages = response.data;
							}, function errorCallback(response) {
								console.log(response.statusText);
							});
						}
						$scope.getAlllikes = function() {
							$http(
									{
										method : 'GET',
										url : 'http://localhost:8081/sumeet/rest/messages/like'
									}).then(function successCallback(response) {
								$scope.messages = response.data;
							}, function errorCallback(response) {
								console.log(response.statusText);
							});
						}

						$scope.addmsg = function(userid, msg) {
							console.log($scope.message.userid);
							console.log($scope.message.msg);
							$http(
									{
										method : 'POST',
										url : 'http://localhost:8081/sumeet/rest/messages/'
												+ userid + '/' + msg
									}).then(function successCallback(response) {
								$scope.countries = response.data;
							}, function errorCallback(response) {
								console.log(response.statusText);
							});
						}

						$scope.Addcomment = function(userid, msgid, comment) {
							console.log($scope.message.userid);
							console.log($scope.message.msgid);
							$http(
									{
										method : 'POST',
										url : 'http://localhost:8081/sumeet/rest/messages/'
												+ userid
												+ '/'
												+ msgid
												+ '/'
												+ comment
									}).then(function successCallback(response) {
								$scope.countries = response.data;
							}, function errorCallback(response) {
								console.log(response.statusText);
							});
						}

						$scope.Addlike = function(userid, msgid) {
							console.log($scope.message.userid);
							console.log($scope.message.msg);
							$http(
									{
										method : 'POST',
										url : 'http://localhost:8081/sumeet/rest/messages/likes/'
												+ userid + '/' + msgid
									}).then(function successCallback(response) {
								$scope.countries = response.data;
							}, function errorCallback(response) {
								console.log(response.statusText);
							});
						}

					});
</script>
<head>
<body ng-app="CountryManagement" ng-controller="CountryController">
	<input type="name" ng-model="message.userid" placeholder="UserId">
	<input type="name" ng-model="message.msg" placeholder="Message">

	<input type="button" name="btb" value="Add Messages"
		ng-click="addmsg(message.userid,message.msg)">
	<input type="button" name="btb" value="View all Messages"
		ng-click="getAllMessages()">
	<input type="button" name="btb" value="view all Comment"
		ng-click="getAllComments()">
	<input type="button" name="btb" value="view all likes"
		ng-click="getAlllikes()">
	<input type="button" name="btb" value="Add Comment/Like"
		ng-click="getAllsMessages()">
	<br>
	<div ng-if="comment1" style="margin-top: 5px;">
		<input type="name" ng-model="comment.userid" placeholder="UserId">
		<input type="name" ng-model="comment.msgid" placeholder="msgID">
		<input type="name" ng-model="comment.comment" placeholder="Comment">
		<input type="button" name="btb" value="Comment"
			ng-click="Addcomment(comment.userid,comment.msgid,comment.comment)">
		<input type="button" value="Like"
			ng-click="Addlike(comment.userid,comment.msgid)">
	</div>






</body>
</html>