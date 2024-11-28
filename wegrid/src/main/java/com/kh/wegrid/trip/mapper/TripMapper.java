package com.kh.wegrid.trip.mapper;

import com.kh.wegrid.trip.vo.TripVo;
import com.kh.wegrid.util.page.PageVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TripMapper {

    @Insert("""
            INSERT INTO BUSINESS_TRIP
            (
                NO
                , EMP_NO
                , TYPE_NO
                , DESTINATION
                , TITLE
                , CONTENT
                , START_DATE
                , END_DATE
                , CLIENT
            )
            VALUES
            (
                SEQ_BUSINESS_TRIP.NEXTVAL
                , '1'
                , #{typeNo}
                , #{destination}
                , #{title}
                , #{content}
                , #{startDate}
                , #{endDate}
                , #{client}
            )
            """)
    int write(TripVo vo);

    @Select("""
            SELECT
                B.NO
                , B.EMP_NO
                , B.TYPE_NO                          
                , T.NAME           AS TYPE_NAME                
                , E.NAME           AS WRITER_NAME 
                , B.DESTINATION
                , B.TITLE
                , B.CONTENT
                , TO_CHAR(B.START_DATE, 'YYYY-MM-DD') AS START_DATE
                , TO_CHAR(B.END_DATE, 'YYYY-MM-DD')   AS END_DATE
                , B.CLIENT
            FROM BUSINESS_TRIP B
            JOIN EMPLOYEE E ON ( E.NO = B.EMP_NO )
            JOIN TRIP_TYPE T ON ( B.TYPE_NO = T.NO )
            WHERE B.DEL_YN = 'N'
            ORDER BY B.START_DATE
            OFFSET #{offset} ROWS FETCH NEXT #{boardLimit} ROWS ONLY
            """)
    List<TripVo> getTripVoList(PageVo pvo);


    @Select("""
            SELECT COUNT(NO)
            FROM BUSINESS_TRIP
            WHERE DEL_YN = 'N'
            """)
    int getTripCnt();
}
