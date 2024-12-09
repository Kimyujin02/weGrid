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
<script defer src="/js/board/edit.js"></script>

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


            <form action="/board/edit" method="post" enctype="multipart/form-data">
                <div class="main-main">
                    <div class="board-title">
                        <input type="hidden" name="no" value="${vo.no}">
                        <input class="title" type="text" name="title" placeholder="제목을 입력하세요(65자 이내)" maxlength="64"  value="${vo.title}">
                        </input>
                    </div>
                    <div class="board-content">
                        <textarea class="content" name="content" placeholder="내용을 입력하세요(500자 이내)" maxlength="2000">
                            ${vo.content}
                        </textarea>
                    </div>

                    <div class="board-attach">
                        <div class="line-title">첨부파일</div>
                        <div class="line-divider"></div>
                        <div class="inner">
                            <input class="file-button" type="file" name="f" multiple>
                            <div class="info-text">또는 파일을 여기로 드래그 하세요.

                            </div>
                        </div>
                        <div class="board-img-area">
                            <c:forEach items="${attachmentVoList}" var="attachVo">
                                <img src="/img/board/attachment/${attachVo.changeName}" alt="${attachVo.originName}" width="100px" height="100px" onclick="delAttach(${attachVo.no}, '/img/board/attachment/${attachVo.changeName}', this);">
                                <!-- 여기에서 this는 이미지 태그를 말함(이벤트) -->
                            </c:forEach>

                            <input type="file" name="f" multiple> <!-- enctype -->
                            <div class="preview-area">

                            </div>
                        </div>
                    </div>



                    <div class="board-btns">
                        <input type="submit" value="수정하기" class="btn-insert">
                        <button class="btn-cancel">취소</button>
                    </div>

                </div>
            </form>
        </div>
    </main>

</body>
</html>

