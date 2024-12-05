package com.kh.wegrid.systemManager.mapper;

import com.kh.wegrid.member.vo.MemberVo;
import com.kh.wegrid.systemManager.vo.DepartMentVo;
import com.kh.wegrid.systemManager.vo.JobInfoVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SystemManergerMapper {

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
                ,EMP_NUM
                ,JOB_NO
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
                , #{empNum}
                , #{jobNo}
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
}
