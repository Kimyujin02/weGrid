<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>WEGRID</title>

    <link rel="stylesheet" href="/css/common/main.css">
    <script defer src="/js/common/main.js"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="/css/crm/clientList.css">

    <script defer src="/js/crm/clientList.js"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>
        <div class="main-content">

            <div class="container">

                <div class="title"> 고객사 리스트 </div>
                
                <hr>

                <div></div>
                <div class="enroll-btn">
                    <button>등록</button>
                </div>
                <div class="search">
                    <div class="dropdown">
                        <button class="dropdown-toggle">진행 여부 &nbsp; <i class="fa-solid fa-chevron-down"></i></button></button>
                        <div class="dropdown-menu">
                          <div class="option-list">
                            <label>
                              <input type="checkbox" value="진행중" />
                              진행중
                            </label>
                            <label>
                              <input type="checkbox" value="미진행" />
                              미진행
                            </label>
                          </div>
                        </div>
                    </div>
                    
                    <div class="dropdown">
                        <button class="dropdown-toggle">등급 필터 &nbsp; <i class="fa-solid fa-chevron-down"></i></button>
                        <div class="dropdown-menu">
                          <div class="option-list">
                            <label>
                              <input type="checkbox" value="S" />
                              S
                            </label>
                            <label>
                              <input type="checkbox" value="A" />
                              A
                            </label>
                            <label>
                              <input type="checkbox" value="B" />
                              B
                            </label>
                            <label>
                              <input type="checkbox" value="C" />
                              C
                            </label>
                            <label>
                              <input type="checkbox" value="D" />
                              D
                            </label>
                          </div>
                        </div>
                    </div>
                    
                    <select id="searchType">
                        <option value="통합">통합</option>
                        <option value="고객사">고객사</option>
                        <option value="고객사 담당자명">고객사 담당자명</option>
                        <option value="담당자 연락처">담당자 연락처</option>
                    </select>
                    
                    <form class="search-box" method="get">
                        <input type="text" name="" placeholder="검색">
                        <i class="fas fa-search"></i>
                    </form>
                </div>
                <div></div>
                
                <div></div>
                <table class="table">
                    <thead class="list-top">
                        <tr>
                            <th class="num">번호</th>
                            <th class="client-name">고객사</th>
                            <th class="client-grade">등급</th>
                            <th class="enroll-date">등록일</th>
                        </tr>
                    </thead>
              
                    <tbody>
                        <tr class="list-middle">
                            <!-- tbody안쪽은 js사용해서 동적으로 채워줌   -->
                            <td>1</td>
                            <td>KH 정보교육원</td>
                            <td>S</td>
                            <td>2024-11-26</td>
                        </tr>
                        <tr class="list-middle">
                            <td>2</td>
                            <td>KA 정보교육원</td>
                            <td>A</td>
                            <td>2024-11-26</td>
                        </tr>
                        <tr class="list-middle">
                            <td>3</td>
                            <td>KB 정보교육원</td>
                            <td>B</td>
                            <td>2024-11-26</td>
                        </tr>
                        <tr class="list-middle">
                            <td>4</td>
                            <td>KC 정보교육원</td>
                            <td>C</td>
                            <td>2024-11-26</td>
                        </tr>
                        <tr class="list-middle">
                            <td>5</td>
                            <td>KD 정보교육원</td>
                            <td>D</td>
                            <td>2024-11-26</td>
                        </tr>
                        <tr class="list-middle">
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr class="list-middle">
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr class="list-middle">
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr class="list-middle">
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr class="list-middle">
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr class="list-middle">
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr class="list-middle">
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr class="list-middle">
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr class="list-middle">
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr class="list-middle">
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </tbody>
                    <tfoot>
                        <tr class="list-end">
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </tfoot>
                </table>
                <div></div>

                <div class="page">
                    <!-- js에서 동적으로 버튼 만들어줌-->
                    <span><a href="#!"><i class="fas fa-angle-double-left fa-lg" style="color: #174880;"></i></a></span>
                    &nbsp;
                    <span><a href="#!"><i class="fas fa-caret-left fa-lg" style="color: #174880;"></i></a></span>
                    &nbsp;
                    <span><a href="#!">1</a></span>
                    &nbsp;
                    <span><a href="#!">2</a></span>
                    &nbsp;
                    <span><a href="#!">3</a></span>
                    &nbsp;
                    <span><a href="#!"><i class="fas fa-caret-right fa-lg" style="color: #174880;"></i></a></span>
                    &nbsp;
                    <span><a href="#!"><i class="fas fa-angle-double-right fa-lg" style="color: #174880;"></i></a></span>
                </div>

            </div>

        </div>
    </main>

</body>
</html>