<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.wegrid.member.vo.MemberVo" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/crm/editHistory.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script defer src="/js/crm/editHistory.js"></script>

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

                <div class="tab-area">
                    <div></div>
                    <div class="prjTab"><button onclick="location.href='/crm/detail?cno=${param.cno}'">프로젝트</button></div>
                    <div class="hisTab"><button onclick="location.href='/crm/history?cno=${param.cno}'">히스토리</button></div>
                    <div></div>
                </div>

                <div class="content-line"></div>

                <div class="list-create-area">

                    <div class="list-area">
                        <div class="history-title"><h5>히스토리 내역</h5></div>

                        <div class="history-table">
                            <table class="history-list">
                                <thead class="list-top">
                                    <tr>
                                        <th class="num">NO</th>
                                        <th class="writer-name">작성자</th>
                                        <th class="query-content">문의 내용</th>
                                        <th class="enroll-date">작성일</th>
                                        <th class="edit">수정</th>
                                    </tr>
                                </thead>
                                
                                <tbody>
                                    <td>로딩중...</td>
                                </tbody>
                                <tfoot>
                                    <tr class="list-end">
                                        <td></td>
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

                    <div class="vertical-line"></div>

                    <div class="create-area">
                        <div class="history-title"><h5>히스토리 세부내용</h5></div>
                        <div>
                            <form class="form-area" action="/crm/history/edit" method="post">
                                <div class="query-insert">
                                    <div>문의 &nbsp;&nbsp;</div>
                                    <textarea name="inquiry" id="inquiry">${hvo.inquiry}</textarea>
                                </div>
                                <div class="gray-line"></div>
                                <div class="reply-insert">
                                    <div>답변 &nbsp;&nbsp;</div>
                                    <textarea name="reply" id="reply">${hvo.reply}</textarea>
                                </div>
                                <div class="btn-area">
                                    <div><input type="hidden" name="cno" value="${param.cno}"></div>
                                    <div><input type="hidden" name="hno" value="${param.hno}"></div>
                                    <button type="submit" onclick="checkPermission(loginMemberNo, '${hvo.writerNo}' )">수정</button>
                                    <button onclick="location.href='/crm/history?cno=${param.cno}'">취소</button>
                                    <div></div>
                                </div>
                            </form>
                        </div>
                    </div>

                </div>
            </div>

        </div>
    </main>

    <% 
        // 로그인한 사원 정보 가져오기
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String loginMemberNo = (loginMemberVo != null) ? String.valueOf(loginMemberVo.getNo()) : "null";
    %>
    <script>
        var loginMemberNo = '<%= loginMemberNo %>';
    </script>

</body>
</html>