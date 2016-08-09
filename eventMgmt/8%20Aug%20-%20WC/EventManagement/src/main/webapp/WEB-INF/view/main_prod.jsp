<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>

<html>
<head>
	<title>Main</title>

	
 <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/resources/css/angular-material.min.css" var="materialCss" />
<spring:url value="/resources/css/style.css" var="mainCss" />
<spring:url value="/resources/css/try2.css" var="tryCss" />


<spring:url value="/resources/Js/jquery.min.js" var="jqueryJs" />
<spring:url value="/resources/Js/angular.js" var="angularJs" />
<spring:url value="/resources/Js/angular-chat-config.js" var="angularChatConfigJs" />
<spring:url value="/resources/Js/angular-chat.js" var="angularChatJs" />
<spring:url value="/resources/Js/google-plus-signin.js" var="googlePlusJs" />
<spring:url value="/resources/Js/controller2_back.js" var="controllerJs" />
<spring:url value="/resources/Js/bootstrap.min.js" var="bootstrapJs" />
<spring:url value="/resources/Js/angular-animate.min.js" var="angularAnimateJs" />
<spring:url value="/resources/Js/angular-aria.min.js" var="angularAriaJs" />
<spring:url value="/resources/Js/ui-bootstrap-1.2.5.js" var="uiBootstrapJs" />
<spring:url value="/resources/Js/ui-bootstrap-tpls-1.2.5.js" var="uiBootstrapTplsJs" />
<spring:url value="/resources/Js/angular-messages.min.js" var="angularMessagesJs" />
<spring:url value="/resources/Js/angular-material.min.js" var="angularMaterialJs" />
<spring:url value="/resources/Js/try2.js" var="tryJs" />
<spring:url value="/resources/Js/directive.js" var="directiveJs" />

<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${materialCss}" rel="stylesheet" />
<link href="${mainCss}" rel="stylesheet" />
<link href="${tryCss}" rel="stylesheet" />



</head>
<body ng-app="EventManagement" ng-controller="EventController" ng-init="getallevents()" style="overflow:scroll">
	<div class="container-fluid" style="padding-left:75px;padding-right:75px;">
		<div class="row" style="margin:0;">
			
			<div class="col-md-12" style="background-color:#eee;box-shadow: 0px 5px 5px 0px rgba(0, 0, 0, 0.2);padding:0;">
				<ul class="topnav" id="myTopnav" style="margin-bottom:5px;">
					<li><a data-toggle="modal" data-target="#myModal">Create Event</a></li>
					<li><a data-toggle="modal" data-target="#myModal1">Add Admin</a></li>
					<li><a data-toggle="modal" data-target="#myModal1">Leader Board</a></li>
					<li><a href="" ng-click="logout()" target="_self">Log Out</a></li>
				</ul>
			</div>

			<div class="col-md-2 " style="padding:0;">
				<div class="col-md-12 " style="padding: 0;margin-bottom: 5px;">
					<input type="text" placeholder="Search Event....." class="form-control form-control-rounded ng-pristine ng-valid ng-touched" style="height: 32px;" ng-model="search">

				</div>
				<div class="col-md-12 tHi  shadow-outside-all" ng-repeat="event in events | filter:search | startFrom:currentPage*pageSize | limitTo:pageSize" style="min-height: 40px;line-height: 1.8;cursor:pointer;font-family: -webkit-pictograph;font-size: 20px;word-wrap: break-word;" ng-class="{cyan : $index == row}"  ng-click="colorRow($index,event.event._id)" >
					{{event.event.name}}
				</div>
				<button ng-disabled="currentPage == 0" ng-click="currentPage=currentPage-1" style="margin-top: 10px;margin-left: 11px;">Previous</button>
				{{currentPage+1}}/{{numberOfPages()}}
				<button ng-disabled="currentPage >= data.length/pageSize - 1" ng-click="currentPage=currentPage+1" style="width:76px;">
					Next
				</button>

			</div>
			<!-- <div class="col-md-10" style="margin-top:5px">
				<div class="col-md-12">
					<div class="col-md-12">{{events[flag].name}}</div>
					<div class="col-md-12">{{events[flag].description}}</div>
					<div class="col-md-12">{{events[flag].start_time}}</div>
					<div class="col-md-12">{{events[flag].end_time}}</div>
				</div>
			</div> -->
			<div class="col-md-10" style="margin-top:5px;padding-right: 0;">
			
			
				<div class="panel panel-primary">
					<div class="panel-heading" style="height: 42px;background-color: #00BCD4;border-color: #00BCD4;">
						<div class="col-md-6"></div>
						<div class="col-md-6" style="    margin-top: -7px;
					}">
					<div class="btn-group-wrap1 ">
						<div class="col-md-12 padding-right-10">
							<button type="button" class="btn btn-default" ng-click="editmode()">Edit</button>
							<button type="button" class="btn btn-default"  data-toggle="modal" data-target="#myModal2" ng-click="addParticipant()">Add Participant</button>
							<button type="button" class="btn btn-default"  data-toggle="modal" data-target="#myModal3" ng-click="getallgroups()">Add Points</button>
							<button type="button" class="btn btn-default"  data-toggle="modal" data-target="#myModal4" ng-click="addPoints()">Delete Event</button>
						</div>
					</div>
				</div>
						<!-- <ul class="topnav" id="myTopnav" style="background-color:#00BCD4">
						<li><a data-toggle="collapse" data-target="#demo">Creat Event</a></li>
							<li><a data-toggle="modal" data-target="#myModal1">Add Admin</a></li>
							<li><a data-toggle="modal" data-target="#myModal1">Leader Board</a></li>
							<li><div ng-click="editmode()">Edit</div></li>
							<li class="icon">
								<a href="javascript:void(0);" onclick="myFunction()">&#9776;</a>
							</li>
						</ul> -->
					</div>
					<div class="panel-body">
						<form>
							<div class="form-group" ng-model="events[flag].event._id">
								<label for="event-name" class="form-control-label">Name:</label>
								<label for="event-name" class="form-control-label" ng-if="!view">{{events[flag].event.name}}</label>
								<input type="text" class="form-control" ng-model="events[flag].event.name" ng-if="view">
							</div>
							<div class="form-group">
								<label for="message-text" class="form-control-label">Description:</label>
								<label for="message-text" class="form-control-label" ng-if="!view">{{events[flag].event.description}}</label>
								<textarea class="form-control" ng-model="events[flag].event.description" ng-if="view"></textarea>
							</div>
							<div class="form-group">
								<label for="event-name" class="form-control-label">Type:</label>
								<label for="event-name" class="form-control-label" ng-if="!view">{{events[flag].event.type}}</label>
								<select class="form-control" ng-model="events[flag].event.type" ng-if="view">
									<option>individual</option>
									<option>group</option>
								</select>
							</div>
							<div class="form-group">
								<label for="event-name" class="form-control-label">Venue:</label>
								<label for="event-name" class="form-control-label" ng-if="!view">{{events[flag].event.venue}}</label>
								<input type="text" class="form-control" ng-model="events[flag].event.venue" ng-if="view">
							</div>
							<div class="form-group">
								<label for="event-name" class="form-control-label">Start Time:</label>
								<label for="event-name" class="form-control-label" ng-if="!view">{{events[flag].event.start_time | date:'yyyy-MM-dd HH:mm:ss Z'}}</label>
								<input type="datetime-local" datetime="yyyy-MM-dd HH:mm:ss" value="{{events[flag].event.start_time | date:'yyyy-MM-dd'}}T{{events[flag].event.start_time | date:'HH:mm:ss'}}" class="form-control" ng-model="events[flag].event.start_time" ng-if="view">
							</div>
							<div class="form-group">
								<label for="event-name" class="form-control-label">End Time:</label>
								<label for="event-name" class="form-control-label" ng-if="!view">{{events[flag].event.end_time | date:'yyyy-MM-dd HH:mm:ss Z'}}</label>
								<input type="datetime-local"  datetime="yyyy-MM-dd HH:mm:ss" value="{{events[flag].event.end_time | date:'yyyy-MM-dd'}}T{{events[flag].event.end_time | date:'HH:mm:ss'}}" class="form-control" ng-model="events[flag].event.end_time" ng-if="view">
							</div>
							<div class="form-group">
								<label for="event-name" class="form-control-label">Organizers:</label>
								<div for="event-name" class="form-control-label" ng-if="!view" ng-repeat="organizer in events[flag].organizers">{{organizer.email}}</div>
								<div ng-repeat="organizer in events[flag].organizers">
								<input type="text" class="form-control" ng-model="organizer.email"   ng-if="view">	<button type="button" ng-click="removeRow(organizer.email)" ng-if="view"> Remove</button>													
							   </div>
							   </div>	
							</div>									
						     <button type="button" class="btn btn-default btn-sm addbt" ng-click="addorganizer1()" ng-if="view">Add more Email
	          						<span class="glyphicon glyphicon-plus"></span>
	       					</button>
							<div class="form-group"  ng-if="view">
								<button type="button" class="btn cyan"  ng-click="updateEvent()" >Update</button>
								<button type="button" class="btn cyan"  ng-click="editmode()">Close</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			

			
			
			






			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Event Description</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form elegant-aero">
							<label for="event-name" class="form-control-label">Name:</label>
							<input type="text" class="form-control" ng-model="event.name" id="event-name">

							<label for="description" class="form-control-label">Description:</label>
							<textarea class="form-control" ng-model="event.description" id="description"></textarea>

							<label for="venue" class="form-control-label">Venue:</label>
							<input type="text" class="form-control" ng-model="event.venue" id="venue">

							<label for="starttime" class="form-control-label">StartTime:</label>
							<input type="datetime-local" class="form-control" ng-model="event.start_time" id="starttime">

							<label for="endtime" class="form-control-label">EndTime:</label>
							<input type="datetime-local" class="form-control" ng-model="event.end_time" id="endtime">

							<label for="grouptype" class="form-control-label">Type:</label>
							<select class="form-control" ng-model="event.type" id="grouptype">
								<option>individual</option>
								<option>group</option>
							</select>
							<label for="organizers" class="form-control-label" >Organizer Email:</label>
							
							<input type="text" class="form-control" data-ng-repeat="email in organizer" id="organizers" ng-model="email.email">
							<button type="button" class="btn btn-default btn-sm addbt" ng-click="addorganizer()">Add more Email
	          					<span class="glyphicon glyphicon-plus"></span>
	       					</button>
						</div>





					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
					data-dismiss="modal">Close</button>
					<button type="button" class="btn cyan" data-dismiss="modal" ng-click="addevent()">Add Event</button>
					</div>
				</div>
			</div>
		</div>


		<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Admin Detail</h4>
			</div>
			<div class="modal-body">
				<form>
					<div class="form elegant-aero">
						<label for="Admin-name" class="form-control-label">Name:</label>
						<input type="text" class="form-control" ng-model="admin.name">

						<label for="email" class="form-control-label">Email:</label>
						<input type="text" class="form-control" ng-model="admin.email">
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary"
				data-dismiss="modal">Close</button>
				<button type="button" class="btn cyan" data-dismiss="modal">Save
					changes</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<h4 class="modal-title" id="myModalLabel">Participant Details</h4>
		</div>
		<div class="modal-body">
			<form>
				<div class="form elegant-aero">
					<label for="text" class="form-control-label">Stage Name:{{global.participantEventId}}</label>
					<input type="text" id="groupname" class="form-control" ng-model="global.participantGroupName">
					
					
						<label for="participants" class="form-control-label" >Participants Email:</label>
							
							<input type="text" class="form-control" data-ng-repeat="participant in participants" id="participants" ng-model="participant.user.email">
							<div ng-if="events[flag].event.type!='individual'">
							<button type="button" class="btn btn-default btn-sm addbt" ng-click="addparticipantAnother()">Add more Email
	          					<span class="glyphicon glyphicon-plus"></span>
	       					</button>
							</div>
				</div>
			</form>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-secondary"
			data-dismiss="modal">Close</button>
			<button type="button" class="btn cyan" data-dismiss="modal" ng-click="addParticipants()">Add Participants</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="myModal3" tabindex="-1" role="dialog"
aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-dialog" role="document">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<h4 class="modal-title" id="myModalLabel">Add Points</h4>
	</div>
	<div class="modal-body">
		<form>
			<div class="form elegant-aero">
				<label class="form-control-label">  Group Name:</label>
				<select  class="form-control points"  ng-model="group.name">
					<option value="">-- Select a Group --</option>
					<option ng-repeat="group in groups"  value="{{group}}" ng-click="findRow(group.group_id)">{{group.group_name}}</option>
				</select>

				<label class="form-control-label">Points:</label>
				<input type="text" class="form-control" ng-model="group.points">

			</div>
		</form>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-secondary"
		data-dismiss="modal">Close</button>
		<button type="button" class="btn cyan" data-dismiss="modal" ng-click="addpoints()">Save
			changes</button>
		</div>
	</div>
</div>
</div>
<div class="modal fade" id="myModal4" tabindex="-1" role="dialog"
aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-dialog" role="document">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<h4 class="modal-title" id="myModalLabel">Delete Event</h4>
	</div>
	<div class="modal-body">
		<b>Do you really want to delete this event ?</b>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-secondary"
		data-dismiss="modal" ng-click="deleteEvent(flag)">Yes</button>
		<button type="button" class="btn cyan" data-dismiss="modal">No</button>
	</div>
</div>
</div>
</div>




</div>

</div>

<script src="${jqueryJs}"></script>
<script src="${angularJs}"></script>
<script src="${angularChatJs}"></script>
<script src="${angularChatConfigJs}"></script>
<script src="${googlePlusJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="${angularAnimateJs}"></script>
<script src="${angularAriaJs}"></script>
<script src="${uiBootstrapJs}"></script>
<script src="${uiBootstrapTplsJs}"></script>
<script src="${angularMessagesJs}"></script>
<script src="${angularMaterialJs}"></script>

<script src="${controllerJs}"></script>
<script src="${tryJs}"></script>
<script src="${directiveJs}"></script>
</body>
</html>