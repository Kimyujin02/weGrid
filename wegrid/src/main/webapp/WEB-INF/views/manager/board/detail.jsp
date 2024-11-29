<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/manager/board/detail.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
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
                                    <div>영업지원1팀</div>
                                </div>
                                <div class="board-info">
                                    <div>2024-11-27-16:13:56</div>
                                    <div>조회수 : 1</div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="content-detail">
                        <p>
                            awkeahkwjekawjheklahawk
                            awkeahkwjekawjheklahawk
                            awkeahkwjekawjheklahawk
                            awkeahkwjekawjheklahawk
                            awkeahkwjekawjheklahawk
                            awkeahkwjekawjheklahawk
                            awkeahkwjekawjheklahawk
                            awkeahkwjekawjheklahawkawkeahkwjekawjheklahawkawkeahkwjekawjheklahawkawkeahkwjekawjheklahawkawkeahkwjekawjheklahawkawkeahkwjekawjheklahawk
                        </p>
                    </div>

                    <div class="content-reply">
                        <div class="filter">
                            <div class="filter-left">
                                <div>등록순</div>
                                <div>최신순</div>
                                <div><i class="fas fa-redo-alt"></i></div>
                            </div>
                            <div class="filter-right">
                                <div>댓글 9 </div>
                                <i class="far fa-comment-dots"></i>
                            </div>
                        </div>
                        <div class="reply-user">
                            <div class="reply-icon"></div>
                            <div class="reply-info">
                                <div>홍길동</div>
                                <div>영업지원1팀</div>
                            </div>
                            <div class="reply-text">코멘트코멘트코멘트코멘트코멘트코멘트코멘트코멘트코멘트코멘트코멘트코멘트코멘트</div>

                            <div class="reply-subinfo">
                                <div class="reply-date">하루전</div>
                                <div class="reply-adjust">
                                    <div class="reply-edit">수정하기</div>
                                    <div class="reply-delete">삭제하기</div>
                                </div>
                            </div>

                        </div>
                    </div> <!--content-reply -->

                </div>
                <div class="attach">
                    <div class="attach-icon">
                        <i class="fas fa-save"></i> 첨부파일
                    </div> <!--attach-icon -->
                    <div class="attach-info">
                        <table class="table">
                            <tbody >
                                <tr class="list-middle">
                                    <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                    <td>1dddddddddddddddddddddddd.png</td>
                                </tr>
                            </tbody>
                        </table>
                    </div> <!--attach-info -->
                </div>  <!--attach -->
            </div>
    </main>

</body>
</html>

