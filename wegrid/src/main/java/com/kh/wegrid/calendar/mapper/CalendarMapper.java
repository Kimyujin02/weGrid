package com.kh.wegrid.calendar.mapper;

import com.kh.wegrid.calendar.vo.CalendarVo;
import com.kh.wegrid.calendar.vo.EventVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CalendarMapper {

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
    List<EventVo> loadEvent(int typeNo, String date);

}//interface
