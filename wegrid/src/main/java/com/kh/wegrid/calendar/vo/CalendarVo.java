package com.kh.wegrid.calendar.vo;

import lombok.Data;

@Data
public class CalendarVo {

    private String no;
    private String writerNo;
    private String writerName;
    private String typeNo;
    private String typeName;
    private String kindNo;
    private String kindName;
    private String isEditable;
    private String title;
    private String content;
    private String startDate;
    private String endDate;
    private String color;
    private String delYn;

    // 시작일 형 변환
    public void setStartDate(String startDate) {
        if(startDate.contains("T")){
            this.startDate = startDate.replace("T"," ");
        }
        else {
            this.startDate = startDate;
        }
    }
    
    // 종료일 형 변환
    public void setEndDate(String endDate) {
        if(endDate.contains("T")){
            this.endDate = endDate.replace("T"," ");
        }
        else {
            this.endDate = endDate;
        }
    }
    
}

