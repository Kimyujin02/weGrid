<!-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/project/list.css">

<script defer src="/js/common/main.js"></script>
<script defer src="/js/project/list.js"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/hung1001/font-awesome-pro@4cac1a6/css/all.css" />

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
        <main>
            <div class="main-content " id="main-content">
            <div id="content">
                <h2 class="sub-title">프로젝트 리스트</h2>

                <div class="table-controls">
                    <button type="button" onclick="location.href='/project/create'" class="btn btn-primary"  id="approvalBtn" >등록</button>
                
                  
                    <div class="filter-controls">
                        <select>
                            <option value="전체">전체</option>
                            <option value="진행중">진행</option>
                            <option value="완료">완료</option>
                            <option value="철회">철회</option>
                            <option value="준비">준비</option>
                        </select>
                        <a href="/project/list"><span style="color:#565C67; gap: 5px;" ><i class="fas fa-list fa-lg"></i></span></a>
  
                    <div class="square-icon">
                        <a href="/project/card"><span style="color:#565C67"><i class="fas fa-th-large fa-lg "></i></span></a>
                    </div>

                        <div class="search-box">
                            <input type="text" placeholder="검색" />
                            <i class="fas fa-search"></i>
                        </div>
                        
                    </div>
                </div>
                <table class="project-table">
                    <thead>
                        <tr>
                            <th>프로젝트명</th>
                            <th>PM</th>
                            <th>고객사</th>
                            <th>고객사 담당자</th>
                            <th>기간</th>
                            <th>투입 인원</th>
                            <th>진행 상태</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${voList}" var="vo">
                            <tr >
                                
                               
                                <td> <a href="/project/people?projectNo=${vo.projectNo}&pno=1">${vo.projectName}</a></td>
                                <td>${vo.pmName}</td>
                                <td>${vo.clientName}</td>
                                <td>${vo.managerName}</td>
                                <td><p class="project-dates" data-start="${vo.startDate}" data-end="${vo.endDate}">
                                    ${vo.startDate} ~ ${vo.endDate}
                                </p>
                                </td>
                                <td>${vo.projectMemberCount}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${vo.statusNo == 1}"><span class="status-ready ">준비</span></c:when>
                                        <c:when test="${vo.statusNo == 2}"><span class="status-ongoing">진행</span></c:when>
                                        <c:when test="${vo.statusNo == 3}"><span class="status-completed">완료</span></c:when>
                                        <c:when test="${vo.statusNo == 4}"><span class="status-canceled">철회</span></c:when>
                                    </c:choose>
                                </td>
                                </a>
                            </tr>
                        </c:forEach>

                        <!-- 추가 행들 -->
                    </tbody>
                </table>
                </div>
                <div class="bottom-line"></div>

                <div class="page">
                    <c:if test="${pvo.startPage != 1}">
                        <a href="/project/list?pno=${pvo.startPage-1}"><i class="fas fa-caret-left fa-lg" style="color: #174880;"></i></a>
                    </c:if>
                   
                     <c:forEach begin ="${pvo.startPage}" end="${pvo.endPage}" var="i" step="1">
                     <a href="/project/list?pno=${i}">${i}</a>
                     </c:forEach>
        
                     <c:if test="${pvo.endPage != pvo.maxPage}">
                        <a href="/project/list?pno=${pvo.endPage+1}"><i class="fas fa-caret-right fa-lg" style="color: #174880;"></i></a>
                     </c:if>
            </div>
        </div>
            
    </main>
    
        
    </body>
    </html>
    