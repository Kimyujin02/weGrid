<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>

<link rel="stylesheet" href="/css/member/login.css">
<script defer src="/js/member/login.js"></script>

</head>
<body>
    <script>
        <c:if test="${not empty loginFailed}">
            alert("${loginFailed}");
        </c:if>
    </script>

    <div class="top1"></div>

    <div class="login-menu">
        <div class="blank1"></div>
        <div class="logo-area">
            <img src="/img/login_logo.svg" alt="">
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
                <button type="submit" value="로그인">SIGN IN</button>
            </div>
            <div></div>
        </form>



        <a class="password-find" href="/member/find.jsp">비밀번호 찾기</a>
    </div>

    <div class="top2"></div>

    <div class="bottom"></div>

</body>
</html>

