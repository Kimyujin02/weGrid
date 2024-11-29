package com.kh.wegrid.calendar.vo;

import lombok.Data;

@Data
public class CalendarVo {

    private String no;
    private String writer_no;
    private String kindNo;
    private String typeNo;
    private String isEditable;
    private String title;
    private String content;
    private String startDate;
    private String endDate;
    private String color;
    private String delYn;

}
