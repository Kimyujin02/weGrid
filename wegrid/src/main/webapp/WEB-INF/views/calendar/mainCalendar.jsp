<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css" rel="stylesheet">
<script defer src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/index.global.min.js"></script>
<!-- <script defer src="https://cdn.jsdelivr.net/npm/@fullcalendar/bootstrap5@6.1.15/index.global.min.js"></script> -->

<link rel="stylesheet" href="/css/calendar/fullCalendar.css">
<script defer src="/js/calendar/fullcalendar.js"></script>

<link rel="stylesheet" href="/css/calendar/mainCalendar.css">
<script defer src="/js/calendar/mainCalendar.js"></script>

<link rel="stylesheet" href="/css/common/main.css">
<script defer src="/js/common/main.js"></script>

</head>
<body>

    <!-- 헤더 -->
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
    <!-- 사이드 네비게이션 -->
    <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>
        <!-- calendar 선택 박스 -->
        <div class="calendar-filter-area">
            <div class="filter-box personal-calendar-color selected-calendar" id="personal" no="1">
                개인
            </div>
            <div class="filter-box department-calendar-color selected-calendar" id="department" no="2">
                부서
            </div>
            <div class="filter-box project-calendar-color selected-calendar" id="project" no="3">
                프로젝트
            </div>
        </div>  
        <!-- calendar 영역-->
        <div class="main-content"> 
            <div id="calendar"></div> 
        </div>
        <!-- 모달창 include -->
        <%@ include file="/WEB-INF/views/calendar/write.jsp" %>
        <%@ include file="/WEB-INF/views/calendar/detail.jsp" %>
        <%@ include file="/WEB-INF/views/calendar/edit.jsp" %>
    </main>
    
</body>
</html>

