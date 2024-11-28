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

    <div class="top1"></div>

    <div class="login-menu">
        <div class="mode-text">관리자 모드</div>
        <div class="logo-area">
            <img src="/img/admin_login_logo.svg" alt="">
        </div>
        <div class="blank2"></div>
        <div class="input-area">
            <div class="id-text">ID&nbsp;&nbsp;&nbsp; :&nbsp;</div>
            <input class="id-input" type="text">
            <div class="button">
                <button>SIGN IN</button>
            </div>
            <div class="pwd-text">PW&nbsp; :&nbsp;</div>
            <input class="pwd-input" type="text">
            <div class="blank1"></div>
        </div>
        
    </div>

    <div class="top2"></div>

    <div class="bottom"></div>

</body>
</html>