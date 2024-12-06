<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/approval/submitList.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script defer src="/js/common/main.js"></script>
<script defer src="/js/approval/submitList.js"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>
        <div id="main-area">
            <div id="title-area">
                <div></div>
                <div><h2>결재상신함</h2></div>
                <div></div>
            </div>
            <div id="menu-box">
                <div></div>
                <div id="filterDiv">
                    <select name="statusFilter" id="approval-status" onchange="return submitSearchForm(this);">
                    <option value="">전체</option>
                    <option value="1">대기</option>
                    <option value="2">진행</option>
                    <option value="3">승인</option>
                    <option value="4">반려</option>
                </select>
            </div>
                <div id="btn-area">
                    <button type="button" 
                    class="btn btn-primary" 
                    id="approvalBtn"
                    onclick="location.href='/approval/write'" 
                    >등록하기
                </button>
                </div>
                
            </div>
            <div id="table-area">
                
                <table id="table">
                    <colgroup>
                        <col style="width: 150px;"> <!-- 첫 번째 열의 너비 -->
                        <col style="width: 200px;"> <!-- 첫 번째 열의 너비 -->
                        <col style="width: 694px;"> <!-- 두 번째 열의 너비 -->
                        <col style="width: 150px;"> <!-- 세 번째 열의 너비 -->
                        <col style="width: 150px;"> <!-- 세 번째 열의 너비 -->
                    </colgroup>
                    <thead>
                        <tr>
                            <th class="list-top">번호</th>
                            <th class="list-top">등록일</th>
                            <th class="list-top">제목</th>
                            <th class="list-top">최종 결재자</th>
                            <th class="list-top">진행 상태</th>
                        </tr>
                    </thead>
                
                    <tbody >
                       
                        

                        
                    </tbody>
                </table>
            </div>
            <div class="bottom-line"></div>
            <div class="page">
               
            </div>
        </div>
            
    </main>

    
</body>
</html>

