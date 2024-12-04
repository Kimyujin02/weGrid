package com.kh.wegrid.vacation.temp.vo;

import lombok.Data;

@Data
public class EmpVo {

    private int no;
    private String deptNo;
    private int jobNo;
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
