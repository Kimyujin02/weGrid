<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/css/calendar/edit.css">
<script defer src="/js/calendar/edit.js"></script>

<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable" role="document">
        <div class="modal-content">
            <form action="" id="editForm" onsubmit="return editAtDB();">
            <div class="modal-header">
                <h4 class="modal-title" id="exampleModalLabel">일정 수정</h4>
                <input type="hidden" name="no">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="calendar-type-edit" class="col-form-label">항목</label>
                    <div class="type-area">
                        <input type="color" name="color">
                        <select name="typeNo" class="form-control" id="calendar-type-edit">

                        </select>
                    </div>
                    <br>
                    <div class="title-area">
                        <label for="calendar-title-edit" class="col-form-label">제목</label>
                        <input type="text" class="form-control" id="calendar-title-edit" name="title">
                    </div>
                    <br>
                    <div class="writer-area hidden-area">
                        <label class="col-form-label">작성자</label>
                        <br>
                        <input type="text" id="calendar-writerName-edit" disabled>
                        <br>
                    </div>
                    <div class="date-area">
                        <div class="date-label-area">
                            <label for="calendar-start-date-edit" class="col-form-label">시작</label>
                            <label for="calendar-end-date-edit" class="col-form-label">종료</label>
                        </div>
                        <div class="date-input-area">
                            <input type="datetime-local" class="form-control" id="calendar-start-date-edit" name="startDate">
                            <input type="datetime-local" class="form-control" id="calendar-end-date-edit" name="endDate">
                        </div>
                    </div>
                    <br>
                    <label class="col-form-label">일정 종류</label>
                    <div class="kind-area">
                        
                    </div>
                    <br>
                    <div class="content-area">
                        <label for="calendar-content-edit" class="col-form-label">상세 내용</label>
                        <textarea class="form-control" id="calendar-content-edit" name="content"></textarea>
                    </div>

                </div>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary" id="editSchedule">완료</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
            </div>
            </form>
        </div>
    </div>
</div>