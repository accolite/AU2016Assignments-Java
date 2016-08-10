var app=angular.module('VideoPortal',['ngRoute']);
app.controller('AppController',['$scope','$http','$sce',function($scope,$http,$sce){
	
	$scope.start=function(){
		
		
		$scope.admin=false;
		$scope.user=false;
		$scope.grpadmin=false;
		$scope.infoOfGrp=false;
		$scope.addAdmin=false;
		$scope.siteAdmin=false;
		$scope.grpAdmin=false;
		$scope.crtGrp=false;
		$scope.crtEvt=false;
		$scope.grpvid=false;
		$scope.addnames=[{name:""}];
		$scope.apprvid=false;
		$scope.vid_grp={value:''};
		$scope.typeuser();
		$scope.detect();
		$scope.getAllVideos();
		
	};
	
	
	$scope.signOut = function(){
        var auth2 = gapi.auth2.getAuthInstance();
        auth2.signOut().then(function () {
          console.log('User signed out.');
          window.location.href = 'http://localhost:8081/VideoPO/';
        });
      }
	
	$scope.detect=function(){
		$http({
			method:'GET',
			url:'spr/detectUser',
		}).then(function successCallback(response){
			 $scope.UserName = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	};
	
	$scope.typeuser=function(){
		$http({
			method:'GET',
			url:'spr/isSiteAdmin',
		}).then(function successCallback(response) {
			
			$scope.integer = response.data;
			if($scope.integer==1){
				$scope.admin=true;
				$scope.user=false;
				$scope.grpadmin=false;
				$scope.getGrpNames();
				console.log('admin');
			}else if($scope.integer==2){
				$scope.admin=false;
				$scope.user=false;
				$scope.grpadmin=true;
				$scope.groupspecvid();
				console.log('grpadmin');
			}else{
				$scope.admin=false;
				$scope.user=true;
				$scope.groupspecvid();
				$scope.grpadmin=false;
				console.log('user');
			}
			console.log("msc");
		}, function errorCallback(response) {
			console.log("failed");
			console.log(response.statusText);
		});
	};
	
	$scope.check=function(d){
		if(d===null){
			return false;
		}
		return true;
	};
	
	$scope.submitusername = function(group_name) {
		var x = "";
		var bool=true;
		for(var i = 0; i < $scope.addnames.length-1; i++) {
			x = x + $scope.addnames[i].name + ',';
			if($scope.addnames[i].name==''){
				bool=false;
			}
		}
		if($scope.addnames[i].name==''){
			bool=false;
		}
		x = x + $scope.addnames[i].name; 
		if(!(group_name==''||(!bool))){
		$http({
	        method : 'GET',
	        url : 'spr/addMembers?x='+x+'&group_name='+group_name,
	    }).then(function successCallback(response) {
	        console.log("yey adding members");
	    }, function errorCallback(response) {
	        console.log(response.statusText);
	    });}else{
	    	alert("Select/Enter all the Fields");
	    }
	};
	
	 $scope.addEvent=function(event_name, date_of_event)
	 {	if(!(event_name==''||date_of_event=='')){
		 $http({
	         method : 'GET',
	         url : 'spr/addEvent?event_name='+ event_name+'&date_of_event='+date_of_event,
	     }).then(function successCallback(response) {
	    	 $scope.searchResult = response.data;
	     }, function errorCallback(response) {
	         console.log(response.statusText);
	     });}else{
	    	 alert("Select/Enter All Fields");
	     }
	 };
	 $scope.checkgrpexits=function(grpname){
		  $http({
		   method:'GET',
		   url:'spr/checkIfGroupAlreadyExists?groupname='+grpname,
		  }).then(function successCallback(response){
		   $scope.xyz=response.data;
		   if($scope.xyz.name!=undefined){
			   alert("Group Name already exists");
		   }
		  }, function errorCallback(response) {
		   console.log(response.statusText);
		  });
		 };
	 $scope.submitgrp = function(cgroup_name, group_admin) {
		 if(!(cgroup_name==''||group_admin=='')){
			   $http({
			          method : 'GET',
			          url : 'spr/createGroup?group_name='+cgroup_name+'&email_id='+group_admin
			      }).then(function successCallback(response) {
			       $scope.getGrpNames();
			      }, function errorCallback(response) {
			          console.log(response.statusText);
			      });
			   }else{
				   alert("Select/Enter all Fields");
			   }
	 };
	 
	 $scope.videodup=function(url,group_name){
		 $http({
	         method : 'GET',
	         url : 'spr/checkdupVideo?url='+ url+'&groupname='+group_name,
	     }).then(function successCallback(response) {
	    	 $scope.abc = response.data;
	    	 if($scope.abc.video_id==0){
	    		 return true;
	    	 }
	    	 else{
	    		 return false;
	    	 }
	     }, function errorCallback(response) {
	         console.log(response.statusText);
	     });
	 };
	 
	 $scope.addVideo = function(video_url,title,topic,event,group_name) {
		 if(!(video_url==undefined||title==undefined||topic==undefined||event==undefined||group_name==undefined)){
			 if($scope.myVar=='Public'){group_name='';
			 var flag = $scope.videodup(video_url,group_name);
			 if(flag){
				 var k = $scope.group_name;
				 $http({
			         method : 'GET',
			         url : 'spr/addVideo?video_url='+ video_url+'&title='+title+'&topic='+topic+'&event='+event+'&group_name='+group_name
			     }).then(function successCallback(response) {
			    	 $scope.searchResult = response.data;
			    	 console.log("yey video");
			     }, function errorCallback(response) {
			         console.log(response.statusText);
			     });
			 }else{alert("Video is already present");}
			 }
			 else if($scope.myVar=='Private'){
				 if(group_name==''){
					 alert("Select Group");
				 }
				 else{
					 if($scope.videodup(video_url,group_name)){
						 var k = $scope.group_name;
						 $http({
					         method : 'GET',
					         url : 'spr/addVideo?video_url='+ video_url+'&title='+title+'&topic='+topic+'&event='+event+'&group_name='+group_name
					     }).then(function successCallback(response) {
					    	 $scope.searchResult = response.data;
					    	 console.log("yey video");
					     }, function errorCallback(response) {
					         console.log(response.statusText);
					     });
					 }else{alert("Video is already present");}
				 }
			 }
		 }else{alert("Select/Enter the fields");}
	 }
	
	$scope.getAllVideos=function(){
		$http({
			method:'GET',
			url:'spr/getPublicVideo',
		}).then(function successCallback(response) {
			
			$scope.videos = response.data;
			console.log("Successd");
		}, function errorCallback(response) {
			console.log("failed");
			console.log(response.statusText);
		});
	};

	$scope.getGrpNames=function(){
		$http({
			method:'GET',
			url:'spr/listGroup',
		}).then(function successCallback(response){
			$scope.grpNames = response.data;
			console.log("grp success charan");
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}

	$scope.groupinfo=function(dt){
		$scope.groupvid(dt);//infoOfGrp
	}

	$scope.groupvid=function(dt){
		$http({
			method:'GET',
			url:'spr/listGrpVideo?group_id='+dt,
		}).then(function successCallback(response){
			$scope.grpVideos = response.data;
			$scope.grpvid=true;
			$scope.apprvid=false;
			console.log("grp success");
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	};

	
	$scope.addusername = function() {
		$scope.addnames.push({name:""});
		console.log("in push");
	}
	
	$scope.groupspecvid=function(){
		$http({
			method:'GET',
			url:'spr/listGroupForUser',
		}).then(function successCallback(response){
			$scope.usergrps = response.data;
			console.log("acco");
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	};
	
	$scope.addsiteadmin=function(name){
		if(!(name==undefined)){
		$http({
			method:'GET',
			url:'spr/makeAdmin?email_id='+name.email_id,
		}).then(function successCallback(response){
			console.log("site admin");
		}, function errorCallback(response) {
			console.log(response.statusText);
		});}else{
			alert("Select Site Admin");
		}
	};
	
	$scope.setpre=function(){
		$scope.apprvid=false;
		$scope.grpvid=false;
		console.log('yup');
		$scope.getAllVideos();
	};
	
	$scope.fetch=function(){
		$http({
			method:'GET',
			url:'spr/FetchVideosForApproval',
		}).then(function successCallback(response){
			$scope.apprvids = response.data;
			$scope.apprvid=true;
			console.log("Fetching vids");
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	};
	
	$scope.approve=function(id){
		$http({
			method:'GET',
			url:'spr/ApproveVideo?video_id='+id,
		}).then(function successCallback(response){
			console.log("approval done");
			$scope.fetch();
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	};
	

	$scope.reject=function(id){
		$http({
			method:'GET',
			url:'spr/RejectVideo?video_id='+id,
		}).then(function successCallback(response){
			console.log("reject done");
			$scope.fetch();
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	};

	$scope.fetchevents=function(){
		$http({
			method:'GET',
			url:'spr/fetchEvents',
		}).then(function successCallback(response){
			$scope.events = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	};

	$scope.fetchgroups=function(){
		$http({
			method:'GET',
			url:'spr/listofGroupsForWhichHeIsMember',
		}).then(function successCallback(response){
			$scope.memgroup = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	};

	$scope.fetchGroups=function(){
		$http({
			method:'GET',
			url:'spr/listofGroupsForWhichHeIsAdmin',
		}).then(function successCallback(response){
			$scope.grpsforwhich = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	};

	$scope.fetchsiteuser=function(){
		$http({
			method:'GET',
			url:'spr/listAllUsers',
		}).then(function successCallback(response){
			$scope.userforsite = response.data;
			console.log("shrema");
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}

	$scope.myMod1=function(){
		$scope.fetchsiteuser();
		
	};

	$scope.myMod2=function(){
		$scope.vid_grp={value:''};
		$scope.vid_url='';
		$scope.vid_title='';
		$scope.vid_topic='';
		$scope.myVar='Public';
		$scope.fetchevents();
		$scope.fetchgroups();
	};

	$scope.myMod3=function(){
		$scope.addnames=[{name:""}];
		$scope.grp_Name='';
		$scope.groupspecvid();
		$scope.fetchGroups();
	};

	$scope.myMod4=function(){
		$scope.cgroup_name='';
		$scope.group_admin='';
	};

	$scope.myMod5=function(){
		$scope.event_name='';
		$scope.date_of_event='';
	};

}]);


