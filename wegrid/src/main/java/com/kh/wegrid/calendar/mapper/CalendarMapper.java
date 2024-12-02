package com.kh.wegrid.calendar.mapper;

import com.kh.wegrid.calendar.vo.CalendarTypeVo;
import com.kh.wegrid.calendar.vo.CalendarVo;
import com.kh.wegrid.calendar.vo.EventVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CalendarMapper {
    
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


    // 항목 별 이벤트 호출
    @Select("""
            SELECT
                C.NO AS ID
                , C.TYPE_NO
                , C.TITLE
                , TO_CHAR(C.START_DATE,'YYYY-MM-DD HH24:mi') AS "START"
                , TO_CHAR(C.END_DATE,'YYYY-MM-DD HH24:mi') AS END
                , C.COLOR
            FROM CALENDAR C
            JOIN EMPLOYEE E ON (C.WRITER_NO = E.NO)
            WHERE C.TYPE_NO = #{typeNo}
            AND TO_CHAR(C.START_DATE,'YYYY-MM') LIKE '${date}%'
            ORDER BY C.START_DATE
            """)
    List<EventVo> loadEvent(String date,int typeNo);

    
    // 캘린더 항목 별 정보 조회
    @Select("""
            SELECT
                NO
                , NAME
                , COLOR
            FROM CALENDAR_TYPE
            """)
    List<CalendarTypeVo> getTypeInfo();
    
}//interface
