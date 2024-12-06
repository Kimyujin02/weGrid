package com.kh.wegrid.calendar.mapper;

import com.kh.wegrid.calendar.vo.CalendarTypeVo;
import com.kh.wegrid.calendar.vo.CalendarVo;
import com.kh.wegrid.calendar.vo.EventVo;
import com.kh.wegrid.calendar.vo.KindVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CalendarMapper {

    // 항목 별 이벤트 호출 (개인, 부서)
    List<EventVo> loadEvent(String date, String type , int typeNo, String writerNo);

    // 항목 별 이벤트 호출 (프로젝트)
    @Select("""
            SELECT
                PM.PROJECT_NO AS ID
                , #{typeNo} AS TYPE_NO
                , P.PROJECT_NAME AS TITLE
                , TO_CHAR(PM.START_DATE,'YYYY-MM-DD HH24:mi') AS "START"
                , TO_CHAR(PM.END_DATE,'YYYY-MM-DD HH24:mi') AS END
                , (SELECT CT.COLOR FROM CALENDAR_TYPE CT WHERE CT.NO = #{typeNo}) AS COLOR
            FROM PROJECT_MEMBER PM
            JOIN PROJECT P ON(PM.PROJECT_NO = P.NO)
            JOIN EMPLOYEE E ON (PM.EMP_NO = E.NO)
            WHERE PM.EMP_NO = #{writerNo}
            AND TO_CHAR(PM.START_DATE,'YYYY-MM') LIKE '${date}%'
            AND PM.DEL_YN = 'N'
            UNION ALL
            SELECT
                P.NO
                , #{typeNo} AS TYPE_NO
                , P.PROJECT_NAME AS TITLE
                , TO_CHAR(P.START_DATE,'YYYY-MM-DD HH24:mi') AS "START"
                , TO_CHAR(P.END_DATE,'YYYY-MM-DD HH24:mi') AS END
                , (SELECT CT.COLOR FROM CALENDAR_TYPE CT WHERE CT.NO = #{typeNo}) AS COLOR
            FROM PROJECT P
            JOIN EMPLOYEE E ON (P.EMP_NO = E.NO)
            WHERE P.EMP_NO = #{writerNo}
            AND TO_CHAR(P.START_DATE,'YYYY-MM') LIKE '${date}%'
            """)
    List<EventVo> loadProjectEvent(String date, String type , int typeNo, String writerNo);

    // 일정 상세정보 조회(개인,부서)
    @Select("""
            SELECT
                C.NO
                , C.WRITER_NO
                , E.NAME AS WRITER_NAME
                , C.TYPE_NO
                , CT.NAME AS TYPE_NAME
                , C.KIND_NO
                , S.NAME AS KIND_NAME
                , C.IS_EDITABLE
                , C.TITLE
                , C.CONTENT
                , TO_CHAR(C.START_DATE,'YYYY-MM-DD HH24:mi') AS START_DATE
                , TO_CHAR(C.END_DATE,'YYYY-MM-DD HH24:mi') AS END_DATE
                , C.COLOR
                , C.DEL_YN
            FROM CALENDAR C
            JOIN EMPLOYEE E ON (C.WRITER_NO = E.NO)
            JOIN CALENDAR_TYPE CT ON (C.TYPE_NO = CT.NO)
            LEFT JOIN SCHEDULE_KIND S ON (C.KIND_NO = S.NO)
            WHERE C.NO = #{no}
            AND C.DEL_YN = 'N'
            """)
    CalendarVo getScheduleByNo(String no);

    // 일정 상세정보 조회(프로젝트)
    @Select("""
            SELECT
                PM.PROJECT_NO AS NO
                , PM.EMP_NO AS WRITER_NO
                , E.NAME AS WRITER_NAME
                , 3 AS TYPE_NO
                , 'N' AS IS_EDITABLE
                , P.PROJECT_NAME AS TITLE
                , P.DESCRIPTION AS CONTENT
                , TO_CHAR(PM.START_DATE,'YYYY-MM-DD HH24:mi') AS START_DATE
                , TO_CHAR(PM.END_DATE,'YYYY-MM-DD HH24:mi') AS END_DATE
            FROM PROJECT_MEMBER PM
            JOIN PROJECT P ON(PM.PROJECT_NO = P.NO)
            JOIN EMPLOYEE E ON (PM.EMP_NO = E.NO)
            WHERE PM.PROJECT_NO = #{no}
            AND PM.DEL_YN = 'N'
            AND PM.EMP_NO = #{writerNo}
            UNION ALL
            SELECT
                P.NO
                , P.EMP_NO AS WRITER_NO
                , E.NAME AS WRITER_NAME
                , 3 AS TYPE_NO
                , 'N' AS IS_EDITABLE
                , P.PROJECT_NAME AS TITLE
                , P.DESCRIPTION AS CONTENT
                , TO_CHAR(P.START_DATE,'YYYY-MM-DD HH24:mi') AS START_DATE
                , TO_CHAR(P.END_DATE,'YYYY-MM-DD HH24:mi') AS END_DATE
            FROM PROJECT P
            JOIN EMPLOYEE E ON (P.EMP_NO = E.NO)
            WHERE P.NO = #{no}
            AND P.EMP_NO = #{writerNo}
            """)
    CalendarVo getProjectScheduleByNo(String no,String writerNo);

    // 신규 일정 추가
    @Insert("""
            INSERT INTO CALENDAR
            (
                NO
                , WRITER_NO
                , TYPE_NO
                , KIND_NO
                , TITLE
                , CONTENT
                , START_DATE
                , END_DATE
                , COLOR
            )
            VALUES
            (
                SEQ_CALENDAR.NEXTVAL
                , #{writerNo}
                , #{typeNo}
                , #{kindNo}
                , #{title}
                , #{content}
                , TO_DATE(#{startDate},'YYYY-MM-DD HH24:mi:SS')
                , TO_DATE(#{endDate},'YYYY-MM-DD HH24:mi:SS')
                , UPPER(#{color})
            )
            """)
    int write(CalendarVo vo);
    
    // 일정 수정
    @Update("""
            UPDATE CALENDAR
            SET
                TYPE_NO = #{typeNo}
                , KIND_NO = #{kindNo}
                , TITLE = #{title}
                , CONTENT = #{content}
                , START_DATE = TO_DATE(#{startDate},'YYYY-MM-DD HH24:mi:SS')
                , END_DATE = TO_DATE(#{endDate},'YYYY-MM-DD HH24:mi:SS')
                , COLOR = UPPER(#{color})
            WHERE NO = #{no}
            AND WRITER_NO = #{writerNo}
            AND DEL_YN = 'N'
            """)
    int edit(CalendarVo vo);

    // 일정 삭제
    @Update("""
            UPDATE CALENDAR
            SET
                DEL_YN = 'Y'
            WHERE NO = #{scheduleNo}
            AND WRITER_NO = #{writerNo}
            """)
    int delete(String scheduleNo, String writerNo);

    // 캘린더 항목 별 정보 조회
    @Select("""
            SELECT
                NO
                , TYPE
                , NAME
                , COLOR
            FROM CALENDAR_TYPE
            """)
    List<CalendarTypeVo> getTypeInfo();

    // 일정종류 정보 조회
    @Select("""
            SELECT
                NO
                , NAME
            FROM SCHEDULE_KIND
            """)
    List<KindVo> getKindInfo();
    
}//interface
