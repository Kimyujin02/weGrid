package com.kh.wegrid.notice.mapper;

import com.kh.wegrid.notice.vo.NoticeAttachmentVo;
import com.kh.wegrid.notice.vo.NoticeVo;
import com.kh.wegrid.util.page.PageVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface NoticeMapper {

    @Select("""
            SELECT
                    N.NO
                    , N.TITLE
                    , N.WRITER_NO
                    , N.ENROLL_DATE
                    , N.VIEW_CNT
                    , E.NAME
            FROM NOTICE N
            JOIN EMPLOYEE E ON ( E.NO = N.WRITER_NO )
            WHERE N.DEL_YN = 'N'
            ORDER BY N.NO DESC
            """)
    List<NoticeVo> getSelectAllNoticeList();

    
    int getNoticeCnt(String searchType, String searchTitleValue, String searchContentValue);

    List<NoticeVo> getNoticeVoList(PageVo pvo, String searchType, String searchTitleValue, String searchContentValue);

    //공지 insert
    @Insert("""
            INSERT INTO NOTICE (
                NO
                , WRITER_NO
                , TITLE
                , CONTENT
            ) VALUES (
                SEQ_NOTICE.NEXTVAL
                , #{writerNo}
                , #{title}
                , #{content}
            )
            """)
    int insert(NoticeVo nvo);

    int insertNoticeAttachment(List<NoticeAttachmentVo> attachmentVoList);

    @Update("""
            UPDATE NOTICE
                SET
                    VIEW_CNT = VIEW_CNT + 1
            WHERE NO = #{nno}
            AND DEL_YN = 'N'
            """)
    int increaseHit(String nno);

    @Select("""
            SELECT
                N.NO
                , N.TITLE
                , N.CONTENT
                , D.NAME AS DEPT_NAME
                , J.NAME AS JOB_NAME
                , N.WRITER_NO
                , N.VIEW_CNT
                , N.ENROLL_DATE
                , N.MODIFY_DATE
                , N.DEL_YN
                , E.NAME
            FROM NOTICE N
            JOIN EMPLOYEE E ON( N.WRITER_NO = E.NO )
            JOIN JOB_INFO J ON( J.NO = E.JOB_NO )
            JOIN DEPARTMENT D ON( D.CODE = E.DEPT_NO )
            WHERE N.NO = #{nno}
            AND N.DEL_YN = 'N'
            """)
    NoticeVo getNotice(String nno);

    @Select("""
            SELECT *
            FROM NOTICE_ATTACHMENT
            WHERE NOTICE_NO = #{nno}
            AND DEL_YN = 'N'
            ORDER BY NO DESC
            """)
    List<NoticeAttachmentVo> getAttachmentVoList(String nno);

    @Update("""
            UPDATE NOTICE
                SET
                    TITLE = #{title}
                    , CONTENT = #{content}
                    , MODIFY_DATE = SYSDATE
                WHERE NO = #{no}
                AND DEL_YN = 'N'
            """)
    int update(NoticeVo vo);


    int updateNoticeAttachment(List<String> changeNameList, String no);

    @Update("""
            UPDATE NOTICE_ATTACHMENT
                SET
                    DEL_YN = 'Y'
                WHERE NO = #{ano}
            """)
    int delAttachment(String ano);

    @Update("""
            UPDATE NOTICE
                SET
                    DEL_YN = 'Y'
            WHERE NO = #{nno}
            """)
    int del(String nno);
}
