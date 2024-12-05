<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/project/create.css">

<script defer src="/js/common/main.js"></script>
<script defer src="/js/project/creates.js"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>
        <form action="/project/create" method="post">
            <div class="main-content" id="main-con">
                <!-- 프로젝트 / 인력정보 섹션 -->
                <div class="grid-container">
                    <div class="create-prj">
                        <!-- 상단 제목 / 날짜입력란 -->
                        <div class="head-nav">
                            <h2 class="sub-title">프로젝트 생성</h2>
                            <div class="date-range">
                                <input type="date" name="startDate" style="height: 30px; border-radius: 5px;">
                                ~ <input type="date" name="endDate" style="height: 30px; border-radius: 5px;">
                                <i class="fas fa-calendar-alt fa-2x"></i>
                            </div>
                        </div>

                        <!-- 여백 공간 -->
                        <div class="place"></div>
        
                         <!-- 프로젝트 정보 입력 공간 -->
                        <div class="req-content">
                            <div class="left-panel">
                                <br>
                                <div>
                                    <label for="projectName">프로젝트 명</label>
                                    <input type="text" id="projectName" name="projectName">
                                </div>
                                <br><br>
                                <div>
                                    <label for="empNo">PM(담당자)</label>
                                    <input type="hidden" name="empNo" id="empNo">
                                    <input
                                        type="text"
                                        id="empName"
                                        oninput="searchPm(this.value)"
                                        autocomplete="off" 
                                    />
                                    <p id="searchResults" class="search-results"></p> 
                                </div>
                                
                                <br><br>
                                <div>
                                    <label for="budget">예산</label>
                                    <input type="number" id="budget" name="budget" required>
                                </div>
                            </div>
                            <div class="right-panel">
                                <br>
                                <div>
                                    <label for="clientNo">고객사</label>
                                    <input type="hidden" name="clientNo" id="clientNo">
                                    <input type="text" id="clientName"  
                                    oninput="searchClient(this.value)" autocomplete="off" />
                                    <ul id="searchClient" class="search-client"></ul> 
                                </div>
                                

                                <br><br>
                                <div>
                                    <label for="managerName">고객사 담당자</label>
                                    <input type="text" id="managerName" name="managerName" required>
                                </div>
                                <br><br>
                                <div>
                                    <label for="managerPhone">고객사 연락처</label>
                                    <input type="text" id="managerPhone" name="managerPhone" required>
                                </div>
                            </div>
                        </div>
                        
                         <!-- 여백 -->
                        <div class="place"></div>

                         <!-- 프로젝트 내용 입력란 -->
                        <div class="content">
                            <label for="description" style="margin-right: 15px;">내용</label>
                            <textarea id="description" name="description" rows="4" placeholder="프로젝트 내용을 입력하세요"></textarea>
                        </div>

                         <!-- 여백 -->
                        <div class="place"></div>
                    </div>
        
                   <!-- 사람 추가 관리 섹션 -->
                    <div class="add-personnel">
                        <div class="personnel-list" id="personnelList">
                            <button type="button" class="add-btn" onclick="addOpenModal()">+</button>
                            <p class="plus">인원 추가하기</p>
                            <!-- 여기에 동적으로 추가된 사원 정보가 표시됨 -->
                        </div>
                    </div>
        
                     <!-- 첨부파일 섹션 -->
                    <div class="attachments-container">
                        <div class="line-title">첨부파일</div>
                        <div class="line-divider"></div>
                        <div class="inner">
                            <button class="file-button" onclick="document.getElementById('input').click()">파일 선택</button>
                            <input type="file" id="input" name="f" style="display: none;" multiple>
                            <div class="info-text">또는 파일을 여기로 드래그 하세요.</div>
                        </div>
                    </div>
        
                      <!-- 여백 -->
                    <div class="place"></div>
        
                      <!-- 버튼 섹션 -->
                    <div id="section-button">
                        <button type="submit" class="btn btn-primary" id="create-btn" onclick="location.href='/project/list'">생성</button>
                        <button type="button" class="btn btn-primary" id="delete-btn" onclick="location.href='/project/list'">취소</button>
                    </div>
                </div>
            </div>
        </form>
        
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

