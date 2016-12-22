<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"    uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<sec:authentication var="user" property="principal"/>

<header id="header">
    <nav id="nav-wrap">
        <ul id="nav" class="nav">
            <li><a data-page="${pageContext.request.contextPath}/main" href="${pageContext.request.contextPath}/">Главная</a></li>
            <sec:authorize access="isAnonymous()">
                <li><a data-page="${pageContext.request.contextPath}/demo" href="${pageContext.request.contextPath}/demo">Демо</a></li>
            </sec:authorize>
            <sec:authorize access="isAnonymous()">
                <li><a data-page="${pageContext.request.contextPath}/login" href="${pageContext.request.contextPath}/login">Вход</a></li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li><a data-page="${pageContext.request.contextPath}/calendar" href="${pageContext.request.contextPath}/calendar">Календарь</a></li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li><a href="${pageContext.request.contextPath}/logout">Logout (<c:out value="${user.username}"/>)</a></li>
            </sec:authorize>
        </ul>
    </nav>
</header>