<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시스템 관리자 계정 정보 수정</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/system/edit.css">

<script defer src="/js/common/main.js"></script>
<script defer src="/js/system/edit.js"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/hung1001/font-awesome-pro@4cac1a6/css/all.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav-system.jsp" %>

    <!-- Main -->
    <main>
        <div class="main-content">
            <h1 class="title">계정 정보 수정</h1>
            <div class="line-box"></div>

            <div class="form-container">
            <!-- 기본 개인 정보 -->
            <div class="left-panel">
                <h3 class="sub-title">기본 개인 정보</h3>
                <form action="/system/edit" name="personal-info" method="post">
                    <input type="hidden" name="no" value="${vo.no}">
                    <label for="name">이름</label>
                    <input type="text" id="name" name="name" value="${vo.name}"><br>
                    <label for="id">아이디</label>
                    <input type="text" id="id" name="id" value="${vo.id}"><br>
                    <label for="email">이메일</label>
                    <input type="email" id="email" name="email" value="${vo.email}"><br>
                    <label for="phone">연락처</label>
                    <input type="text" id="phone" name="phone" value="${vo.phone}"><br><br>
                
                <!-- 주소 입력 필드 -->
                <input type="text" id="sample2_postcode" placeholder="우편번호" style="width: 30%;" name="postAddress" value="${vo.postAddress}">
                <input type="button" class="search-button"  onclick="sample2_execDaumPostcode()" value="우편번호 찾기"><br>
                <input type="text" id="sample2_address" placeholder="주소" style="width: 80%; margin: 5px 0px 5px 0px;" name="roadAddress" value="${vo.roadAddress}"><br>
                <input type="text" id="sample2_detailAddress" placeholder="상세주소" name="detailAddress" value="${vo.detailAddress}">
                <input type="text" id="sample2_extraAddress" placeholder="참고항목" name="extraAddress" value="${vo.extraAddress}">
                    
                <!-- iOS에서는 position:fixed 버그가 있음, 적용하는 사이트에 맞게 position:absolute 등을 이용하여 top,left값 조정 필요 -->
                <div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
                <img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
                </div>

                <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
                <script>
                    // 우편번호 찾기 화면을 넣을 element
                    var element_layer = document.getElementById('layer');

                    function closeDaumPostcode() {
                        // iframe을 넣은 element를 안보이게 한다.
                        element_layer.style.display = 'none';
                    }

                    function sample2_execDaumPostcode() {
                        new daum.Postcode({
                            oncomplete: function(data) {
                                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                                var addr = ''; // 주소 변수
                                var extraAddr = ''; // 참고항목 변수

                                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                                    addr = data.roadAddress;
                                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                                    addr = data.jibunAddress;
                                }

                                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                                if(data.userSelectedType === 'R'){
                                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                                        extraAddr += data.bname;
                                    }
                                    // 건물명이 있고, 공동주택일 경우 추가한다.
                                    if(data.buildingName !== '' && data.apartment === 'Y'){
                                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                                    }
                                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                                    if(extraAddr !== ''){
                                        extraAddr = ' (' + extraAddr + ')';
                                    }
                                    // 조합된 참고항목을 해당 필드에 넣는다.
                                    document.getElementById("sample2_extraAddress").value = extraAddr;
                                
                                } else {
                                    document.getElementById("sample2_extraAddress").value = '';
                                }

                                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                                document.getElementById('sample2_postcode').value = data.zonecode;
                                document.getElementById("sample2_address").value = addr;
                                // 커서를 상세주소 필드로 이동한다.
                                document.getElementById("sample2_detailAddress").focus();

                                // iframe을 넣은 element를 안보이게 한다.
                                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                                element_layer.style.display = 'none';
                            },
                            width : '100%',
                            height : '100%',
                            maxSuggestItems : 5
                        }).embed(element_layer);

                        // iframe을 넣은 element를 보이게 한다.
                        element_layer.style.display = 'block';

                        // iframe을 넣은 element의 위치를 화면의 가운데로 이동시킨다.
                        initLayerPosition();
                    }

                    // 브라우저의 크기 변경에 따라 레이어를 가운데로 이동시키고자 하실때에는
                    // resize이벤트나, orientationchange이벤트를 이용하여 값이 변경될때마다 아래 함수를 실행 시켜 주시거나,
                    // 직접 element_layer의 top,left값을 수정해 주시면 됩니다.
                    function initLayerPosition(){
                        var width = 300; //우편번호서비스가 들어갈 element의 width
                        var height = 400; //우편번호서비스가 들어갈 element의 height
                        var borderWidth = 5; //샘플에서 사용하는 border의 두께

                        // 위에서 선언한 값들을 실제 element에 넣는다.
                        element_layer.style.width = width + 'px';
                        element_layer.style.height = height + 'px';
                        element_layer.style.border = borderWidth + 'px solid';
                        // 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
                        element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width)/2 - borderWidth) + 'px';
                        element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height)/2 - borderWidth) + 'px';
                    }
                </script>

            </div>

                 <!-- 가운데 구분선 -->
                <div class="divider"></div>

                <!-- 사원 정보 -->
                <div class="right-panel">
                    <h3 class="sub-title">사원 정보</h3>
                        <label for="employee-no" id="employeeInfo">사번</label>
                        <input type="text" id="employeeSub" name="empNum" value="${vo.empNum}"
                        style=" background-color: #F4F4F4;
                        box-shadow:inset 3px 3px 5px 1px rgba(98, 97, 97, 0.3);"><br>

                        <label for="department" id="employeeInfo">부서명</label>
                        <div class="department-row">
                            <input type="text" id="department-name" value="${vo.deptName}" 
                            style=" background-color: #F4F4F4;
                                box-shadow:inset 3px 3px 5px 1px rgba(98, 97, 97, 0.3);"> 
                            <div class="filter-controls">
                                <select id="deptName" name="deptName" onchange="updateDepartmentName()">
                                    <c:forEach var="departMentVo" items="${departMentVoList}">
                                        <option value="${departMentVo.code}">${departMentVo.name}</option>
                                    </c:forEach>
                                </select>
                                
                                <br>
                            </div>
                        </div>
                       
                        <label for="position" id="employeeInfo">직급</label>
                        <div class="filter-controls">
                            <select name="jobNo" id="employeeSub">
                                <c:forEach var="JobInfoVo" items="${jobInfoVoList}">
                                    <option value="${JobInfoVo.no}">${JobInfoVo.name}</option>
                                </c:forEach>
                            </select>
                        <br>
                    </div>
                        <label for="authority" id="employeeInfo">권한</label>
                        <div class="filter-controls">
                        <select id="employeeSub" name="isManager">
                            <option value="Y">관리자</option>
                            <option value="N">일반 사원</option>
                        </select>
                    </div>
                    <br>
                    
                    <button type="button" class="btn btn-primary" id="pwd-reset" value="${vo.no}">비밀번호 초기화</button>
                    

                    
                </div>
            </div>

            <div class="button-group">
                <button type="submit" class="btn btn-primary" id="edit-btn">수정하기</button>
                <button type="button" class="btn btn-primary" id="cancle-btn" onclick="location.href='/system/account/list'" >취소</button>
            </div>
        </form>
        </div>
    </main>

</body>
</html>

