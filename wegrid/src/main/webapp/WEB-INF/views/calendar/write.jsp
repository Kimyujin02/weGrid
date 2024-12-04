<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/css/calendar/write.css">
<script defer src="/js/calendar/write.js"></script>

<div class="modal fade" id="writeModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable" role="document">
        <div class="modal-content">
            <form action="" onsubmit="return insertToDB();">
            <div class="modal-header">
                <h4 class="modal-title" id="exampleModalLabel">일정 추가</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="calendar_type" class="col-form-label">항목</label>
                    <div class="type-area">
                        <input type="color" name="color">
                        <select name="typeNo" class="form-control" id="calendar_type">

                        </select>
                    </div>
                    <br>
                    <div class="title-area">
                        <label for="calendar_title" class="col-form-label">제목</label>
                        <input type="text" class="form-control" id="calendar_title" name="title">
                    </div>
                    <br>
                    <div class="date-area">
                        <div class="date-label-area">
                            <label for="calendar_start_date" class="col-form-label">시작</label>
                            <label for="calendar_end_date" class="col-form-label">종료</label>
                        </div>
                        <div class="date-input-area">
                            <input type="datetime-local" class="form-control" id="calendar_start_date" name="startDate">
                            <input type="datetime-local" class="form-control" id="calendar_end_date" name="endDate">
                        </div>
                    </div>
                    <br>
                    <div>
                        <label class="col-form-label">일정 종류</label>
                        <div class="kind-area">
                            <div class="kindBox">
                                <label for="kindNo1">교육</label>
                                <input type="radio" id="kindNo1" name="kindNo" value="1">
                            </div>
                            <div class="kindBox">
                                <label for="kindNo2">업무</label>
                                <input type="radio" id="kindNo2" name="kindNo" value="2">
                            </div>
                            <div class="kindBox">
                                <label for="kindNo3">행사</label>
                                <input type="radio" id="kindNo3" name="kindNo" value="3">
                            </div>
                            <div class="kindBox">
                                <label for="kindNo4">기타</label>
                                <input type="radio" id="kindNo4" name="kindNo" value="4">
                            </div>
                        </div>
                    </div>
                    <br>
                    <div class="content-area">
                        <label for="calendar_content" class="col-form-label">상세 내용</label>
                        <textarea class="form-control" id="calendar_content" name="content"></textarea>
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