package com.kh.wegrid.board.mapper;

import com.kh.wegrid.board.vo.BoardAttachmentVo;
import com.kh.wegrid.board.vo.BoardVo;
import com.kh.wegrid.util.page.PageVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {

    //게시글 insert
    @Insert("""
            INSERT INTO BOARD (
                NO
                , WRITER_NO
                , DEPT_NO
                , TITLE
                , CONTENT
            ) VALUES (
                SEQ_BOARD.NEXTVAL
                , #{writerNo}
                , #{deptNo}
                , #{title}
                , #{content}
            )
            """)
    int insert(BoardVo bvo);

    int insertBoardAttachment(List<BoardAttachmentVo> attachmentVoList);

    @Select("""
            SELECT
                    B.NO
                    , B.TITLE
                    , B.WRITER_NO
                    , B.ENROLL_DATE
                    , B.VIEW_CNT
                    , E.NAME
            FROM BOARD B
            JOIN EMPLOYEE E ON ( E.NO = B.WRITER_NO )
            WHERE B.DEL_YN = 'N'
            ORDER BY B.NO DESC
            """)
    List<BoardVo> getSelectAllBoardList();




    List<BoardVo> getBoardVoList(PageVo pvo, String searchType, String searchValue);

    int getBoardCnt(String searchType, String searchValue);




}
