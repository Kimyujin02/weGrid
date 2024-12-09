<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/crm/clientDetail.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script defer src="/js/crm/clientDetail.js"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>
        <div class="main-content">
            
            <div class="info-area">
                <div class="title-name">
                    <h4>고객사 정보</h4>
                    <button onclick="location.href='/crm/edit?cno=${param.cno}'">
                        <i class="fa-solid fa-pen-to-square fa-xl" style="color: #174880;"></i>
                    </button>
                </div>
                
                <div class="client-info">
                    <div class="blueTag">고객사 명</div>
                    <div class="whiteTag">${vo.name}</div>
                    <div class="blueTag">대표</div>
                    <div class="whiteTag">${vo.presidentName}</div>
                    <div class="blueTag">이메일</div>
                    <div class="whiteTag">${vo.presidentEmail}</div>
                    <div class="blueTag">대표 번호</div>
                    <div class="whiteTag">${vo.presidentPhone}</div>
                    
                    <div class="info-line"></div>
                    
                    <div class="blueTag">주소</div>
                    <div class="whiteTag" id="addressName">${vo.roadAddress}&nbsp;${vo.detailAddress}</div>
                    <div class="blueTag">등급</div>
                    <div class="whiteTag">${vo.rankName}</div>
                    <div class="blueTag">거래 시작일</div>
                    <div class="whiteTag">${vo.startDate.split(" ")[0]}</div>

                    <div class="info-line"></div>
                </div>
                <div></div>
            </div>

            <div class="blank_space"></div>

            <div class="content-area">

                <div class="tab_filter_search">
                    <div></div>
                    <div class="prjTab"><button onclick="location.href='/crm/project?cno=${param.cno}'">프로젝트</button></div>
                    <div class="hisTab"><button onclick="location.href='/crm/history?cno=${param.cno}'">히스토리</button></div>
                    <div></div>
                    <div></div>
                    <!-- <div class="dropdown" id="drop">
                        <button class="dropdown-toggle">진행 현황 &nbsp;</button>
                        <div class="dropdown-menu">
                          <div class="option-list">
                            <label><input type="checkbox" value="대기" />대기</label>
                            <label><input type="checkbox" value="진행" />진행</label>
                            <label><input type="checkbox" value="완료" />완료</label>
                          </div>
                        </div>
                    </div> -->
                    <div></div>
                    <form class="search-box" method="get" action="/crm/detail">

                        <input type="hidden" name="cno" value="${param.cno}">
                        <input id="searchInput" type="text" name="searchValue" placeholder="검색">
                        <button class="form-submit" type="submit">
                            <i class="fas fa-search"></i>
                        </button>
                    
                    </form>
                    <div></div>
                </div>

                <div class="content-line"></div>

                <div class="table-area">
                    <table class="client-table">
                        <thead class="list-top">
                            <tr>
                                <th class="num">NO</th>
                                <th class="prj-name">프로젝트명</th>
                                <th class="prj-prog">진행 현황</th>
                                <th class="period">기간</th>
                            </tr>
                        </thead>
                  
                        <tbody>
                            <td>로딩중</td>

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

                <div class="paging-area">

                </div>

            </div>

        </div>
    </main>

</body>
</html>