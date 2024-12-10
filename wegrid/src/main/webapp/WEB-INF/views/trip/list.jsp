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
<script defer src="/js/trip/list.js"></script>
<!-- jquery -->
<script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <style>
    .wrong_text{font-size:1rem;color:#f44e38;letter-spacing:-.2px;font-weight:300;margin:8px 0 2px;line-height:1em;display:none}
  </style>

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
                <div class="fil-btn-div"><button class="fil-btn-z" onclick="loadTripList();">출장목록</button></div>
                <div class="fil-btn-div"><button class="fil-btn-z" onclick="endTripList();">완료출장</button></div>
                <div></div>
                <div></div>
                <form  onsubmit="return submitSearchForm();">
                    <div id="type-boc"> 
                        <select name="searchType" id="trip-filter" >
                            <option value="all">전체</option>
                            <option value="content">내용</option>
                            <option value="title">제목</option>
                            <option value="writerName">작성자</option>
                            <option value="no">번호</option>
                            <option value="client">고객사</option>
                        </select>
                    </div>
                <div id="iwannagohome">
                    <div  id="search-boc">
                        <input type="text" name="searchValue" placeholder="검색" id="searchTag">
                        <span>
                            <button type="submit" id="searchBtn" onclick="return submitSearchForm();">
                                <i class="fas fa-search" id="search-i"></i>
                            </button>
                        </span>
                    </div>
                    </form>
               
                </div>
                <div id="btn-area">
                    <button type="button" 
                    class="btn btn-primary" 
                    id="bootbtn" 
                    onclick="openTripModal();">등록하기
                    </button>
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
                
                    <tbody>
                       
                    </tbody>
                </table>
            </div>
            <div class="bottom-line"></div>
            <div class="page">
                
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
                <form action="/trip/write" method="post">
                <div class="tripModal-body">

                        <!-- 왼쪽 섹션 -->
                    <div class="tripModal-left">
                        <div class="form-tripModal" id="date-boc">
                            <div><label>기간 설정</label></div>
                            <div>
                                <div><input type="date" class="shortInput" name="startDate"></div>
                                <div>~</div>
                                <div><input type="date" class="shortInput" name="endDate"></div>
                            </div>
                            
                        </div>
                        <div class="form-tripModal">
                            <label>항목태그</label>
                            <div class="radio-group">
                                <c:forEach items="${typeVoList}" var="vo">
                                    <label><input type="radio" name="typeNo" value="${vo.no}">${vo.name}</label>
                                </c:forEach>
                            </div>
                            <input type="text" placeholder="기타 내용" class="longInput" id="gita">
                        </div>
                        <div class="form-tripModal" id="api-div">
                            <label>출장지</label>
                            <input type="text" id="sample6_postcode" placeholder="우편번호" class="longInput" readonly="readonly" name="postAddress">
                            <input type="text" id="sample6_address" placeholder="주소" class="longInput" readonly="readonly" name="roadAddress">
                            <input type="text" id="sample6_detailAddress" placeholder="상세주소" class="longInput" name="detailAddress">
                            <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" class="longInput">
                            <input type="hidden" name="aaaaaaaaaaaa" id="address">
                            
                        </div>
                        
                        <div class="form-tripModal">
                            <label>고객사 회사명</label>
                            <input type="text" placeholder="신규입력" class="longInput" name="client">
                        </div>
                    </div>
                    <!-- 오른쪽 섹션 -->
                    <div class="tripModal-right">
                        <div><label>제목</label></div>
                        <div id="titleDiv"><input type="text" placeholder="제목" class="longInput" name="title"></div>
                        <div><label>내용</label></div>
                        <div><textarea placeholder="내용" name="content"></textarea></div>
                    </div>
                </div>
                <div class="tripModal-footer">
                    <button class="submit-btn" type="submit" onclick="return sub();">등록</button>
                </div>
            </div>
        </form>
        </div>
    
</body>
</html>







