var library = angular.module("library", ['ngRoute', 'chart.js']); //,'ngAnimate' 
library.config(function($routeProvider) {
	$routeProvider
	.when('/trainer', {
		templateUrl: 'trainer.html',
		controller: 'appController'
	})
	.when('/trainee', {
		templateUrl: 'trainee.html',
		controller: 'appController'
	})
	.when('/admin/createNewSessiontest', {
		templateUrl: 'createNewSessiontest.html',
		controller: 'appController1'
	})
	.when('/trainee/TraineeFeedbacktest', {
		templateUrl: 'TraineeFeedbacktest.html',
		controller: 'appController2'
	})
	.when('/admin/FeedbackManagerAdmin', {
		templateUrl: 'FeedbackManagerAdmin.html',
		controller: 'appController3'
	})
	.when('/trainee/traineePoll', {
		templateUrl: 'traineePoll.html',
		controller: 'appController4'
	})
	.when('/trainer/trainerPoll', {
		templateUrl: 'trainerPoll.html',
		controller: 'appController5'
	})
	.when('/trainer/inviteTrainee', {
		templateUrl: 'inviteTrainee.html',
		controller: 'appController6'
	})
	.when('/trainer/sendNotification', {
		templateUrl: 'sendNotification.html',
		controller: 'appController7'
	})
	.otherwise({
		redirectTo: '/trainer'
	});;
});




library.controller('appController', function($scope, $http) {
		//angular.element(document).ready(function () {
		$scope.init = function()
				{
				function f(target){
			    	var xhttp = new XMLHttpRequest();
			    	var value;
			    	  xhttp.onreadystatechange = function() {
			    	    if (xhttp.readyState == 4 && xhttp.status == 200) {
			    	      value = xhttp.responseText;
			    	      document.getElementById(target).innerHTML = value;
			    	      document.getElementById(target).value = value;
			    	      if(target == "username")
			                  document.getElementById("user").innerHTML =  value;
			    	      if (value == "admin"){
			      	        document.getElementById("create").style.visibility = "visible";
			      	   		} 
			    	      else if (value == "user"){
			      	        document.getElementById("create").style.visibility = "hidden";
			    	      	}
			    	      
			    	    }
			    	  };
			    	  if(target=="SessionID")
			    		  xhttp.open("GET", "rest/getSessionid", true);
			    	  else
			    	  	  xhttp.open("GET", "rest/getSessionAttribute?attribute="+target, true);
			    	  xhttp.send();
			    }
			    
			    	f("username");
			    	f("role");
			    	f("SessionID");
			    	f("email");
			
			    	
			var url = "rest/getSessions?TrainerID=" + document.getElementById("SessionID").value;
			   console.log(url);
			   $http.get(url).success( function(response) {
			      $scope.trainerdata = response; 
			   });
			   
				var url = "rest/getJoinedSessions?TraineeID=" + document.getElementById("SessionID").value;
				   console.log(url);
				   $http.get(url).success( function(response) {
				      $scope.traineedata = response; 
				   });
				   
				   var url = "rest/getWaitingSessions?TraineeID=" + document.getElementById("SessionID").value;
			       console.log(url);
			       $http.get(url).success( function(response) {
			          $scope.traineewaitdata = response; 
			       });
			       
			       var url = "rest/checkavaltrainer?id=" + document.getElementById("SessionID").value;
			       console.log(url);
			       $http.get(url).success( function(response) {
			          $scope.activetrainer = response; 
			    	   console.log( response );
			       });
			       
			       var url = "rest/checkavaltrainee?id=" + document.getElementById("SessionID").value;
			       console.log(url);
			       $http.get(url).success( function(response) {
			          $scope.activetrainee = response; 
			    	   console.log( response );
			       });
			       
			       var url = "rest/fetchSessionsAdmin?TraineeID=" + document.getElementById("SessionID").value;
			       console.log(url);
			       $http.get(url).success( function(response) {
			          $scope.fetchSessionsAdmin = response; 
			    	   console.log( response );
			       });
			       
			       var url = "rest/fetchFeedbackSessionsTrainee?TraineeID=" + document.getElementById("SessionID").value;
			       console.log(url);
			       $http.get(url).success( function(response) {
			          $scope.fetchFeedbackSessionsTrainee = response; 
			    	   console.log( response );
			       });
			       
			       var url = "rest/getAllUsers";
			       console.log(url);
			       $http.get(url).success( function(response) {
			          $scope.alluserdata = response; 
			       });
			       

				};
				
				angular.element(document).ready(function () {
						$scope.init();

						$scope.tempfilelist = new Array();
				});
		
	setInterval($scope.init, 30000);
			
				
     $scope.getTraineeSessions = function TraineeSessions() 
						{
						   var url = "rest/getJoinedSessions?TraineeID=" + $scope.TraineeID;
						   console.log(url);
						   $http.get(url).success( function(response) {
						      $scope.traineedata = response; 
						   });
						};
						
	$scope.sendInvite = function sendInvite() 
					       {
					          var url = "rest/sendInvite?SessionID=" + $scope.InviteSessionID + "&TrainerID=" + document.getElementById("SessionID").value + "&Emails=" + $scope.InviteEmail;          
					          url = encodeURI( url );
					          console.log( url );
					          $http.get(url).success( function(response) {
					         });
					       };
						
	$scope.sendEmail = function Email() 
							{
							   var url = "rest/sendEmail?SessionID=" + $scope.SessionID + "&Subject=" + $scope.Subject + "&Message=" + $scope.Message;
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
							   var url = "rest/addTrainee?SessionID=" + document.getElementById("MyTraineeSessionID").value + "&UserID=" + document.getElementById("SessionID").value;
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
							}
					
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
							
	$scope.listdownloads = function listdownloads( s )
							{
								   console.log("HERE WITH " + s);
								   var url = "rest/listFiles?SessionID=" + s;							   
								   console.log( url );
								   $http.get(url).success( function(response) {
									   $scope.tempfilelist[s] = response;
									   console.log( response );
									   return response;
								   });
							}
	
		
							
							
 });
 
 library.controller('appController1', function($scope, $http) {

	 
	 
	 $scope.create = function create() 
		{
		 var xmlhttp =new XMLHttpRequest();
		    
		    
		    var sessionName = document.getElementById("sessionName").value;
		    var trainerID =$scope.MyTrainerID;
		    var date = document.getElementById("date").value;
		    var startTime = document.getElementById("startTime").value;
		    var endTime = document.getElementById("endTime").value;
		    var query = "rest/createSession?SessionName=" + sessionName 
		+ "&TrainerID=" + trainerID + 
		         "&Date=" + date + 
		         "&StartTime=" + startTime + 
		         "&EndTime=" + endTime;
		    console.log( query );
		    xmlhttp.onreadystatechange = function() {
		     if(xmlhttp.readyState==4) {
		              document.getElementById("status").innerText = "Done!";
		     }
		    };
		    xmlhttp.open("POST", query , 
		         true);
		    
		    
		    xmlhttp.send();
		    alert('Session has been created.');
		    location.href= "/SpringAU2016Demo/indextest.html#/hometest";
		};
		   
 
 });

 
 library.controller('appController2', function($scope, $http) {

		$scope.avgfeedback = function avgfeedback() 
		{
		   var url = "rest/avgFeedback?SessionID=" + $scope.FeedbackSessionID + "&f1=" + $scope.f1+ "&f2=" + $scope.f2 + "&f3=" + $scope.f3+ "&f4=" + $scope.f4;
		   console.log( url );
		   $http.get(url).success( function(response) {
			      $scope.Common = response; 
			   });
		   alert('Feedback has been submitted.');
		   $window.location.href= "#hometest";
		};
			   

	});
	library.controller('appController3', function($scope, $http) {

		$scope.fetchfeedback = function fetchfeedback() 
		{
		   var url = "rest/fetchFeedback?SessionID=" + $scope.fetchFeedbackSessionID;							   
		   console.log( url );
		   $http.get(url).success( function(response) {
			      $scope.feedbackdata = response; 
			      $scope.labels = ["Knowledge and Presentation", "Method of Presentation", "Question Answering", "Overall Intensity"];
			      $scope.data = [response.feedback1, response.feedback2, response.feedback3, response.feedback4];
		   });
		}
		
		   $scope.createFeedback = function createFeedback() 
			{
			   var url = "rest/feedback?SessionID=" + $scope.FeedbackSessionID;
			   $http.get(url).success( function(response) {
				      $scope.Common = response; 
				   });
			   alert('Feedback has been created.');
			};	   

	});

	
library.controller('appController5', function($scope, $http) {
	
	angular.element(document).ready(function () {
		console.log("Hello");
		var url = "rest/listActivePollTrainer";							   
		url = encodeURI( url );
		console.log( url );
		$http.get(url).success( function(response) {
			      $scope.trainerpolldata = response;
		   
		   });
	});
	
	$scope.addPoll = function addPoll() 
	{
	   var url = "rest/addPoll?q=" + $scope.q + "&o1=" + $scope.o1 + "&o2=" + $scope.o2 + "&o3=" + $scope.o3 + "&o4=" + $scope.o4 + "&SessionID=" + $scope.TrainerPollSessionID;							   
	   url = encodeURI( url );
	   console.log( url );
	   $http.get(url).success( function(response) {
		      $scope.common = response;
	   });
	   alert('Poll has been created.');
	};
	
	$scope.fetchPoll = function fetchPoll() 
	{
	   var url = "rest/fetchPoll?PollID=" + $scope.PollID;							   
	   url = encodeURI( url );
	   console.log( url );
	   $http.get(url).success( function(response) {
		      $scope.polldata = response;
		      
		      $scope.labels1 = [response[4], response[5], response[6], response[7]];
		      $scope.data1 = [response[0], response[1], response[2], response[3]];
	   
	   });
	};
	
	
	$scope.closePoll = function closePoll() 
	{
	   var url = "rest/closePoll?PollID=" + $scope.closePollID;							   
	   url = encodeURI( url );
	   console.log( url );
	   $http.get(url).success( function(response) {
	   });
	};	

});

library.controller('appController4', function($scope, $http) {
	angular.element(document).ready(function () {
		console.log("Hello");
		var url = "rest/listActivePollTrainee";							   
		url = encodeURI( url );
		console.log( url );
		$http.get(url).success( function(response) {
			      $scope.traineepolldata = response;
		   
		   });
	});
	$scope.givePoll = function givePoll() 
						{
						   var url = "rest/givePoll?UserID=" +  document.getElementById("SessionID").value + "&PollID=" + $scope.TraineePollID + "&choice=" + $scope.Choice;
						   console.log( url );
						   $http.get(url).success( function(response) {
							      $scope.Common = response; 
							   });
						   alert('Your Poll has been recorded.');
						}; 	
							
});


library.controller('appController6', function($scope, $http) {
		
			$scope.sendInvite = function sendInvite() 
					       {
					          var url = "rest/sendInvite?SessionID=" + $scope.InviteSessionID + "&TrainerID=" + document.getElementById("SessionID").value + "&Emails=" + $scope.InviteEmail;          
					          url = encodeURI( url );
					          console.log( url );
					          $http.get(url).success( function(response) {
					         });

					          alert('Trainee has been invited.');
						   	  $window.location.href= "#hometest";
					       };					
});

library.controller('appController7', function($scope, $http) {
		
			$scope.sendEmail = function Email() 
							{
							   var url = "rest/sendEmail?SessionID=" + $scope.SessionID + "&Subject=" + $scope.Subject + "&Message=" + $scope.Message;
							   console.log(url);
							   url = encodeURI( url );
							   console.log(url);
							   $http.get(url).success( function(response) {
								      $scope.Common = response; 
								   });
							};
											
});
