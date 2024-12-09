package com.kh.wegrid.trip.mapper;

import com.kh.wegrid.trip.vo.TripVo;
import com.kh.wegrid.trip.vo.typeVo;
import com.kh.wegrid.util.page.PageVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TripMapper {

    @Insert("""
            INSERT INTO BUSINESS_TRIP
            (
                NO
                , EMP_NO
                , TYPE_NO
                , POST_ADDRESS
                , ROAD_ADDRESS
                , DETAIL_ADDRESS
                , TITLE
                , CONTENT
                , START_DATE
                , END_DATE
                , CLIENT
            )
            VALUES
            (
                SEQ_BUSINESS_TRIP.NEXTVAL
                , #{writerNo}
                , #{typeNo}
                , #{postAddress}
                , #{roadAddress}
                , #{detailAddress}
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
                , B.POST_ADDRESS
                , B.ROAD_ADDRESS
                , B.DETAIL_ADDRESS
                , B.TITLE
                , B.CONTENT
                , TO_CHAR(B.START_DATE, 'YYYY-MM-DD') AS START_DATE
                , TO_CHAR(B.END_DATE, 'YYYY-MM-DD')   AS END_DATE
                , B.CLIENT
            FROM BUSINESS_TRIP B
            JOIN EMPLOYEE E ON ( E.NO = B.EMP_NO )
            JOIN TRIP_TYPE T ON ( T.NO = B.TYPE_NO)
            WHERE B.NO = #{no}
            AND B.DEL_YN = 'N'
            """)
    TripVo editDetail(TripVo vo);

    @Select("""
            SELECT
                B.NO
                , B.EMP_NO          AS WRITER_NO
                , E.NAME            AS WRITER_NAME
                , B.TYPE_NO
                , T.NAME            AS TYPE_NAME
                , B.POST_ADDRESS
                , B.ROAD_ADDRESS
                , B.DETAIL_ADDRESS
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



    @Update("""
            UPDATE BUSINESS_TRIP
            SET
                 TYPE_NO = #{typeNo}
                , POST_ADDRESS = #{postAddress}
                , ROAD_ADDRESS = #{roadAddress}
                , DETAIL_ADDRESS = #{detailAddress}
                , TITLE = #{title}
                , CONTENT = #{content}
                , START_DATE = #{startDate}
                , END_DATE = #{endDate}
                , CLIENT = #{client}
            WHERE NO = #{no}
            """)
    int edit(TripVo vo);

    @Select("""
            SELECT
                NO
                , NAME
            FROM TRIP_TYPE
            """)
    List<typeVo> getTypeList();

    @Update("""
            UPDATE BUSINESS_TRIP
                SET
                    DEL_YN = 'Y'
            WHERE NO = #{no}
            """)
    int delete(String no);

    List<TripVo> getEndTripVoList(PageVo pvo, String searchType, String searchValue);

    int getEndTripCnt(String searchType, String searchValue);
}
