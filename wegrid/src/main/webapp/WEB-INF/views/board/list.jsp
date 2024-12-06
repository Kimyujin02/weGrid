<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/board/list.css">
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
                    <h1 class="section-title">개발1팀 게시판</h1>
                </div>
                <div class="head-bottom">
                    <div class="head-bottom-align">
                        <form action="/board/insert" method="get">
                            <button class="register-btn">작성하기</button>
                        </form>

                        <div class="history-controls">
                            <form action="/board/list?pno=1" onsubmit="return submitSearchForm();">
                                <div class="filter-controls">
                                    <select class="filter-title-content" onchange="handleSearchType(this);">
                                        <option value="title">제목</option>
                                        <option value="content">내용</option>
                                    </select>

                                    <select class="filter-date" name="searchValue" disabled>
                                        <option value="year">올해</option>
                                        <option value="month">이번달</option>
                                        <option value="week">1주일</option>
                                        <option value="tday">3일</option>
                                        <option value="day">1일</option>
                                        <option value="all">전체기간</option>
                                    </select>

                                    <input type="text" name="searchValue" placeholder="검색어 입력" />
                                    <button class="search-btn" value="검색">🔍</button>
                                </div>
                            </form>
                        </div>







            </div>
            <div class="main-bottom">
                    <div class="bottom-top">
                    </div>
                    <div class="bottom-bottom">



                            <table class="table">
                                <thead class="list-top">
                                    <tr>
                                        <th>번호</th>
                                        <th class="title">제목</th>
                                        <th>작성자</th>
                                        <th>작성일</th>
                                        <th>조회수</th>
                                    </tr>
                                </thead>


                                <tbody>
                                    <c:forEach items="${selectAllBoardList}" var="x" >
                                        <tr class="list-middle">
                                            <td>${x.no}</td>
                                            <td>${x.title}</td>
                                            <td>${x.name}</td>
                                            <td>${x.enrollDate}</td>
                                            <td>${x.viewCnt}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div class="bottom-line"></div>


                            <div class="page">
                                <!-- js에서 동적으로 버튼 만들어줌-->
                                <span><a href="#!"><i class="fas fa-angle-double-left fa-lg" style="color: #174880;"></i></a></span>
                                <span><a href="#!"><i class="fas fa-caret-left fa-lg" style="color: #174880;"></i></a></span>
                                <span><a href="#!">1</a></span>
                                <span><a href="#!">2</a></span>
                                <span><a href="#!">3</a></span>
                                <span><a href="#!">4</a></span>
                                <span><a href="#!">5</a></span>
                                <span><a href="#!"><i class="fas fa-caret-right fa-lg" style="color: #174880;"></i></a></span>
                                <span><a href="#!"><i class="fas fa-angle-double-right fa-lg" style="color: #174880;"></i></a></span>
                            </div>
                    </div>
                </div>
            </div>
        </div>
    </main>

</body>
</html>

