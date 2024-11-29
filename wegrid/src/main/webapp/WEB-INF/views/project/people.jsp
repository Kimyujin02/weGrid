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
                    <a href="/project/edit"><i class="fas fa-edit" style="color:#666;"></i></a>
                </div>
                <table class="project-table">
                    <thead>
                        <tr style="border-top: 1px solid #797979ab;">
                            <th>프로젝트 명</th>
                            <td>${projectName}</td>
                            <th>담당 PM</th>
                            <td>${pmName}</td>
                            <th>고객사 담당자</th>
                            <td></td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th>고객사</th>
                            <td>${clientName}</td>
                            <th>고객 등급</th>
                            <td>A</td>
                            <th>고객사 연락처</th>
                            <td>010-1234-5678</td>
                        </tr>
                        <tr>
                            <th>진행 현황</th>
                            <td><span class="status-label progress" style="text-align: center;">진행중</span></td>
                            <th>예산</th>
                            <td>₩3,000,000,000</td>
                            <th>프로젝트 기간</th>
                            <td>2024.01.18 ~ 2024.12.10</td>
                        </tr>
                        <tr>
                            <th>내용</th>
                            <td colspan="5">${description}</td>
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
                        <a href="/project/people" class="sidebar-btn active" id="btn1">
                            <i class="fas fa-user-friends"></i> 
                        </a>
                        <a href="/project/attach" class="sidebar-btn" id="btn2">
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
                                <th>담당업무</th>
                                <th>이메일</th>
                                <th>시작일</th>
                                <th>종료일</th>
                            </tr>
                        </thead>
                  
                        <tbody >
                            <c:forEach items="${voList}" var="vo">
                                <tr class="list-middle">
                                    <td>${vo.employeeName}</td>
                                    <td>${vo.empNo}</td>
                                    <td>${vo.jobName}</td>
                                    <td>몰루?</td>
                                    <td>${vo.email}</td>
                                    <td>${vo.startDate}</td>
                                    <td>${vo.endDate}</td>
                                </tr>
                            </c:forEach>
                            
                            <tr class="list-middle">
                                <td>홍길동</td>
                                <td>kh123456</td>
                                <td>영업 1팀</td>
                                <td>몰루?</td>
                                <td>kh1234@gmail.com</td>
                                <td>2024.11.22</td>
                                <td>2024.12.10</td>
                            </tr>
                            <tr class="list-middle">
                                <td>홍길동</td>
                                <td>kh123456</td>
                                <td>영업 1팀</td>
                                <td>몰루?</td>
                                <td>kh1234@gmail.com</td>
                                <td>2024.11.22</td>
                                <td>2024.12.10</td>
                            </tr>
                            <tr class="list-middle">
                                <td>홍길동</td>
                                <td>kh123456</td>
                                <td>영업 1팀</td>
                                <td>몰루?</td>
                                <td>kh1234@gmail.com</td>
                                <td>2024.11.22</td>
                                <td>2024.12.10</td>
                            </tr>
                            <tr class="list-middle">
                                <td>홍길동</td>
                                <td>kh123456</td>
                                <td>영업 1팀</td>
                                <td>몰루?</td>
                                <td>kh1234@gmail.com</td>
                                <td>2024.11.22</td>
                                <td>2024.12.10</td>
                            </tr>
                            <tr class="list-middle"><td colspan="8" class="empty-row">데이터가 없습니다.</td></tr>
                            <tr class="list-middle"><td colspan="8" class="empty-row">데이터가 없습니다.</td></tr>
                            <tr class="list-middle"><td colspan="8" class="empty-row">데이터가 없습니다.</td></tr>
                            <tr class="list-middle"><td colspan="8" class="empty-row">데이터가 없습니다.</td></tr>
                            <tr class="list-middle"><td colspan="8" class="empty-row">데이터가 없습니다.</td></tr>
                            <tr class="list-middle"><td colspan="8" class="empty-row">데이터가 없습니다.</td></tr>
                            <tr class="list-middle"><td colspan="8" class="empty-row">데이터가 없습니다.</td></tr>
                            <tr class="list-middle"><td colspan="8" class="empty-row">데이터가 없습니다.</td></tr>
                            <tr class="list-middle"><td colspan="8" class="empty-row">데이터가 없습니다.</td></tr>
                        </tbody>
                        
                    </table>
                    <div class="bottom-line"></div>
                    <div class="page">
                        <!-- js에서 동적으로 버튼 만들어줌-->
                        <span><a href="#!"><i class="fas fa-angle-double-left fa-lg" style="color: #174880;"></i></a></span>
                        <span><a href="#!"><i class="fas fa-caret-left fa-lg" style="color: #174880;"></i></a></span>
                        <span><a href="#!">1</a></span>
                        <span><a href="#!">2</a></span>
                        <span><a href="#!">3</a></span>
                        <span><a href="#!">4</a></span>
                        <span><a href="#!"><i class="fas fa-caret-right fa-lg" style="color: #174880;"></i></a></span>
                        <span><a href="#!"><i class="fas fa-angle-double-right fa-lg" style="color: #174880;"></i></a></span>
                    </div>
                </div>

                </div>
            </div>
        </div>
        
        <!-- 일정추가/ 현재 참여인원 관리 섹션 -->
         <div class="sub-info">
            <!-- 일정 추가 버튼 -->
            <div class="add-btn">
                <button type="button" class="btn btn-primary"  id="schedule-btn" > + 일정 등록</button>
            </div>

            <!-- 현재 참여인원 -->
            <div class="profile-card">
                <div class="profile">
                    <img src="profile1.jpg" alt="사원" class="profile-img">
                    <div class="profile-info">
                        <span class="name">김태훈</span>
                        <span class="role">조장</span>
                    </div>
                </div>
                <hr>
                <div class="profile">
                    <img src="profile2.jpg" alt="왕두수" class="profile-img">
                    <div class="profile-info">
                        <span class="name">왕두수</span>
                        <span class="role">디자인팀</span>
                    </div>
                </div>
                <hr>
                <div class="profile">
                    <img src="profile3.jpg" alt="???" class="profile-img">
                    <div class="profile-info">
                        <span class="name">????</span>
                        <span class="role">??</span>
                    </div>
                </div>
                <hr>
                <div class="profile">
                    <img src="profile3.jpg" alt="???" class="profile-img">
                    <div class="profile-info">
                        <span class="name">????</span>
                        <span class="role">??</span>
                    </div>
                </div>
                <hr>
                <div class="profile">
                    <img src="profile3.jpg" alt="???" class="profile-img">
                    <div class="profile-info">
                        <span class="name">????</span>
                        <span class="role">??</span>
                    </div>
                </div>
                <hr>
            </div>
            
         </div>
        </div>
    </main>

</body>
</html>

