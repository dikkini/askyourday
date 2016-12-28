<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@ page import="org.springframework.context.i18n.LocaleContextHolder" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"    uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<fmt:requestEncoding value="utf-8" />

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/main/images/favicon.png"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/ext/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/ext/fonts/font-awesome/css/font-awesome.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/ext/fonts/fontello/css/fontello.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/ext/fonts/fonts.css">
<link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,900" rel="stylesheet">

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/main/css/common.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/main/css/default.css">


<script src="${pageContext.request.contextPath}/assets/ext/jquery/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js" integrity="sha256-UOSXsAgYN43P/oVrmU+JlHtiDGYWN2iHnJuKY9WD+Jg=" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/assets/ext/jquery/jquery-validate.bootstrap-tooltip.min.js" type="text/javascript" charset="utf-8"></script>

<script src="${pageContext.request.contextPath}/assets/ext/bootstrap/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/assets/ext/moment/moment.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/ext/underscore/underscore.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/ext/modernizr.js" type="text/javascript" charset="utf-8"></script>

<script src="${pageContext.request.contextPath}/assets/main/js/init.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/assets/main/js/navigation.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript">
    var validationMessages = new Array();
    validationMessages['validate.required'] = "<spring:message code='validate.required' javaScriptEscape='true' />";
    validationMessages['validate.equalTo'] = "<spring:message code='validate.equalTo' javaScriptEscape='true' />";
    validationMessages['validate.email'] = "<spring:message code='validate.email' javaScriptEscape='true' />";
    validationMessages['validate.maxlength'] = "<spring:message code='validate.maxlength' javaScriptEscape='true' />";
    validationMessages['validate.minlength'] = "<spring:message code='validate.minlength' javaScriptEscape='true' />";
</script>


