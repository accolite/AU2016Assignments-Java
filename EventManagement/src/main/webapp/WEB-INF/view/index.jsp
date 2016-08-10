<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>

<html>
<head>
<title>Login</title>


<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/resources/css/angular-material.min.css" var="materialCss" />
<spring:url value="/resources/css/style.css" var="mainCss" />
<spring:url value="/resources/css/try2.css" var="tryCss" />
<spring:url value="/resources/css/angular-notys.css" var="notyCss"/>


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
<spring:url value="/resources/Js/angular-notys.js" var="angularnotyJs" />


<spring:url value="/resources/images/event2u2.png" var="logoImage" />

<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${materialCss}" rel="stylesheet" />

<link href="${mainCss}" rel="stylesheet" />
<link href="${notyCss}" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<meta name="viewport" content="width=device-width, initial-scale=1">





</head>
<body ng-app="EventManagement" ng-controller="EventController" id="indexBody">
<div class="col-md-3"></div>
<md-card md-theme="default" md-theme-watch="" class="_md md-default-theme col-md-6" style="background-color:#F5F5F5;margin-top:95px">
	
        <md-card-title>
          <md-card-title-text>
           <span class="md-headline">Welcome to <span style="font-size:40px">event2u</span></span>
            <span class="md-subhead">We welcome you event management app that helps you to manage events.</span>
          </md-card-title-text>
          <md-card-title-media>
            <div class="md-media-lg card-media">
            <img src="${logoImage}" height="100" width="100">
            </div>
          </md-card-title-media>
        </md-card-title>
         <md-card-actions layout="row" layout-align="end center" class="layout-align-end-center layout-row">
           <google-plus-signin
			clientid="598945532802-8fnvuaijr1h10hk5jgsi7a0n66ks9g8h"></google-plus-signin>
        </md-card-actions>
       
      </md-card>
 <div class="col-md-3"></div>


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
<script src="${angularnotyJs}"></script>

<script src="${controllerJs}"></script>


</body>
</html>