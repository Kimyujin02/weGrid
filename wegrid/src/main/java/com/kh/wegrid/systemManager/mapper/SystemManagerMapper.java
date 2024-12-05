package com.kh.wegrid.systemManager.mapper;

import com.kh.wegrid.member.vo.MemberVo;
import com.kh.wegrid.project.vo.EmployeeVo;
import com.kh.wegrid.systemManager.vo.DepartMentVo;
import com.kh.wegrid.systemManager.vo.JobInfoVo;
import com.kh.wegrid.util.page.PageVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SystemManagerMapper {

    @Insert("""
            INSERT INTO EMPLOYEE
            (
                NO
                ,NAME
                ,ID
                ,EMAIL
                ,PHONE
                ,POST_ADDRESS
                ,ROAD_ADDRESS
                ,DETAIL_ADDRESS
                ,ENROLL_DATE
                ,EMP_NUM
                ,JOB_NO
                ,DEPT_NO
                ,IS_MANAGER
            )
            VALUES
            (
                 SEQ_EMPLOYEE.NEXTVAL
                , #{name}
                , #{id}
                , #{email}
                , #{phone}
                , #{postAddress}
                , #{roadAddress}
                , #{detailAddress}
                , SYSDATE
                , #{empNum}
                , #{jobNo}
                , #{deptNo}
                , #{isManager}
            )
            """)
    int create(MemberVo vo);


    @Select("""
           SELECT NO
           FROM JOB_INFO
           WHERE NAME = #{name};
           """)
    List<JobInfoVo> getJobInfoVoList();

    @Select("""
            SELECT CODE
            FROM DEPARTMENT
            WHERE NAME = #{name};
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
                TO_CHAR(E.ENROLL_DATE, 'YYYY-MM-DD') AS ENROLL_DATE,
                E.DEL_YN
            FROM EMPLOYEE E
            LEFT JOIN DEPARTMENT D
                ON E.DEPT_NO = D.CODE  -- 부서 번호 조인
            LEFT JOIN JOB_INFO J
                ON E.JOB_NO = J.NO    -- 직급 번호 조인
            ORDER BY E.DEL_YN ASC
            """)
    List<EmployeeVo> getEmployeeVoList(PageVo pvo, String str);

    @Select("""
            SELECT COUNT(*)
            FROM EMPLOYEE
            WHERE DEL_YN = 'N'
            """)
    int getSystemCnt();
}
