package com.kh.wegrid.approval.mapper;

import com.kh.wegrid.approval.vo.ApprovalAttachmentVo;
import com.kh.wegrid.approval.vo.ApprovalVo;
import com.kh.wegrid.approval.vo.DeptVo;
import com.kh.wegrid.approval.vo.MemberListVo;
import com.kh.wegrid.util.page.PageVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ApprovalMapper {


    int getSubmitApprovalCnt(String no, String statusFilter);



    List<ApprovalVo> getSubmitApprovalVoList(PageVo pvo, String statusFilter, String no);

    int getreceiveApprovalCnt(String no, String statusFilter);

    List<ApprovalVo> getReceiveApprovalVoList(PageVo pvo, String statusFilter, String no);

    @Select("""
            SELECT
                CODE
                , NAME
            FROM DEPARTMENT
            WHERE DEL_YN = 'N'
            """)
    List<DeptVo> getDeptVoList();


    int getEmpListCnt(String searchType, String searchValue);

    List<MemberListVo> getEmpVoList(PageVo pvo, String searchType, String searchValue);

    @Insert("""
            INSERT INTO APPROVAL
            (
                NO
                , EMP_NO        
                , M_LINE
                , STATUS_NO
                , M_STATUS
                , L_LINE
                , TITLE
                , CONTENT
            )
            VALUES
            (
                SEQ_APPROVAL.NEXTVAL
                , #{writerNo}
                , #{mline}
                , #{statusNo}
                , #{mstatus}
                , #{lline}
                , #{title}
                , #{content}
            )
            """)
    int insertApproval(ApprovalVo avo);


    int insertApprovalAttachment(List<ApprovalAttachmentVo> attachmentVoList);

    @Select("""
    SELECT
         A.NO,
         A.EMP_NO          AS WRITER_NO,
         E.NAME            AS WRITER_NAME,
         E.PROFILE         AS WRITER_PROFILE,
         D.NAME            AS WRITER_DEPT,
         A.L_LINE,
         L.NAME            AS L_LINE_NAME,
         L.PROFILE         AS L_LINE_PROFILE,
         LD.NAME           AS L_LINE_DEPT,
         A.M_LINE,
         A.M_STATUS,
         COALESCE(M.NAME, '미지정') AS M_LINE_NAME,
         COALESCE(MD.NAME, '미지정') AS M_LINE_DEPT,
         COALESCE(M.PROFILE, '미지정') AS M_LINE_PROFILE,
         A.STATUS_NO,
         S.NAME            AS STATUS_NAME,
         A.TITLE,
         A.CONTENT,
         TO_CHAR(A.ENROLL_DATE, 'YYYY-MM-DD') AS ENROLL_DATE
    FROM APPROVAL A
    JOIN EMPLOYEE E ON (E.NO = A.EMP_NO)
    JOIN APPROVAL_STATUS S ON (S.NO = A.STATUS_NO)
    JOIN EMPLOYEE L ON (L.NO = A.L_LINE)
    JOIN DEPARTMENT LD ON (LD.CODE = L.DEPT_NO)
    LEFT JOIN EMPLOYEE M ON (M.NO = A.M_LINE) 
    LEFT JOIN DEPARTMENT MD ON (MD.CODE = M.DEPT_NO) 
    JOIN DEPARTMENT D ON (D.CODE = E.DEPT_NO)
    WHERE A.NO = #{ano}
      """)
    ApprovalVo approvalDetail(String ano);

    @Select("""
            SELECT
                NO
                , APPR_NO
                , ORIGIN_NAME
                , CHANGE_NAME
                , UPLOAD_DATE
                , DEL_YN
            FROM APPROVAL_ATTACHMENT
            WHERE DEL_YN = 'N'
            AND APPR_NO = #{ano}
            """)
    List<ApprovalAttachmentVo> attDetail(String ano);

    @Delete("""
            DELETE APPROVAL
            WHERE NO = #{no}
            """)
    int deleteApproval(String no);

    @Delete("""
            DELETE APPROVAL_ATTACHMENT
            WHERE APPR_NO = #{no}
            """)
    int deleteApprovalAttach(String no);

    @Update("""
            UPDATE APPROVAL
                SET 
                    STATUS_NO = '2'
                    , M_STATUS = '2'
            WHERE NO = #{no}
            """)
    int middleAllow(String no);

    @Update("""
            UPDATE APPROVAL
                SET
                    STATUS_NO = '4'
                    , M_STATUS = '4'
            WHERE NO = #{no}
            """)
    int middleCompanion(String no);

    @Update("""
            UPDATE APPROVAL
                SET
                    STATUS_NO = '3'
            WHERE NO = #{no}
            """)
    int lastAllow(String no);

    @Update("""
            UPDATE APPROVAL
                SET
                    STATUS_NO = '4'
            WHERE NO = #{no}
            """)
    int lastCompanion(String no);
}
