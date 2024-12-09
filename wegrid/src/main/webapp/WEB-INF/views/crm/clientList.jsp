<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>WEGRID</title>

    <link rel="stylesheet" href="/css/common/main.css">
    <link rel="stylesheet" href="/css/crm/clientList.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script defer src="/js/common/main.js"></script>
    <script defer src="/js/crm/clientList.js"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>
        <div class="main-content">

            <div class="content-area">

                <!-- row1 -->
                <div class="title-area">
                    <h2 class="title-text">고객사 리스트</h2>
                </div>
                <div class="line_1"></div>
                
                <!-- row2 -->
                <div></div>
                <div class="btn-area">
                    <form action="http://127.0.0.1/crm/enroll" method="get">
                        <button type="submit" class="btn btn-primary">&nbsp;등록&nbsp;</button>
                    </form>
                </div>

                <div class="search-area">

                    <form class="search-box" action="/crm/list" method="get">

                        <select name="statusNo" class="form-select" aria-label="Default select example" onchange="applyFilters()">
                            <option name="statusNo" value="" selected>전체</option>
                            <c:forEach items="${clientStatusVoList}" var="clientStatusVo">
                                <option name="statusNo" value="${clientStatusVo.no}">${clientStatusVo.name}</option>
                            </c:forEach>
                        </select>

                        <select name="rankCode" class="form-select" aria-label="Default select example" onchange="applyFilters()">
                            <option name="rankCode" value="" selected>전체</option>
                            <c:forEach items="${clientRankVoList}" var="clientRankVo">
                                <option name="rankCode" value="${clientRankVo.no}">${clientRankVo.name}</option>
                            </c:forEach>
                        </select>
              

                        <select class="form-select searchType" name="searchType" aria-label="Search Type">
                            <option value="integration">통합</option>
                            <option value="client">고객사</option>
                            <option value="managerName">고객사 담당자명</option>
                            <option value="managerPhone">담당자 연락처</option>
                        </select>

                        <input id="searchInput" type="text" class="searchValue" name="searchValue" placeholder="검색">
                        <button class="form-submit" type="submit" onclick="applyFilters()">
                            <i class="fas fa-search"></i>
                        </button>
                    
                    </form>

                </div>
                <div></div>
                
                <!-- row3 -->
                <div></div>
                <div class="table-area">
                    <table class="client-table">
                        <thead class="list-top">
                            <tr>
                                <th class="num">번호</th>
                                <th class="client-name">고객사</th>
                                <th class="client-grade">등급</th>
                                <th class="enroll-date">등록일</th>
                            </tr>
                        </thead>
                  
                        <tbody>
                            <c:forEach items="${clientVoList}" var="vo">
                                <tr class="list-middle">
                                    <td>${vo.no}</td>
                                    <td class="linked-name"><a href='/crm/detail?cno=${vo.no}&pno=1'>${vo.name}</a></td>
                                    <td>${vo.rankName}</td>
                                    <td>${fn:substring(vo.startDate, 0, 10)}</td>
                                </tr>
                            </c:forEach>
                        </tbody>

                        <tfoot>
                            <tr class="list-end">
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </tfoot>
                    </table>
                </div>
                <div></div>

                <!-- row4 -->
                <div class="paging-area">
                    <c:if test="${pvo.startPage != 1}">
                        <a class="previous" href="/crm/list?pno=${pvo.startPage-1}&searchValue=${searchValue}">
                            <i class="fas fa-caret-left fa-lg" style="color: #174880;"></i>
                        </a>
                    </c:if>
                    <c:forEach begin="${pvo.startPage}" end="${pvo.endPage}" var="i" step="1">
                        <c:choose>
                            <c:when test="${i == pvo.currentPage}">
                                <a class="current" href="/crm/list?pno=${i}&searchValue=${searchValue}">
                                    ${i}
                                </a>
                            </c:when>
                            <c:otherwise>
                                <a class="pageNum" href="/crm/list?pno=${i}&searchValue=${searchValue}">
                                    ${i}
                                </a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>                    
                    <c:if test="${pvo.endPage != pvo.maxPage}">
                        <a href="/crm/list?pno=${pvo.endPage+1}&searchValue=${searchValue}">
                            <i class="fas fa-caret-right fa-lg" style="color: #174880;"></i>
                        </a>
                    </c:if>
                </div>
            </div>

        </div>
    </main>

</body>
</html>