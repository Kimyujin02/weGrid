<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/system/list.css">

<script defer src="/js/common/main.js"></script>
<script defer src="/js/system/list.js"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/hung1001/font-awesome-pro@4cac1a6/css/all.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav-system.jsp" %>

    <!-- Main -->
    <main>
        <div class="main-content">
            <h1 class="title">계정 리스트</h1>
            <div class="line-box"></div>

            <div class="top-area">
                <button type="button" class="btn btn-primary" id="create-btn" onclick="location.href='/system/create'">등록하기</button>
                
                <form action="/system/account/list"  method="get">
                <div class="filter-controls" >
                    <!-- 부서명 필터링 값 -->
                    <select id="deptName" name="deptNo" onchange="updateJobOptions()" >
                        <option value="">전체</option>
                        <c:forEach var="departMentVo" items="${departMentVoList}">
                            <c:if test="${deptNo == departMentVo.code}">
                                <option value="${departMentVo.code}" selected>
                                    ${departMentVo.name}
                                </option>
                            </c:if>

                            <c:if test="${deptNo != departMentVo.code}">
                                <option value="${departMentVo.code}">
                                    ${departMentVo.name}
                                </option>
                            </c:if>
                        </c:forEach>
                    </select>
                     
                    <!-- 직급명 필터링 -->
                    <select id="job" name="jobNo" onchange="applyFilters()">
                        <option value="">전체</option>
                        <c:forEach var="JobInfoVo" items="${jobInfoVoList}">

                                <c:if test="${jobNo == JobInfoVo.no}">
                                <option value="${JobInfoVo.no}" selected>
                                    ${JobInfoVo.name}
                                </option>
                                </c:if>

                                <c:if test="${jobNo != JobInfoVo.no}">
                                    <option value="${JobInfoVo.no}">
                                        ${JobInfoVo.name}
                                    </option>
                                    </c:if>
                         
                        </c:forEach>
                    </select>
                    <div class="search-box">
                        <input type="text" name="searchValue" placeholder="사원 이름 검색" value="${searchValue}">
                        <i class="fas fa-search"></i>
                    </div>
                </div>

                </form>
    
                    <button type="button" class="btn btn-primary" id="delete-btn" onclick="delete(this)">일괄삭제</button>
            </div>
            

            <div id="account-list">
                <table class="table">
                    <thead class="list-head">
                        <tr>
                            <th>ID</th>
                            <th>사원명</th>
                            <th>사번</th>
                            <th>부서</th>
                            <th>직급</th>
                            <th>셍성일</th>
                            <th>권한</th>
                            <th>정보수정</th>
                            <th>사용여부</th>
                            <th>삭제<input type="checkbox" onclick="handleCheckbox(this);"></th>
                        </tr>
                    </thead>
              
                    <tbody >
                        <c:forEach items="${empVoList}" var="vo">
                            <tr class="list-middle" data-no="${vo.no}">
                                <input type="hidden" value="${vo.no}">
                                <td>${vo.id}</td>
                                <td>${vo.name}</td>
                                <td>${vo.empNum}</td>
                                <td>${vo.deptName}</td>
                                <td>${vo.jobName}</td>
                                <td>${vo.enrollDate}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${vo.isManager == 'Y'}">매니저</c:when>
                                        <c:otherwise>일반 사원</c:otherwise>
                                    </c:choose>
                                </td>
                                <td><button type="button" class="btn btn-primary" id="edit-btn" onclick="location.href='/system/edit?no=${vo.no}'">정보수정</button></td>
                                <td>${vo.delYn}</td>
                                <td class="checkbox-td">
                                    <input type="checkbox" name="del" class="exclude-click">
                                </td>
                        </tr>
                        </c:forEach>
                       
                       
                    </tbody>
                    
                </table>
                
                <div class="bottom-line"></div>
                
            </div>
            <div class="page">
                <c:if test="${pvo.startPage != 1}">
                    <a href="/system/account/list?pno=${pvo.startPage-1}&searchValue=${searchValue}"><i class="fas fa-caret-left fa-lg" style="color: #174880;"></i></a>
                </c:if>
                <c:forEach begin="${pvo.startPage}" end="${pvo.endPage}" var="i" step="1">
                    <a href="/system/account/list?pno=${i}&searchValue=${searchValue}">${i}</a>
                </c:forEach>
                <c:if test="${pvo.endPage != pvo.maxPage}">
                    <a href="/system/account/list?pno=${pvo.endPage+1}&searchValue=${searchValue}"><i class="fas fa-caret-right fa-lg" style="color: #174880;"></i></a>
                </c:if>
        </div>
        
            </div>
    </main>

</body>
</html>

