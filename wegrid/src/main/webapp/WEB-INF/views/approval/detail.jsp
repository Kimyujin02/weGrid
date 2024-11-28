<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/approval/detail.css">

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
                    <div id="main-boc">
                        <div>
                            <div id="title-boc">
                                <div>
                                  
                                    <div>결재명</div>
                                    <div>집좀 보내주세요</div>
                                </div>
                                <div>
                                    <div>번호</div>
                                    <div>6</div>
                                    <div>기안자</div>
                                    <div>홍길동</div>
                                    <div>부서명</div>
                                    <div>개발1부</div>
                                    <div>진행상태</div>
                                    <div>진행</div>
                                    <div>등록일</div>
                                    <div>2024-11-27</div>
                                </div>
                            </div>
                            <div id="content-boc">
                                <div></div>
                                <div><h4 class="subtitle-color">내용</h4></div>
                                <div></div>
                                <div></div>
                                <div><textarea name="" id="content-a"></textarea></div>
                                <div></div>
                            </div>
                        </div>
                        <div id="pgh">
                            <div id="line-boc">
                                <div></div>
                                <div><h4 class="subtitle-color">결재선</h4></div>
                                <div></div>
                                <div></div>
                                <div>결재선 들어가는곳</div>
                                <div></div>
                            </div>
                            <div></div>
                        </div>
                    </div>
                    <div id="footer-boc">
                        <div id="attach-area">
                            <div></div>
                            <div><h4 class="subtitle-color">첨부파일</h4></div>
                            <div></div>
                            <div></div>
                            <div>첨부파일실제</div>
                            <div></div>
                        </div>
                        <div id="button-area">
                            <div id="allowBtnDiv"><button type="button" class="btn btn-primary" id="allow-btn">승인</button></div>
                            <div id="companionBtnDiv"><button type="button" class="btn btn-primary" id="companion-btn">반려</button></div>
                            <div id="cancleBtnDiv"><button type="button" class="btn btn-primary" id="cancle-btn">취소</button></div>
                        </div>
                    </div>
                    <div></div>
                </div>
           <div></div>
           
        </div>
    </main>

</body>
</html>

