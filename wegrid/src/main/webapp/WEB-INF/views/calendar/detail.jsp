<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/css/calendar/detail.css">
<script defer src="/js/calendar/detail.js"></script>

<div class="modal fade" id="detailModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="exampleModalLabel">일정 상세 조회</h4>                
                <input type="hidden" name="scheduleNo">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label class="col-form-label">항목</label>
                    <div class="type-area">
                        <div id="calendar-color-view"></div>
                        <div id="calendar-typName-view" class="calendar-detail-view-box"></div>
                    </div>
                    <br>
                    <div class="title-area">
                        <label for="calendar-title-view" class="col-form-label">제목</label>
                        <div id="calendar-title-view" class="calendar-detail-view-box"></div>
                    </div>
                    <br>
                    <div class="writer-area hidden-area">
                        <label class="col-form-label">작성자</label>
                        <div id="calendar-writerName-view" class="calendar-detail-view-box"></div>
                        <br>
                    </div>
                    <div class="date-area">
                        <div class="date-label-area">
                            <label for="calendar-start-date-view" class="col-form-label">시작</label>
                            <label for="calendar-end-date-view" class="col-form-label">종료</label>
                        </div>
                        <div class="date-input-area">
                            <div id="calendar-start-Date-view" class="calendar-detail-view-box"></div>
                            <div id="calendar-end-Date-view" class="calendar-detail-view-box"></div>
                        </div>
                    </div>
                    <br>
                    <div id="kindName-view-area">
                        <label class="col-form-label">일정 종류</label>

                    </div>
                    <br>
                    <div class="content-area">
                        <label for="calendar-content-view" class="col-form-label">상세 내용</label>
                        <div id="calendar-content-view" class="calendar-detail-view-box"></div>
                    </div>
                    <div class="modal-footer .hidden-area">
                        
                    </div>
                </div>
            </div>
            
        </div>
    </div>
</div>