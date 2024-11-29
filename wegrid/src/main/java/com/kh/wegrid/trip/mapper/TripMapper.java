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


    List<TripVo> getTripVoList(PageVo pvo, String searchType, String searchValue);



    int getTripCnt(String searchType, String searchValue);

    @Select("""
            SELECT
                B.NO
                , B.EMP_NO          AS WRITER_NO
                , E.NAME            AS WRITER_NAME
                , B.TYPE_NO
                , T.NAME            AS TYPE_NAME
                , SUBSTR(B.DESTINATION, 1, 2) AS DESTINATION
                , B.TITLE
                , B.CONTENT
                , TO_CHAR(B.START_DATE, 'YYYY-MM-DD') AS START_DATE
                , TO_CHAR(B.END_DATE, 'YYYY-MM-DD')   AS END_DATE
                , B.CLIENT
            FROM BUSINESS_TRIP B
            JOIN EMPLOYEE E ON ( E.NO = B.EMP_NO )
            JOIN TRIP_TYPE T ON ( T.NO = B.TYPE_NO)
            WHERE B.NO = #{tno}
            AND B.DEL_YN = 'N'
            """)
    TripVo detail(String tno);
}
