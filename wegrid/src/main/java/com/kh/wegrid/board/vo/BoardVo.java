package com.kh.wegrid.board.vo;

import lombok.Data;

@Data
public class BoardVo {

    private String no;
    private String writerNo;
    private String name;
    private String deptNo;
    private String title;
    private String content;
    private String viewCnt;
    private String enrollDate;
    private String modifyDate;
    private String noticeYn;
    private String delYn;

    private String deptName;
    private String jobName;
    private String replyNo;

}
