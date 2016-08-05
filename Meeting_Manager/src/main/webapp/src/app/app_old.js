
angular.module('library',["chart.js"])
	.controller('appController', function($scope, $http) {
     $scope.getTraineeSessions = function TraineeSessions() 
						{
						   var url = "rest/getJoinedSessions?TraineeID=" + $scope.TraineeID;
						   console.log(url);
						   $http.get(url).success( function(response) {
						      $scope.traineedata = response; 
						   });
						};
     $scope.getTrainerSessions = function TrainerSessions() 
						{
						   var url = "rest/getSessions?TrainerID=" + $scope.TrainerID;
						   console.log(url);
						   $http.get(url).success( function(response) {
						      $scope.trainerdata = response; 
						   });
						};
	
	$scope.sendEmail = function Email() 
							{
							   var url = "rest/SendEmail?SessionID=" + $scope.SessionID + "&Subject=" + $scope.Subject + "&Message=" + $scope.Message;
							   console.log(url);
							   url = encodeURI( url );
							   console.log(url);
							   $http.get(url).success( function(response) {
								      $scope.Common = response; 
								   });
							};
							
	$scope.createFeedback = function createFeedback() 
							{
							   var url = "rest/feedback?SessionID=" + $scope.FeedbackSessionID;
							   $http.get(url).success( function(response) {
								      $scope.Common = response; 
								   });
							};
	$scope.approve = function approve() 
							{
							   var url = "rest/addTrainee?SessionID=" + $scope.TraineeSessionID + "&UserID=" + $scope.TraineeUserID;
							   $http.get(url).success( function(response) {
								      $scope.Common = response; 
								   });
							}; 
	
	$scope.avgfeedback = function avgfeedback() 
							{
							   var url = "rest/avgFeedback?SessionID=" + $scope.FeedbackSessionID + "&f1=" + $scope.f1+ "&f2=" + $scope.f2 + "&f3=" + $scope.f3+ "&f4=" + $scope.f4;
							   console.log( url );
							   $http.get(url).success( function(response) {
								      $scope.Common = response; 
								   });
							}; 	
	$scope.givePoll = function givePoll() 
							{
							   var url = "rest/givePoll?UserID=" + $scope.TraineePollUserID + "&PollID=" + $scope.TraineePollID + "&choice=" + $scope.Choice;
							   console.log( url );
							   $http.get(url).success( function(response) {
								      $scope.Common = response; 
								   });
							}; 	
													
	$scope.fetchfeedback = function fetchfeedback() 
							{
							   var url = "rest/fetchFeedback?SessionID=" + $scope.fetchFeedbackSessionID;							   
							   console.log( url );
							   $http.get(url).success( function(response) {
								      $scope.feedbackdata = response; 
								      $scope.labels = ["Knowledge and Presentation", "Method of Presentation", "Question Answering", "Overall Intensity"];
								      $scope.data = [response.feedback1, response.feedback2, response.feedback3, response.feedback4];
							   });
							}; 
		$scope.addPoll = function addPoll() 
							{
							   var url = "rest/addPoll?q=" + $scope.q + "&o1=" + $scope.o1 + "&o2=" + $scope.o2 + "&o3=" + $scope.o3 + "&o4=" + $scope.o4;							   
							   url = encodeURI( url );
							   console.log( url );
							   $http.get(url).success( function(response) {
								      $scope.common = response;
							   });
							};
		$scope.fetchPoll = function fetchPoll() 
							{
							   var url = "rest/fetchPoll?PollID=" + $scope.PollID;							   
							   url = encodeURI( url );
							   console.log( url );
							   $http.get(url).success( function(response) {
								      $scope.polldata = response;
								      $scope.labels1 = ["Option1", "Option2", "Option3", "Option4"];
								      $scope.data1 = [response[0], response[1], response[2], response[3]];
							   
							   });
							};
          $scope.sendInvite = function sendInvite() 
							{
							   var url = "rest/sendInvite?SessionID=" + $scope.InviteSessionID + "&TrainerID=" + $scope.InviteTrainerID + "&Emails=" + $scope.InviteEmail;							   
							   url = encodeURI( url );
							   console.log( url );
							   $http.get(url).success( function(response) {
								 });
							};
	
							
 });
