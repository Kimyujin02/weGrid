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
<script defer src="/js/board/list.js"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>
        <div class="main-content">
            <div class="main-head">
                <div class="head-top">
                    <h1 class="section-title">게시판</h1>
                </div>
                <div class="head-bottom">
                    <div class="head-bottom-align">
                        <form action="/board/insert" method="get">
                            <button class="register-btn">작성하기</button>
                        </form>

                        <div class="history-controls">
                            <form action="/board/list?pno=1" onsubmit="return submitSearchForm();">
                                <div class="filter-controls">
                                    <select class="filter-title-content" name="searchType">
                                        <option value="title">제목</option>
                                        <option value="content">내용</option>
                                    </select>



                                    <input type="text" name="searchValue" placeholder="검색어 입력" />
                                    <input type="submit" value="검색"/>
                                </div>
                            </form>
                        </div>


            </div>
            <div class="main-bottom">
                    <div class="bottom-top">
                    </div>
                    <div class="bottom-bottom">

                        <div class="table-form">

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

                        </div>
                        <div class="page">

                        </div>


                    </div>
                </div>
            </div>
        </div>
    </main>

</body>
</html>

