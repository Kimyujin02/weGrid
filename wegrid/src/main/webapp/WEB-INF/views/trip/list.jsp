<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/trip/list.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script defer src="/js/common/main.js"></script>
<script src="/js/trip/list.js"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>
        <div id="main-area">
            <div id="title-area"><h2>출장 항목</h2></div>
            <div id="menu-box">
                <div></div>
                <div id="btn-area"><button type="button" 
                    class="btn btn-primary" 
                    id="bootbtn" 
                    onclick="openTripModal();">등록하기
                </button>
            </div>
            <div></div>
            <div>필터</div>
            <div>
                <select name="" id="">
                        <option value=""></option>
                    </select>
                </div>
                <div>
                    <form class="search-box" method="get">
                
                    <select name="" id="trip-filter">
                        <option value="">전체</option>
                        <option value="">내용</option>
                        <option value="">제목</option>
                        <option value="">제목+내용</option>
                        <option value="">고객사</option>
                    </select>
                    
                    <input type="text" name="" placeholder="검색" id="searchTag">
                    <i class="fas fa-search"></i>
                    </form>
                </div>
                
                <div></div>
            </div>
            <div id="table-area">
                
                <table id="table">
                    <colgroup>
                        <col style="width: 150px;"> <!-- 첫 번째 열의 너비 -->
                        <col style="width: 596px;"> <!-- 두 번째 열의 너비 -->
                        <col style="width: 150px;"> <!-- 세 번째 열의 너비 -->
                        <col style="width: 150px;"> <!-- 세 번째 열의 너비 -->
                        <col style="width: 150px;"> <!-- 세 번째 열의 너비 -->
                        <col style="width: 150px;"> <!-- 세 번째 열의 너비 -->
                    </colgroup>
                    <thead>
                        <tr>
                            <th class="list-top">번호</th>
                            <th class="list-top">제목</th>
                            <th class="list-top">시작일</th>
                            <th class="list-top">종료일</th>
                            <th class="list-top">작성자</th>
                            <th class="list-top">출장항목</th>
                        </tr>
                    </thead>
                
                    <tbody >
                        <tr class="list-middle">
                            <td>5</td>
                            <td>출장갑니다</td>
                            <td>2024/11/25</td>
                            <td>2024-11-26</td>
                            <td>홍길동</td>
                            <td>기술지원</td>
                        </tr>
                        <tr class="list-middle">
                            <td>서울</td>
                            <td>출장갑니다</td>
                            <td>2024/11/25</td>
                            <td>2024-11-26</td>
                            <td>홍길동</td>
                            <td>기술지원</td>
                        </tr>
                        <tr class="list-middle">
                            <td>서울</td>
                            <td>출장갑니다</td>
                            <td>2024/11/25</td>
                            <td>2024-11-26</td>
                            <td>홍길동</td>
                            <td>기술지원</td>
                        </tr>
                        <tr class="list-middle">
                            <td>서울</td>
                            <td>출장갑니다</td>
                            <td>2024/11/25</td>
                            <td>2024-11-26</td>
                            <td>홍길동</td>
                            <td>기술지원</td>
                        </tr>
                        <tr class="list-middle">
                            <td>서울</td>
                            <td>출장갑니다</td>
                            <td>2024/11/25</td>
                            <td>2024-11-26</td>
                            <td>홍길동</td>
                            <td>기술지원</td>
                        </tr>
                        <tr class="list-middle">
                            <td>서울</td>
                            <td>출장갑니다</td>
                            <td>2024/11/25</td>
                            <td>2024-11-26</td>
                            <td>홍길동</td>
                            <td>기술지원</td>
                        </tr>
                        <tr class="list-middle">
                            <td>서울</td>
                            <td>출장갑니다</td>
                            <td>2024/11/25</td>
                            <td>2024-11-26</td>
                            <td>홍길동</td>
                            <td>기술지원</td>
                        </tr>
                        <tr class="list-middle">
                            <td>서울</td>
                            <td>출장갑니다</td>
                            <td>2024/11/25</td>
                            <td>2024-11-26</td>
                            <td>홍길동</td>
                            <td>기술지원</td>
                        </tr>
                        <tr class="list-middle">
                            <td>서울</td>
                            <td>출장갑니다</td>
                            <td>2024/11/25</td>
                            <td>2024-11-26</td>
                            <td>홍길동</td>
                            <td>기술지원</td>
                        </tr>
                        <tr class="list-middle">
                            <td>서울</td>
                            <td>출장갑니다</td>
                            <td>2024/11/25</td>
                            <td>2024-11-26</td>
                            <td>홍길동</td>
                            <td>기술지원</td>
                        </tr>
                        <tr class="list-middle">
                            <td>서울</td>
                            <td>출장갑니다</td>
                            <td>2024/11/25</td>
                            <td>2024-11-26</td>
                            <td>홍길동</td>
                            <td>기술지원</td>
                        </tr>
                        <tr class="list-middle">
                            <td>서울</td>
                            <td>출장갑니다</td>
                            <td>2024/11/25</td>
                            <td>2024-11-26</td>
                            <td>홍길동</td>
                            <td>기술지원</td>
                        </tr>
                        <tr class="list-middle">
                            <td>서울</td>
                            <td>출장갑니다</td>
                            <td>2024/11/25</td>
                            <td>2024-11-26</td>
                            <td>홍길동</td>
                            <td>기술지원</td>
                        </tr>
                        <tr class="list-middle">
                            <td>서울</td>
                            <td>출장갑니다</td>
                            <td>2024/11/25</td>
                            <td>2024-11-26</td>
                            <td>홍길동</td>
                            <td>기술지원</td>
                        </tr>
                        <tr class="list-middle">
                            <td>서울</td>
                            <td>출장갑니다</td>
                            <td>2024/11/25</td>
                            <td>2024-11-26</td>
                            <td>홍길동</td>
                            <td>기술지원</td>
                        </tr>

                        

                       
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
            
    </main>
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
                    <div class="form-tripModal">
                        <label>출장지</label>
                        <input type="text" placeholder="경기도 무슨시 무슨구 ...">
                    </div>
                    
                    <div class="form-tripModal">
                        <label>고객사 회사명</label>
                        <input type="text" placeholder="신규입력">
                    </div>
                </div>
                <!-- 오른쪽 섹션 -->
                <div class="tripModal-right">
                    <div class="form-tripModal">
                        <label>제목 및 내용</label>
                        <br>
                        <input type="text" placeholder="제목">
                        <br>
                        <br>
                        <textarea placeholder="내용"></textarea>
                    </div>
                </div>
            </div>
            <div class="tripModal-footer">
                <button class="submit-btn">등록</button>
            </div>
        </div>
    </div>
    
</body>
</html>

