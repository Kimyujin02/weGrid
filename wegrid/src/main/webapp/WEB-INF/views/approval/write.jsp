<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/approval/write.css">

<script defer src="/js/common/main.js"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>
        <div id="main-area">
           <div></div>
           <div id="use-area">
                <div><h2>결재등록</h2></div>
                <div></div>
                <div id="title-boc">
                    <div><h4 class="subtitle-color">제목</h4></div>
                    <div><input type="text" placeholder="제목을 입력하세요" id="title-a"></div>
                </div>
                <div></div>
                <div id="content-boc">
                    <div></div>
                    <div><h4 class="subtitle-color">내용</h4></div>
                    <div></div>
                    <div></div>
                    <div><textarea name="" id="content-a"></textarea></div>
                    <div></div>
                </div>
                <div></div>
                <div id="menu-boc">
                    <div id="attach-area">
                        <div>
                            <div></div>
                            <div><h4 class="subtitle-color">첨부파일</h4></div>
                            <div></div>
                        </div>
                        <div>파일선택</div>
                    </div>
                    <div></div>
                    <div id="line-area">
                        <div>
                            <div></div>
                            <div><h4 class="subtitle-color">결재선</h4></div>
                            <div></div>
                        </div>
                        <div>등록취소</div>
                    </div>
                    <div id="submitBtnDiv"><button type="button" class="btn btn-primary" id="submit-btn">등록</button></div>
                    <div></div>
                    <div id="cancleBtnDiv"><button type="button" class="btn btn-primary" id="cancle-btn">취소</button></div>
                </div>
           </div>
           <div></div>
           
        </div>
    </main>

</body>
</html>

