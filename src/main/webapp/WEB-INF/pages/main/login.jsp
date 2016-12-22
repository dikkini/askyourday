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
    <title>5 years calendar</title>
</head>
<body>

<header id="header">
    <jsp:include page="../partitial/header.jsp"/>
</header>

<section id="main">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" data-dismiss="modal" aria-label="Close" class="close"><span aria-hidden="true">×</span></button>
                <h5 class="modal-title">
                    <label><a id="login_tab" href="#login" class="login_form">LOG IN</a></label><small>  or</small>
                    <label class="color-orange"><a id="signup_tab" href="#signup" class="login_form">SIGN UP</a></label>
                </h5>
            </div>
            <div class="modal-body">
                <div id="login_form">
                    <div style="padding-bottom: 5px" class="row">
                        <div class="col-lg-12">
                            <div id="error-alert" role="alert" style="display: none;" class="alert alert-danger">
                                <button type="button" data-dismiss="alert" aria-label="Close" class="close"><span aria-hidden="true">&times;</span></button><strong id="error-message"></strong>
                            </div>
                        </div>
                    </div>
                    <div style="padding-bottom: 5px" class="row">
                        <div class="col-lg-6"><span><i class="glyphicon glyphicon-user"></i> USERNAME</span></div>
                        <div class="col-lg-6"><span><i class="glyphicon glyphicon-lock"></i> PASSWORD</span></div>
                    </div>
                    <div style="padding-bottom: 5px;" class="row">
                        <div class="col-lg-6">
                            <div class="input-group">
                                <input id="username_input" type="text" placeholder="Username" class="form-control"><span id="username_input-success" aria-hidden="true" style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span><span id="username_input-failed" aria-hidden="true" style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="input-group">
                                <input id="password_input" type="password" placeholder="Password" class="form-control"><span id="password_input-success" aria-hidden="true" style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span><span id="password_input-failed" aria-hidden="true" style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="register_form" style="display: none;">
                    <div style="padding-bottom: 5px;" class="row">
                        <div class="col-lg-6"><span><i class="glyphicon glyphicon-envelope"></i> EMAIL</span></div>
                        <div class="col-lg-6"><span><i class="glyphicon glyphicon-lock"></i> REPEAT PASSWORD</span></div>
                    </div>
                    <div style="padding-bottom: 5px;" class="row">
                        <div class="col-lg-6">
                            <div class="input-group">
                                <input id="email_input" type="text" placeholder="Email" class="form-control"><span id="email_input-success" aria-hidden="true" style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span><span id="email_input-failed" aria-hidden="true" style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="input-group">
                                <input id="password_confirm_input" type="password" placeholder="Password" class="form-control"><span id="password_confirm_input-success" aria-hidden="true" style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span><span id="password_confirm_input-failed" aria-hidden="true" style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                            </div>
                        </div>
                    </div>
                </div>
                <div style="padding-bottom: 5px;" class="row">
                    <div class="col-lg-12">
                        <label style="float: right;">
                            <input id="show_password_cb" type="checkbox" style="margin-right: 5px;">Show Password
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
                        <button id="login_btn" type="button" class="btn btn-warning btn-block">Log In</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<footer id="footer">
    <jsp:include page="../partitial/footer.jsp"/>
</footer>

</body>
</html>