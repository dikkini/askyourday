<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<fmt:requestEncoding value="utf-8" />

<jsp:useBean id="SIGNUP_ERROR" scope="request" class="java.lang.String"/>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../partitial/head.jsp"/>

    <script src="${pageContext.request.contextPath}/assets/main/js/login.js" type="text/javascript" charset="utf-8"></script>

    <title>5 years calendar</title>
</head>
<body>

<header id="header">
    <jsp:include page="../partitial/header.jsp"/>
</header>

<section id="login">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" data-dismiss="modal" aria-label="Close" class="close"><span aria-hidden="true">×</span></button>
                <h5 class="modal-title">
                    <label><a id="login_tab" href="javascript:void(0)" class="login_form">ВОЙТИ</a></label><small>  или</small>
                    <label class="color-orange"><a id="signup_tab" href="javascript:void(0)" class="login_form">ЗАРЕГИСТРИРУЙТЕСЬ</a></label>
                </h5>
            </div>
            <div class="modal-body">
                <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                    <div class="error-message">
                        Ошибка входа <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.localizedMessage}"/>.
                    </div>
                </c:if>
                <c:if test="${not empty SIGNUP_ERROR}">
                    <div class="error-message">
                        Ошибка регистрации <c:out value="${SIGNUP_ERROR}"/>.
                    </div>
                </c:if>
                <form id="logsig-form" method="post" action="${pageContext.request.contextPath}/security_check">
                    <div style="padding-bottom: 5px" class="row">
                        <div class="col-lg-12">
                            <div id="error-alert" role="alert" style="display: none;" class="alert alert-danger">
                                <button type="button" data-dismiss="alert" aria-label="Close" class="close"><span aria-hidden="true">&times;</span></button><strong id="error-data"></strong>
                            </div>
                        </div>
                    </div>
                    <div style="padding-bottom: 5px" class="row">
                        <div class="col-lg-6"><span><i class="glyphicon glyphicon-user"></i> НИКНЕЙМ</span></div>
                        <div class="col-lg-6"><span><i class="glyphicon glyphicon-lock"></i> ПАРОЛЬ</span></div>
                    </div>
                    <div style="padding-bottom: 5px;" class="row">
                        <div class="col-lg-6">
                            <div class="input-group">
                                <input id="username_input" type="text" name="username" placeholder="Введите никнейм" class="form-control"><span id="username_input-success" aria-hidden="true" style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span><span id="username_input-failed" aria-hidden="true" style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="input-group">
                                <input id="password_input" type="password" name="password" placeholder="Введите пароль" class="form-control"><span id="password_input-success" aria-hidden="true" style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span><span id="password_input-failed" aria-hidden="true" style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                            </div>
                        </div>
                    </div>
                    <div id="signup_part_form" style="display: none;">
                        <div style="padding-bottom: 5px;" class="row">
                            <div class="col-lg-6"><span><i class="glyphicon glyphicon-envelope"></i> ПОЧТА</span></div>
                            <div class="col-lg-6"><span><i class="glyphicon glyphicon-lock"></i> ПОВТОРИТЕ ПАРОЛЬ</span></div>
                        </div>
                        <div style="padding-bottom: 5px;" class="row">
                            <div class="col-lg-6">
                                <div class="input-group">
                                    <input id="email_input" type="text" name="email" placeholder="Введите эл. почту" class="form-control" disabled="disabled"><span id="email_input-success" aria-hidden="true" style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span><span id="email_input-failed" aria-hidden="true" style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="input-group">
                                    <input id="password_confirm_input" type="password" placeholder="Введите повторный пароль" class="form-control"><span id="password_confirm_input-success" aria-hidden="true" style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span><span id="password_confirm_input-failed" aria-hidden="true" style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div style="padding-bottom: 5px;" class="row">
                        <div class="col-lg-12">
                            <label style="float: right;">
                                <input id="show_password_cb" type="checkbox" style="margin-right: 5px;">Показать пароль
                            </label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <ul class="social">
                                <li><a target="_blank" href="https://www.facebook.com/?q=#/dikkini"><i class="fa fa-facebook"></i></a></li>
                                <li><a target="_blank" href="https://twitter.com/dikkini"><i class="fa fa-twitter"></i></a></li>
                                <li><a target="_blank" href="http://vk.com/dikkini"><i class="fa fa-vk"></i></a></li>
                            </ul>
                        </div>
                        <div class="col-lg-6">
                            <button id="login_btn" type="submit" class="btn btn-warning btn-block">Войти</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
</html>