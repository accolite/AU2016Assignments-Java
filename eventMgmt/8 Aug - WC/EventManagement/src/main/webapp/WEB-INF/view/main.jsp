<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>

<html>
<head>
<title>Main</title>


<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/resources/css/angular-material.min.css"
	var="materialCss" />
<spring:url value="/resources/css/style.css" var="mainCss" />
<spring:url value="/resources/css/try2.css" var="tryCss" />


<spring:url value="/resources/Js/jquery.min.js" var="jqueryJs" />
<spring:url value="/resources/Js/angular.js" var="angularJs" />
<spring:url value="/resources/Js/angular-chat-config.js"
	var="angularChatConfigJs" />
<spring:url value="/resources/Js/angular-chat.js" var="angularChatJs" />
<spring:url value="/resources/Js/google-plus-signin.js"
	var="googlePlusJs" />
<spring:url value="/resources/Js/controller.js" var="controllerJs" />
<spring:url value="/resources/Js/bootstrap.min.js" var="bootstrapJs" />
<spring:url value="/resources/Js/ui-bootstrap-1.2.5.js"
	var="uiBootstrapJs" />
<spring:url value="/resources/Js/ui-bootstrap-tpls-1.2.5.js"
	var="uiBootstrapTplsJs" />
<spring:url value="/resources/Js/angular-animate.min.js"
	var="angularAnimateJs" />
<spring:url value="/resources/Js/angular-aria.min.js"
	var="angularAriaJs" />
<spring:url value="/resources/Js/angular-material.min.js"
	var="angularMaterialJs" />
<spring:url value="/resources/Js/directive.js" var="directiveJs" />


<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${materialCss}" rel="stylesheet" />
<link href="${mainCss}" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>

<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body ng-app="EventManagment" ng-controller="EventController"
	style="overflow: scroll">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12"></div>
			<div class="col-md-2">
				<md-card md-theme-watch> 
					<md-card-header>
						<md-card-header-text>
				           <span class="md-title header-white">Admin</span>
				         </md-card-header-text>
					</md-card-header> 
					<md-card-body>
						<ul class="docs-menu">
							<li>
							<button class="md-primary md-button md-ink-ripple" type="button">
						    <div flex layout="row" class="layout-row flex">
								Create Event
							</div>
							<div class="md-ripple-container"></div>
							</button>	
							</li>
							<li>
							<button class="md-primary md-button md-ink-ripple" type="button">
						    <div flex layout="row" class="layout-row flex">
								Add Admin
							</div>
							<div class="md-ripple-container"></div>
							</button>	
							</li>
						</ul>
					</md-card-body>
					
				</md-card>
			</div>
			<div class="col-md-10">
				<md-card>
					<md-card-header>
						<md-card-header-text>
				           <span class="md-title header-white">Events</span>
				         </md-card-header-text>
					</md-card-header> 
				<div class="col-md-12" style="margin-top: 5px">
					<div class="col-md-10" style="margin-top: 5px">
						<input typr="text" placeholder="Search Event....."
							class="form-control form-control-rounded ng-pristine ng-valid ng-touched"
							style="height: 32px; width: 60%;" ng-model="search">
					</div>
				</div>
				<events filterevents='events'></events>
				<div class="col-md-4"></div>
				<div class="col-md-8" data-pagination="" data-num-pages="numPages()"
					data-current-page="currentPage" data-max-size="maxSize"
					data-boundary-links="true"></div>
				<md-card>
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
								<div class="form-group">
									<label for="event-name" class="form-control-label">Name:</label>
									<input type="text" class="form-control" ng-model="event.name">
								</div>
								<div class="form-group">
									<label for="message-text" class="form-control-label">Description:</label>
									<textarea class="form-control" ng-model="event.description"></textarea>
								</div>
								<div class="form-group">
									<label for="event-name" class="form-control-label">Venue:</label>
									<input type="text" class="form-control" ng-model="event.venue">
								</div>
								<div class="form-group">
									<label for="event-name" class="form-control-label">StartTime:</label>
									<input type="text" class="form-control"
										ng-model="event.starttime">
								</div>
								<div class="form-group">
									<label for="event-name" class="form-control-label">EndTime:</label>
									<input type="text" class="form-control"
										ng-model="event.endtime">
								</div>
								<div class="form-group">
									<label for="event-name" class="form-control-label">Type:</label>
									<select class="form-control" ng-model="event.type">
										<option>Individual</option>
										<option>Group</option>
									</select>
								</div>
								<div class="form-group">
									<label for="event-name" class="form-control-label">OrganizerName:</label>
									<input type="text" class="form-control"
										ng-model="event.organizerName">
								</div>
								<div class="form-group">
									<label for="event-name" class="form-control-label">OrganizerEmail:</label>
									<input type="text" class="form-control"
										ng-model="event.organizerEmail">
								</div>





							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary">Save
								changes</button>
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
								<div class="form-group">
									<label for="Admin-name" class="form-control-label">Name:</label>
									<input type="text" class="form-control" ng-model="admin.name">
								</div>
								<div class="form-group">
									<label for="email" class="form-control-label">Email:</label> <input
										type="text" class="form-control" ng-model="admin.email">
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary">Save
								changes</button>
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
	<script src="${uiBootstrapJs}"></script>
	<script src="${uiBootstrapTplsJs}"></script>
	<script src="${angularAnimateJs}"></script>
	<script src="${angularAriaJs}"></script>
	<script src="${angularMaterialJs}"></script>

	<script src="${controllerJs}"></script>
	<script src="${directiveJs}"></script>
</body>
</html>