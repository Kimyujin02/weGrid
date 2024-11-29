<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/css/calendar/write.css">

<div class="modal fade" id="detailModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="exampleModalLabel">일정 상세 조회</h4>
                    <!-- <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button> -->
                    
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="form-group">

                    <div class="title-area">
                        <label for="calendar_title" class="col-form-label">제목</label>
                        <input type="text" class="form-control" id="calendar_title" name="title">
                    </div>
                    <br>
                    <div class="date-area">
                        <div class="date-label-area">
                            
                            <label for="calendar_end_date" class="col-form-label">종료일</label>
                        </div>
                        <div class="date-input-area">
                            <input type="datetime-local" class="form-control" id="calendar_start_date" name="startDate">
                            <input type="datetime-local" class="form-control" id="calendar_end_date" name="endDate">
                        </div>
                    </div>
                    <br>
                    <div>
                        <label for="" class="col-form-label">일정 종류</label>
                        <div class="type-area">
                            <div class="typeBox">
                                <label for="typeNo1">교육</label>
                                <input type="radio" id="typeNo1" name="typeNo" value="1">
                            </div>
                            <div class="typeBox">
                                <label for="typeNo2">업무</label>
                                <input type="radio" id="typeNo2" name="typeNo" value="2">
                            </div>
                            <div class="typeBox">
                                <label for="typeNo3">행사</label>
                                <input type="radio" id="typeNo3" name="typeNo" value="3">
                            </div>
                            <div class="typeBox">
                                <label for="typeNo4">기타</label>
                                <input type="radio" id="typeNo4" name="typeNo" value="4">
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
                <button type="button" class="btn btn-primary" id="addCalendar">추가</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
            </div>
        </div>
    </div>
</div>