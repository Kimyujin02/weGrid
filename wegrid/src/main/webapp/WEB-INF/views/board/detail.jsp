<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/board/detail.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script defer src="/js/common/main.js"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>
        <div class="main-content">

            <div></div>

            <div class="board-detail">
                <div class="content">

                    <div class="content-btns">
                        <button class="btn-edit">수정하기</button>
                        <button class="btn-delete">삭제하기</button>
                    </div>

                    <div class="content-shortcut">
                        <div><h1 class="shortcut-title">제목~~~~~</h1></div>

                        <div class="shortcut-user">
                            <div class="user-propic"></div> <!-- 프로필 사진 -->
                            <div class="user-detail">
                                <!-- 사용자 상세 정보 -->
                                <div class="user-info">
                                    <div>홍길동</div>
                                    <div>경영지원1팀</div>
                                </div>
                                <div class="board-info">
                                    <div>날짜-날짜-날짜</div>
                                    <div>조회수 : 1</div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="content-detail">
                        <!-- 콘텐츠 디테일 -->
                    </div>

                    <div class="content-reply">
                        <div>
                            <div>등록순</div>
                            <div>최신순</div>
                            <div>최신순</div>
                        </div>
                        <div>
                            <div></div>
                            <div>
                                <div></div>
                                <div></div>
                            </div>
                            <div></div>
                        </div>
                    </div> <!--content-reply -->

                </div>
                <div class="attach">
                    <div class="attach-icon"></div> <!--attach-icon -->
                    <div class="attach-info"></div> <!--attach-info -->
                </div>  <!--attach -->
            </div>




---------------------------------------------
            div1    flex - row
            	div2    flex - col
            		divdiv2-1
            		divdiv2-2
            		divdiv2-3
            		divdiv2-4
            	div2

            	div3    flex - col
            		divdiv3-1
            		divdiv3-2
            	div3
            div1
---------------------------------------------

        </div>
    </main>

</body>
</html>

