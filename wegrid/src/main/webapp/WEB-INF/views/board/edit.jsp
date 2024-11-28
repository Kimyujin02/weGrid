<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/board/edit.css">
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
                    <h1 class="section-title">게시글 수정</h1>
                    <div class="notice-check">
                        공지사항<input class="is-notice" type="checkbox" name="title">
                        </input>
                    </div>
                </div>
            </div>

            <div class="main-main">
                <div class="board-title">
                    <input class="title" type="text" name="title" placeholder="제목을 입력하세요(65자 이내)" maxlength="64">
                    </input>
                </div>
                <div class="board-content">
                    <textarea class="content" name="content" placeholder="내용을 입력하세요(500자 이내)" maxlength="500"></textarea>
                </div>

                <div class="board-attach">
                    <div class="line-title">첨부파일</div>
                    <div class="line-divider"></div>
                    <div class="inner">
                        <button class="file-button" onclick="document.getElementById('input').click()">파일 선택</button>
                        <input type="file" id="input" style="display: none;">
                        <div class="info-text">또는 파일을 여기로 드래그 하세요.</div>
                    </div>
                </div>

                <div class="board-btns">
                    <button class="btn-insert">작성하기</button>
                    <button class="btn-cancel">취소</button>
                </div>

            </div>
        </div>
    </main>

</body>
</html>

