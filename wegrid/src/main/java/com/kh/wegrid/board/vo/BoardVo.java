package com.kh.wegrid.board.vo;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public class BoardVo {

    private String no;
    private String writerNo;
    private String deptNo;
    private String title;
    private String content;
    private String viewCnt;
    private String enrollDate;
    private String modifyDate;
    private String noticeYn;
    private String delYn;

}
