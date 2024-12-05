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

    // 항목 별 이벤트 호출
//    @Select("""
//            SELECT
//                C.NO AS ID
//                , C.TYPE_NO
//                , C.TITLE
//                , TO_CHAR(C.START_DATE,'YYYY-MM-DD HH24:mi') AS "START"
//                , TO_CHAR(C.END_DATE,'YYYY-MM-DD HH24:mi') AS END
//                , C.COLOR
//            FROM CALENDAR C
//            JOIN EMPLOYEE E ON (C.WRITER_NO = E.NO)
//            JOIN CALENDAR_TYPE CT ON (C.TYPE_NO = CT.NO)
//            WHERE CT.TYPE = #{type}
//            AND TO_CHAR(C.START_DATE,'YYYY-MM') LIKE '${date}%'
//            ORDER BY C.START_DATE
//            """)
    List<EventVo> loadEvent(String date, String type , int typeNo, String writerNo);

    // 일정 상세정보 조회
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
                , START_DATE = #{startDate}
                , END_DATE = #{endDate}
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
