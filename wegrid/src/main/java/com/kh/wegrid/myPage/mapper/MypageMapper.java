package com.kh.wegrid.myPage.mapper;

import com.kh.wegrid.member.vo.MemberVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MyPageMapper {

    @Select("""
            SELECT
                ID
                , EMAIL
                , PHONE
                , POST_ADDRESS
                , ROAD_ADDRESS
                , DETAIL_ADDRESS
                , PROFILE
            FROM
                EMPLOYEE
            WHERE
                NO = #{eno}
            """)
    MemberVo getInfo(String eno);

    @Update("""
            UPDATE
                EMPLOYEE
            SET
                PROFILE = #{imagePath}
            WHERE
                NO = #{eno}
            """)
    void updateProfileImage(String eno, String imagePath);
}
