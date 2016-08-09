<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>

<html>
<head>
	<title>Main</title>

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

<spring:url value="/resources/Js/moment-with-locales.min.js" var="momentJs" />
<spring:url value="/resources/Js/angular-material-datetimepicker.min.js" var="angularMaterialDateTimeJs" />
<spring:url value="/resources/Js/try2.js" var="tryJs" />
<spring:url value="/resources/Js/directive.js" var="directiveJs" />

<spring:url value="/resources/images/event2u2.png" var="logoImage" />

<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${materialCss}" rel="stylesheet" />

<link href="${mainCss}" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">



</head>
<body ng-app="EventManagement" ng-controller="EventController" ng-init="getallevents()" style="overflow:scroll" id="mainBody">


	<md-content> <md-toolbar layout="row"
		class="custom-tool-bar">
	<table>
		<tr>
			<td><img src="${logoImage}" width="100px"></td>
			<td style="vertical-align: bottom">
				<h1>event2u</h1>
			</td>
		</tr>
	</table>
	</md-toolbar> 
	
	
	<md-toolbar class="md-primary md-hue-1" layout="row"
		style="padding:0px;margin:0px;position:relative;"> 
		<md-nav-bar
		nav-bar-aria-label="navigation links"
		style="margin:auto;margin-left:0"> <md-nav-item
		name="createEventNav" data-toggle="modal" data-target="#myModal">Create
	Event</md-nav-item> <md-nav-item name="addAdminNav" data-toggle="modal"
		data-target="#myModal1">Add Admin</md-nav-item> 
		<md-nav-item name="logoutNav" ng-click="logout()" target="_self">Log
	Out</md-nav-item> 
	</md-nav-bar> 
	</md-toolbar> 
	
	
	<md-content class="md-padding _md">
	<section>
	
		<md-content class="col-md-3 col-xs-12">
		<md-card>
		<md-card-title class="custom-tool-bar layout-padding">
		<md-card-title-text><h1 style="margin:auto">Event List</h1></md-card-title-text>
		</md-card-title>
		<md-content style="overflow:hidden">
		<div class="col-md-12">
		<div>
			<md-input-container style="width:100%"> <label>Search</label>
			<input ng-model="search"> </md-input-container>
		</div>
		<div>
		<div class="col-md-12 tHi shadow-outside-all"
			ng-repeat="event in events | filter:search | startFrom:currentPage*pageSize | limitTo:pageSize"
			style="min-height: 40px; line-height: 1.8; cursor: pointer; font-size: 20px; word-wrap: break-word;"
			ng-class="{cyan : $index == row}"
			ng-click="colorRow($index,event.event._id)"
			ng-cloak>
			{{event.event.name}}</div>
			</div>
			</div>
			
		<md-card-actions layout="row" class="col-md-12" layout-align="end center" ng-cloak>
		<md-button class="md-fab md-mini"
			ng-disabled="currentPage == 0" ng-click="currentPage=currentPage-1">
		<i class="material-icons" style="margin:5px 2px">keyboard_arrow_left</i> </md-button>
		{{currentPage+1}}/{{numberOfPages()}} <md-button
			class="md-fab md-mini"
			style="margin:5px 2px"
			ng-disabled="currentPage >= events.length/pageSize - 1"
			ng-click="currentPage=currentPage+1""> <i
			class="material-icons" style="margin:5px 2px">keyboard_arrow_right</i> </md-button> </md-card-actions> </md-content> 
			
			</md-card>
			
		</md-content>
		<md-content class="col-md-9 col-xs-12">


			<md-card> 
			<md-card-title class="custom-tool-bar layout-padding">
			<md-card-title-text layout="row">
				<div class="form-group col-md-9">
					<h1 class="event-header" ng-if="!view" ng-cloak>{{events[flag].event.name}}</h1>
					<md-input-container ng-if="view" class="col-md-6 col-xs-12 padding-less"> <label>Event Name</label>
					<input ng-model="events[flag].event.name"> </md-input-container>
				</div>
				<div class="col-md-3" layout="row" layout-align="end start">
			
			<md-button
			data-toggle="modal" data-target="#myModalLeaderboard" 
			ng-click="getallgroups()"
			class="md-fab md-mini"
			style="background-color:#31b0d5; border:1px solid #269abc"
			ng-if="!view"
			> <i class="material-icons" style="margin:5px 2px">grade</i>
			</md-button>
					
			<md-button 
			ng-click="editmode()"
			class="md-fab md-mini"
			ng-if="!view"
			> <i class="material-icons" style="margin:5px 2px">mode_edit</i>
			</md-button>
					
			<md-button 
			data-toggle="modal" data-target="#myModal4"
			class="md-fab md-mini md-warn"
			ng-if="!view"
			> <i class="material-icons" style="margin:5px 2px">delete</i>
			</md-button>
			
				</div>
			</md-card-title-text> 
			</md-card-title> 
			<md-content layout-align="space-between" class="layout-padding">
			<div>
				<form>

					<div class="form-group">
						<md-input-container class="md-block" ng-if="view">
				          <label>Description</label>
				          <textarea ng-model="events[flag].event.description" md-maxlength="150" rows="5" md-select-on-focus></textarea>
				        </md-input-container>
						<div ng-if="!view">
						<h3 class="event-sub-header">About</h3>
						<span ng-cloak>{{events[flag].event.description}}</span>
						</div>
					</div>
					<div class="form-group">
						<div layout="row">
						<div ng-if="!view"  class="col-md-6 col-xs-12 padding-less">
							<h4 class="event-sub-header">Venue</h4> 
							<span ng-cloak>{{events[flag].event.venue}}</span>
							</div>
							<md-input-container ng-if="view" class="col-md-6 col-xs-12 padding-less"> <label>Venue</label>
							<input ng-model="events[flag].event.venue"> </md-input-container>
						<div ng-if="!view" class="col-md-6 col-xs-12 padding-less">
							<h4 class="event-sub-header">Type</h4> 
							<span ng-cloak>{{events[flag].event.type}}</span>
							</div>
						<md-input-container ng-if="view" class="col-md-6 col-xs-12 padding-less">
					        <label>Type</label>
					        <md-select ng-model="events[flag].event.type">
					          <md-option>individual</md-option>
							  <md-option>group</md-option>
					        </md-select>
					      </md-input-container>
						</div>
					</div>
					<div class="form-group">
						<div layout="row">
						<div ng-if="!view"  class="col-md-6 col-xs-12 padding-less">
							<h4 class="event-sub-header">Start Time</h4> 
							<span class="btn btn-success" ng-cloak>{{events[flag].event.start_time |
							date:'dd-MMM-yyyy HH:mm'}}</span>
							</div>
							<md-input-container class="col-md-6 col-xs-12 padding-less" ng-if="view" ng-cloak>
			                    <label>Start time</label>
			                    <input type="datetime-local"
								datetime="yyyy-MM-dd HH:mm"
								value="{{events[flag].event.start_time | date:'yyyy-MM-dd'}}T{{events[flag].event.start_time | date:'HH:mm'}}"
								class="form-control" ng-model="events[flag].event.start_time"
								min="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(java.util.Calendar.getInstance().getTime())
   								%>">
			                </md-input-container>
							<div ng-if="!view" class="col-md-6 col-xs-12 padding-less">
							<h4 class="event-sub-header">End Time</h4> 
							<span class="btn btn-warning" ng-cloak>{{events[flag].event.end_time |
							date:'dd-MMM-yyyy HH:mm'}}</span>
							</div>
							<md-input-container class="col-md-6 col-xs-12 padding-less" ng-if="view" ng-cloak>
			                    <label>End time</label>
			                    <input type="datetime-local"
								datetime="yyyy-MM-dd HH:mm"
								value="{{events[flag].event.end_time | date:'yyyy-MM-dd'}}T{{events[flag].event.end_time | date:'HH:mm'}}"
								class="form-control" ng-model="events[flag].event.end_time"
								>
			                </md-input-container>
							</div>
							</div>
					</div>
					
					<div class="form-group">
						<h4 class="event-sub-header">Organizers</h4>
						<div for="event-name" class="form-control-label" ng-if="!view"
							ng-repeat="organizer in events[flag].organizers" ng-cloak>{{organizer.email}}</div>
						<div ng-if="view" ng-repeat="organizer in events[flag].organizers">
							<md-input-container>
						        <label>Email</label>
						        <input ng-model="organizer.email" type="email">
						      </md-input-container>
							<md-button class="md-fab md-mini md-warn" ng-click="removeRow(organizer.email)">
								<i class="material-icons" style="margin:5px 2px">clear</i>
							</md-button>
						</div>
					</div>
			
			<md-button class="md-primary addbt"
				ng-click="addorganizer1()" ng-if="view">
				Add more email
			</md-button>
			<div class="form-group" ng-if="view">
				<button class="btn btn-info" ng-click="updateEvent()">Update</button>
				<button class="btn" ng-click="editmode()">Close</button>
			</div>
			</form>
			</div>
		<md-card-actions layout="row" layout-align="end center">
		<md-button class="md-primary" data-toggle="modal" data-target="#myModal2"
			ng-click="addParticipant()" ng-if="!view">Add Participant</md-button> 
		<md-button class="md-primary" data-toggle="modal" data-target="#myModal3" ng-click="getallgroups()" ng-if="!view">Add
		Points</md-button>
		</md-card-actions> 
		</md-content>
		</md-card>
	</md-content>
	</section>
	</md-content>
	</md-content>











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
							<md-input-container class="col-md-12 col-xs-12">
							<label>Name</label>
							<input ng-model="event.name">
							</md-input-container>
							
							<md-input-container class="col-md-12 col-xs-12">
							<label>Description</label>
				        	<textarea ng-model="event.description" md-maxlength="150" rows="5" md-select-on-focus></textarea>
				        	</md-input-container>
							
							<md-input-container class="col-md-12 col-xs-12">
							<label>Venue</label>
							<input ng-model="event.venue">
							</md-input-container>
							
							<label for="grouptype" class="form-control-label">Type</label>
							<md-input-container class="col-md-12 col-xs-12 padding-less">
					        <select class="form-control" ng-model="event.type" id="grouptype">
								<option>individual</option>
								<option>group</option>
							</select>
					      </md-input-container>
					      
							<md-input-container class="col-md-12 col-xs-12">
							<label>StartTime</label>
							<input type="datetime-local" datetime="yyyy-MM-dd HH:mm" ng-model="event.start_time">
							</md-input-container>
							
							<md-input-container class="col-md-12 col-xs-12">
							<label>EndTime</label>
							<input type="datetime-local" datetime="yyyy-MM-dd HH:mm" ng-model="event.end_time">
							</md-input-container>
							
							
							
							<h4>Organizer Email</h4>
							
							<md-input-container data-ng-repeat="email in organizer" class="col-md-12 col-xs-12">
							<input ng-model="email.email">
							</md-input-container>
							
							<md-button class="md-primary addbt"
								ng-click="addorganizer()">
								Add more email
							</md-button>
						</div>





					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
					data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal" ng-click="addevent()">Add Event</button>
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
						<md-input-container class="col-md-12">
						<label>Email</label>
						<input type="email" ng-model="admin.email">
						</md-input-container>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary"
				data-dismiss="modal">Close</button>
				<button class="btn btn-info" data-dismiss="modal"  ng-click="addAdmin()">Save
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
					<md-input-container class="col-md-12">
					<label>Stage Name</label>
					<input type="text" id="groupname" class="form-control" ng-model="global.participantGroupName">
					</md-input-container>
					
							<md-input-container data-ng-repeat="participant in participants" class="col-md-12">
							<label for="participants" class="form-control-label" >Participant Email</label>
							<input type="text" class="form-control" id="participants" ng-model="participant.user.email">
							</md-input-container>
							
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
			<button type="button" class="btn btn-info" data-dismiss="modal" ng-click="addParticipants()">Add Participants</button>
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

				<md-input-container>
				<label class="form-control-label">Points</label>
				<input type="text" class="form-control" ng-model="group.points">
				</md-input-container>

			</div>
		</form>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-secondary"
		data-dismiss="modal">Close</button>
		<button type="button" class="btn btn-info" data-dismiss="modal" ng-click="addpoints()">Save
			changes</button>
		</div>
	</div>
</div>
</div>

<div class="modal fade" id="myModalLeaderboard" tabindex="-1" role="dialog"
aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-dialog" role="document">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<h4 class="modal-title" id="myModalLabel">Leaderboard</h4>
	</div>
	<div class="modal-body">
		<form>
			<div class="form elegant-aero">
				<label class="form-control-label"></label>
				
				<div ng-repeat="group in groups">
				
				<h5 class="event-sub-header">{{group.group_name}}</h5>
				<span>{{group.points}}</span>
				</div>
				
			</div>
		</form>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-secondary"
		data-dismiss="modal">Close</button>
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
		<button type="button" class="btn" data-dismiss="modal">No</button>
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
<script src="${directiveJs}"></script>
</body>
</html>