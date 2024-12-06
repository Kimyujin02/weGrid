<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/mypage/home.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script defer src="/js/common/main.js"></script>
<script defer src="/js/mypage/home.js"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>
        <div class="main-content">
            <!-- 마이페이지 텍스트 -->
            <div class="title-area">
                <h2 class="title-text">마이페이지</h2>
            </div>

            <!-- 라인 -->
            <div class="line-area"></div>

            <!-- 경로참고
             /img/default_profile.png -->
            <!-- 프로필 영역 -->
            <div class="profile-area">
                <!-- 이미지를 클릭하면 파일 선택창을 열도록 설정 -->
                <img class="profile-img" id="profileImage" src="${memberVo.profile}?${System.currentTimeMillis()}" alt="Profile Image" onclick="document.getElementById('fileInput').click();">
                <!-- 이미지 파일을 선택하는 input, 화면에는 보이지 않게 설정 -->
                <input type="file" id="fileInput" style="display: none;" accept="image/*" onchange="uploadImage(event)">
            </div>


            <!-- 개인정보 표시란 -->
            <div class="info-area">
                <div class="my-info">
                    <h4>개인정보</h4>
                </div>
                <div class="line"></div>
                <div class="readonly-input">
                    <div>아이디</div>
                    <input type="text" readonly value="${memberVo.id}">
                </div>
                <div class="line"></div>
                <div class="readonly-input">
                    <div>이메일</div>
                    <input type="email" readonly value="${memberVo.email}">
                </div>
                <div class="line"></div>
                <div class="readonly-input">
                    <div>연락처</div>
                    <input type="tel" readonly value="${memberVo.phone}">
                </div>
                <div class="line"></div>
                <div class="readonly-input">
                    <div>주소</div>
                    <input type="text" readonly value="${memberVo.postAddress}, ${memberVo.roadAddress} ${memberVo.detailAddress}">
                </div>
                <!-- div 9개 -->
            </div>

            <!-- 버튼칸 -->
            <div class="btn-area">
                <div></div>
                <button class="btn btn-primary changeInfo" onclick="location.href='/mypage/edit'">정보 수정</button>
                <button class="btn btn-primary changePwd">비밀번호 변경</button>
            </div>
            
        </div>

        <!-- 모달 -->
        <div class="modal fade" id="changePwdModal" tabindex="-1" aria-labelledby="changePwdLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                <h5 class="modal-title" id="changePwdLabel">비밀번호 변경</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                <form id="changePwdForm" action="/mypage/changePwd" method="post">
                    <div class="mb-3">
                    <label for="currentPwd" class="form-label">현재 비밀번호</label>
                    <input type="password" class="form-control" id="currentPwd" name="pwd" placeholder="현재 비밀번호 입력" required>
                    </div>
                    <div class="mb-3">
                    <label for="newPwd" class="form-label">새 비밀번호</label>
                    <input type="password" class="form-control" id="newPwd" name="newPwd" placeholder="새 비밀번호 입력" required>
                    </div>
                    <div class="mb-3">
                    <label for="confirmPwd" class="form-label">새 비밀번호 확인</label>
                    <input type="password" class="form-control" id="confirmPwd" name="confirmPwd" placeholder="새 비밀번호 확인" required>
                    </div>
                </form>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" form="changePwdForm">변경하기</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                </div>
            </div>
            </div>
        </div>
    </main>


    <c:if test="${not empty changeMsg}">
        <script type="text/javascript">
            alert("${changeMsg}");
        </script>
    </c:if>

    <c:if test="${not empty changeXoMsg}">
        <script type="text/javascript">
            alert("${changeXoMsg}");
        </script>
    </c:if>


</body>
</html>
