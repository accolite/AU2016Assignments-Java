<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>

<html>
<head>
<title>Try</title>


<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/resources/css/angular-material.min.css" var="materialCss" />
<spring:url value="/resources/css/style.css" var="mainCss" />
<spring:url value="/resources/css/try2.css" var="tryCss" />


<spring:url value="/resources/Js/jquery.min.js" var="jqueryJs" />
<spring:url value="/resources/Js/angular.js" var="angularJs" />
<spring:url value="/resources/Js/angular-chat-config.js" var="angularChatConfigJs" />
<spring:url value="/resources/Js/angular-chat.js" var="angularChatJs" />
<spring:url value="/resources/Js/google-plus-signin.js" var="googlePlusJs" />
<spring:url value="/resources/Js/controller2.js" var="controllerJs" />
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
<body>
<div ng-app="BasicChat">
    <div ng-controller="chatControl" class="chat-container" ng-cloak>
    <div class="chat-messages">
        <events filterevents="messages"></events>
    </div>
    <form ng-submit="send()" class="chat-input">
            <input ng-model="textbox" type="text" autofocus>
            <input type="submit" class="send-icon" value=" ">
            <input type="submit" value=" " class="sent-indicator {{ chat.status }}">
        </form>
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