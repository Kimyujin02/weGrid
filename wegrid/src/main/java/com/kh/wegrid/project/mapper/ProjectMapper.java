package com.kh.wegrid.project.mapper;

import com.kh.wegrid.project.vo.EmployeeVo;
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

    
    // 사원 정보 select
    @Select("""
            SELECT *
            FROM EMPLOYEE
            WHERE NAME LIKE '%#{query}%' OR NAME LIKE '%#{query}%'
            """)
    List<EmployeeVo> searchEmployees(String query);


    // 첨부파일 insert


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
                                        ON P.EMP_NO = E.NO -- 프로젝트 PM과 사원 계정 테이블을 JOIN
                                    JOIN
                                        CLIENT C
                                        ON P.CLIENT_NO = C.NO -- 프로젝트와 고객사 테이블을 JOIN
                                    LEFT JOIN
                                        PROJECT_MEMBER PM
                                        ON P.NO = PM.PROJECT_NO -- 프로젝트와 프로젝트 수행인원 테이블을 JOIN
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
            """)
    ProjectVo getProjectByNo(String no);

    @Select("""
            SELECT
                M.NO
                ,M.PROJECT_NO
                ,M.EMP_NO
                ,M.DEL_YN
                ,E.NAME  AS EMP_NAME
                ,E.EMAIL
                ,E.DEPT_NO
                ,E.EMP_NUM
                ,P.PROJECT_NAME
                ,D.NAME
            FROM PROJECT_MEMBER M
            JOIN EMPLOYEE E ON M.EMP_NO = E.NO
            JOIN PROJECT P ON P.NO = M.PROJECT_NO
            JOIN DEPARTMENT D ON D.CODE = E.DEPT_NO
            """)
    List<ProjectMemberVo> getPeopleList(PageVo pvo);


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
                                                 ON P.EMP_NO = E.NO -- 프로젝트 PM과 사원 계정 테이블을 JOIN
                                             JOIN
                                                 CLIENT C
                                                 ON P.CLIENT_NO = C.NO -- 프로젝트와 고객사 테이블을 JOIN
                                             LEFT JOIN
                                                 PROJECT_MEMBER PM
                                                 ON P.NO = PM.PROJECT_NO -- 프로젝트와 프로젝트 수행인원 테이블을 JOIN
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
            """)
    ProjectVo getPeopleByNo(String no);

    //프로젝트 참여 인원 리스트 카운트
    @Select("""
            SELECT COUNT(*)
            FROM PROJECT_MEMBER
            WHERE PROJECT_NO = #{projectNo}
            """)
    int getMemberCnt();
}
