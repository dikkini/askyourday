<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"    uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<fmt:requestEncoding value="utf-8" />
<head>
    <!-- Google Tag Manager -->
    <script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
            new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
            j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
            'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
    })(window,document,'script','dataLayer','GTM-NN242JX');</script>
    <!-- End Google Tag Manager -->

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="yandex-verification" content="79c8d78c01d7e0b0" />

    <link rel="apple-touch-icon" sizes="57x57" href="${pageContext.request.contextPath}/assets/main/images/favicon/apple-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="60x60" href="${pageContext.request.contextPath}/assets/main/images/favicon/apple-icon-60x60.png">
    <link rel="apple-touch-icon" sizes="72x72" href="${pageContext.request.contextPath}/assets/main/images/favicon/apple-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/assets/main/images/favicon/apple-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114" href="${pageContext.request.contextPath}/assets/main/images/favicon/apple-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120" href="${pageContext.request.contextPath}/assets/main/images/favicon/apple-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144" href="${pageContext.request.contextPath}/assets/main/images/favicon/apple-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152" href="${pageContext.request.contextPath}/assets/main/images/favicon/apple-icon-152x152.png">
    <link rel="apple-touch-icon" sizes="180x180" href="${pageContext.request.contextPath}/assets/main/images/favicon/apple-icon-180x180.png">
    <link rel="icon" type="image/png" sizes="192x192"  href="${pageContext.request.contextPath}/assets/main/images/favicon/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/assets/main/images/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="96x96" href="${pageContext.request.contextPath}/assets/main/images/favicon/favicon-96x96.png">
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/assets/main/images/favicon/favicon-16x16.png">
    <link rel="manifest" href="${pageContext.request.contextPath}/assets/main/images/favicon/manifest.json">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
    <meta name="theme-color" content="#ffffff">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/ext/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/ext/fonts/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/ext/fonts/fontello/css/fontello.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/ext/fonts/fonts.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/main/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/main/css/default.css">


    <script src="${pageContext.request.contextPath}/assets/ext/jquery/jquery.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/assets/ext/jquery/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
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

        var javascriptStrings = new Array();
        javascriptStrings['label.calendar.save'] = "<spring:message code='label.calendar.save' javaScriptEscape='true' />";
        javascriptStrings['WrongDayQuestion'] = "<spring:message code='WrongDayQuestion' javaScriptEscape='true' />";

    </script>
</head>