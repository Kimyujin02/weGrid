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
        <div class="main-content">
            <!-- 프로젝트 생성 섹션 -->
           <h2 class="sub-title">프로젝트 생성</h2>

            <div class="date-range">
                <input type="date">
                <button><i class="fas fa-calendar-alt fa-2x"></i></button>
            </div>
            <div class="form">
                <div class="form-group">
                    <label for="project-name">프로젝트 명</label>
                    <input type="text" id="project-name" placeholder="프로젝트 이름을 입력하세요">
                </div>
                <div class="form-group">
                    <label for="pm-name">PM(담당자)</label>
                    <input type="text" id="pm-name" placeholder="PM 이름을 입력하세요">
                </div>
                <div class="form-group">
                    <label for="budget">예산</label>
                    <input type="text" id="budget" placeholder="예산을 입력하세요">
                </div>
                <div class="form-group">
                    <label for="client-name">고객사</label>
                    <input type="text" id="client-name" placeholder="고객사를 입력하세요">
                </div>
                <div class="form-group">
                    <label for="client-contact-person">고객사 담당자</label>
                    <input type="text" id="client-contact-person" placeholder="담당자 이름">
                </div>
                <div class="form-group">
                    <label for="client-contact">고객사 연락처</label>
                    <input type="text" id="client-contact" placeholder="연락처를 입력하세요">
                </div>
                <div class="form-group textarea-group">
                    <label for="description">내용</label>
                    <textarea id="description" rows="4" placeholder="프로젝트 내용을 입력하세요"></textarea>
                </div>
            </div>
        </div>

        <!-- 인원 추가하기 섹션 -->
        <div class="section add-personnel">
            <h2>인원 추가하기</h2>
            <div class="personnel-list">
                <button class="add-btn">+</button>
                <input type="text" placeholder="검색" class="search-input">
                <ul class="personnel-options">
                    <li>KHW</li>
                    <li>KEVI</li>
                    <li>KDBL</li>
                    <li>KCIB</li>
                    <li>KBLI</li>
                    <li>KABJ</li>
                </ul>
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

        <!-- 하단 버튼 -->
        <div class="section action-buttons">
           
        </div>
    </div>
</main>

</body>
</html>

