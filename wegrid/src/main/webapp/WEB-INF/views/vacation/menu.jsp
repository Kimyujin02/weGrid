<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/vacation/menu.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script defer src="/js/common/main.js"></script>
<script defer src="/js/vacation/menu.js"></script>

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
                        <th>보유 휴가</th>
                        <th>등록 휴가</th>
                        <th>사용 휴가</th>
                        <th>등록 가능 잔여 휴가</th>
                    </tr>
                </thead>

                <tbody >
                    <tr class="list-middle">
                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌   -->
                        <td>${name}</td>
                        <td>${vacCnt}</td>
                        <td>${totalUsed}</td>
                        <td>${totalUsed}</td>
                        <td>${vacCnt - totalUsed}</td>
                    </tr>
                </tbody>
            </table>
            <div class="bottom-line"></div>
            
            <table class="table">
                <thead class="list-top">
                    <tr>
                        <th>전체</th>
                        <th>연차</th>
                        <th>오전 반차</th>
                        <th>오후 반차</th>
                        <th>병가</th>
                        <th>특근</th>
                        <th>육아휴직</th>
                        <th>경조사</th>
                        <th>예비군</th>
                        <th>휴직</th>
                        <th>기타</th>
                    </tr>
                </thead>

                <tbody >
                    <tr class="list-middle">
                        <td>ㅇㅇㅇ합산값</td>
                        <c:forEach begin="1" end="10" var="i">
                            <td>
                                <c:forEach var="vo2" items="${selectPersonalCnt}">
                                    <c:if test="${vo2.vactype == i}">
                                        ${vo2.dayoftype}
                                    </c:if>
                                </c:forEach>
                            </td>
                        </c:forEach>
                    </tr>
                </tbody>
            </table>
            <div class="bottom-line"></div>
        </div>

        <button class="register-btn" onclick="openVacationModal();">휴가 등록하기</button>

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
          
                <tbody>
                    <c:forEach items="${selectAllVacationList}" var="x">
                        <tr class="user-history">
                            <td>${x.deptName}</td>
                            <td>${x.name}</td>
                            <td>${x.startDate}</td>
                            <td>${x.endDate}</td>
                            <td>${x.content}</td>
                            <td>${x.vacTypeName}</td>
                            <td>${x.cnt}</td>
                            <td><button class="edit" onclick="openVacationModal();">수정</button> <button class="delete">삭제</button></td>
                        </tr>
                    </c:forEach>
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

        <!-- 모달 -->

                  <div id="vacationModal" class="vacationModal">
                    <div class="vacationModal-content">
                        <div class="vacationModal-header">
                            <h2>휴가등록</h2>
                            <button class="close-vacationModal" onclick="closeVacationModal()">×</button>
                        </div>
                        <div class="vacationModal-body">
                            <!-- 왼쪽 섹션 -->
                            <form action="/vacation/menu" method="post">
                            <div class="vacationModal-left">
                                <div class="form-vacationModal">
                                    <label>기간 설정</label>
                                    <input type="date" id="startDate" name="startDate"> ~ <input type="date" id="endDate" name="endDate">
                                </div>
                                <div class="form-vacationModal">
                                    <label>항목태그</label>
                                    <div class="checkbox-group">
                                        <label><input type="radio" name="vacTypeNo" value="1"> 연차</label>
                                        <label><input type="radio" name="vacTypeNo" value="2"> 오전반차</label>
                                        <label><input type="radio" name="vacTypeNo" value="3"> 오후반차</label>
                                        <label><input type="radio" name="vacTypeNo" value="4"> 병가</label>
                                        <label><input type="radio" name="vacTypeNo" value="5"> 특근</label>

                                        <label><input type="radio" name="vacTypeNo" value="6"> 육아휴직</label>
                                        <label><input type="radio" name="vacTypeNo" value="7"> 경조사</label>
                                        <label><input type="radio" name="vacTypeNo" value="8"> 예비군</label>
                                        <label><input type="radio" name="vacTypeNo" value="9"> 휴직</label>
                                        <label><input type="radio" name="vacTypeNo" value="10"> 기타</label>
                                    </div>

                                    <input type="text" name="content" id="content" placeholder="휴가 내용">
                                </div>
                            </div>

                        </div>
                        <div class="vacationModal-footer">
                            <button class="submit-btn">등록</button>
                            <button class="submit-btn">수정</button>
                        </div>
                </form>
                </div><!-- 모달 -->


    </div>

    </main>

</body>
</html>

