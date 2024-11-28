<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/crm/clientEdit.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script defer src="/js/common/main.js"></script>
<script defer src="/js/crm/clientEdit.js"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>
        <div class="main-content">
            
            <div class="content-area">
                <!-- row1 -->
                <div class="title-area">
                    <h2 class="title-text">고객 정보 수정</h2>
                </div>

                <!-- line1 -->
                <div class="line_1"></div>           

                <!-- row2 -->
                <div class="cinfo-area">
                    <div class="c-info">
                        <h5>고객사 정보</h5>
                    </div>
                    <div class="client-name">
                        고객사 &nbsp; <input type="text">
                    </div>
                    <div class="cinfo_line"></div>
                    <div class="client-address">
                        <div class="text-address">주소</div>
                        <div class="adress-input_1"><input type="text"></div>
                        <div class="adress-input_2"><input type="text"></div>
                        <button type="button" class="btn btn-primary">우편번호</button>
                        <div></div>
                        <div class="adress-input_3"><input type="text"></div>
                        <div></div>
                        <div class="adress-input_4"><input type="text"></div>
                    </div>

                    <div class="cinfo_line"></div>

                    <div class="select-area">
                        <div class="business-status">
                            거래상태 &nbsp; 
                            <select class="select-grade">
                                <option value="S">대기</option>
                                <option value="A">진행</option>
                                <option value="A">완료</option>
                            </select>
                        </div>
                        <div class="client-grade">
                            등급 &nbsp; 
                            <select class="select-grade">
                                <option value="S">S</option>
                                <option value="A">A</option>
                                <option value="B">B</option>
                                <option value="C">C</option>
                                <option value="D">D</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="line_2"></div>

                <div class="cminfo-area">
                    <div class="cm-info">
                        <h5>고객사 담당자 정보</h5>
                    </div>

                    <div class="cminfo-input">
                        <div class="text">담당자</div>
                        <div>
                            <input type="text">
                        </div>
                    </div>
                    
                    <div class="cminfo_line"></div>

                    <div class="cminfo-input">
                        <div class="text">이메일</div>
                        <div>
                            <input type="email">
                        </div>
                    </div>

                    <div class="cminfo_line"></div>

                    <div class="cminfo-input">
                        <div class="text">연락처</div>
                        <div>
                            <input type="tel">
                        </div>
                    </div>

                    <div class="blank_space"></div>
                </div>

                <!-- row3 -->
                <div class="btn-area">
                    <div class="enroll-btn"><button type="button" class="btn btn-primary">수정</button></div>
                    <div class="cancel-btn"><button type="button" class="btn btn-primary">취소</button></div>
                </div>

            </div>

        </div>
    </main>

</body>
</html>
