<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/manager/home.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script defer src="/js/common/main.js"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>
        <div class="main-content">
            <h1 class="section-title">매니저 홈페이지</h1>

            <div class="menu">

                <div class="menu-board">
                    <div class="bg-board">
                        <div>
                            <h1>게시글 관리</h1>
                        </div>
                        <div>
                            <button class="register-btn"><i class="fas fa-paste fa-5x"></i></button>
                        </div>
                    </div>
                </div>
                <div class="menu-reply">
                    <div  class="bg-reply">
                        <div>
                            <h1>댓글 관리</h1>
                        </div>
                        <div>
                            <button class="register-btn"><i class="fas fa-comments fa-5x"></i></button>
                        </div>
                    </div>
                </div>
                <div class="menu-vacation">
                    <div class="bg-vacation">
                        <div>
                            <h1>휴가 관리</h1>
                        </div>
                        <div>
                            <button class="register-btn"><i class="fas fa-walking fa-5x"></i></button>
                        </div>
                    </div>
                </div>

            </div>   <!-- menu임 -->

        </div>

    </main>

</body>
</html>

