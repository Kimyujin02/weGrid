package com.kh.wegrid.vacation.vo;

import lombok.Data;

@Data
public class VacationVo {

    private String no;
    private String empNo;
    private String deptNo;
    private String vacTypeNo;
    private String startDate;
    private String endDate;
    private String content;
    private String useCnt;
    private String deptName;
    private String vacTypeName;

    private String name;
    private String remainingVacation;
    private String usedVacation;
    private String dayOfType;

    private String vacType;
}
