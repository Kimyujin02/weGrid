<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<link rel="stylesheet" href="/css/common/main.css">
<link rel="stylesheet" href="/css/approval/write.css">

<script defer src="/js/common/main.js"></script>
<script defer src="/js/approval/write.js"></script>

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
                <div></div>
                <form action="/approval/write" method="post" enctype="multipart/form-data">
                    <input type="hidden" id="approvalMiddle" name="mline">
                    <input type="hidden" id="approvalLast" name="lline">
                    <div id="title-boc">
                        <div><h4 class="subtitle-color">제목</h4></div>
                        <div><input type="text" placeholder="제목을 입력하세요" id="title-a" name="title"></div>
                    </div>
                    <div></div>
                    <div id="content-boc">
                        <div></div>
                        <div><h4 class="subtitle-color">내용</h4></div>
                        <div></div>
                        <div></div>
                        <div><textarea name="content" id="content-a"></textarea></div>
                        <div></div>
                    </div>
                    <div></div>
                    <div id="menu-boc">
                        <div id="attach-area">
                            <div>
                                <div></div>
                                <div><h4 class="subtitle-color">첨부파일</h4></div>
                                <div></div>
                            </div>
                            <div><input type="file" id="attachInputTag" name="approvalAttachment" multiple></div>
                        </div>
                        <div></div>
                        <div id="line-area">
                            <div>
                                <div></div>
                                <div><h4 class="subtitle-color">결재선</h4></div>
                                <div></div>
                            </div>
                            <div id="lineBtnDiv">
                                <div>
                                    <span class="dept-areaa">${loginMemberVo.deptName} </span>
                                    &nbsp;&nbsp;<span class="name-areaa"> ${loginMemberVo.name}</span>
                                </div>
                                <div>
                                    <div>
                                        <span id="middleDept" class="dept-areaa"></span>
                                        <button id="approvalMiddleBtn" class="approvalBtn" onclick="return handleApproval('middle');">
                                            +
                                        </button>
                                    </div>
                                </div>
                                <div>
                                    <div>
                                        <span id="lastDept" class="dept-areaa"></span>
                                        <button id="approvalLastBtn" class="approvalBtn" name="lline" onclick="return handleApproval('last');">
                                            +
                                        </button>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                        <div id="submitBtnDiv"><button type="submit" class="btn btn-primary" id="submit-btn"
                            onclick="return confirmSubmission()"
                            >등록</button></div>
                        <div></div>
                        <div id="cancleBtnDiv"><button type="button" class="btn btn-primary" id="cancle-btn"
                            onclick="return cancle();"
                            >취소</button></div>
                    </div>
                </form>
                </div>
                <div></div>
                
            </div>

         <!-- 모달 -->
      <div id="empSearchModal" class="empSearchModal">
        <div class="empSearchModal-content">
            <div class="empSearchModal-header">
                <h2>사원 검색</h2>
                <button class="close-empSearchModal" onclick="closeEmpSearchModal()">×</button>
            </div>
            
            <div id="searchMenu">
                
                    <div id="type-boc"> 
                        <select name="searchType" id="dept-filter" value="" onchange="submitSearchForm();">
                            <!-- <option value="">전체</option> -->
                        </select>
                    </div>
                        <div id="iwannagohome">
                            <div  id="search-boc">
                                <input type="text" name="searchValue" placeholder="검색" id="searchTag">
                                <span>
                                    <button id="searchBtn" onclick="submitSearchForm();">
                                        <i class="fas fa-search" id="search-i"></i>
                                    </button>
                                </span>
                            </div>
                           
                        </div>
            </div>
            <div class="empSearchModal-body" id="aaavvv">
                <table id="empSearchModalTable">
                    <thead id="empSearchModalThead">
                        <tr>
                            <th class="list-top">사번</th>
                            <th class="list-top">부서</th>
                            <th class="list-top">직급</th>
                            <th class="list-top">이름</th>
                        </tr>
                    </thead>
                    <tbody>

                    </tbody>
                    
                </table>
                
            </div>
            <div class="page"></div>
          
                <div class="tripModal-footer">
                 
                </div>
                 
        </div>
      </div>
    </main>

</body>
</html>

