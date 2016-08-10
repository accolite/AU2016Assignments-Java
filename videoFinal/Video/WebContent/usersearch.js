app.controller('UserSearch',['$scope','$http',function($scope,$http){
	$hhtp({
		method:'GET',
		url:
	}).then(function successCallback(response) {
		$scope.videos = response.data;
	}, function errorCallback(response) {
		console.log(response.statusText);
	});
}
}]);