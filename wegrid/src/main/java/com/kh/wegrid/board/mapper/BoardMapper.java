package com.kh.wegrid.board.mapper;

import com.kh.wegrid.board.vo.BoardAttachmentVo;
import com.kh.wegrid.board.vo.BoardVo;
import com.kh.wegrid.member.vo.ReplyVo;
import com.kh.wegrid.util.page.PageVo;
import org.apache.ibatis.annotations.*;

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




    List<BoardVo> getBoardVoList(PageVo pvo, String searchType, String searchTitleValue, String searchContentValue);

    int getBoardCnt(String searchType, String searchTitleValue, String searchContentValue);





    @Update("""
            UPDATE BOARD
                SET
                    VIEW_CNT = VIEW_CNT + 1
            WHERE NO = #{bno}
            AND DEL_YN = 'N'
            """)
    int increaseHit(String bno);

    @Select("""
            SELECT
                B.NO
                , B.TITLE
                , B.CONTENT
                , B.DEPT_NO
                , D.NAME AS DEPT_NAME
                , J.NAME AS JOB_NAME
                , B.WRITER_NO
                , B.VIEW_CNT
                , B.ENROLL_DATE
                , B.MODIFY_DATE
                , B.DEL_YN
                , E.NAME
                , B.NOTICE_YN
            FROM BOARD B
            JOIN EMPLOYEE E ON( B.WRITER_NO = E.NO )
            JOIN JOB_INFO J ON( J.NO = E.JOB_NO )
            JOIN DEPARTMENT D ON( D.CODE = E.DEPT_NO )
            WHERE B.NO = #{bno}
            AND B.DEL_YN = 'N'
            """)
    BoardVo getBoard(String bno);

    @Select("""
            SELECT *
            FROM BOARD_ATTACHMENT
            WHERE BOARD_NO = #{bno}
            AND DEL_YN = 'N'
            ORDER BY NO DESC
            """)
    List<BoardAttachmentVo> getAttachmentVoList(String bno);



    @Insert("""
            INSERT INTO REPLY
            (
                NO
                ,CONTENT
                ,BOARD_NO
                ,WRITER_NO
            )
            VALUES
            (
                SEQ_REPLY.NEXTVAL
                , #{content}
                , #{boardNo}
                , #{writerNo}
            )
            """)
    int replyWrite(ReplyVo vo);

    @Select("""
            SELECT
                            R.NO
                            ,R.CONTENT
                            ,R.BOARD_NO
                            ,R.WRITER_NO
                            ,R.ENROLL_DATE
                            ,R.DEL_YN
                            ,E.NAME AS WRITER_NAME
                            ,D.NAME AS DEPT_NAME
                        FROM REPLY R
                        JOIN EMPLOYEE E ON (R.WRITER_NO = E.NO)
                        JOIN BOARD B ON (B.WRITER_NO = E.NO)
                        JOIN DEPARTMENT D ON D.CODE = E.DEPT_NO
                        WHERE R.BOARD_NO = #{boardNo}
                        AND R.DEL_YN = 'N'
            """)
    List<ReplyVo> getReplyList(String boardNo);


    @Update("""
            UPDATE BOARD
                SET
                    TITLE = #{title}
                    , CONTENT = #{content}
                    , MODIFY_DATE = SYSDATE
                WHERE NO = #{no}
                AND DEL_YN = 'N'
            """)
    int update(BoardVo vo);


    int updateBoardAttachment(List<String> changeNameList, String no);

    @Update("""
            UPDATE BOARD_ATTACHMENT
                SET
                    DEL_YN = 'Y'
                WHERE NO = #{ano}
            """)
    int delAttachment(String ano);


    @Update("""
            UPDATE BOARD
                SET
                    DEL_YN = 'Y'
            WHERE NO = #{bno}
            """)
    int del(String bno);








}
