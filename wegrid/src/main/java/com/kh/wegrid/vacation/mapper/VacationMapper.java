package com.kh.wegrid.vacation.mapper;

import com.kh.wegrid.vacation.temp.vo.EmpVo;
import com.kh.wegrid.vacation.vo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VacationMapper {

//    @Select("""
//        SELECT
//            E.NAME AS name
//            , J.VAC_CNT - V.USE_CNT AS remaining_vacation
//            , V.USE_CNT AS used_vacation
//        FROM VACATION V
//        LEFT JOIN EMPLOYEE E ON (E.NO = V.EMP_NO)
//        LEFT JOIN JOB_INFO J ON (J.NO = V.EMP_NO)
//        LEFT JOIN VACATION_TYPE VT ON (VT.NO = V.V_TYPE_NO)
//        WHERE V.EMP_NO = #{no}
//        """)
//    List<VacationVo> getRemainVacation();

//    @Select("""
//        SELECT
//            V.USE_CNT AS DayOfType
//        FROM VACATION V
//        LEFT JOIN EMPLOYEE E ON ( E.NO = V.EMP_NO )
//        LEFT JOIN VACATION_TYPE VT ON ( VT.NO = V.V_TYPE_NO )
//        WHERE E.NO = '3'
//        AND VT.NO = '1'
//        """)
//    List<VacationVo> getVacationCntOfType(@Param("vacationTypeVo") VacationTypeVo vType);

    @Select("""
            SELECT
                D.NAME AS dept_name
                , VT.NAME AS vac_type_name
                , E.NAME
                , TO_CHAR(V.START_DATE, 'YYYY-MM-DD') AS START_DATE
                , TO_CHAR(V.END_DATE, 'YYYY-MM-DD') AS END_DATE
                , V.CONTENT
                , V.V_TYPE_NO AS VAC_TYPE_NO
                , TO_NUMBER(TO_DATE(END_DATE, 'YYYY-MM-DD') - TO_DATE(START_DATE, 'YYYY-MM-DD')) AS CNT
            FROM VACATION V
            JOIN EMPLOYEE E ON ( E.NO = V.EMP_NO )
            JOIN JOB_INFO J ON ( J.NO = V.EMP_NO )
            JOIN DEPARTMENT D ON ( D.CODE = E.DEPT_NO )
            JOIN VACATION_TYPE VT ON ( VT.NO = V.V_TYPE_NO )
            WHERE E.DEL_YN = 'N'
            """)
    List<VacationVo1> getSelectAllVacationList();

    @Insert("""
        INSERT INTO VACATION
        (
            NO
            , EMP_NO
            , V_TYPE_NO
            , START_DATE
            , END_DATE
            , CONTENT
            , USE_CNT
        )
        VALUES
        (
            SEQ_VACATION.NEXTVAL
            , '3'
            , #{vacTypeNo}
            , #{startDate}
            , #{endDate}
            , #{content}
            , TO_NUMBER(TO_DATE(#{endDate}, 'YYYY-MM-DD') - TO_DATE(#{startDate}, 'YYYY-MM-DD'))
        )
    """)
    int insertNewVacation(VacationVo vo);

    @Select("""
        SELECT
            VT.NO AS vacType
            , COALESCE(SUM(V.USE_CNT), 0) AS DayOfType
        FROM VACATION V
        JOIN EMPLOYEE E ON (E.NO = V.EMP_NO)
        JOIN VACATION_TYPE VT ON (VT.NO = V.V_TYPE_NO)
        WHERE E.NO = '3'
        GROUP BY VT.NO
        ORDER BY VT.NO
        """)
    List<VacationVo2> getSelectPersonalCnt();

    @Select("""
        SELECT
            E.NAME AS name
            , J.VAC_CNT - V.USE_CNT AS remaining_vacation
            , V.USE_CNT AS used_vacation
            , J.VAC_CNT
        FROM VACATION V
        LEFT JOIN EMPLOYEE E ON (E.NO = V.EMP_NO)
        LEFT JOIN JOB_INFO J ON (J.NO = V.EMP_NO)
        LEFT JOIN VACATION_TYPE VT ON (VT.NO = V.V_TYPE_NO)
        WHERE V.EMP_NO = #{mno}
        """)
    List<VacationVo3> getSelectPersonalCntInfo(String mno);


    int updateVacation(VacationVo vo);
}