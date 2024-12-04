package com.kh.wegrid.crm.vo;

import lombok.Data;

@Data
public class ClientVo {

    private String no;
    private String name;
    private String rankCode;
    private String rankName;
    private String statusNo;
    private String statusName;
    private String address;

    private String presidentName;
    private String presidentPhone;
    private String presidentEmail;

    private String startDate;
    private String endDate;

    private String managerName;
    private String managerPhone;
    private String managerEmail;

    private String postAddress;
    private String roadAddress;   // 도로명 주소
    private String detailAddress; // 상세 주소

    private String projectNo;
    private String projectName;
    private String projectStatusNo;
    private String projectStatusName;

    private String historyNo;
    private String employeeName;
    private String inquiry;
    private String hisEnrollDate;


}
