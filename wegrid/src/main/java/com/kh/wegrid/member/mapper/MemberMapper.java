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
                NO
                , DEPT_NO
                , JOB_NO
                , EMP_NUM
                , ID
                , PWD
                , NAME
                , PHONE
                , EMAIL
                , POST_ADDRESS
                , ROAD_ADDRESS
                , DETAIL_ADDRESS
                , ENROLL_DATE
                , MODIFY_DATE
                , IS_MANAGER
                , DEL_YN
                , PROFILE
                , FAILED_ATTEMPTS
                , IS_LOCKED
            FROM
                EMPLOYEE
            WHERE
                ID = #{id}
                AND PWD = #{pwd}
                AND DEL_YN = 'N'
                AND IS_LOCKED = 'N'
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
