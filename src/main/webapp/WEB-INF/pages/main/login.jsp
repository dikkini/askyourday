<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"    uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<fmt:requestEncoding value="utf-8" />

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../partitial/head.jsp"/>
</head>
<body>
<div class="container">
    <div class="main">
        <jsp:include page="../partitial/navigation.jsp"/>
        <div class="body">
            <jsp:include page="../partitial/login_form.jsp"/>
        </div>
        <jsp:include page="../partitial/footer.jsp"/>
    </div>
</div>
</body>
</html>