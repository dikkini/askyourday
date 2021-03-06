<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"    uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<fmt:requestEncoding value="utf-8" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/main/css/login.css">

<div class="login">
    <h2><fmt:message key="label.login"/></h2>
    <form id="login-form" action="${pageContext.request.contextPath}/security_check" method="POST">
        <div class="row">
            <input id="email-input" type="text" name="username" placeholder="<fmt:message key="label.email"/>" class="form-control">
        </div>
        <div class="row lower-top-10">
            <input id="password-input" type="password" name="password" placeholder="<fmt:message key="label.password"/>" class="form-control">
        </div>
        <%--<div class="row lower-top-10">--%>
        <%--<a title="Восстановление пароля" href="${pageContext.request.contextPath}/restore">Забыли пароль?</a>--%>
        <%--</div>--%>
        <div class="row lower-top-10">
            <button class="btn btn-danger" type="submit"><fmt:message key="label.btn.login"/></button>
        </div>
        <hr>
        <ul class="social">
            <li><a href="${pageContext.request.contextPath}/login?social=fb"><i class="fa fa-facebook"></i></a></li>
            <li><a href="${pageContext.request.contextPath}/login?social=vk"><i class="fa fa-vk"></i></a></li>
            <li><a href="${pageContext.request.contextPath}/login?social=tw"><i class="fa fa-twitter"></i></a></li>
        </ul>
        <p class="register-text text-center"><fmt:message key="label.text.not_registered"/> <a href="${pageContext.request.contextPath}/signup"><fmt:message key="label.link.signup"/></a></p>
    </form>
</div>