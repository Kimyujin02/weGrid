<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/project/list.css">

<script defer src="/js/common/main.js"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/hung1001/font-awesome-pro@4cac1a6/css/all.css" />

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
        <main>
            <div class="main-content " id="main-content">
            <div id="content">
                <h2 class="sub-title">프로젝트 리스트</h2>

                <div class="table-controls">
                    <button type="button" class="btn btn-primary"  id="approvalBtn" >등록</button>
                    <div class="date-area">
                        <button class="arrow-btn">&lt;</button>
                        <span class="date">2024.10.18</span>
                        <button class="arrow-btn">&gt;</button>
                    </div>
                  
                    <div class="filter-controls">
                        <select>
                            <option value="전체">전체</option>
                            <option value="진행중">진행</option>
                            <option value="완료">완료</option>
                            <option value="철회">철회</option>
                            <option value="준비">준비</option>
                        </select>
                        <a href="/project/list"><span style="color:#565C67; gap: 5px;" ><i class="fas fa-list fa-lg"></i></span></a>
  
                    <div class="square-icon">
                        <a href="/project/card"><span style="color:#565C67"><i class="fas fa-th-large fa-lg "></i></span></a>
                    </div>

                        <div class="search-box">
                            <input type="text" placeholder="검색" />
                            <i class="fas fa-search"></i>
                        </div>
                        
                    </div>
                </div>
                <table class="project-table">
                    <thead>
                        <tr>
                            <th>프로젝트명</th>
                            <th>PM</th>
                            <th>고객사</th>
                            <th>고객사 담당자</th>
                            <th>기간</th>
                            <th>투입 인원</th>
                            <th>진행 상태</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>프로젝트1</td>
                            <td>차은우</td>
                            <td>신한 은행</td>
                            <td>황철웅</td>
                            <td>2024.10 ~ 2025.01</td>
                            <td>10명</td>
                            <td><span class="status1">준비</span></td>
                        </tr>
                        <tr>
                            <td>프로젝트2</td>
                            <td>차은우</td>
                            <td>신한 은행</td>
                            <td>황철웅</td>
                            <td>2024.10 ~ 2025.01</td>
                            <td>30명</td>
                            <td><span class="status completed">완료</span></td>
                        </tr>
                        <tr>
                            <td>프로젝트1</td>
                            <td>차은우</td>
                            <td>신한 은행</td>
                            <td>황철웅</td>
                            <td>2024.10 ~ 2025.01</td>
                            <td>10명</td>
                            <td><span class="status ongoing">진행</span></td>
                        </tr>
                        <tr>
                            <td>프로젝트1</td>
                            <td>차은우</td>
                            <td>신한 은행</td>
                            <td>황철웅</td>
                            <td>2024.10 ~ 2025.01</td>
                            <td>10명</td>
                            <td><span class="status ongoing">진행</span></td>
                        </tr>
                        <tr>
                            <td>프로젝트1</td>
                            <td>차은우</td>
                            <td>신한 은행</td>
                            <td>황철웅</td>
                            <td>2024.10 ~ 2025.01</td>
                            <td>10명</td>
                            <td><span class="status ongoing">진행</span></td>
                        </tr>
                        <tr>
                            <td>프로젝트1</td>
                            <td>차은우</td>
                            <td>신한 은행</td>
                            <td>황철웅</td>
                            <td>2024.10 ~ 2025.01</td>
                            <td>10명</td>
                            <td><span class="status completed">완료</span></td>
                        </tr>
                        <tr>
                            <td>프로젝트1</td>
                            <td>차은우</td>
                            <td>신한 은행</td>
                            <td>황철웅</td>
                            <td>2024.10 ~ 2025.01</td>
                            <td>10명</td>
                            <td><span class="status ongoing">진행</span></td>
                        </tr>
                        <tr>
                            <td>프로젝트1</td>
                            <td>차은우</td>
                            <td>신한 은행</td>
                            <td>황철웅</td>
                            <td>2024.10 ~ 2025.01</td>
                            <td>10명</td>
                            <td><span class="status ongoing">진행</span></td>
                        </tr>
                        <tr>
                            <td>프로젝트1</td>
                            <td>차은우</td>
                            <td>신한 은행</td>
                            <td>황철웅</td>
                            <td>2024.10 ~ 2025.01</td>
                            <td>10명</td>
                            <td><span class="status4">철회</span></td>
                        </tr>
                        <tr>
                            <td>프로젝트1</td>
                            <td>차은우</td>
                            <td>신한 은행</td>
                            <td>황철웅</td>
                            <td>2024.10 ~ 2025.01</td>
                            <td>10명</td>
                            <td><span class="status1">준비</span></td>
                        </tr>
                        <tr>
                            <td>프로젝트2</td>
                            <td>차은우</td>
                            <td>신한 은행</td>
                            <td>황철웅</td>
                            <td>2024.10 ~ 2025.01</td>
                            <td>30명</td>
                            <td><span class="status completed">완료</span></td>
                        </tr>
                        <tr>
                            <td>프로젝트2</td>
                            <td>차은우</td>
                            <td>신한 은행</td>
                            <td>황철웅</td>
                            <td>2024.10 ~ 2025.01</td>
                            <td>30명</td>
                            <td><span class="status completed">완료</span></td>
                        </tr>
                        <tr>
                            <td>프로젝트1</td>
                            <td>차은우</td>
                            <td>신한 은행</td>
                            <td>황철웅</td>
                            <td>2024.10 ~ 2025.01</td>
                            <td>10명</td>
                            <td><span class="status ongoing">진행</span></td>
                        </tr>
                        
                        <!-- 추가 행들 -->
                    </tbody>
                </table>
                </div>
                <div class="bottom-line"></div>
                <div class="page">
                    <!-- js에서 동적으로 버튼 만들어줌-->
                    <span><a href="#!"><i class="fas fa-angle-double-left fa-lg" style="color: #174880;"></i></a></span>
                    <span><a href="#!"><i class="fas fa-caret-left fa-lg" style="color: #174880;"></i></a></span>
                    <span><a href="#!">1</a></span>
                    <span><a href="#!">2</a></span>
                    <span><a href="#!">3</a></span>
                    <span><a href="#!">4</a></span>
                    <span><a href="#!">5</a></span>
                    <span><a href="#!"><i class="fas fa-caret-right fa-lg" style="color: #174880;"></i></a></span>
                    <span><a href="#!"><i class="fas fa-angle-double-right fa-lg" style="color: #174880;"></i></a></span>
                </div>
            </div>
        </div>
    
    </main>
    
        
    </body>
    </html>
    