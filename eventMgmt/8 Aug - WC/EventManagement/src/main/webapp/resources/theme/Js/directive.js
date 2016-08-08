/**
 * 
 */

myApp = angular.module('EventManagement');

myApp.directive('events', function(){
	return {
		restrict:'E',
		scope:{
			filterevents: "="
		},
		template:'<div class="col-md-5" ng-repeat="event in filterevents | filter: search" style="background-color: #B3E5FC;'+
			'border-radius: 10px;margin-right:60px;margin-left:26px;margin-top: 15px;">'+
		'<div class="col-md-12">'+
		'	<center class="h4" style="color: #0288D1;">Planned Timings'+
		'	</center>'+
		'</div>'+
		'<div class="col-sm-12 " style="padding-bottom:6px;">'+
		'	<center>'+
		'	<span class="label label-info ng-binding" style="font-size:13px;">Jul 26</span>'+
		'	</center>'+
		'</div>'+
			''+
			'<div class="col-sm-12" style="padding-bottom:10px;">'+
			'<div class="col-sm-5">'+
				'<center>'+
					'<span class="label label-primary ng-binding ng-scope" ng-if="!vm.editMode" style="font-size:15px;"> {{$parent.event.starttime}} PM</span>'+
				'</center>'+
			'</div>'+
			'<div class="col-sm-2">'+
			'	<center><i class="fa fa-arrow-right" aria-hidden="true"></i></center>'+
			'</div>'+
			'<div class="col-sm-5">'+
			'	<center>'+
			'		<span class="label label-primary ng-binding ng-scope" ng-if=	"!vm.editMode" style="font-size:15px;">{{event.endtime}} PM'+
			'		</span>'+
			'	</center>'+
			'</div>'+
		'</div>'+
		'<b>Event Name:</b>{{event.name}}'+
		'<br>'+
		'<b>Description:</b>{{event.description}}'+
		'<br>'+
			'	'+
		'<b>Venue:</b>{{event.venue}}'+
''+
'		<br>'+
''+
'		<b><i>Event Organizer:</i></b><i>{{event.organizerName}}</i>'+
''+
'		<br>'+
''+
'		<b><i>Email:</i></b><i>{{event.organizerEmail}}</i>'+
''+
''+
'	</div>'
	};
	
});

/*var basicApp = angular.module('BasicChat');

basicApp.directive('events', function(){
	return{
		restrict:'E',
		scope:{
			filterevents: "="
		},
		templateUrl: 'resources/template/eventtemplate.html'
    
	};
});*/

