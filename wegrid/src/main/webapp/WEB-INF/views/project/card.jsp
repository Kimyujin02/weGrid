<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/project/card.css">

<script defer src="/js/common/main.js"></script>
<script defer src="/js/project/card.js"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/hung1001/font-awesome-pro@4cac1a6/css/all.css" />

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

   <!-- Main -->
   <main>
    <div class="main-content " id="main-content">
        <div class="header-menu">
            <div class="filter-controls">
                <select>
                    <option>부서명</option>
                    <option>부서명</option>
                    <option>부서명</option>
                </select>
            </div>

            <a href="/project/list"><span style="color:#565C67; gap: 5px;" ><i class="fas fa-list fa-lg"></i></span></a>
  
            <div class="square-icon">
                <a href="/project/card"><span style="color:#565C67"><i class="fas fa-th-large fa-lg "></i></span></a>
            </div>

                <div class="search-box">
                    <input type="text" placeholder="검색" />
                    <i class="fas fa-search"></i>
                </div>
        </div>

        
        <!-- /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
        <div class="card-container">
            <c:forEach items="${voList}" var="vo">
                <a href="/project/people?projectNo=${vo.projectNo}&pno=${vo.projectNo}" class="card-link">
                    <div id="card">
                        <div class="card-header">
                            <svg width="18" height="18" viewBox="0 0 18 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path d="M8.04506 1.07261C8.33646 0.134991 9.66354 0.134989 9.95494 1.0726L11.2511 5.24309C11.3811 5.66132 11.7681 5.9463 12.206 5.9463H16.4918C17.4498 5.9463 17.8595 7.16322 17.0967 7.74263L13.5541 10.4335C13.219 10.688 13.0791 11.1249 13.204 11.5266L14.5389 15.8219C14.8277 16.7511 13.754 17.5036 12.9791 16.915L9.60487 14.352C9.24734 14.0805 8.75266 14.0805 8.39513 14.352L5.0209 16.915C4.24604 17.5036 3.1723 16.7511 3.46109 15.8219L4.79603 11.5266C4.92088 11.1249 4.78096 10.688 4.44595 10.4335L0.903316 7.74263C0.140491 7.16322 0.550251 5.9463 1.50818 5.9463H5.79396C6.23192 5.9463 6.61892 5.66132 6.7489 5.24309L8.04506 1.07261Z" fill="#F0E000"/>
                            </svg>
                            
                            <c:choose>
                                <c:when test="${vo.statusNo == 1}"><span class="status-ready ">준비</span></c:when>
                                <c:when test="${vo.statusNo == 2}"><span class="status-ongoing">진행</span></c:when>
                                <c:when test="${vo.statusNo == 3}"><span class="status-completed">완료</span></c:when>
                                <c:when test="${vo.statusNo == 4}"><span class="status-canceled">철회</span></c:when>
                            </c:choose>
                        </div>
        
                        <div id="card-content">
                            <input type="hidden" name="projectNo" value="${vo.projectNo}">
                            <h3 class="project-title">${vo.projectName}</h3>
                            <p class="project-dates" data-start="${vo.startDate}" data-end="${vo.endDate}">
                                ${vo.startDate} ~ ${vo.endDate}
                            </p>
                            
                            <p>고객사 : ${vo.clientName}</p>
                            <p>PM : ${vo.pmName}</p>
                        </div>
        
                        <div class="card-footer">
                            <div class="team-info">
                                <span style="color:#174880"><i class="far fa-user"></i></span>
                                <span class="team-count">${vo.projectMemberCount}</span>
                            </div>
                        </div>
                    </div>
                </a>
            </c:forEach>
        </div>
        

    <div class="page-area">
        <c:if test="${pvo.startPage != 1}">
            <a href="/project/card?pno=${pvo.startPage-1}"><i class="fas fa-caret-left fa-lg" style="color: #174880;"></i></a>
        </c:if>
       
         <c:forEach begin ="${pvo.startPage}" end="${pvo.endPage}" var="i" step="1">
         <a href="/project/card?pno=${i}">${i}</a>
         </c:forEach>

         <c:if test="${pvo.endPage != pvo.maxPage}">
            <a href="/project/card?pno=${pvo.endPage+1}"><i class="fas fa-caret-right fa-lg" style="color: #174880;"></i></a>
         </c:if>
    </div>
</main>
</body>
</html>