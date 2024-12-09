package com.kh.wegrid.member.vo;

import lombok.Data;

@Data
public class ReplyVo {
    private String no;        // 댓글 번호
    private String writerNo;  // 댓글 작성자
    private String writerName;  // 댓글 작성자
    private String boardNo;   // 게시글 번호
    private String content;   // 댓글 내용
    private String enrollDate; // 댓글 작성일
    private String modifyDate; // 댓글 작성일
    private String delYn;     // 삭제 여부
    private String deptName;     // 부서이름
}