<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/css/calendar/write.css">
<script defer src="/js/calendar/write.js"></script>

<div class="modal fade" id="writeModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable" role="document">
        <div class="modal-content">
            <form action="" id="writeForm" onsubmit="return insertToDB();">
            <div class="modal-header">
                <h4 class="modal-title" id="exampleModalLabel">일정 추가</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="calendar-type" class="col-form-label">항목</label>
                    <div class="type-area">
                        <input type="color" name="color">
                        <select name="typeNo" class="form-control" id="calendar-type">

                        </select>
                    </div>
                    <br>
                    <div class="title-area">
                        <label for="calendar-title" class="col-form-label">제목</label>
                        <input type="text" class="form-control" id="calendar-title" name="title">
                    </div>
                    <br>
                    <div class="date-area">
                        <div class="date-label-area">
                            <label for="calendar-start-date" class="col-form-label">시작</label>
                            <label for="calendar-end-date" class="col-form-label">종료</label>
                        </div>
                        <div class="date-input-area">
                            <input type="datetime-local" class="form-control" id="calendar-start-date" name="startDate">
                            <input type="datetime-local" class="form-control" id="calendar-end-date" name="endDate">
                        </div>
                    </div>
                    <br>
                    <label class="col-form-label">일정 종류</label>
                    <div class="kind-area">
                        
                    </div>
                    <br>
                    <div class="content-area">
                        <label for="calendar-content" class="col-form-label">상세 내용</label>
                        <textarea class="form-control" id="calendar-content" name="content"></textarea>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary" id="addSchedule">추가</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
            </div>
            </form>
        </div>
    </div>
</div>