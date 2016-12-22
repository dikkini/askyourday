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
    <div style="padding-top: 50px" class="banner container">
        <div class="row">
            <div class="col-lg-6">
                <label id="calendar-title" style="font-size: 25px" class="pull-left"></label>
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

<section id="question-day">
    <div class="row">
        <div class="col-lg-6 col-lg-offset-3 text-center">
            <div class="question">
                <label class="question-header">Why did you do this?</label>
                <textarea class="question-body"></textarea>
            </div>
        </div>
    </div>
    <p class="scrolldown"><a href="#footer" class="smoothscroll"><i class="icon-down-circle color-black"></i></a></p>
</section>

<footer id="footer">
    <jsp:include page="../partitial/footer.jsp"/>
</footer>

</body>
</html>