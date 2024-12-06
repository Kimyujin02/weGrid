package com.kh.wegrid.member.mapper;

import com.kh.wegrid.member.vo.AdminVo;
import com.kh.wegrid.member.vo.MemberVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MemberMapper {

    @Select("""
            SELECT
                E.NO
                , E.DEPT_NO
                , E.JOB_NO
                , E.EMP_NUM
                , E.ID
                , E.PWD
                , E.NAME
                , E.PHONE
                , E.EMAIL
                , E.POST_ADDRESS
                , E.ROAD_ADDRESS
                , E.DETAIL_ADDRESS
                , E.ENROLL_DATE
                , E.MODIFY_DATE
                , E.IS_MANAGER
                , E.DEL_YN
                , E.PROFILE
                , E.FAILED_ATTEMPTS
                , E.IS_LOCKED
                , D.NAME AS DEPT_NAME
            FROM
                EMPLOYEE E
            JOIN
                DEPARTMENT D ON ( E.DEPT_NO = D.CODE )
            WHERE
                E.ID = #{id}
                AND E.PWD = #{pwd}
                AND E.DEL_YN = 'N'
                AND E.IS_LOCKED = 'N'
            """)
    MemberVo login(MemberVo vo);

    @Select("""
            SELECT *
            FROM
                EMPLOYEE
            WHERE
                ID = #{id}
            """)
    MemberVo getMemberById(String id);

    @Update("""
            UPDATE
                EMPLOYEE
            SET
                FAILED_ATTEMPTS = #{failedAttempts}
            WHERE
                ID = #{id}
                AND DEL_YN = 'N'
            """)
    int updateFailedAttempts(MemberVo member);

    @Update("""
            UPDATE
                EMPLOYEE
            SET
                FAILED_ATTEMPTS = 0
            WHERE
                ID = #{id}
                AND DEL_YN = 'N'
            """)
    int resetFailedAttempts(String id);

    @Update("""
            UPDATE
                EMPLOYEE
            SET
                IS_LOCKED = #{isLocked}
            WHERE
                ID = #{id}
            """)
    int updateIsLocked(MemberVo member);

    @Select("""
            SELECT
                NO
                , ID
                , PWD
                , NICK
            FROM
                ADMIN
            WHERE
                ID = #{id}
                AND PWD = #{pwd}
            """)
    AdminVo adminLogin(AdminVo vo);
}
