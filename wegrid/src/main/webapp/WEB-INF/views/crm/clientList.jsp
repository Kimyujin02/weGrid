<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>WEGRID</title>

    <link rel="stylesheet" href="/css/common/main.css">
    <link rel="stylesheet" href="/css/crm/clientList.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script defer src="/js/common/main.js"></script>
    <script defer src="/js/crm/clientList.js"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>
        <div class="main-content">

            <div class="content-area">

                <!-- row1 -->
                <div class="title-area">
                    <h2 class="title-text">고객사 리스트</h2>
                </div>
                <div class="line_1"></div>
                
                <!-- row2 -->
                <div></div>
                <div class="btn-area">
                    <form action="http://127.0.0.1/crm/enroll" method="get">
                        <button type="submit" class="btn btn-primary">&nbsp;등록&nbsp;</button>
                    </form>
                </div>

                <div class="search-area">
                    <div class="dropdown">
                        <button class="dropdown-toggle">진행 여부 &nbsp;</button>
                        <div class="dropdown-menu">
                          <div class="option-list">

                            <c:forEach items="${clientStatusVoList}" var="clientStatusVo">
                                <label><input type="checkbox" value="${clientStatusVo.no}" />${clientStatusVo.name}</label>
                            </c:forEach>

                          </div>
                        </div>
                    </div>
                    
                    <div class="dropdown">
                        <button class="dropdown-toggle">등급 필터 &nbsp;</button>
                        <div class="dropdown-menu">
                          <div class="option-list">
                            
                            <c:forEach items="${clientRankVoList}" var="clientRankVo">
                                <label><input type="checkbox" value="${clientRankVo.no}" />${clientRankVo.name}</label>
                            </c:forEach>

                          </div>
                        </div>
                    </div>
                    
                    <form class="search-box" method="get">

                        <select id="searchType">
                            <option value="통합">통합</option>
                            <option value="고객사">고객사</option>
                            <option value="고객사 담당자명">고객사 담당자명</option>
                            <option value="담당자 연락처">담당자 연락처</option>
                        </select>

                        <input id="searchInput" type="text" name="" placeholder="검색">
                        <button class="form-submit" type="submit">
                            <i class="fas fa-search"></i>
                        </button>
                    
                    </form>

                </div>
                <div></div>
                
                <!-- row3 -->
                <div></div>
                <div class="table-area">
                    <table class="client-table">
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
                </div>
                <div></div>

                <!-- row4 -->
                <div class="paging-area">
                    <!-- js에서 동적으로 버튼 만들어줌-->
                    <span><a href="#!"><i class="fas fa-angle-double-left fa-lg" style="color: #174880;"></i></a></span>
                    &nbsp;
                    <span><a href="#!"><i class="fas fa-caret-left fa-lg" style="color: #174880;"></i></a></span>
                    &nbsp;
                    <span><a id="black" href="#!">1</a></span>
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