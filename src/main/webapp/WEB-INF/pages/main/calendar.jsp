<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<fmt:requestEncoding value="utf-8" />

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../partitial/head.jsp"/>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/ext/bootstrap-calendar/css/calendar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/main/css/calendar.css">

    <script src="${pageContext.request.contextPath}/assets/ext/bootstrap-calendar/js/language/ru-RU.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/ext/bootstrap-calendar/js/calendar.js" type="text/javascript"></script>

    <script src="${pageContext.request.contextPath}/assets/main/js/calendar.js" type="text/javascript"></script>

    <title>5 years calendar</title>
</head>
<body>

<header id="header">
    <jsp:include page="../partitial/header.jsp"/>
</header>

<section id="calendar-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <label id="calendar-title" class="pull-left"></label>
            </div>
            <div class="col-lg-6">
                <div class="btn-group">
                    <button data-calendar-nav="prev" class="btn btn-warning"><i class="glyphicon glyphicon-circle-arrow-left"></i></button>
                    <button data-calendar-nav="today" class="btn btn-warning"><i class="glyphicon glyphicon-record"></i></button>
                    <button data-calendar-nav="next" class="btn btn-warning"><i class="glyphicon glyphicon-circle-arrow-right"></i></button>
                </div>
            </div>
        </div>
        <div class="row">
            <div id="calendar"></div>
        </div>
    </div>
</section>

<footer id="footer">
    <jsp:include page="../partitial/footer.jsp"/>
</footer>

</body>
</html>


<div class="modal fade" id="events-modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3>Event</h3>
            </div>
            <div class="modal-body">
                <textarea class="question-body"></textarea>
            </div>
            <div class="modal-footer">
                <a href="#" data-dismiss="modal" class="btn">Close</a>
            </div>
        </div>
    </div>
</div>