<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

    <link rel="stylesheet" href="/css/common/main.css">
    <link rel="stylesheet" href="/css/myPage/edit.css">

    <script defer src="/js/common/main.js"></script>

    <!-- 카카오 우편번호 서비스 스크립트 추가 (최신 경로) -->
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>
        <div class="main-content">

            <form class="content-area" action="/mypage/edit" method="post">
                <!-- row1 -->
                <div class="title-area">
                    <h2 class="title-text">개인 정보 수정</h2>
                </div>

                <!-- line1 -->
                <div class="line_1"></div> 

                <!-- row2 -->
                <div></div>

                <!-- row3 -->
                <div class="input-area">

                    <div class="info-input">
                        <div>이름&nbsp;&nbsp;&nbsp;</div>
                        <input type="text" name="name" value="${vo.name}">
                    </div>
                    <div class="line_2"></div>
                    <div class="info-input">
                        <div>아이디</div>
                        <input type="text" name="id" value="${vo.id}" readonly>
                    </div>
                    <div class="line_2"></div>
                    <div class="info-input">
                        <div>이메일</div>
                        <input type="email" name="email" value="${vo.email}">
                    </div>
                    <div class="line_2"></div>
                    <div class="info-input">
                        <div>연락처</div>
                        <input type="text" name="phone" value="${vo.phone}">
                    </div>
                    <div class="line_2"></div>
                    <div class="client-address">
                        <div class="text-address">주소&nbsp;&nbsp;&nbsp;</div>
                        
                        <!-- 우편번호 입력 칸 -->
                        <div class="address-input_1">
                            <input type="text" name="postAddress" id="postAddress" value="${vo.postAddress}" readonly placeholder="우편번호">
                        </div>
                        
                        <div class="address-btn">
                            <!-- 우편번호 버튼 -->
                            <button type="button" class="btn btn-primary" id="postalCodeBtn">우편번호</button>
                        </div>
                    
                        <div></div>
                        <div class="address-input_2">
                            <!-- 도로명 주소 입력 칸 -->
                            <input type="text" name="roadAddress" id="roadAddress" value="${vo.roadAddress}" readonly placeholder="도로명 주소">
                        </div>
                    
                        <div></div>
                        <div class="address-input_3">
                            <!-- 상세 주소 입력 칸 -->
                            <input type="text" name="detailAddress" id="detailAddress" value="${vo.detailAddress}" placeholder="상세 주소">
                        </div>
                    </div>
                </div>

                <!-- row4 -->
                <div class="btn-area">
                    <div class="enroll-btn"><button type="submit" class="btn btn-primary">수정</button></div>
                    <div class="cancel-btn"><button type="button" class="btn btn-primary" onclick="location.href='/mypage/home'">취소</button></div>
                </div>

            </form>

        </div>
    </main>

    <!-- 카카오 우편번호 서비스 기능 구현 -->
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            if (typeof daum !== 'undefined') {
                // 우편번호 버튼 클릭 시
                document.getElementById("postalCodeBtn").onclick = function() {
                    // 우편번호 API 실행
                    new daum.Postcode({
                        oncomplete: function(data) {
                            // 우편번호 입력
                            document.getElementById("postAddress").value = data.zonecode;

                            // 도로명 주소 입력
                            document.getElementById("roadAddress").value = data.roadAddress;

                            // 상세 주소 입력은 기존 값에 추가
                            var detailAddress = '';
                            if (data.bname !== '') {
                                detailAddress += data.bname;
                            }
                            if (data.buildingName !== '') {
                                detailAddress += (detailAddress !== '' ? ', ' + data.buildingName : data.buildingName);
                            }
                            document.getElementById("detailAddress").value = detailAddress;
                        }
                    }).open();  // 우편번호 검색 창 열기
                };
            } else {
                console.error('Daum Postcode API가 로드되지 않았습니다.');
            }
        });
    </script>

</body>
</html>

