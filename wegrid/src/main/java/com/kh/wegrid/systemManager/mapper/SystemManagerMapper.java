package com.kh.wegrid.systemManager.mapper;

import com.kh.wegrid.member.vo.MemberVo;
import com.kh.wegrid.project.vo.EmployeeVo;
import com.kh.wegrid.systemManager.vo.DepartMentVo;
import com.kh.wegrid.systemManager.vo.JobInfoVo;
import com.kh.wegrid.util.page.PageVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SystemManagerMapper {

    @Insert("""
            INSERT INTO EMPLOYEE
            (
                NO
                ,NAME
                ,ID
                ,DEPT_NO
                ,EMAIL
                ,PHONE
                ,POST_ADDRESS
                ,ROAD_ADDRESS
                ,DETAIL_ADDRESS
                ,ENROLL_DATE
                ,EMP_NUM
                ,JOB_NO
                ,IS_MANAGER
            )
            VALUES
            (
                 SEQ_EMPLOYEE.NEXTVAL
                , #{name}
                , #{id}
                , #{deptNo}
                , #{email}
                , #{phone}
                , #{postAddress}
                , #{roadAddress}
                , #{detailAddress}
                , SYSDATE
                , #{empNum}
                , #{jobNo}
                , #{isManager}
            )
            """)
    int create(MemberVo vo);


    @Select("""
        SELECT *
        FROM JOB_INFO
        """)
    List<JobInfoVo> getJobInfoVoList();

    @Select("""
            SELECT *
            FROM DEPARTMENT
            """)
    List<DepartMentVo> getDepartmentVoList();


    @Select("""
            SELECT
                E.NO,
                E.NAME,
                E.ID,
                E.EMAIL,
                E.PHONE,
                E.POST_ADDRESS,
                E.ROAD_ADDRESS,
                E.DETAIL_ADDRESS,
                E.EMP_NUM,
                D.NAME AS DEPT_NAME,  -- 부서 이름
                J.NAME AS JOB_NAME,        -- 직급 이름
                E.IS_MANAGER,
                TO_CHAR(E.ENROLL_DATE, 'YYYY-MM-DD')  AS ENROLL_DATE,
                E.DEL_YN
            FROM EMPLOYEE E
            LEFT JOIN DEPARTMENT D
                ON E.DEPT_NO = D.CODE  -- 부서 번호 조인
            LEFT JOIN JOB_INFO J
                ON E.JOB_NO = J.NO    -- 직급 번호 조인
            ORDER BY E.DEL_YN ASC
            """)
    List<EmployeeVo> getEmployeeVoList(PageVo pvo, String str);

    int getSystemCnt(String searchValue, String jobNo, String value);


    List<MemberVo> getMemberVoList(PageVo pvo, String deptNo, String jobNo, String searchValue);


    @Select("""
            SELECT
                E.NO,
                E.NAME,
                E.ID,
                E.EMAIL,
                E.PHONE,
                E.POST_ADDRESS,
                E.ROAD_ADDRESS,
                E.DETAIL_ADDRESS,
                E.EMP_NUM,
                D.NAME AS DEPT_NAME,  -- 부서 이름
                J.NAME AS JOB_NAME,        -- 직급 이름
                E.IS_MANAGER,
                TO_CHAR(E.ENROLL_DATE, 'YYYY-MM-DD') AS ENROLL_DATE,
                E.IS_LOCKED,
                E.DEL_YN
            FROM EMPLOYEE E
            LEFT JOIN DEPARTMENT D
                ON E.DEPT_NO = D.CODE  -- 부서 번호 조인
            LEFT JOIN JOB_INFO J
                ON E.JOB_NO = J.NO    -- 직급 번호 조인
                WHERE E.NO = #{no}
            ORDER BY E.DEL_YN ASC
            """)
    MemberVo getMemberVo(String no);


    int accountEdit(MemberVo vo);

    // 비밀번호 초기화
    @Update("""
    UPDATE EMPLOYEE
    SET 
        PWD = #{newPassword}
        , FAILED_ATTEMPTS = 0
        , IS_LOCKED = 'N'  
    WHERE NO = #{no}
    """)
    int updatePassword(@Param("no") String no, @Param("newPassword") String newPassword);


    @Update("""
            UPDATE EMPLOYEE
            SET DEL_YN = 'Y'
            WHERE NO = #{NO}
            """)
    int accountDelete(String no);


    int delete(@Param("accountArr") List<String> accountArr);
}


