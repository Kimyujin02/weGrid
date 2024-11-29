<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/manager/vacation/list.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script defer src="/js/common/main.js"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>
        <div class="main-content">
            <div class="main-head">
                <div class="head-top">
                    <h1 class="section-title">휴가 관리</h1>
                </div>
                <div class="head-bottom">
                    <div class="head-bottom-align">
                        <div class="history-controls">
                            <div class="filter-controls">
                            <label>
                                <h5>잔여 휴가 존재 </h5><input type="checkbox" name="option" value="remain-vacation-check">
                            </label>
                            <select>
                                <option>필터링</option>
                                <option>팀1</option>
                                <option>팀2</option>
                                <option>팀3</option>
                                <option>팀4</option>
                                <option>팀5</option>
                            </select>
                            <select>
                                <option>올해</option>
                                <option>이번달</option>
                                <option>1주일</option>
                                <option>3일</option>
                                <option>1일</option>
                                <option>전체기간</option>
                            </select>
                            <input type="text" placeholder="검색어 입력" />
                            <button class="search-btn">🔍</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="main-bottom">
                    <div class="bottom-top">
                    </div>
                    <div class="bottom-bottom">



                            <table class="table">
                                <thead class="list-top">
                                    <tr>
                                        <th>사원명</th>
                                        <th>사번</th>
                                        <th>부서</th>
                                        <th>직급</th>
                                        <th>전체 휴가</th>
                                        <th>사용 휴가</th>
                                        <th>잔여 휴가</th>
                                        <th>휴가 수정</th>
                                    </tr>
                                </thead>

                                <tbody >
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>홍길동</td>
                                        <td>KH123</td>
                                        <td>경영1팀</td>
                                        <td>사원</td>
                                        <td>30</td>
                                        <td>9</td>
                                        <td>21</td>
                                        <td><button class="edit">수정</button></td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>홍길동</td>
                                        <td>KH123</td>
                                        <td>경영1팀</td>
                                        <td>사원</td>
                                        <td>30</td>
                                        <td>9</td>
                                        <td>21</td>
                                        <td><button class="edit">수정</button></td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>홍길동</td>
                                        <td>KH123</td>
                                        <td>경영1팀</td>
                                        <td>사원</td>
                                        <td>30</td>
                                        <td>9</td>
                                        <td>21</td>
                                        <td><button class="edit">수정</button></td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>홍길동</td>
                                        <td>KH123</td>
                                        <td>경영1팀</td>
                                        <td>사원</td>
                                        <td>30</td>
                                        <td>9</td>
                                        <td>21</td>
                                        <td><button class="edit">수정</button></td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>홍길동</td>
                                        <td>KH123</td>
                                        <td>경영1팀</td>
                                        <td>사원</td>
                                        <td>30</td>
                                        <td>9</td>
                                        <td>21</td>
                                        <td><button class="edit">수정</button></td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>홍길동</td>
                                        <td>KH123</td>
                                        <td>경영1팀</td>
                                        <td>사원</td>
                                        <td>30</td>
                                        <td>9</td>
                                        <td>21</td>
                                        <td><button class="edit">수정</button></td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>홍길동</td>
                                        <td>KH123</td>
                                        <td>경영1팀</td>
                                        <td>사원</td>
                                        <td>30</td>
                                        <td>9</td>
                                        <td>21</td>
                                        <td><button class="edit">수정</button></td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>홍길동</td>
                                        <td>KH123</td>
                                        <td>경영1팀</td>
                                        <td>사원</td>
                                        <td>30</td>
                                        <td>9</td>
                                        <td>21</td>
                                        <td><button class="edit">수정</button></td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>홍길동</td>
                                        <td>KH123</td>
                                        <td>경영1팀</td>
                                        <td>사원</td>
                                        <td>30</td>
                                        <td>9</td>
                                        <td>21</td>
                                        <td><button class="edit">수정</button></td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>홍길동</td>
                                        <td>KH123</td>
                                        <td>경영1팀</td>
                                        <td>사원</td>
                                        <td>30</td>
                                        <td>9</td>
                                        <td>21</td>
                                        <td><button class="edit">수정</button></td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>홍길동</td>
                                        <td>KH123</td>
                                        <td>경영1팀</td>
                                        <td>사원</td>
                                        <td>30</td>
                                        <td>9</td>
                                        <td>21</td>
                                        <td><button class="edit">수정</button></td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>홍길동</td>
                                        <td>KH123</td>
                                        <td>경영1팀</td>
                                        <td>사원</td>
                                        <td>30</td>
                                        <td>9</td>
                                        <td>21</td>
                                        <td><button class="edit">수정</button></td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>홍길동</td>
                                        <td>KH123</td>
                                        <td>경영1팀</td>
                                        <td>사원</td>
                                        <td>30</td>
                                        <td>9</td>
                                        <td>21</td>
                                        <td><button class="edit">수정</button></td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>홍길동</td>
                                        <td>KH123</td>
                                        <td>경영1팀</td>
                                        <td>사원</td>
                                        <td>30</td>
                                        <td>9</td>
                                        <td>21</td>
                                        <td><button class="edit">수정</button></td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>홍길동</td>
                                        <td>KH123</td>
                                        <td>경영1팀</td>
                                        <td>사원</td>
                                        <td>30</td>
                                        <td>9</td>
                                        <td>21</td>
                                        <td><button class="edit">수정</button></td>
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
            </div>
        </div>
    </main>

</body>
</html>

