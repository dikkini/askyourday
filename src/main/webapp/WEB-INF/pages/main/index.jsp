<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"    uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<fmt:requestEncoding value="utf-8" />

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../partitial/head.jsp"/>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/main/css/index.css">
</head>
<body>
<div class="container">
    <div class="main">
        <jsp:include page="../partitial/navigation.jsp"/>
        <div class="body">
            <div class="row text-center">
                <div class="row login-module">
                    <div class="col-xs-5"></div>
                    <sec:authorize access="isAnonymous()">
                        <div class="col-xs-7">
                            <jsp:include page="../partitial/login_form.jsp"/>
                        </div>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        wow wow
                    </sec:authorize>
                </div>
            </div>
        </div>
        <jsp:include page="../partitial/footer.jsp"/>
    </div>
</div>
</body>
</html>