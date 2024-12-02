package com.kh.wegrid.systemManager.mapper;

import com.kh.wegrid.systemManager.vo.SystemManagerVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

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
                , #{empNum}
                , #{jobNo}
                , #{isManager}
            )
            """)
    int create(SystemManagerVo vo);
}
