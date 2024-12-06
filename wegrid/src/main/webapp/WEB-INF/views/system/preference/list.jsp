<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/system/preference/list.css">
<script defer src="/js/common/main.js"></script>
<script defer src="/js/system/preference/list.js"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav-system.jsp" %>

    <!-- Main -->
    <main>
        <div class="main-content">
            <div class="list-box">
                <div class="title-area">
                    <h3>고객사 등급</h3>
                    <div class="addBtn">+</div>
                    <!-- <button>추가하기</button> -->
                </div>
                <div class="list-area">
                    <table>
                        <thead>
                            <tr>
                                <th>항목</th>
                                <th>수정</th>
                                <th>삭제</th>
                            </tr>
                        </thead>
                        <tbody>
                            
                        </tbody>
                    </table>
                </div>
                <div class="bottom-area">

                </div>
            </div>
            <div class="list-box">
                <div class="title-area">
                    <h3>출장 항목</h3>
                </div>

            </div>
            <div class="list-box">
                <div class="title-area">
                    <h3>부서 항목</h3>
                </div>
            </div>
            <div class="list-box">
                <div class="title-area">
                    <h3>직급 목록</h3>
                </div>
                
            </div>
            <div class="list-box">
                <div class="title-area">
                    <h3>휴가 항목</h3>
                </div>
                
            </div>
            <div class="list-box">
                <div class="title-area">
                    <h3>직급 별 연차</h3>
                </div>

            </div>
        </div>
    </main>

</body>
</html>

