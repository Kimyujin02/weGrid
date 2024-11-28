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
                        <h2 class="sub-title">프로젝트 생성</h2>
                        <div class="date-range">
                            <input type="date" name="startDate" style="height: 40px; border-radius: 5px;">
                            ~ <input type="date" name="endDate" style="height: 40px; border-radius: 5px;">
                            <button class="date-btn"><i class="fas fa-calendar-alt fa-2x"></i></button>
                        </div>
                    </div>
                    <!-- 여백 공간 -->
                    <div class="place"></div>

                    <!-- 프로젝트 정보 입력 공간 -->
                    <div class="req-content">
                        <div class="left-panel">
                            <br>

                            <div>
                                <label for="project-name">프로젝트 명</label>
                                <input type="text" id="project-name">
                            </div>
                            <br>
                            <br>
                            <div>
                                <label for="pm-name">PM(담당자)</label>
                                <input type="text" id="pm-name" >
                            </div>
                            <br>
                            <br>
                            <div>
                                <label for="budget">예산</label>
                                <input type="text" id="budget" >
                            </div>
                        </div>
                        
                        <div class="right-panel">
                            <br>
                          
                            <div>
                                <label for="client-name">고객사</label>
                                <input type="text" id="client-name">
                            </div>
                            <br>
                            <br>
                            <div>
                                <label for="client-contact-person">고객사 담당자</label>
                                <input type="text" id="client-contact-person">
                            </div>
                            <br>
                            <br>
                            <div>
                                <label for="client-contact">고객사 연락처</label>
                                <input type="text" id="client-contact">
                            </div>
                        </div>
                       
                    </div>

                    <!-- 여백 -->
                    <div class="place"></div>

                    <!-- 프로젝트 내용 입력란 -->
                    <div class="content">
                        <label for="description" style="margin-right: 15px;">내용</label>
                        <textarea id="description" rows="4" placeholder="프로젝트 내용을 입력하세요" ></textarea>
                    </div>

                     <!-- 여백 -->
                     <div class="place"></div>
                </div>

                <!-- 인원 관리 영역 -->
                <div class="add-personnel">
                    <div class="personnel-list">
                        <button class="add-btn">+</button>
                        <p class="plus">인원 추가하기</p>
                        <div class="person-line1"></div>
                        <div class="person-line"></div>
                        <div class="person-line"></div>
                        <div class="person-line"></div>
                        <div class="person-line"></div>
                    </div>
                </div>
            </div>

            <!-- 첨부파일 섹션 -->
            <div class="attachments-container">
                <div class="line-title">첨부파일</div>
                <div class="line-divider"></div>
                <div class="inner">
                    <button class="file-button" onclick="document.getElementById('input').click()">파일 선택</button>
                    <input type="file" id="input" style="display: none;">
                    <div class="info-text">또는 파일을 여기로 드래그 하세요.</div>
                </div>
            </div>

            <!-- 버튼 섹션 -->
            <div id="section-button">
                <button type="button" class="btn btn-primary" id="create-btn">등록</button>
                <button type="button" class="btn btn-primary" id="delete-btn">삭제</button>
            </div>
           
    </div>
    </main>
    
</body>
</html>

