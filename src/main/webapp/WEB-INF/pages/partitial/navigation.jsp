<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"    uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<fmt:requestEncoding value="utf-8" />

<sec:authentication var="user" property="principal"/>

<jsp:useBean id="now" class="java.util.Date" />

<div id="nav-anchor"></div>
<div id="navigation" class="nav">
    <div class="locales">
        <a href="?locale=ru"><img width="30" src="${pageContext.request.contextPath}/assets/main/images/ru_locale.png"></a>
        <%--<a href="?locale=en"><img width="30" src="${pageContext.request.contextPath}/assets/main/images/en_locale.png"></a>--%>
    </div>
    <div class="row center">
        <div class="col-xs-2">
            <div class="now">
                <div class="date_number"><fmt:formatDate pattern="dd" value="${now}" /></div>
                <div class="date_month"><fmt:formatDate pattern="MMMM" value="${now}" /></div>
            </div>
        </div>
        <div class="col-xs-4 col-xs-offset-6">
            <h2 id="title" class="white"><spring:message code="label.title"/></h2>
            <div id="menu-nav">
                <ul>
                    <li class="white"><a data-page="${pageContext.request.contextPath}/main" href="${pageContext.request.contextPath}/"><spring:message code="label.nav.main"/></a> | </li>
                    <sec:authorize access="isAnonymous()">
                        <li class="white"><a data-page="${pageContext.request.contextPath}/signup" href="${pageContext.request.contextPath}/signup"><spring:message code="label.nav.signup"/></a></li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <li class="white"><a data-page="${pageContext.request.contextPath}/calendar" href="${pageContext.request.contextPath}/calendar"><spring:message code="label.nav.calendar"/></a> | </li>
                        <li class="white"><a href="${pageContext.request.contextPath}/logout"><spring:message code="label.nav.logout"/></a></li>
                    </sec:authorize>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="ring-left"></div>
<div class="ring-right"></div>