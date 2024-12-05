package com.kh.wegrid.approval.vo;

import lombok.Data;

@Data
public class MemberListVo {
    private String no;
    private String deptNo;
    private String jobNo;
    private String jobName;
    private String deptName;
    private String empNum;
    private String id;
    private String pwd;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String enrollDate;
    private String modifyDate;
    private String isManager;
    private String delYn;
    private String profile;
    private int failedAttempts;
    private String isLocked;
}
