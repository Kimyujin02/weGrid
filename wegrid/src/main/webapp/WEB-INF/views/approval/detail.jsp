<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/approval/detail.css">

<script defer src="/js/common/main.js"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav.jsp" %>

    <!-- Main -->
    <main>
        <div id="main-area">
           <div></div>
                <div id="use-area">
                    <div><h2>결재등록</h2></div>
                    <div id="main-boc">
                        <div>
                            <div id="title-boc">
                                <div>
                                  
                                    <div>결재명</div>
                                    <div>${avo.title}</div>
                                </div>
                                <div>
                                    <div>번호</div>
                                    <div>${avo.no}</div>
                                    <div>기안자</div>
                                    <div>${avo.writerName}</div>
                                    <div>부서명</div>
                                    <div>${avo.writerDept}</div>
                                    <div>진행상태</div>
                                    <div>${avo.statusName}</div>
                                    <div>등록일</div>
                                    <div>${avo.enrollDate}</div>
                                </div>
                            </div>
                            <div id="content-boc">
                                <div></div>
                                <div><h4 class="subtitle-color">내용</h4></div>
                                <div></div>
                                <div></div>
                                <div>${avo.content}</div>
                                <div></div>
                            </div>
                        </div>
                        <div id="pgh">
                            <div id="line-boc">
                                <div></div>
                                <div><h4 class="subtitle-color">결재선</h4></div>
                                <div></div>
                                <div></div>
                                <div>결재선 들어가는곳</div>
                                <div></div>
                            </div>
                            <div></div>
                        </div>
                    </div>
                    <div id="footer-boc">
                        <div id="attach-area">
                            <div></div>
                            <div><h4 class="subtitle-color">첨부파일</h4></div>
                            <div></div>
                            <div></div>
                            <div>첨부파일실제</div>
                            <div></div>
                        </div>
                        <div id="button-area">
                            <div></div>
                            <c:if test="${loginMemberVo.no == avo.mline}">
                                <form action="/approval/mline/allow" method="post">
                                    <input type="hidden" name="no" value="${avo.no}">
                                    <input type="hidden" name="mline" value="${avo.mline}">
                                    <div id="allowBtnDiv"><button type="submit" class="btn btn-primary" id="allow-btn">결재 승인</button></div>
                                </form>
                                <form action="/approval/mline/companion" method="post">
                                    <input type="hidden" name="no" value="${avo.no}">
                                    <input type="hidden" name="mline" value="${avo.mline}">
                                    <div id="companionBtnDiv"><button type="submit" class="btn btn-primary" id="companion-btn">결재 반려</button></div>
                                </form>
                            </c:if>
                            <c:if test="${loginMemberVo.no == avo.lline}">
                                <form action="/approval/lline/allow" method="post">
                                    <input type="hidden" name="no" value="${avo.no}">
                                    <input type="hidden" name="line" value="${avo.lline}">
                                    <div id="allowBtnDiv"><button type="submit" class="btn btn-primary" id="allow-btn">결재 승인</button></div>
                                </form>
                                <form action="/approval/lline/companion" method="post">
                                    <input type="hidden" name="no" value="${avo.no}">
                                    <input type="hidden" name="line" value="${avo.lline}">
                                    <div id="companionBtnDiv"><button type="submit" class="btn btn-primary" id="companion-btn">결재 반려</button></div>
                                </form>
                            </c:if>
                            <c:if test="${loginMemberVo.no != avo.mline && loginMemberVo.no != avo.lline && loginMemberVo.no == avo.writerNo}">
                                <form action="/approval/delete" method="post">
                                    <div></div>
                                    <input type="hidden" name="no" value="${avo.no}">
                                    <input type="hidden" name="writerNo" value="${avo.writerNo}">
                                    <div><div id="cancleBtnDiv"><button type="submit" class="btn btn-primary" id="cancle-btn">결재 취소</button></div></div>
                                </form>
                            </c:if>
                            
                        </div>
                    </div>
                    <div></div>
                </div>
           <div></div>
           
        </div>
    </main>

</body>
</html>

