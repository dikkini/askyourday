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

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/ext/bootstrap-calendar/css/calendar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/main/css/calendar.css">

    <script src="${pageContext.request.contextPath}/assets/ext/bootstrap-calendar/js/language/ru.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/ext/bootstrap-calendar/js/calendar.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/ext/jquery/jquery.elastic.source.js" type="text/javascript" charset="utf-8"></script>

    <script src="${pageContext.request.contextPath}/assets/main/js/calendar.js" type="text/javascript"></script>

</head>
<body>
<div class="container">
    <div class="main">
        <jsp:include page="../partitial/navigation.jsp"/>
        <div class="body">
            <div class="row">
                <div class="col-lg-6">
                    <label id="calendar-title" class="pull-left"></label>
                </div>
                <div class="col-lg-6">
                    <div id="calendar_control-btn-group" class="btn-group">
                        <button data-calendar-nav="prev" class="btn btn-danger"><i class="glyphicon glyphicon-circle-arrow-left"></i></button>
                        <button data-calendar-nav="today" class="btn btn-danger"><i class="fa fa-location-arrow gi-5x"></i></button>
                        <button data-calendar-nav="next" class="btn btn-danger"><i class="glyphicon glyphicon-circle-arrow-right"></i></button>
                    </div>
                </div>
            </div>
            <div class="row">
                <div id="calendar"></div>
            </div>
        </div>
        <jsp:include page="../partitial/footer.jsp"/>
    </div>
</div>
</body>
</html>