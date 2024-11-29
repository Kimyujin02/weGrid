<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/trip/detail.css">

<script defer src="/js/common/main.js"></script>


</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>
        <div id="main-area">
            <div id="title-area"><h2>출장 상세조회</h2></div>
            <div></div>
            <div id="detail-area">
                <div></div>
                <div>
                    <div>출장 상세 내용</div>
                    <div>${tripVo.content}</div>
                    <div></div>
                </div>
                <div></div>
                <div>
                    <div id="f-area">
                        <div class="centerplease">
                            <div >출장번호</div>
                            <div>제목</div>
                            <div>항목</div>
                            <div>고객사</div>
                        </div>
                        <div class="centerplease-second">
                            <div>${tripVo.no}</div>
                            <div>${tripVo.title}</div>
                            <div>${tripVo.typeName}</div>
                            <div>${tripVo.client}</div>
                        </div>
                        <div></div>
                    </div>
                    <div></div>
                    <div id="s-area">
                        <div class="centerplease">
                            <div>작성자</div>
                            <div>출장지</div>
                            <div>시작일</div>
                            <div>출발일</div>
                        </div>
                        <div class="centerplease-second">
                            <div>${tripVo.writerName}</div>
                            <div>${tripVo.destination}</div>
                            <div>${tripVo.startDate}</div>
                            <div>${tripVo.endDate}</div>
                        </div>
                        <div></div>
                    </div>
                    <div id="t-area">
                        <div id="updateBtnDiv"><button type="button" 
                            class="btn btn-primary" 
                            id="updateBtn" 
                            >수정하기
                        </button></div>
                        <div id="deleteBtnDiv"><button type="button" 
                            class="btn btn-primary" 
                            id="deleteBtn" 
                            >삭제하기
                        </button></div>
                    </div>
                    <div></div>
                    <div id="q-area">
                        <div><button type="button" 
                            class="btn btn-primary" 
                            id="preBtn"
                            onclick="prePage(){
                                 location.href=`/trip/detail?tno=${tripVo.no}`
                            };" 
                            >이전항목
                        </button></div>
                        <div><button type="button" 
                            class="btn btn-primary" 
                            id="listBtn" 
                            >목록
                        </button></div>
                        <div id="nextBtnDiv"><button type="button" 
                            class="btn btn-primary" 
                            id="nextBtn" 
                            >다음항목
                        </button></div>
                    </div>
                </div>
                <div></div>
            </div>
            <div></div>
        </div>
            
    </main>
      
    
</body>
</html>

