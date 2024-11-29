<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/index.global.min.js"></script>
<!--<script src="https://cdn.jsdelivr.net/npm/@fullcalendar/bootstrap5@6.1.15/index.global.min.js"></script>-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css" rel="stylesheet">

<link defer rel="stylesheet" href="/css/calendar/fullCalendar.css">
<script defer src="/js/calendar/write.js"></script>
<script defer src="/js/calendar/fullcalendar.js"></script>

<link rel="stylesheet" href="/css/common/main.css">
<script defer src="/js/common/main.js"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>

        <div class="main-content">
            <div id="calendar"></div>
        </div>

        <%@ include file="/WEB-INF/views/calendar/write.jsp" %>

    </main>

</body>
</html>

