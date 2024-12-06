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
<script defer src="/js/system/list.js"></script>

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
                <button type="button" class="btn btn-primary" id="create-btn" onclick="location.href='/system/create'">등록하기</button>
                
                <div class="filter-controls">
                    <!-- 부서명 필터링 값 -->
                    <select name="departmentNo">
                        <c:foreach var="deptVo" items="${DepartmentVoList}">
                            <option value="${deptVo.code}">${deptVo.name}</option>
                        </c:foreach>
                    </select>
                     
                    <!-- 직급명 필터링 값 -->
                    <select name="jobInfoVo">
                        <c:forEach items="${JobInfoVoList}" var="jobVo">
                            <option value="${jobVo.no}">${jobVo.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <form class="search-box" method="get">
                    <input type="text" name="" placeholder="검색">
                    <i class="fas fa-search"></i>
                </form>
    
                    <button type="button" class="btn btn-primary" id="delete-btn" onclick="deleteList();">일괄삭제</button>
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
                            <th><input type="checkbox" onclick="handleCheckbox(this);">삭제</th>
                        </tr>
                    </thead>
              
                    <tbody >
                        <tr class="list-middle">
                            <c:forEach items="${empVoList}" var="vo">
                                <input type="hidden" value="${vo.no}">
                                <td>${vo.id}</td>
                                <td>${vo.name}</td>
                                <td>${vo.empNo}</td>
                                <td>${vo.deptName}</td>
                                <td>${vo.jobName}</td>
                                <td>${vo.enrollDate}</td>
                                <td>${isManager}</td>
                                <td><button type="button" class="btn btn-primary" id="edit-btn" onclick="location.href='/system/edit?no=${vo.no}'">정보수정</button></td>
                                <td>${delYn}</td>
                                <td class="checkbox-td"><input type="checkbox" name="del"></td>
                            </c:forEach>
                           
                        </tr>
                        <tr class="list-middle">
                            <td>kh1234@gamil.com</td>
                            <td>홍길동</td>
                            <td>kh123456</td>
                            <td>영업 1팀</td>
                            <td>부장</td>
                            <td>2024.11.26</td>
                            <td>매니저</td>
                            <td></td>
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
                    <c:if test="${pvo.startPage != 1}">
                <a href="/notice/list?pno=${pvo.startPage-1}&searchValue=${searchValue}"><i class="fas fa-caret-left fa-lg" style="color: #174880;"></i></a>
                </c:if>
                <c:forEach begin="${pvo.startPage}" end="${pvo.endPage}" var="i" step="1">
                    <a href="/notice/list?pno=${i}&searchValue=${searchValue}">${i}</a>
                </c:forEach>
                <c:if test="${pvo.endPage != pvo.maxPage}">
                    <a href="/notice/list?pno=${pvo.endPage+1}&searchValue=${searchValue}"><i class="fas fa-caret-right fa-lg" style="color: #174880;"></i></a>
                </c:if>
                </div>
        
            </div>
    </main>

</body>
</html>

