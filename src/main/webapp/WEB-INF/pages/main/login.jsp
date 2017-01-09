<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"    uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<fmt:requestEncoding value="utf-8" />

<jsp:include page="../partitial/top.jsp"/>

<title><fmt:message key="label.login.title"/></title>

<div class="container">
    <div class="main">
        <jsp:include page="../partitial/navigation.jsp"/>
        <div class="body">
            <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                <div id="login-error" class="alert alert-danger alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <fmt:message key="BadCredentialsException"/>
                </div>
            </c:if>
            <jsp:include page="../partitial/login_form.jsp"/>
        </div>
        <jsp:include page="../partitial/footer.jsp"/>
    </div>
</div>
<jsp:include page="../partitial/bottom.jsp"/>