package com.kh.wegrid.vacation.service;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface JobInfoMapper {

    @Select("""
            SELECT 
                NO
                , NAME
                , VAC_CNT
                , DEL_YN
            FROM JOB_INFO
            WHERE EMP_NO = #{empNo}
            AND DEL_YN = 'N'
            """)
    int getVacationDaysByJobInfo(String empNo);
}
