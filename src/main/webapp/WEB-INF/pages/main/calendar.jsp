<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"    uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<fmt:requestEncoding value="utf-8" />

<jsp:include page="../partitial/head.jsp"/>

<title><fmt:message key="label.calendar.title"/></title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/main/css/calendar.css">

<script src="${pageContext.request.contextPath}/assets/main/js/calendar.js" type="text/javascript"></script>

<div class="container">
    <div class="main">
        <jsp:include page="../partitial/navigation.jsp"/>
        <div class="body">
            <div class="container-fluid">
                <div id="calendar">
                    <div class="control row">
                        <div class="col-lg-10">
                            ОКТЯБРЬ - 2017
                        </div>
                        <div class="col-lg-2">
                            <- - ->
                        </div>
                    </div>
                    <div class="cal-weekdays cal-fluid row">
                        <div class="cal-weekday col-md-3 col-sm-4 col-xs-6">ПН</div>
                        <div class="cal-weekday col-md-3 col-sm-4 col-xs-6">ВТ</div>
                        <div class="cal-weekday col-md-3 col-sm-4 col-xs-6">СР</div>
                        <div class="cal-weekday col-md-3 col-sm-4 col-xs-6">ЧТ</div>
                        <div class="cal-weekday col-md-3 col-sm-4 col-xs-6">ПТ</div>
                        <div class="cal-weekday col-md-3 col-sm-4 col-xs-6">СБ</div>
                        <div class="cal-weekday col-md-3 col-sm-4 col-xs-6">ВС</div>
                    </div>
                    <div class="cal-days">
                        <div class="cal-week cal-fluid row">
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">1</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">2</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">3</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">4</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">5</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">6</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">7</span>
                            </div>
                        </div>
                        <div class="cal-week cal-fluid row">
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">8</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">9</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">10</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">11</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">12</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">13</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">14</span>
                            </div>
                        </div>
                        <div class="cal-week cal-fluid row">
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">15</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">16</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">17</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">18</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">19</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">20</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">21</span>
                            </div>
                        </div>
                        <div class="cal-week cal-fluid row">
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">22</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">23</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">24</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">25</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">26</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">27</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">28</span>
                            </div>
                        </div>
                        <div class="cal-week cal-fluid row">
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">29</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">30</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number">31</span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number"></span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number"></span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number"></span>
                            </div>
                            <div class="cal-day col-md-3 col-sm-4 col-xs-6">
                                <span class="cal-day-number"></span>
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