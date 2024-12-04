package com.kh.wegrid.util.page;

import lombok.Data;

@Data
public class PageVo {

    private int listCount;      // 전제 게시글 갯수
    private int currentPage;    // 현재 페이지
    private int pageLimit;      // 페이징 영역에 나타낼 페이지 버튼
    private int boardLimit;     // 한 페이지에 보여줄 게시글 최대갯수

    private int maxPage;        // 마지막 페이지 (전체 게시글 기준)
    private int startPage;      // 페이징 영역의 시작 페이지
    private int endPage;        // 페이징 영역의 마지막 페이지

    private int offset;         // SQL 에 사용될 값 (몇개를 건너뛰고 읽을지)

    public PageVo(int listCount, int currentPage, int pageLimit, int boardLimit) {
        this.listCount = listCount;
        this.currentPage = currentPage;
        this.pageLimit = pageLimit;
        this.boardLimit = boardLimit;

        this.maxPage = (int)Math.ceil((double)listCount / boardLimit);
        this.startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
        this.endPage = startPage + pageLimit - 1;
        if(endPage > maxPage) {
            endPage = maxPage;
        }
        this.offset = boardLimit * (currentPage-1);
    }
}
