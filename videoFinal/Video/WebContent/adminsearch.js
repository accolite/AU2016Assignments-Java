app.controller('AppController',['$scope','$http',function($scope,$http){
	/*init(){
		getAllVideos();
	}*/	
	$scope.firstName='charanmovva';
	$scope.params={
		UserName:'charan',
		Topic:'',
		Title:'',
		Event:'',
		date_of_addition:'',
		date_of_Event:''
	};
	$scope.customers=[
			{name:'charan', city:"Bengaluru"},
			{name:'kiran', city:"Coimbatore"},
			{name:'Shubham', city:"hyderabad"},
			{name:'jaswanth', city:"US"}
		];

	$scope.getAllVideos=function(){
		$hhtp({
			method:'GET',
			url:'',
		}).then(function successCallback(response) {
			$scope.videos = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}
}]);