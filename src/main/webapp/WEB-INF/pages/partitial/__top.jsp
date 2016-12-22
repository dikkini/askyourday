<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"    uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<sec:authentication var="user" property="principal"/>

<jsp:useBean id="constants" class="com.fyc.utils.ApplicationConstants" scope="request"/>

<!DOCTYPE HTML>

<html>
<head>
    <title><spring:message code="label.title"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/main/images/favicon.png"/>
    <%--<link rel="stylesheet" type="text/css" href="">--%>

    <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/main/js/utils.js"></script>
</head>

<body>

<div class="header">
    <header>
        <sec:authorize access="isAnonymous()">
            <a href="${pageContext.request.contextPath}/login"><spring:message code="label.login"/></a>
            <a href="${pageContext.request.contextPath}/signup"><spring:message code="label.signup"/></a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <a href="${pageContext.request.contextPath}/logout"><spring:message code="label.logout"/></a>
            ||||
            <a href="${pageContext.request.contextPath}/profile/view"><spring:message code="label.signed"/> <c:out value="${user.lastName}"/> <c:out value="${user.firstName}"/> aka <c:out value="${user.username}"/></a>
        </sec:authorize>
        <div style="float: right;">
            Language : <a href="${requestScope['javax.servlet.forward.servlet_path']}?locale=en">English</a> | <a href="${requestScope['javax.servlet.forward.servlet_path']}?locale=ru">Russia</a>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/">Main page</a>
            <a href="${pageContext.request.contextPath}/request/create">Create request</a>
            <a href="${pageContext.request.contextPath}/request/list">Request list</a>
        </div>
        <br/>
        <br/>
    </header>
</div>
