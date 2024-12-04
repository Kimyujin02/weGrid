package com.kh.wegrid.systemManager.vo;

import lombok.Data;

@Data
public class DepartMentVo {

    private String code;
    private String parentCode;
    private String headNo;
    private String name;
    private String delYn;

    @Data
    public static class JobInfoVo {

        private String no;
        private String name;
        private String vacCnt;
        private String delYn;

    }
}
