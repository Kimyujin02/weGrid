<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/board/detail.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script defer src="/js/common/main.js"></script>
<script defer src="/js/board/detail.js"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>


    <!-- Main -->
    <main>
        <input type="hidden" id="boardNo" value="${vo.no}">
        <div class="main-content">

            <div></div>

            <div class="board-detail">
                <div class="content">


                    <c:if test="${loginMemberVo.no == vo.writerNo}">        <%-- 로그인정보 == 작성자일때 --%>
                        <div class="content-btns" tp>
                            <button class="btn-edit" onclick="location.href='/board/edit?bno=${vo.no}'">수정하기</button>
                            <button class="btn-delete" onclick="location.href='/board/del?bno=${vo.no}'">삭제하기</button>
                        </div>
                    </c:if>

                    <div class="content-shortcut">
                        <div><h1 class="shortcut-title">${vo.title}</h1></div>

                        <div class="shortcut-user">
                            <div class="user-propic"></div> <!-- 프로필 사진 -->
                            <div class="user-detail">
                                <!-- 사용자 상세 정보 -->
                                <div class="user-info">
                                    <div>${vo.name} ${vo.jobName}</div>
                                    <div>${vo.deptName}</div>
                                </div>
                                <div class="board-info">
                                    <div>${vo.enrollDate}</div>
                                    <div>조회수 : ${vo.viewCnt}</div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="content-detail">
                        <p>
                            ${vo.content}
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
                                <div>댓글 <span id="reply-count">${replyList.size()}</span></div>
                                <i class="far fa-comment-dots"></i>
                            </div>
                        </div>

                        <form id="reply-write-area">
                            <div class="reply-input-area">
                                <input name="content" placeholder="댓글을 입력하세요..." />
                                <button type="button" onclick="writeReply(${vo.no});">댓글 작성</button>
                            </div>
                            <input type="hidden" name="bno" value="${boardNo}"> <!-- 해당 게시글 번호를 hidden input으로 전달 -->
                        </form>

                        <div id="reply-list-area" >

                        </div> <!-- 댓글 목록을 여기에 동적으로 추가할 예정 -->

                </div>

            </div>
            <div class="attach">
                <div class="attach-icon">
                    <i class="fas fa-save"></i> 첨부파일
                </div> <!--attach-icon -->
                <div class="attach-info">
                    <table class="table">
                        <tbody >
                            <c:forEach items="${attachmentVoList}" var="x" >
                            <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                <tr class="list-middle">
                                    <td>
                                        <a href="/download?fileName=${x.changeName}" download>
                                            ${x.originName}
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div> <!--attach-info -->
            </div>  <!--attach -->
    </main>

</body>
</html>

