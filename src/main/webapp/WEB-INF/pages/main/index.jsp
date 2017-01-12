<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"    uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<fmt:requestEncoding value="utf-8" />

<jsp:include page="../partitial/top.jsp"/>
<script>
    window.fbAsyncInit = function() {
        FB.init({
            appId      : '245876892501434',
            xfbml      : true,
            version    : 'v2.8'
        });
        FB.AppEvents.logPageView();
    };
</script>
<script>
    $(window).bind("load", function() {
        $.getScript("${pageContext.request.contextPath}/assets/main/js/social.js", function() {
            $(".social-like").show();
        });
    });
</script>
<title><fmt:message key="label.index.title"/></title>

<script src="${pageContext.request.contextPath}/assets/main/js/index.js" type="text/javascript" charset="utf-8"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/main/css/index.css">

<div class="container">
    <div class="main">
        <jsp:include page="../partitial/navigation.jsp"/>
        <div class="body">
            <div class="row">
                <sec:authorize access="isAnonymous()">
                <div class="col-xs-9 vertical-line">
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <div class="col-xs-12">
                </sec:authorize>
                    <div class="row">
                        <div class="col-xs-12">
                            <h1 class="header-text"><fmt:message key="label.index.motto"/></h1>
                            <small>
                                <h4 id="motto-text">
                                    <fmt:message key="label.index.motto.descr"/>
                                    <sec:authorize access="isAnonymous()">
                                        <a href="${pageContext.request.contextPath}/signup"><fmt:message key="label.index.motto.descr.register"/></a>
                                        <fmt:message key="label.or"/>
                                        <a href="${pageContext.request.contextPath}/login"><fmt:message key="label.index.motto.descr.login"/></a>
                                        <fmt:message key="label.index.motto.descr2"/>
                                    </sec:authorize>
                                </h4>
                            </small>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2 social-btn">
                            <div class="fb-like" data-href="https://askyourday.com" data-layout="button_count" data-action="like" data-size="small" data-show-faces="false" data-share="false" data-send="false"></div>
                        </div>
                        <div class="col-xs-2 social-btn">
                            <a class="twitter-share-button" href="https://twitter.com/intent/tweet?URL=https%3A//askyourday.com&text=AskYourDay.com%20-%20<fmt:message key="label.index.motto"/>%0A&hashtags=<fmt:message key="label.index.twitter.hashtags"/>" >Tweet</a>
                        </div>
                        <div class="col-xs-2 social-btn">
                            <div id="vk_like"></div>
                            <script type="text/javascript">
                                VK.Widgets.Like("vk_like", {type: "button", height: 20});
                            </script>
                        </div>
                    </div>
                </div>
                <sec:authorize access="isAnonymous()">
                    <div id="login-module" class="col-xs-3">
                        <jsp:include page="../partitial/login_form.jsp"/>
                    </div>
                </sec:authorize>
            </div>
            <hr>
            <div class="row">
                <div id="main-carousel-container" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#main-carousel-container" data-slide-to="0" class="active"></li>
                        <li data-target="#main-carousel-container" data-slide-to="1"></li>
                        <li data-target="#main-carousel-container" data-slide-to="2"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">
                        <div class="item active">
                            <img src="${pageContext.request.contextPath}/assets/main/images/carousel/calendar.png" alt="calendar" class="img-thumbnail">
                            <div class="carousel-caption">
                                <h3><fmt:message key="label.index.carousel.calendar"/></h3>
                            </div>
                        </div>

                        <div class="item">
                            <img src="${pageContext.request.contextPath}/assets/main/images/carousel/calendar_future.png" alt="calendar_future" class="img-thumbnail">
                            <div class="carousel-caption">
                                <h3><fmt:message key="label.index.carousel.calendar_future"/></h3>
                            </div>
                        </div>

                        <div class="item">
                            <img src="${pageContext.request.contextPath}/assets/main/images/carousel/answer.png" alt="answer" class="img-thumbnail">
                            <div class="carousel-caption">
                                <h3><fmt:message key="label.index.carousel.answer"/></h3>
                            </div>
                        </div>
                    </div>

                    <!-- Left and right controls -->
                    <a class="left carousel-control" href="#main-carousel-container" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only"><fmt:message key="label.index.carousel.prev"/></span>
                    </a>
                    <a class="right carousel-control" href="#main-carousel-container" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only"><fmt:message key="label.index.carousel.next"/></span>
                    </a>
                </div>
            </div>
            <hr>
            <div class="row">
                <h3 class="header-text"><fmt:message key="label.index.who_need"/></h3>
                <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingOne">
                            <h4 class="panel-title">
                                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    <fmt:message key="label.index.who_need.text1"/>
                                </a>
                            </h4>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                            <div class="panel-body">
                                <fmt:message key="label.index.who_need.text1.descr"/>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingTwo">
                            <h4 class="panel-title">
                                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                    <fmt:message key="label.index.who_need.text2"/>
                                </a>
                            </h4>
                        </div>
                        <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                            <div class="panel-body">
                                <fmt:message key="label.index.who_need.text2.descr"/>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingThree">
                            <h4 class="panel-title">
                                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                    <fmt:message key="label.index.who_need.text3"/>
                                </a>
                            </h4>
                        </div>
                        <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                            <div class="panel-body">
                                <fmt:message key="label.index.who_need.text3.descr"/>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingFour">
                            <h4 class="panel-title">
                                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                                    <fmt:message key="label.index.who_need.text4"/>
                                </a>
                            </h4>
                        </div>
                        <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
                            <div class="panel-body">
                                <fmt:message key="label.index.who_need.text4.descr"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="../partitial/footer.jsp"/>
    </div>
</div>
<jsp:include page="../partitial/bottom.jsp"/>