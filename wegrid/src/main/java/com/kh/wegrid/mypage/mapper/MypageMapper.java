package com.kh.wegrid.mypage.mapper;

import com.kh.wegrid.member.vo.MemberVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MypageMapper {

    @Select("""
            SELECT
                ID
                , NAME
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

    @Update("""
            UPDATE
                EMPLOYEE
            SET
                PWD = #{newPwd}
            WHERE
                NO = #{eno}
            """)
    void changePwd(String newPwd, String eno);

    @Update("""
            UPDATE
                EMPLOYEE
            SET
                NAME = #{vo.name}
                , ID = #{vo.id}
                , EMAIL = #{vo.email}
                , PHONE = #{vo.phone}
                , POST_ADDRESS = #{vo.postAddress}
                , ROAD_ADDRESS = #{vo.roadAddress}
                , DETAIL_ADDRESS = #{vo.detailAddress}
            WHERE
                NO = #{eno}
            """)
    int editInfo(String eno, MemberVo vo);
}
