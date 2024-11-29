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
<script defer src="/js/trip/detail.js"></script>


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
                            onclick="openTripModal();" 
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
                            onclick="location.href=`/trip/detail?tno=${tripVo.no-1}`" 
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

         <!-- 모달 -->
      <div id="tripModal" class="tripModal">
        <div class="tripModal-content">
            <div class="tripModal-header">
                <h2>수정하기</h2>
                <button class="close-tripModal" onclick="closeTripModal()">×</button>
              </div>
              <form action="/trip/edit" method="post">
              <div class="tripModal-body">

                      <!-- 왼쪽 섹션 -->
                  <div class="tripModal-left">
                      <div class="form-tripModal" id="date-boc">
                          <div><label>기간 설정</label></div>
                          <div>
                              <div><input type="date" class="shortInput" name="startDate" value="${tripVo.startDate}"></div>
                              <div>~</div>
                              <div><input type="date" class="shortInput" name="endDate" value="${tripVo.endDate}"></div>
                          </div>
                          
                      </div>
                      <div class="form-tripModal">
                          <label>항목태그</label>
                          <div class="radio-group">
                              <label><input type="radio" name="typeNo" value="1"> 프로젝트</label>
                              <label><input type="radio" name="typeNo" value="2"> 기술지원</label>
                              <label><input type="radio" name="typeNo" value="3"> 교육</label>
                              <label><input type="radio" name="typeNo" value="4"> 영업</label>
                              <label><input type="radio" name="typeNo" value="5"> 유지보수</label>
                              <label><input type="radio" name="typeNo" value="6"> 기타</label>
                          </div>
                          <input type="text" placeholder="기타 내용" class="longInput" id="gita">
                      </div>
                      <div class="form-tripModal" id="api-div">
                          <label>출장지</label>
                          <input type="text" id="sample6_postcode" placeholder="우편번호" class="longInput" value="${tripVo.firstAddress}">
                          <input type="text" id="sample6_address" placeholder="주소" class="longInput" value="${tripVo.secondAddress}">
                          <input type="text" id="sample6_detailAddress" placeholder="상세주소" class="longInput" value="${tripVo.thirdAddress}">
                          <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" class="longInput">
                          <input type="hidden" name="destination" id="address">
                          
                      </div>
                      
                      <div class="form-tripModal">
                          <label>고객사 회사명</label>
                          <input type="text" placeholder="신규입력" class="longInput" name="client" value="${tripVo.client}">
                      </div>
                  </div>
                  <!-- 오른쪽 섹션 -->
                  <div class="tripModal-right">
                      <div><label>제목</label></div>
                      <div id="titleDiv"><input type="text" placeholder="제목" class="longInput" name="title" value="${tripVo.title}"></div>
                      <div><label>내용</label></div>
                      <div><textarea placeholder="내용" name="content" value="${tripVo.content}"></textarea></div>
                  </div>
              </div>
              <div class="tripModal-footer">
                  <button class="submit-btn" type="submit" onclick="combineAdress();">수정</button>
              </div>
          </div>
      </form>
      </div>
            
    </main>
      
    
</body>
</html>

