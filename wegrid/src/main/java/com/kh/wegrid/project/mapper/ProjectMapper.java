package com.kh.wegrid.project.mapper;

import com.kh.wegrid.crm.vo.ClientVo;
import com.kh.wegrid.project.vo.EmployeeVo;
import com.kh.wegrid.project.vo.ProjectMemberVo;
import com.kh.wegrid.project.vo.ProjectVo;
import com.kh.wegrid.project.vo.StatusVo;
import com.kh.wegrid.util.page.PageVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ProjectMapper {

    // 프로젝트 생성
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
            WHERE NAME LIKE '%${name}%'
            """)
    List<EmployeeVo> searchEmployees(String name);


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
              ,P.STATUS_NO
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
              , P.STATUS_NO
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
                M.NO
                ,M.PROJECT_NO
                ,M.EMP_NO
                ,TO_CHAR(M.START_DATE,'YYYY-MM-DD HH24:mi') AS START_DATE
                ,TO_CHAR(M.END_DATE,'YYYY-MM-DD HH24:mi') AS END_DATE
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
            WHERE P.NO = #{projectNo}
            """)
    List<ProjectMemberVo> getPeopleList(String projectNo);


    //프로젝트 참여 인원 리스트 카운트
    @Select("""
            SELECT COUNT(*)
            FROM PROJECT_MEMBER
            WHERE PROJECT_NO = #{projectNo}
            """)
    int getMemberCnt();

    // 프로젝트 정보 상세 조회
    @Select("""
            SELECT
                P.NO AS PROJECT_NO
                ,P.PROJECT_NAME
                ,P.START_DATE
                ,P.STATUS_NO
                ,P.END_DATE
                ,P.BUDGET
                ,P.DESCRIPTION
                ,P.MANAGER_NAME
                ,P.MANAGER_PHONE
                ,E.NAME AS PM_NAME
                ,C.NAME AS CLIENT_NAME
                ,CR.NAME AS RANK_NAME
                ,LISTAGG(PE.NAME, ', ') WITHIN GROUP (ORDER BY PE.NAME) AS PROJECT_MEMBER_NAMES
            FROM
                PROJECT P
            JOIN
                EMPLOYEE E
                ON P.EMP_NO = E.NO -- 프로젝트 매니저와 사원 계정 테이블을 JOIN
            JOIN
                CLIENT C
                ON P.CLIENT_NO = C.NO -- 프로젝트와 고객사 테이블을 JOIN
            JOIN
                PROJECT_MEMBER PM
                ON P.NO = PM.PROJECT_NO -- 프로젝트와 프로젝트 수행인원 테이블을 JOIN
            JOIN
                EMPLOYEE PE
                ON PM.EMP_NO = PE.NO -- 수행인원의 정보를 사원 계정 테이블에서 가져옴
            JOIN
                CLIENT_RANK CR
                ON CR.NO = C.RANK_CODE
            WHERE
                P.NO = #{projectNo} -- 상세 조회할 특정 프로젝트 번호를 조건으로 설정
            GROUP BY
                P.NO
                , P.PROJECT_NAME
                , P.STATUS_NO
                , P.START_DATE
                , P.END_DATE
                , P.BUDGET
                , P.DESCRIPTION
                , P.MANAGER_NAME
                , P.MANAGER_PHONE
                , E.NAME
                , C.NAME
                , CR.NAME
                ORDER BY
                P.START_DATE DESC
            """)
    ProjectVo projectDetail(String projectNo);

    // 프로젝트 정보 수정
    @Update("""
            UPDATE PROJECT
                SET
                    PROJECT_NAME = #{projectName}
                    , EMP_NO = #{empNO}
                    , MANAGER_NAME =#{managerName}
                    , MANAGER_PHONE = #{managerPhone}
                    , BUDGET = #{budget}
                    , DESCRIPTION = #{description}
            WHERE NO = #{no}
            """)
    int edit(ProjectVo vo, String projectNo, ProjectMemberVo pmVo);

    // 프로젝트 참여 멤버 추가하기(insert)
    @Insert("""
            INSERT INTO PROJECT_MEMBER
            (
                    NO
                    ,PROJECT_NO
                    ,EMP_NO
                    ,START_DATE
                    ,END_DATE
            )
            VALUES
            (
                SEQ_PROJECT_MEMBER.NEXTVAL
                ,SEQ_PROJECT.CURRVAL
                ,#{empNo}
                ,#{startDate}
                ,#{endDate}
            )
            """)
    int addMember(String empNo,String startDate, String endDate);

    // 사원 삭제하기 UPDATE
    @Update("""
    UPDATE PROJECT_MEMBER
        SET
             END_DATE = SYSDATE
             ,DEL_YN = 'Y'
    WHERE PROJECT_NO = #{projectNo}
      AND EMP_NO = #{empNo}
      AND END_DATE IS NULL  -- 이미 삭제된 멤머는 중복 업데이트 되지 않게 함
    """)
    int removeMember(ProjectMemberVo pmVo);

    //프로젝트 상태 카테고리
    @Select("""
            SELECT *
            FROM PROJECT_STATUS
            """)
    List<StatusVo> getStatusVoList();

    @Select("""
             SELECT
                NO
               ,RANK_CODE
               ,STATUS_NO
               ,NAME
               ,POST_ADDRESS
               ,ROAD_ADDRESS
               ,DETAIL_ADDRESS
               ,PRESIDENT_NAME
               ,PRESIDENT_PHONE
               ,PRESIDENT_EMAIL
               ,START_DATE
               FROM CLIENT
            WHERE NAME LIKE '%${clientName}%'
            """)
    List<ClientVo> searchClient(String clientName);

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
            WHERE P.NO = #{projectNo}
            """)
    List<ProjectMemberVo> getAttachPeopleList(String projectNo);
}
