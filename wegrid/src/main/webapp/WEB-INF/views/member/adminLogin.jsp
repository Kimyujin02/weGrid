<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>

<link rel="stylesheet" href="/css/member/adminLogin.css">
<script defer src="/js/member/adminLogin.js"></script>

</head>
<body>
    <script>
        <c:if test="${not empty alertMsg}">
            alert('${sessionScope.alertMsg}');
        </c:if>
        <c:remove var="alertMsg" scope="session" />
    </script>

    <div class="top1"></div>

    <div class="login-menu">
        <div class="mode-text">관리자 모드</div>
        <div class="logo-area">
            <img src="/img/admin_login_logo.svg" alt="">
        </div>
        <div class="blank2"></div>

        <form class="login-area" method="post">
            <div></div>
            <div class="input-area">
                <div class="id-text">
                    ID&nbsp;&nbsp;&nbsp; :&nbsp;
                    <input class="id-input" type="text" name="id">
                </div>
                
                <div class="pwd-text">
                    PW&nbsp; :&nbsp;
                    <input class="pwd-input" type="password" name="pwd">
                </div>
            </div>

            <div class="login-button">
                <button type="submit">SIGN IN</button>
            </div>
            <div></div>
        </form>



        <div></div>
    </div>

    <div class="top2"></div>

    <div class="bottom"></div>

</body>
</html>