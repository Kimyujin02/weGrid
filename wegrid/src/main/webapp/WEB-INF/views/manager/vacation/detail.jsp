<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/manager/vacation/detail.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script defer src="/js/common/main.js"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>
        <div class="main-content">
            <h1 class="section-title">휴가조회</h1>
            <div class="summary-table">
                <table class="table">
                    <thead class="list-top">
                        <tr>
                            <th class="num">이름</th>
                            <th>휴가</th>
                            <th>장기 근속</th>
                            <th>단축근무 휴가</th>
                            <th>등록 휴가</th>
                            <th>사용 휴가</th>
                            <th>등록 가능 잔여 휴가</th>
                            <th>등록 가능 잔여 휴가</th>
                        </tr>
                    </thead>

                    <tbody >
                        <tr class="list-middle">
                            <!-- tbody안쪽은 js사용해서 동적으로 채워줌   -->
                            <td>22</td>
                            <td>3</td>
                            <td>3</td>
                            <td>3</td>
                            <td>3</td>
                            <td>3</td>
                            <td>3</td>
                            <td>3</td>
                        </tr>
                    </tbody>
                </table>
                <div class="bottom-line"></div>


                <table class="table">
                    <thead class="list-top">
                        <tr>
                            <th>전체</th>
                            <th>오전 반차</th>
                            <th>오후 반차</th>
                            <th>연차 휴가</th>
                            <th>단축근무</th>
                            <th>특근 오전</th>
                            <th>특근 오후</th>
                            <th>특근 연차</th>
                            <th>보건 휴가</th>
                            <th>예비군</th>
                            <th>민방위 오전</th>
                            <th>민방위 오후</th>
                            <th>기타 오전</th>
                            <th>기타 오후</th>
                            <th>기타 연차</th>
                        </tr>
                    </thead>

                    <tbody >
                        <tr class="list-middle">
                            <!-- tbody안쪽은 js사용해서 동적으로 채워줌   -->
                            <td>33</td>
                            <td>1</td>
                            <td>3</td>
                            <td>2</td>
                            <td>5</td>
                            <td>6</td>
                            <td>1</td>
                            <td>3</td>
                            <td>2</td>
                            <td>3</td>
                            <td>1</td>
                            <td>2</td>
                            <td>2</td>
                            <td>2</td>
                            <td>0</td>
                        </tr>
                    </tbody>
                </table>
                <div class="bottom-line"></div>

            </div>

            <h1 class="section-title">휴가 사용내역</h1>
            <div class="history-controls">
                <div class="date-controls">
                    <button class="arrow-btn">◀</button>
                    <span class="current-date">2024 11월</span>
                    <button class="arrow-btn">▶</button>
                </div>
                <div class="filter-controls">
                    <select>
                        <option>부서명</option>
                    </select>
                    <input type="text" placeholder="검색어 입력" />
                    <button class="search-btn">🔍</button>
                </div>
            </div>
                <table class="table">
                    <thead class="list-top">
                        <tr>
                            <th class="num">부서명</th>
                            <th>사원명</th>
                            <th>시작일 ID</th>
                            <th>종료일</th>
                            <th>휴가 내용</th>
                            <th>구분</th>
                            <th>총 기간</th>
                            <th>수정 및 삭제</th>
                        </tr>
                    </thead>

                    <tbody >
                        <tr class="list-middle">
                            <!-- tbody안쪽은 js사용해서 동적으로 채워줌   -->
                            <td>영업지원1팀</td>
                            <td>홍길동</td>
                            <td>2024-11-18</td>
                            <td>2024-11-21</td>
                            <td>휴가라는 내용임</td>
                            <td>연차</td>
                            <td>4</td>
                            <td><button class="edit">수정</button> <button class="delete">삭제</button></td>
                        </tr>
                        <tr class="list-middle">
                            <td>영업지원1팀</td>
                            <td>홍길동</td>
                            <td>2024-11-18</td>
                            <td>2024-11-21</td>
                            <td>휴가라는 내용임</td>
                            <td>연차</td>
                            <td>4</td>
                            <td><button class="edit">수정</button> <button class="delete">삭제</button></td>
                        </tr>
                        <tr class="list-middle">
                            <td>영업지원1팀</td>
                            <td>홍길동</td>
                            <td>2024-11-18</td>
                            <td>2024-11-21</td>
                            <td>휴가라는 내용임</td>
                            <td>연차</td>
                            <td>4</td>
                            <td><button class="edit">수정</button> <button class="delete">삭제</button></td>
                        </tr>
                        <tr class="list-middle">
                            <td>영업지원1팀</td>
                            <td>홍길동</td>
                            <td>2024-11-18</td>
                            <td>2024-11-21</td>
                            <td>휴가라는 내용임</td>
                            <td>연차</td>
                            <td>4</td>
                            <td><button class="edit">수정</button> <button class="delete">삭제</button></td>
                        </tr>
                        <tr class="list-middle">
                            <td>영업지원1팀</td>
                            <td>홍길동</td>
                            <td>2024-11-18</td>
                            <td>2024-11-21</td>
                            <td>휴가라는 내용임</td>
                            <td>연차</td>
                            <td>4</td>
                            <td><button class="edit">수정</button> <button class="delete">삭제</button></td>
                        </tr>
                        <tr class="list-middle">
                            <td>영업지원1팀</td>
                            <td>홍길동</td>
                            <td>2024-11-18</td>
                            <td>2024-11-21</td>
                            <td>휴가라는 내용임</td>
                            <td>연차</td>
                            <td>4</td>
                            <td><button class="edit">수정</button> <button class="delete">삭제</button></td>
                        </tr>
                        <tr class="list-middle">
                            <td>영업지원1팀</td>
                            <td>홍길동</td>
                            <td>2024-11-18</td>
                            <td>2024-11-21</td>
                            <td>휴가라는 내용임</td>
                            <td>연차</td>
                            <td>4</td>
                            <td><button class="edit">수정</button> <button class="delete">삭제</button></td>
                        </tr>
                        <tr class="list-middle">
                            <td>영업지원1팀</td>
                            <td>홍길동</td>
                            <td>2024-11-18</td>
                            <td>2024-11-21</td>
                            <td>휴가라는 내용임</td>
                            <td>연차</td>
                            <td>4</td>
                            <td><button class="edit">수정</button> <button class="delete">삭제</button></td>
                        </tr>
                        <tr class="list-middle">
                            <td>영업지원1팀</td>
                            <td>홍길동</td>
                            <td>2024-11-18</td>
                            <td>2024-11-21</td>
                            <td>휴가라는 내용임</td>
                            <td>연차</td>
                            <td>4</td>
                            <td><button class="edit">수정</button> <button class="delete">삭제</button></td>
                        </tr>
                        <tr class="list-middle">
                            <td>영업지원1팀</td>
                            <td>홍길동</td>
                            <td>2024-11-18</td>
                            <td>2024-11-21</td>
                            <td>휴가라는 내용임</td>
                            <td>연차</td>
                            <td>4</td>
                            <td><button class="edit">수정</button> <button class="delete">삭제</button></td>
                        </tr>
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
                    <span><a href="#!">5</a></span>
                    <span><a href="#!"><i class="fas fa-caret-right fa-lg" style="color: #174880;"></i></a></span>
                    <span><a href="#!"><i class="fas fa-angle-double-right fa-lg" style="color: #174880;"></i></a></span>
                </div>

            </div>
        </div>
    </main>

</body>
</html>

