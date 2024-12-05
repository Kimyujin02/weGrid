package com.kh.wegrid.board.vo;

import lombok.Data;

@Data
public class MemberVo {

    private String no;
    private String deptNo;
    private String jobNo;
    private String empNum;
    private String pwd;
    private String name;
    private String phone;
    private String email;
    private String postAddress;
    private String roadAddress;
    private String detailAddress;
    private String enrollDate;
    private String modifyDate;
    private String isManager;
    private String delYn;
    private String profile;
    private String failedAttempts;
    private String isLocked;

}
