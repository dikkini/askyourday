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
    <div class="row text-center">
        <div class="banner-text">
            <h1 class="responsive-headline">Five Years Calendar</h1>
            <div class="btn-group">
                <button type="button" onclick="location.href='demo';" class="btn btn-warning btn-circle">Demo</button>
                <button type="button" onclick="location.href='login';" class="btn btn-warning btn-circle">Login/Signup</button>
            </div>
            <div>
                <label style="padding-top: 20px;"> or signup using social networks</label>
            </div>
            <ul class="social">
                <li><a target="_blank" href="https://www.facebook.com/?q=#/dikkini"><i class="fa fa-facebook"></i></a></li>
                <li><a target="_blank" href="https://twitter.com/dikkini"><i class="fa fa-twitter"></i></a></li>
                <li><a target="_blank" href="http://vk.com/dikkini"><i class="fa fa-vk"></i></a></li>
            </ul>
        </div>
    </div>
    <p class="scrolldown"><a href="#about" class="smoothscroll"><i class="icon-down-circle color-black"></i></a></p>
</section>

<section id="about">
    <div class="row add-bottom">
        <div class="col-xs-12">
            <h1>This is 5 year question book. Bla bla bla</h1>
            <p class="lead add-bottom">Bla bla bla</p>
            <hr>
        </div>
    </div>
    <p class="scrolldown"><a href="#footer" class="smoothscroll"><i class="icon-down-circle color-black"></i></a></p>
</section>

<footer id="footer">
    <jsp:include page="../partitial/footer.jsp"/>
</footer>

</body>
</html>