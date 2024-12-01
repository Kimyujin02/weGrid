<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/vacation/enroll.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script defer src="/js/common/main.js"></script>
<script src="/js/trip/list.js"></script>

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

            <button class="register-btn" onclick="openTripModal();">휴가 등록하기</button>

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
                            <td><button class="edit" onclick="openTripModal();">수정</button> <button class="delete">삭제</button></td>
                        </tr>
                        <tr class="list-middle">
                            <td>영업지원1팀</td>
                            <td>홍길동</td>
                            <td>2024-11-18</td>
                            <td>2024-11-21</td>
                            <td>휴가라는 내용임</td>
                            <td>연차</td>
                            <td>4</td>
                            <td><button class="edit" onclick="openTripModal();">수정</button> <button class="delete">삭제</button></td>
                        </tr>
                        <tr class="list-middle">
                            <td>영업지원1팀</td>
                            <td>홍길동</td>
                            <td>2024-11-18</td>
                            <td>2024-11-21</td>
                            <td>휴가라는 내용임</td>
                            <td>연차</td>
                            <td>4</td>
                            <td><button class="edit" onclick="openTripModal();">수정</button> <button class="delete">삭제</button></td>
                        </tr>
                        <tr class="list-middle">
                            <td>영업지원1팀</td>
                            <td>홍길동</td>
                            <td>2024-11-18</td>
                            <td>2024-11-21</td>
                            <td>휴가라는 내용임</td>
                            <td>연차</td>
                            <td>4</td>
                            <td><button class="edit" onclick="openTripModal();">수정</button> <button class="delete">삭제</button></td>
                        </tr>
                        <tr class="list-middle">
                            <td>영업지원1팀</td>
                            <td>홍길동</td>
                            <td>2024-11-18</td>
                            <td>2024-11-21</td>
                            <td>휴가라는 내용임</td>
                            <td>연차</td>
                            <td>4</td>
                            <td><button class="edit" onclick="openTripModal();">수정</button> <button class="delete">삭제</button></td>
                        </tr>
                        <tr class="list-middle">
                            <td>영업지원1팀</td>
                            <td>홍길동</td>
                            <td>2024-11-18</td>
                            <td>2024-11-21</td>
                            <td>휴가라는 내용임</td>
                            <td>연차</td>
                            <td>4</td>
                            <td><button class="edit" onclick="openTripModal();">수정</button> <button class="delete">삭제</button></td>
                        </tr>
                        <tr class="list-middle">
                            <td>영업지원1팀</td>
                            <td>홍길동</td>
                            <td>2024-11-18</td>
                            <td>2024-11-21</td>
                            <td>휴가라는 내용임</td>
                            <td>연차</td>
                            <td>4</td>
                            <td><button class="edit" onclick="openTripModal();">수정</button> <button class="delete">삭제</button></td>
                        </tr>
                        <tr class="list-middle">
                            <td>영업지원1팀</td>
                            <td>홍길동</td>
                            <td>2024-11-18</td>
                            <td>2024-11-21</td>
                            <td>휴가라는 내용임</td>
                            <td>연차</td>
                            <td>4</td>
                            <td><button class="edit" onclick="openTripModal();">수정</button> <button class="delete">삭제</button></td>
                        </tr>
                        <tr class="list-middle">
                            <td>영업지원1팀</td>
                            <td>홍길동</td>
                            <td>2024-11-18</td>
                            <td>2024-11-21</td>
                            <td>휴가라는 내용임</td>
                            <td>연차</td>
                            <td>4</td>
                            <td><button class="edit" onclick="openTripModal();">수정</button> <button class="delete">삭제</button></td>
                        </tr>
                        <tr class="list-middle">
                            <td>영업지원1팀</td>
                            <td>홍길동</td>
                            <td>2024-11-18</td>
                            <td>2024-11-21</td>
                            <td>휴가라는 내용임</td>
                            <td>연차</td>
                            <td>4</td>
                            <td><button class="edit" onclick="openTripModal();">수정</button> <button class="delete">삭제</button></td>
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

            <!-- 모달 -->
                  <div id="tripModal" class="tripModal">
                    <div class="tripModal-content">
                        <div class="tripModal-header">
                            <h2>출장등록</h2>
                            <button class="close-tripModal" onclick="closeTripModal()">×</button>
                        </div>
                        <div class="tripModal-body">
                            <!-- 왼쪽 섹션 -->
                            <div class="tripModal-left">
                                <div class="form-tripModal">
                                    <label>기간 설정</label>
                                    <input type="date"> ~ <input type="date">
                                </div>
                                <div class="form-tripModal">
                                    <label>항목태그</label>
                                    <div class="checkbox-group">
                                        <label><input type="checkbox"> 기술지원</label>
                                        <label><input type="checkbox"> 프로젝트</label>
                                        <label><input type="checkbox"> 교육</label>
                                        <label><input type="checkbox"> 영업</label>
                                        <label><input type="checkbox"> 유지보수</label>
                                        <label><input type="checkbox"> 기타</label>
                                    </div>
                                    <input type="text" placeholder="기타 내용">
                                </div>
                            </div>
                            <!-- 오른쪽 섹션 -->
                            <div class="tripModal-right">
                                <div class="form-tripModal">
                                    <label>휴가 사유</label>
                                    <br>
                                    <input type="text" placeholder="사유 입력">
                                </div>
                            </div>
                        </div>
                        <div class="tripModal-footer">
                            <button class="submit-btn">등록</button>
                            <button class="submit-btn">수정</button>
                        </div>
                    </div><!-- 모달 -->


        </div>
    </main>

</body>
</html>

