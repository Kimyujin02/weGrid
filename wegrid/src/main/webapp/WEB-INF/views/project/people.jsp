<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/project/people.css">

<script defer src="/js/common/main.js"></script>
<script defer src="/js/project/modal.js"></script>
<script defer src="/js/project/page.js"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>
        <div class="main-content" id="main-con">

        <!-- 정보 섹션 -->
        <div class="main-info">
            <!-- 프로젝트 정보 -->
            <div class="project-info">
                 <!-- 공백 -->
                 <div class="edit-icon">
                    <a href="/project/edit?projectNo=${map.project.projectNo}&pno=${pvo.currentPage}"><i class="fas fa-edit" style="color:#666;"></i></a>
                </div>
                <table class="project-table" id="project-tb">
                    <thead>
                        <tr style="border-top: 1px solid #797979ab;">

                            <!-- 프로젝트 번호를 hidden 필드로 추가 -->
                            <input type="hidden" name="projectNo" value="${map.project.projectNo}">
                            <th>프로젝트 명</th>
                            <td>${map.project.projectName}</td>
                            <th>담당 PM</th>
                            <td>${map.project.pmName}</td>
                            <th>고객사 담당자</th>
                            <td>${map.project.managerName}</td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th>고객사</th>
                            <td>${map.project.clientName}</td>
                            <th>고객 등급</th>
                            <td>${map.project.rankName}</td>
                            <th>고객사 연락처</th>
                            <td>${map.project.managerPhone}</td>
                        </tr>
                        <tr>
                            <th>진행 현황</th>
                            <td>
                                <c:choose>
                                <c:when test="${map.project.statusNo == 1}"><span class="status-ready ">준비</span></c:when>
                                <c:when test="${map.project.statusNo == 2}"><span class="status-ongoing">진행</span></c:when>
                                <c:when test="${map.project.statusNo == 3}"><span class="status-completed">완료</span></c:when>
                                <c:when test="${map.project.statusNo == 4}"><span class="status-canceled">철회</span></c:when>
                                </c:choose>
                            </td>
                                
                            <th>예산</th>
                            <td>₩ ${map.project.budget}</td>
                            <th>프로젝트 기간</th>
                            <td><p id="project-dates" data-start="${map.project.startDate}" data-end="${map.project.endDate}">
                                ${map.project.startDate} ~ ${map.project.endDate}</p>
                            </td>
                        </tr>
                        <tr>
                            <th>내용</th>
                            <td colspan="5">${map.project.description}</td>
                        </tr>
                    </tbody>
                </table>
                 <!-- 공백 -->
            <div class="place"></div>
            </div>

            <!-- 공백 -->
            <div class="place"></div>

            <!-- 참여 인력 목록 -->
            <div class="people-info">
                <div class="sidebar">
               
                    <div class="sidebar">
                        <a href="/project/people?projectNo=${map.project.projectNo}&pno=1" class="sidebar-btn active" id="btn1">
                            <i class="fas fa-user-friends"></i> 
                        </a>
                        <a href="/project/attach?projectNo=${map.project.projectNo}&pno=1" class="sidebar-btn" id="btn2">
                            <i class="fas fa-paperclip"></i>
                        </a>
                    </div>
                    
                </div>
                <div class="list">
                <div class="list-header">
                    <div class="date-controls">
                        <button class="arrow-btn">◀</button>
                        <span class="current-date">2024 11월</span>
                        <button class="arrow-btn">▶</button>
                    </div>
                        <div class="search-box">
                            <input type="text" name="" placeholder="검색">
                            <i class="fas fa-search"></i>
                        </div>
                </div>
                    <div class="background-box">
                    <table class="people-table">
                        <thead class="list-top">
                            <tr>
                                <th>이름</th>
                                <th>사원 ID</th>
                                <th>소속부서</th>
                                <!-- <th>담당업무</th> -->
                                <th>이메일</th>
                                <th>시작일</th>
                                <th>종료일</th>
                            </tr>
                        </thead>
                  
                        <tbody >
                            <c:forEach items="${voList}" var="vo">
                                <tr class="list-middle">
                                    <td>${vo.empName}</td>
                                    <td>${vo.empNum}</td>
                                    <td>${vo.deptNo}</td>
                                    <!-- <td>${vo.deptName}</td> -->
                                    <td>${vo.email}</td>
                                    <td>${vo.startDate}</td>
                                    <td>${vo.endDate}</td>
                                </tr>
                            </c:forEach>
                            
                        </tbody>
                        
                    </table>
                    <div class="bottom-line"></div>
                    <div class="page">
                        <c:if test="${pvo.startPage != 1}">
                            <a href="/project/people?pno=${pvo.startPage-1}&searchValue=${searchValue}"><i class="fas fa-caret-left fa-lg" style="color: #174880;"></i></a>
                        </c:if>
                       
                         <c:forEach begin ="${pvo.startPage}" end="${pvo.endPage}" var="i" step="1">
                         <a href="/project/people?pno=${i}&searchValue=${searchValue}">${i}</a>
                         </c:forEach>
            
                         <c:if test="${pvo.endPage != pvo.maxPage}">
                            <a href="/project/people?pno=${pvo.endPage+1}&searchValue=${searchValue}"><i class="fas fa-caret-right fa-lg" style="color: #174880;"></i></a>
                         </c:if>
                </div>
                </div>

                </div>
            </div>
        </div>
        
        <!-- 일정추가/ 현재 참여인원 관리 섹션 -->
         <div class="sub-info">
            <!-- 1)일정 추가 버튼 -->
            <div class="add-btn">
                <button type="button"  class="btn btn-primary" id="schedule-btn" data-bs-toggle="modal" data-bs-target="#writeModal" > + 일정 등록</button>
            </div>

                <!-- 일정 추가 모달 -->
                <div class="modal fade" id="writeModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title" id="exampleModalLabel">일정 추가</h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <div class="title-area">
                                        <label for="calendar_title" class="col-form-label">제목</label>
                                        <input type="text" class="form-control" id="calendar_title" name="title">
                                    </div>
                                    <br>
                                    <div class="date-area">
                                        <div class="date-label-area">
                                            <label for="calendar_end_date" class="col-form-label">종료일</label>
                                        </div>
                                        <div class="date-input-area">
                                            <input type="datetime-local" class="form-control" id="calendar_start_date" name="startDate">
                                            <input type="datetime-local" class="form-control" id="calendar_end_date" name="endDate">
                                        </div>
                                    </div>
                                    <br>
                                    <div>
                                        <label for="" class="col-form-label">일정 종류</label>
                                        <div class="type-area">
                                            <div class="typeBox">
                                                <label for="typeNo1">회의</label>
                                            </div>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="content-area">
                                        <label for="calendar_content" class="col-form-label">상세 내용</label>
                                        <textarea class="form-control" id="calendar_content" name="content"></textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary" id="addCalendar">추가</button>
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                            </div>
                        </div>
                    </div>
                </div>

            <!-- 현재 참여인원 -->
            <div class="profile-card">
                <div class="profile">
                    
                    <div class="profile-info">
                        <c:forEach items="${voList}" var="vo">
                            <img src="profile1.jpg" alt="사원" class="profile-img">
                            <span class="name">${vo.empName}</span>
                            <br>
                            <span class="role">${vo.deptNo}</span>
                            <hr>
                        </c:forEach>
                    </div>
                </div>
            </div>
            
         </div>
        </div>
    </main>

</body>
</html>

