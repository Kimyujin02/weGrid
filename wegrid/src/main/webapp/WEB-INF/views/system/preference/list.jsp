<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEGRID</title>

<script defer src="/js/common/main.js"></script>

<link rel="stylesheet" href="/css/system/preference/list.css">
<link rel="stylesheet" href="/css/system/preference/modal.css">
<script defer src="/js/system/preference/list.js"></script>

</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp" %>
   <%@ include file="/WEB-INF/views/common/nav-system.jsp" %>

    <!-- Main -->
    <main>
        <div class="main-content">
            <div class="list-box">
                <div class="title-area">
                    <h3>고객사 등급</h3>
                    <div class="addBtn" onclick="openAddModal('clientRank');">+</div>
                    <!-- <button>추가하기</button> -->
                </div>
                <div class="list-area">
                    <div class="table-head ">
                        <div class="table-line">
                            <div class="table-header">항목</div>
                            <div class="table-header">수정</div>
                            <div class="table-header">삭제</div>
                        </div>
                    </div>
                    <div class="table-body" id="clientRank">
                        <c:forEach var="vo" items="${clientRank}">
                            <div class="table-line">
                                <div class="table-content itemName">${vo.name}</div>
                                <div class="table-content"><button type="btn" class="btn btn-primary editItem" onclick="openEditModal(this);">수정</button></div>
                                <div class="table-content"><button type="btn" class="btn btn-secondary deleteItem" onclick="deleteItem(this);">삭제</button></div>
                                <input type="hidden" id="itemNo" value="${vo.no}">
                            </div>  
                        </c:forEach>
                    </div>
                </div>
                <div class="bottom-area"></div>
            </div>
            <div class="list-box">
                <div class="title-area">
                    <h3>출장 항목</h3>
                    <div class="addBtn" onclick="openAddModal('tripType');">+</div>
                </div>
                <div class="list-area">
                    <div class="table-head ">
                        <div class="table-line">
                            <div class="table-header">항목</div>
                            <div class="table-header">수정</div>
                            <div class="table-header">삭제</div>
                        </div>
                    </div>
                    <div class="table-body" id="tripType">
                        <c:forEach var="vo" items="${tripType}">
                            <div class="table-line">
                                <div class="table-content itmeName">${vo.name}</div>
                                <div class="table-content"><button type="btn" class="btn btn-primary editItem" onclick="openEditModal(this);">수정</button></div>
                                <div class="table-content"><button type="btn" class="btn btn-secondary deleteItem" onclick="deleteItem(this);">삭제</button></div>
                                <input type="hidden" id="itemNo" value="${vo.no}">
                            </div> 
                        </c:forEach>
                    </div>
                </div>
                <div class="bottom-area"></div>
            </div>
            <div class="list-box">
                <div class="title-area">
                    <h3>부서 항목</h3>
                    <div class="addBtn" onclick="openAddModal('department');">+</div>
                </div>
                <div class="list-area">
                    <div class="table-head ">
                        <div class="table-line">
                            <div class="table-header">항목</div>
                            <div class="table-header">수정</div>
                            <div class="table-header">삭제</div>
                        </div>
                    </div>
                    <div class="table-body" id="department">
                        <c:forEach var="vo" items="${department}">
                                <div class="table-line">
                                    <div class="table-content itmeName">${vo.name}</div>
                                    <div class="table-content"><button type="btn" class="btn btn-primary editItem" onclick="openEditModal(this);">수정</button></div>
                                    <div class="table-content"><button type="btn" class="btn btn-secondary deleteItem" onclick="deleteItem(this);">삭제</button></div>
                                    <input type="hidden" id="itemNo" value="${vo.code}">
                                </div> 
                        </c:forEach>
                    </div>
                </div>
                <div class="bottom-area"></div>
            </div>
            <div class="list-box">
                <div class="title-area">
                    <h3>직급 목록</h3>
                    <div class="addBtn" onclick="openAddModal('jobInfo');">+</div>
                </div>
                <div class="list-area">
                    <div class="table-head ">
                        <div class="table-line">
                            <div class="table-header">항목</div>
                            <div class="table-header">수정</div>
                            <div class="table-header">삭제</div>
                        </div>
                    </div>
                    <div class="table-body" id="jobInfo">
                        <c:forEach var="vo" items="${jobInfo}">
                            <div class="table-line">
                                <div class="table-content itmeName">${vo.name}</div>
                                <div class="table-content"><button type="btn" class="btn btn-primary editItem" onclick="openEditModal(this);">수정</button></div>
                                <div class="table-content"><button type="btn" class="btn btn-secondary deleteItem" onclick="deleteItem(this);">삭제</button></div>
                                <input type="hidden" id="itemNo" value="${vo.no}">
                            </div> 
                        </c:forEach>
                    </div>
                </div>
                <div class="bottom-area"></div>
            </div>
            <div class="list-box">
                <div class="title-area">
                    <h3>휴가 항목</h3>
                    <div class="addBtn" onclick="openAddModal('vacationType');">+</div>
                </div>
                <div class="list-area">
                    <div class="table-head ">
                        <div class="table-line">
                            <div class="table-header">항목</div>
                            <div class="table-header">수정</div>
                            <div class="table-header">삭제</div>
                        </div>
                    </div>
                    <div class="table-body" id="vacationType">
                        <c:forEach var="vo" items="${vacationType}">
                            <div class="table-line">
                                <div class="table-content itmeName">${vo.name}</div>
                                <div class="table-content"><button type="btn" class="btn btn-primary editItem" onclick="openEditModal(this);">수정</button></div>
                                <div class="table-content"><button type="btn" class="btn btn-secondary deleteItem" onclick="deleteItem(this);">삭제</button></div>
                                <input type="hidden" id="itemNo" value="${vo.no}">
                            </div> 
                        </c:forEach>
                    </div>
                </div>
                <div class="bottom-area"></div>
            </div>
            <div class="list-box">
                <div class="title-area">
                    <h3>직급 별 연차</h3>
                </div>
                <div class="list-area">
                    <div class="table-head ">
                        <div class="table-line">
                            <div class="table-header">항목</div>
                            <div class="table-header">수정</div>
                            <div class="table-header">삭제</div>
                        </div>
                    </div>
                    <div class="table-body" id="vacCnt">
                        <c:forEach var="vo" items="${jobInfo}">
                            <div class="table-line">
                                <div class="table-content itemName">${vo.name}</div>
                                <div class="table-content itemValue">${vo.vacCnt}</div>
                                <div class="table-content"><button type="btn" class="btn btn-primary editItem" onclick="openEditModal(this);">수정</button></div>
                                <input type="hidden" id="itemNo" value="${vo.no}">
                            </div> 
                        </c:forEach>
                    </div>
                </div>
                <div class="bottom-area"></div>
            </div>
        </div>

        <!-- 추가, 수정을 위한 모달 창 -->
        <div class="modal fade" id="preferenceModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-sm modal-dialog-centered modal-dialog-scrollable">
          
            </div>
        </div>

        <!-- 추가 모달 창 내용 -->
        <template id="addModalContent">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title" id="exampleModalLabel">신규 항목 추가</h1>
                    <!-- <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button> -->
                </div>
                <form action="" onsubmit="return addItem();">
                    <div class="modal-body addItemForm">
                        <div class="mb-3">
                            <label for="newName" class="col-form-label">항목명</label>
                            <input type="text" class="form-control" name="itemName" id="newName">
                            <input type="hidden" name="type">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary">추가</button>
                        <!-- <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button> -->
                    </div>
                </form>
            </div>
        </template>
        
        <!-- 수정 모달 창 내용 -->
        <template id="editModalContent">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title" id="exampleModalLabel">항목 수정</h1>
                    <!-- <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button> -->
                </div>
                <form onsubmit="return editItem();">
                    <div class="modal-body editItemForm">
                        <div class="mb-3">
                            <label for="beforeName" id="beforeValueLable" class="col-form-label">기존 항목명</label>
                            <div id="beforeName"></div>
                        </div>
                        <div class="mb-3">
                            <label for="afterName" id="afterValueLabel" class="col-form-label">변경 항목명</label>
                            <input type="text" class="form-control" name="itemName" id="afterName">
                            <input type="hidden" name="no">
                            <input type="hidden" name="type">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" onclick="editItem();">수정</button>
                        <!-- <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button> -->
                    </div>
                </form>
            </div>
        </template>

        <template id="emptyLine">
            <div class="table-line">
                <div class="table-content itemName"></div>
                <div class="table-content"><button type="btn" class="btn btn-primary editItem" onclick="openEditModal(this);">수정</button></div>
                <div class="table-content"><button type="btn" class="btn btn-secondary deleteItem" onclick="deleteItem(this);">삭제</button></div>
                <input type="hidden" id="itemNo">
            </div>
        </template>

        
        <template id="emptyLine2">
            <div class="table-line">
                <div class="table-content itemName"></div>
                <div class="table-content itemValue"></div>
                <div class="table-content"><button type="btn" class="btn btn-primary editItem" onclick="openEditModal(this);">수정</button></div>
                <input type="hidden" id="itemNo">
            </div>
        </template>

        <template id="subInput">
            <label for="subValue" id="subLabel" class="col-form-label"></label>
            <input type="text" class="form-control" name="sub" id="subValue">
        </template>

    </main>

</body>
</html>

