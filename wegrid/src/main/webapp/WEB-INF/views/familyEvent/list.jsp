<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/familyEvent/list.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script defer src="/js/common/main.js"></script>
<script defer src="/js/familyEvent/list.js"></script>
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
            <div id="title-area"><h2>경조사 게시판</h2></div>
            <div id="menu-box">
                <div></div>
                <div id="btn-area"><button type="button" 
                    class="btn btn-primary" 
                    id="bootbtn" 
                    onclick="openFamilyEventNotion();">등록하기
                </button>
            </div>
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
                
                <div></div>
            </div>
            <div id="table-area">
                
                <table id="table">
                    <!-- <colgroup>
                        <col style="width: 150px;"> 
                        <col style="width: 596px;">
                        <col style="width: 150px;">
                        <col style="width: 150px;">
                        <col style="width: 150px;">
                        <col style="width: 150px;">
                    </colgroup> -->
                    <thead>
                        <tr>
                            <th class="list-top">분류</th>
                            <th class="list-top">내용</th>
                            <th class="list-top">위치</th>
                            <th class="list-top">부서</th>
                            <th class="list-top">작성자</th>
                            <th class="list-top">날짜</th>
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
      
    
</body>
</html>







