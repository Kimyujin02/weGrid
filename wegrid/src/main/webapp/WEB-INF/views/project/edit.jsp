<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/project/edit.css">

<script defer src="/js/common/main.js"></script>
<script defer src="/js/project/edit.js"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>
        <div class="main-content" id="main-con">
            <!-- 프로젝트 / 인력정보 섹션 -->
            <div class="grid-container">
                <div class="create-prj">
                    <!-- 상단 제목 / 날짜입력란 -->
                    <div class="head-nav">
                        <h2 class="sub-title">프로젝트 수정</h2>
                        <div class="date-range">
                            <input type="date" name="startDate" style="height: 30px; border-radius: 5px;" value="${vo.startDate}">
                            ~ <input type="date" name="endDate" style="height: 30px; border-radius: 5px;" value="${vo.endDate}">
                            <i class="fas fa-calendar-alt fa-2x"></i>
                        </div>
                    </div>
                    <!-- 여백 공간 -->
                    <div class="place"></div>

                    <!-- 프로젝트 정보 입력 공간 -->
                     <form action="/project/edit" method="get">
                        <div class="req-content">
                            <div class="left-panel">
                                <br>
                                        <input type="hidden" name="no" value="${vo.no}">
                                <div>
                                    <label for="project-name">프로젝트 명</label>
                                    <input type="text" id="project-name" value="${vo.projectName}">
                                </div>
                                <br>
                                <br>
                                <div>
                                    <label for="pm-name">PM(담당자)</label>
                                    <input type="hidden" name="empNo" id="empNo">
                                    <input type="text" id="empName" value="${vo.pmName}"
                                    oninput="searchPm(this.value)"  autocomplete="off" >
                        
                                <p id="searchResults" class="search-results"></p> 
                                </div>
                                <br>
                                <div class="status">
                                    <label for="pm-name">진행도 </label>
                                    <div class="filter-controls">
                                        <select name="statusNo">
                                            <c:forEach var="statusVo" items="${statusList}">
                                                <option value="${statusVo.no}">${statusVo.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="right-panel">
                                <br>
                              
                                <div>
                                    <label for="client-name">고객사</label>
                                    <input type="hidden" name="clientNo" id="clientNo">
                                    <input type="text" id="clientName" value="${vo.clientName}"
                                    oninput="searchClient(this.value)" autocomplete="off">
                                    <ul id="searchClient" class="search-client"></ul> 
                                </div>
                                <br>
                                <br>
                                <div>
                                    <label for="client-contact-person">고객사 담당자</label>
                                    <input type="text" id="client-contact-person" value="${vo.managerName}">
                                </div>
                                <br>
                                <br>
                                <div>
                                    <label for="client-contact">고객사 연락처</label>
                                    <input type="text" id="client-contact" value="${vo.managerPhone}">
                                </div>
                            </div>
                           
                        </div>
    
                        <!-- 여백 -->
                        <div class="place"></div>
    
                        <!-- 프로젝트 내용 입력란 -->
                         
                        <div class="content">
                            <label for="description" style="margin-right: 15px;">내용</label>
                            <textarea id="description" rows="4" >${vo.description}</textarea>
                        </div>
    
                         <!-- 여백 -->
                         <div class="place"></div>
                    </div>
    
                    <!-- 인원 관리섹션 -->
                    <div class="add-personnel">
                        <div class="personnel-list" id="personnelList">
                            <button class="add-btn" onclick="addOpenModal()">+</button>
                            <p class="plus">인원 추가하기</p>
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
    
                <!-- 버튼 섹션 -->
                <div id="section-button">
                    <button type="submit" class="btn btn-primary" id="create-btn">수정</button>
                    <button type="button" class="btn btn-primary" id="delete-btn" onclick="location.href='/project/people?projectNo=${vo.projectNo}&pno=1'">취소</button>
                </div>
                     </form>
                   
           
    </div>
    </main>

     <!-- 사원 검색 모달 -->
     <div id="searchModal" class="personAddmodal" style="display: none;">
        <div class="personModal-content">
            <span class="close-btn" onclick="addCloseModal()">&times;</span>
            <h4>사원 검색</h4>
            <input
                type="text"
                id="employeeSearch"
                placeholder="사원명을 입력하세요"
                oninput="searchEmployee(this.value)"
            />
            <ul id="employeeResults"></ul>
        </div>
    </div>

</body>
</html>



