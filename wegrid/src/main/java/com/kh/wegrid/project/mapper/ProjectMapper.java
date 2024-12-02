package com.kh.wegrid.project.mapper;

import com.kh.wegrid.project.vo.ProjectMemberVo;
import com.kh.wegrid.project.vo.ProjectVo;
import com.kh.wegrid.util.page.PageVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProjectMapper {

    @Insert("""
            INSERT INTO PROJECT
            (
                NO
               , CLIENT_NO
               , EMP_NO
               , PROJECT_NAME
               , START_DATE
               , END_DATE
               , BUDGET
               , DESCRIPTION
               , MANAGER_NAME
               , MANAGER_PHONE
            
            )
            VALUES
            (
                SEQ_PROJECT.NEXTVAL
                , #{clientNo}
                , #{empNo}
                , #{projectName}
                , #{startDate}
                , #{endDate}
                , #{budget}
                , #{description}
                , #{managerName}
                , #{managerPhone}
            )
            """)
    int create(ProjectVo vo);

    
    // 프로젝트 목록 조회
    @Select("""
                                  SELECT
                                      P.NO AS PROJECT_NO
                                      ,P.PROJECT_NAME
                                      ,P.START_DATE
                                      ,P.END_DATE
                                      ,E.NAME AS PM_NAME
                                      ,C.NAME AS CLIENT_NAME
                                      ,P.MANAGER_NAME
                                      ,COUNT(PM.EMP_NO) AS PROJECT_MEMBER_COUNT
                                      ,P.STATUS_NO
                                      ,PS.NAME AS STATUS_NAME
                                  FROM
                                      PROJECT P
                                  JOIN
                                      EMPLOYEE E
                                      ON P.EMP_NO = E.NO
                                  JOIN
                                      CLIENT C
                                      ON P.CLIENT_NO = C.NO 
                                  LEFT JOIN
                                      PROJECT_MEMBER PM
                                      ON P.NO = PM.PROJECT_NO 
                                  JOIN
                                      PROJECT_STATUS PS
                                      ON P.STATUS_NO = PS.NO
                                  GROUP BY
                                      P.NO
                                      , P.PROJECT_NAME
                                      , P.START_DATE
                                      , P.END_DATE
                                      , P.STATUS_NO
                                      , P.MANAGER_NAME
                                      , E.NAME
                                      , C.NAME
                                      , PS.NAME
                                  ORDER BY
                                      P.START_DATE DESC
                                       OFFSET #{pvo.offset} ROWS FETCH NEXT #{pvo.boardLimit} ROWS ONLY

            """)
    List<ProjectVo> getProjectList(PageVo pvo, String searchValue);

    @Select("""
            SELECT COUNT(*)
            FROM PROJECT
            """)
    int getProjectCnt();

    @Select("""
                                  SELECT
                                      P.NO AS PROJECT_NO
                                      ,P.PROJECT_NAME
                                      ,P.START_DATE
                                      ,P.END_DATE
                                      ,E.NAME AS PM_NAME
                                      ,C.NAME AS CLIENT_NAME
                                      ,P.MANAGER_NAME
                                      ,COUNT(PM.EMP_NO) AS PROJECT_MEMBER_COUNT
                                      ,P.STATUS_NO
                                      ,PS.NAME AS STATUS_NAME
                                  FROM
                                      PROJECT P
                                  JOIN
                                      EMPLOYEE E
                                      ON P.EMP_NO = E.NO
                                  JOIN
                                      CLIENT C
                                      ON P.CLIENT_NO = C.NO 
                                  LEFT JOIN
                                      PROJECT_MEMBER PM
                                      ON P.NO = PM.PROJECT_NO 
                                  JOIN
                                      PROJECT_STATUS PS
                                      ON P.STATUS_NO = PS.NO
                                  GROUP BY
                                      P.NO
                                      , P.PROJECT_NAME
                                      , P.START_DATE
                                      , P.END_DATE
                                      , P.STATUS_NO
                                      , P.MANAGER_NAME
                                      , E.NAME
                                      , C.NAME
                                      , PS.NAME
                                  ORDER BY
                                      P.START_DATE DESC
                                      OFFSET #{pvo.offset} ROWS FETCH NEXT #{pvo.boardLimit} ROWS ONLY

            """)
    List<ProjectVo> getCardList(PageVo pvo, String searchValue);

    int memberCnt(ProjectMemberVo pmvo);

    @Select("""
            SELECT
                P.NO AS PROJECT_NO
                ,P.PROJECT_NAME
                ,P.START_DATE
                ,P.END_DATE
                ,P.BUDGET
                ,P.DESCRIPTION
                ,P.MANAGER_NAME
                ,P.MANAGER_PHONE
                ,E.NAME AS PM_NAME
                ,C.NAME AS CLIENT_NAME
                ,LISTAGG(PE.NAME, ', ') WITHIN GROUP (ORDER BY PE.NAME) AS PROJECT_MEMBER_NAMES
            FROM
                PROJECT P
            LEFT JOIN
                EMPLOYEE E
                ON P.EMP_NO = E.NO 
            LEFT JOIN
                CLIENT C
                ON P.CLIENT_NO = C.NO
            LEFT JOIN
                PROJECT_MEMBER PM
                ON P.NO = PM.PROJECT_NO
            LEFT JOIN
                EMPLOYEE PE
                ON PM.EMP_NO = PE.NO
            WHERE
                P.NO = #{projectNo}
            GROUP BY
                P.NO
                , P.PROJECT_NAME
                , P.START_DATE
                , P.END_DATE
                , P.BUDGET
                , P.DESCRIPTION
                , P.MANAGER_NAME
                , P.MANAGER_PHONE
                , E.NAME
                , C.NAME
                ORDER BY
                P.START_DATE DESC
            """)
    ProjectVo getProjectByNo(String no);
}
