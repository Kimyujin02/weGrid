<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/system/list.css">

<script defer src="/js/common/main.js"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/hung1001/font-awesome-pro@4cac1a6/css/all.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>
        <div class="main-content">
            <h1 class="title">계정 리스트</h1>
            <div class="line-box"></div>

            <div class="top-area">
                <button type="button" class="btn btn-primary" id="create-btn">등록하기</button>
        
                <div class="filter-controls">
                    <select>
                        <option>부서명</option>
                        <option>부서명</option>
                        <option>부서명</option>
                    </select>
                    <select>
                        <option>부서명</option>
                        <option>부서명</option>
                        <option>부서명</option>
                    </select>
                </div>

                <form class="search-box" method="get">
                    <input type="text" name="" placeholder="검색">
                    <i class="fas fa-search"></i>
                </form>
    

                    <button type="button" class="btn btn-primary" id="delete-btn">일괄삭제</button>
            </div>
            

            <div id="account-list">
                <table class="table">
                    <thead class="list-head" id="abc">
                        <tr>
                            <th>ID</th>
                            <th>사원명</th>
                            <th>사번</th>
                            <th>부서</th>
                            <th>직급</th>
                            <th>셍성일</th>
                            <th>권한</th>
                            <th>정보수정</th>
                            <th>사용여부</th>
                            <th>삭제</th>
                        </tr>
                    </thead>
              
                    <tbody >
                        <tr class="list-middle">
                            <!-- tbody안쪽은 js사용해서 동적으로 채워줌   -->
                            <td>kh1234@gamil.com</td>
                            <td>홍길동</td>
                            <td>kh123456</td>
                            <td>영업 1팀</td>
                            <td>부장</td>
                            <td>2024.11.26</td>
                            <td>매니저</td>
                            <td><button type="button" class="btn btn-primary" id="edit-btn">정보수정</button></td>
                            <td>Y</td>
                            <td><input type="checkbox"></td>
                        </tr>
                        <tr class="list-middle">
                            <td>kh1234@gamil.com</td>
                            <td>홍길동</td>
                            <td>kh123456</td>
                            <td>영업 1팀</td>
                            <td>부장</td>
                            <td>2024.11.26</td>
                            <td>매니저</td>
                            <td><button type="button" class="btn btn-primary" id="edit-btn">정보수정</button></td>
                            <td>Y</td>
                            <td><input type="checkbox"></td>
                        </tr>
                        <tr class="list-middle">
                            <td>kh1234@gamil.com</td>
                            <td>홍길동</td>
                            <td>kh123456</td>
                            <td>영업 1팀</td>
                            <td>부장</td>
                            <td>2024.11.26</td>
                            <td>매니저</td>
                            <td><button type="button" class="btn btn-primary" id="edit-btn">정보수정</button></td>
                            <td>Y</td>
                            <td><input type="checkbox"></td>
                        </tr>
                        <tr class="list-middle">
                            <td>kh1234@gamil.com</td>
                            <td>홍길동</td>
                            <td>kh123456</td>
                            <td>영업 1팀</td>
                            <td>부장</td>
                            <td>2024.11.26</td>
                            <td>매니저</td>
                            <td><button type="button" class="btn btn-primary" id="edit-btn">정보수정</button></td>
                            <td>Y</td>
                            <td><input type="checkbox"></td>
                        </tr>
                        <tr class="list-middle">
                            <td>kh1234@gamil.com</td>
                            <td>홍길동</td>
                            <td>kh123456</td>
                            <td>영업 1팀</td>
                            <td>부장</td>
                            <td>2024.11.26</td>
                            <td>매니저</td>
                            <td><button type="button" class="btn btn-primary" id="edit-btn">정보수정</button></td>
                            <td>Y</td>
                            <td><input type="checkbox"></td>
                        </tr>
                        <tr class="list-middle">
                            <td>kh1234@gamil.com</td>
                            <td>홍길동</td>
                            <td>kh123456</td>
                            <td>영업 1팀</td>
                            <td>부장</td>
                            <td>2024.11.26</td>
                            <td>매니저</td>
                            <td><button type="button" class="btn btn-primary" id="edit-btn">정보수정</button></td>
                            <td>Y</td>
                            <td><input type="checkbox"></td>
                        </tr>
                        <tr class="list-middle">
                            <!-- tbody안쪽은 js사용해서 동적으로 채워줌   -->
                            <td>kh1234@gamil.com</td>
                            <td>홍길동</td>
                            <td>kh123456</td>
                            <td>영업 1팀</td>
                            <td>부장</td>
                            <td>2024.11.26</td>
                            <td>매니저</td>
                            <td><button type="button" class="btn btn-primary" id="edit-btn">정보수정</button></td>
                            <td>Y</td>
                            <td><input type="checkbox"></td>
                        </tr>
                        <tr class="list-middle">
                            <!-- tbody안쪽은 js사용해서 동적으로 채워줌   -->
                            <td>kh1234@gamil.com</td>
                            <td>홍길동</td>
                            <td>kh123456</td>
                            <td>영업 1팀</td>
                            <td>부장</td>
                            <td>2024.11.26</td>
                            <td>매니저</td>
                            <td><button type="button" class="btn btn-primary" id="edit-btn">정보수정</button></td>
                            <td>Y</td>
                            <td><input type="checkbox"></td>
                        </tr>
                        <tr class="list-middle">
                            <!-- tbody안쪽은 js사용해서 동적으로 채워줌   -->
                            <td>kh1234@gamil.com</td>
                            <td>홍길동</td>
                            <td>kh123456</td>
                            <td>영업 1팀</td>
                            <td>부장</td>
                            <td>2024.11.26</td>
                            <td>매니저</td>
                            <td><button type="button" class="btn btn-primary" id="edit-btn">정보수정</button></td>
                            <td>Y</td>
                            <td><input type="checkbox"></td>
                        </tr>
                        <tr class="list-middle">
                            <!-- tbody안쪽은 js사용해서 동적으로 채워줌   -->
                            <td>kh1234@gamil.com</td>
                            <td>홍길동</td>
                            <td>kh123456</td>
                            <td>영업 1팀</td>
                            <td>부장</td>
                            <td>2024.11.26</td>
                            <td>매니저</td>
                            <td><button type="button" class="btn btn-primary" id="edit-btn">정보수정</button></td>
                            <td>Y</td>
                            <td><input type="checkbox"></td>
                        </tr>
                        <tr class="list-middle">
                            <!-- tbody안쪽은 js사용해서 동적으로 채워줌   -->
                            <td>kh1234@gamil.com</td>
                            <td>홍길동</td>
                            <td>kh123456</td>
                            <td>영업 1팀</td>
                            <td>부장</td>
                            <td>2024.11.26</td>
                            <td>매니저</td>
                            <td><button type="button" class="btn btn-primary" id="edit-btn">정보수정</button></td>
                            <td>Y</td>
                            <td><input type="checkbox"></td>
                        </tr>
                        
                       
                    </tbody>
                    
                </table>
                
                <div class="bottom-line"></div>
                
            </div>
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
    </main>

</body>
</html>

