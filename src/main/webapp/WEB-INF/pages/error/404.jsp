<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"    uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<fmt:requestEncoding value="utf-8" />

<jsp:include page="../partitial/top.jsp"/>

<title><fmt:message key="label.404.title"/></title>

<div class="container">
    <div class="main">
        <jsp:include page="../partitial/navigation.jsp"/>
        <div class="body">
            <div class="row text-center">
                OOPS. Page Not Found! 404. <a href="${pageContext.request.contextPath}/">Go to main page</a>
            </div>
        </div>
        <jsp:include page="../partitial/footer.jsp"/>
    </div>
</div>
<jsp:include page="../partitial/bottom.jsp"/>