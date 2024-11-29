package com.kh.wegrid.project.mapper;

import com.kh.wegrid.project.vo.ProjectVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectMapper {

    @Insert("""
            INSERT INTO PROJECT
            (
                NO
               , CLIENT_NO
               , EMP_NO
               , STATUS_NO
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
                , '1'
                , #{projectName}
                , TO_DATE(#{startDate}, 'YYYY-MM-DD')
                , TO_DATE(#{endDate}, 'YYYY-MM-DD')
                , #{budget}
                , #{description}
                , #{managerName}
                , #{managerPhone}
            )
            """)
    int create(ProjectVo vo);
}
