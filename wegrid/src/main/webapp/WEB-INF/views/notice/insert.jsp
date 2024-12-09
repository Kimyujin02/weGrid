<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/notice/insert.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script defer src="/js/common/main.js"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>
        <div class="main-content">
            <div class="main-head">
                <div class="head-top">
                    <h1 class="section-title">공지사항 작성</h1>
                </div>
            </div>

            <div class="main-main">
                <form action="/notice/insert" method="post" enctype="multipart/form-data">
                    <div class="notice-title">
                        <input class="title" type="text" name="title" placeholder="[공지] 제목을 입력하세요(65자 이내)" maxlength="64">
                        </input>
                    </div>
                    <div class="notice-content">
                        <textarea class="content" name="content" placeholder="내용을 입력하세요(500자 이내)" maxlength="2000"></textarea>
                    </div>

                    <div class="notice-attach">
                        <div class="line-title">첨부파일</div>
                        <div class="line-divider"></div>
                        <div class="inner">
                            <input class="file-button" type="file" name="f" multiple>
                            <div class="info-text">또는 파일을 여기로 드래그 하세요.

                            </div>
                        </div>
                    </div>

                    <div class="notice-btns">
                        <input type="submit" class="btn-insert" value="작성하기">
                        <input type="submit" class="btn-cancel" value="취소하기">
                    </div>
                </form>
            </div>

        </div>
    </main>

</body>
</html>

