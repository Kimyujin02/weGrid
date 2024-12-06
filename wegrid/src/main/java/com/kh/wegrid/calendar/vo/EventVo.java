package com.kh.wegrid.calendar.vo;

import lombok.Data;

@Data
public class EventVo {

    private String id;
    private String typeNo;
    private String title;
    private String start;
    private String end;
    private String color;

    // 프로젝트 구분을 위한 id 값 변경
    public void setTypeNo(String typeNo) {
        this.typeNo = typeNo;
        this.id = this.id+"_"+typeNo; // id 생성 로직
    }

}
