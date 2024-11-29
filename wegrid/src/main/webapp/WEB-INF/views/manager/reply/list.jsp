<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/manager/reply/list.css">
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
                    <h1 class="section-title">댓글 관리</h1>
                </div>
                <div class="head-bottom">
                    <div class="head-bottom-align">
                        <div class="history-controls">
                            <div class="filter-controls">
                            <select>
                                <option>제목</option>
                                <option>내용</option>
                                <option>제목+내용</option>
                                <option>작성자</option>
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
                            <button class="delete">삭제</button>
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
                                        <th>원글 제목</th>
                                        <th class="title-width">댓글내용</th>
                                        <th>작성자</th>
                                        <th>작성일</th>
                                        <th>
                                            <label class="th-checkbox">
                                                <input type="checkbox" name="option" value="delete-check">
                                            </label>
                                        </th>
                                    </tr>
                                </thead>

                                <tbody >
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>고파배</td>
                                        <td>고파고파고파배</td>
                                        <td>홍로드</td>
                                        <td>2024-11-14</td>
                                        <td>
                                            <label>
                                                <input type="checkbox" name="option" value="delete-check">
                                            </label>
                                        </td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>고파배</td>
                                        <td>고파고파고파배</td>
                                        <td>홍로드</td>
                                        <td>2024-11-14</td>
                                        <td>
                                            <label>
                                                <input type="checkbox" name="option" value="delete-check">
                                            </label>
                                        </td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>고파배</td>
                                        <td>고파고파고파배</td>
                                        <td>홍로드</td>
                                        <td>2024-11-14</td>
                                        <td>
                                            <label>
                                                <input type="checkbox" name="option" value="delete-check">
                                            </label>
                                        </td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>고파배</td>
                                        <td>고파고파고파배</td>
                                        <td>홍로드</td>
                                        <td>2024-11-14</td>
                                        <td>
                                            <label>
                                                <input type="checkbox" name="option" value="delete-check">
                                            </label>
                                        </td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>고파배</td>
                                        <td>고파고파고파배</td>
                                        <td>홍로드</td>
                                        <td>2024-11-14</td>
                                        <td>
                                            <label>
                                                <input type="checkbox" name="option" value="delete-check">
                                            </label>
                                        </td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>고파배</td>
                                        <td>고파고파고파배</td>
                                        <td>홍로드</td>
                                        <td>2024-11-14</td>
                                        <td>
                                            <label>
                                                <input type="checkbox" name="option" value="delete-check">
                                            </label>
                                        </td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>고파배</td>
                                        <td>고파고파고파배</td>
                                        <td>홍로드</td>
                                        <td>2024-11-14</td>
                                        <td>
                                            <label>
                                                <input type="checkbox" name="option" value="delete-check">
                                            </label>
                                        </td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>고파배</td>
                                        <td>고파고파고파배</td>
                                        <td>홍로드</td>
                                        <td>2024-11-14</td>
                                        <td>
                                            <label>
                                                <input type="checkbox" name="option" value="delete-check">
                                            </label>
                                        </td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>고파배</td>
                                        <td>고파고파고파배</td>
                                        <td>홍로드</td>
                                        <td>2024-11-14</td>
                                        <td>
                                            <label>
                                                <input type="checkbox" name="option" value="delete-check">
                                            </label>
                                        </td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>고파배</td>
                                        <td>고파고파고파배</td>
                                        <td>홍로드</td>
                                        <td>2024-11-14</td>
                                        <td>
                                            <label>
                                                <input type="checkbox" name="option" value="delete-check">
                                            </label>
                                        </td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>고파배</td>
                                        <td>고파고파고파배</td>
                                        <td>홍로드</td>
                                        <td>2024-11-14</td>
                                        <td>
                                            <label>
                                                <input type="checkbox" name="option" value="delete-check">
                                            </label>
                                        </td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>고파배</td>
                                        <td>고파고파고파배</td>
                                        <td>홍로드</td>
                                        <td>2024-11-14</td>
                                        <td>
                                            <label>
                                                <input type="checkbox" name="option" value="delete-check">
                                            </label>
                                        </td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>고파배</td>
                                        <td>고파고파고파배</td>
                                        <td>홍로드</td>
                                        <td>2024-11-14</td>
                                        <td>
                                            <label>
                                                <input type="checkbox" name="option" value="delete-check">
                                            </label>
                                        </td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>고파배</td>
                                        <td>고파고파고파배</td>
                                        <td>홍로드</td>
                                        <td>2024-11-14</td>
                                        <td>
                                            <label>
                                                <input type="checkbox" name="option" value="delete-check">
                                            </label>
                                        </td>
                                    </tr>
                                    <tr class="list-middle">
                                        <!-- tbody안쪽은 js사용해서 동적으로 채워줌 -->
                                        <td>고파배</td>
                                        <td>고파고파고파배</td>
                                        <td>홍로드</td>
                                        <td>2024-11-14</td>
                                        <td>
                                            <label>
                                                <input type="checkbox" name="option" value="delete-check">
                                            </label>
                                        </td>
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

