<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>WEGRID</title>

    <link rel="stylesheet" href="/css/common/main.css">
    <link rel="stylesheet" href="/css/crm/clientEnroll.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script defer src="/js/common/main.js"></script>
    <script defer src="/js/crm/clientEnroll.js"></script>

    <!-- 카카오 우편번호 서비스 스크립트 추가 (최신 경로) -->
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <!-- <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> -->
    <!-- <script src="https://t1.daumcdn.net/mapjsapi/postcode/js/postcode.v2.js"></script> -->

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>
        <div class="main-content">
            
            <form class="content-area" action="/crm/enroll" method="post">
                <!-- row1 -->
                <div class="title-area">
                    <h2 class="title-text">신규 고객 등록</h2>
                </div>

                <!-- line1 -->
                <div class="line_1"></div>           

                <!-- row2 -->
                <div class="cinfo-area">
                    <div class="c-info">
                        <h5>고객사 정보</h5>
                    </div>
                    <div class="client-name">
                        고객사 &nbsp; <input type="text" name="name">
                    </div>
                    <div class="cinfo_line"></div>

                    <div class="client-address">
                        <div class="text-address">주소</div>
                        
                        <!-- 우편번호 입력 칸 -->
                        <div class="address-input_1">
                            <input type="text" name="postAddress" id="postAddress" readonly placeholder="우편번호">
                        </div>
                        
                        <div class="address-btn">
                            <!-- 우편번호 버튼 -->
                            <button type="button" class="btn btn-primary" id="postalCodeBtn">우편번호</button>
                        </div>
                    
                        <div class="address-input_2">
                            <!-- 도로명 주소 입력 칸 -->
                            <input type="text" name="roadAddress" id="roadAddress" readonly placeholder="도로명 주소">
                        </div>
                    
                        <div class="address-input_3">
                            <!-- 상세 주소 입력 칸 -->
                            <input type="text" name="detailAddress" id="detailAddress" placeholder="상세 주소">
                        </div>
                    </div>
                    
                    <div class="cinfo_line"></div>
                    <div class="client-grade">
                        등급 &nbsp; 
                        <label>
                            <select class="select-grade" name="rankCode">
                                <c:forEach items="${clientRankVoList}" var="vo">
                                    <option value="${vo.no}">${vo.name}</option>
                                </c:forEach>
                            </select>
                        </label>
                    </div>
                </div>

                <div class="line_2"></div>

                <div class="cminfo-area">
                    <div class="cm-info">
                        <h5>고객사 대표 정보</h5>
                    </div>

                    <div class="cminfo-input">
                        <div class="text">대표</div>
                        <div>
                            <input type="text" name="presidentName">
                        </div>
                    </div>
                    
                    <div class="cminfo_line"></div>

                    <div class="cminfo-input">
                        <div class="text">이메일</div>
                        <div>
                            <input type="email" name="presidentEmail">
                        </div>
                    </div>

                    <div class="cminfo_line"></div>

                    <div class="cminfo-input">
                        <div class="text">연락처</div>
                        <div>
                            <input type="tel" name="presidentPhone">
                        </div>
                    </div>

                    <div class="blank_space"></div>
                </div>

                <!-- row3 -->
                <div class="btn-area">
                    <div class="enroll-btn"><button type="submit" class="btn btn-primary">등록</button></div>
                    <div class="cancel-btn"><button type="button" class="btn btn-primary" onclick="location.href='/crm/list'">취소</button></div>
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
