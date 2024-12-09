package com.kh.wegrid.crm.mapper;

import com.kh.wegrid.crm.vo.ClientHistoryVo;
import com.kh.wegrid.crm.vo.ClientRankVo;
import com.kh.wegrid.crm.vo.ClientStatusVo;
import com.kh.wegrid.crm.vo.ClientVo;
import com.kh.wegrid.project.vo.ProjectVo;
import com.kh.wegrid.util.page.PageVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CrmMapper {

    List<ClientVo> getClientVoList(PageVo pvo, String statusNo, String rankCode, String searchType, String searchValue);

    int getClientCnt(String statusNo, String rankCode, String searchType, String searchValue);

    @Select("""
            SELECT
                NO
                , NAME
            FROM CLIENT_RANK
            ORDER BY NO ASC
            """)
    List<ClientRankVo> getClientRankVoList();

    @Select("""
            SELECT
                NO
                , NAME
            FROM CLIENT_STATUS
            ORDER BY NO ASC
            """)
    List<ClientStatusVo> getClientStatusVoList();

    @Insert("""
            INSERT INTO CLIENT
            (
                NO
                , RANK_CODE
                , NAME
                , POST_ADDRESS
                , ROAD_ADDRESS
                , DETAIL_ADDRESS
                , PRESIDENT_NAME
                , PRESIDENT_PHONE
                , PRESIDENT_EMAIL
                , START_DATE
            )
            VALUES
            (
                SEQ_CLIENT.NEXTVAL
                , #{rankCode}
                , #{name}
                , #{postAddress}
                , #{roadAddress}
                , #{detailAddress}
                , #{presidentName}
                , #{presidentPhone}
                , #{presidentEmail}
                , SYSDATE
            )
            """)
    int enrollClient(ClientVo vo);

    @Select("""
            SELECT
                C.NO,
                C.RANK_CODE,
                CR.NAME AS RANK_NAME,
                C.STATUS_NO,
                CS.NAME AS STATUS_NAME,
                C.NAME,
                C.POST_ADDRESS,
                C.ROAD_ADDRESS,
                C.DETAIL_ADDRESS,
                C.PRESIDENT_NAME,
                C.PRESIDENT_PHONE,
                C.PRESIDENT_EMAIL,
                C.START_DATE
            FROM
                CLIENT C
                LEFT JOIN CLIENT_RANK CR ON ( C.RANK_CODE = CR.NO )
                LEFT JOIN CLIENT_STATUS CS ON ( C.STATUS_NO = CS.NO )
            WHERE
                C.NO = #{cno}
            """)
    ClientVo getClientDetail(String cno);

    @Select("""
            SELECT COUNT(*)
            FROM PROJECT
            WHERE CLIENT_NO = #{cno}
              AND PROJECT_NAME LIKE '%' || #{searchValue} || '%'
            """)
    int getPrjCnt(String cno, String searchValue);

    @Select("""
            SELECT
                P.NO AS PROJECT_NO,
                P.PROJECT_NAME,
                P.START_DATE,
                P.END_DATE,
                P.CLIENT_NO,
                PS.NAME AS STATUS_NAME
            FROM
                PROJECT P
                JOIN PROJECT_STATUS PS ON ( P.STATUS_NO = PS.NO )
            WHERE
                P.PROJECT_NAME LIKE '%' || #{searchValue} || '%'
                AND P.CLIENT_NO = #{cno}
            ORDER BY P.NO DESC
            OFFSET #{pvo.offset} ROWS FETCH NEXT #{pvo.boardLimit} ROWS ONLY
            """)
    List<ProjectVo> getProjectVoList(String cno, PageVo pvo, String searchValue);

    @Select("""
            SELECT
                CH.NO,
                CH.CLIENT_NO,
                CH.WRITER_NO,
                CH.INQUIRY,
                CH.REPLY,
                CH.ENROLL_DATE,
                CH.DEL_YN,
                E.NAME AS WRITER_NAME
            FROM
                CLIENT_HISTORY CH
                LEFT JOIN EMPLOYEE E ON ( CH.WRITER_NO = E.NO )
            WHERE
                CH.CLIENT_NO = #{cno}
                AND CH.INQUIRY LIKE '%' || #{searchValue} || '%'
            ORDER BY CH.NO DESC
            OFFSET #{pvo.offset} ROWS FETCH NEXT #{pvo.boardLimit} ROWS ONLY
            """)
    List<ClientHistoryVo> getHistoryVoList(String cno, PageVo pvo, String searchValue);

    @Update("""
            UPDATE CLIENT
            SET
                NAME = #{name},
                POST_ADDRESS = #{postAddress},
                ROAD_ADDRESS = #{roadAddress},
                DETAIL_ADDRESS = #{detailAddress},
                RANK_CODE = #{rankCode},
                STATUS_NO = #{statusNo},
                PRESIDENT_NAME = #{presidentName},
                PRESIDENT_EMAIL = #{presidentEmail},
                PRESIDENT_PHONE = #{presidentPhone}
            WHERE
                NO = #{no}
            """)
    int editClient(ClientVo vo);

    @Select("""
            SELECT COUNT(*)
            FROM CLIENT_HISTORY
            WHERE CLIENT_NO = #{cno}
            """)
    int getHistoryCnt(String cno);

    @Select("""
            SELECT
                CH.NO,
                CH.CLIENT_NO,
                CH.WRITER_NO,
                CH.INQUIRY,
                CH.REPLY,
                CH.ENROLL_DATE,
                CH.DEL_YN,
                E.NAME AS WRITER_NAME
            FROM
                CLIENT_HISTORY CH
                LEFT JOIN EMPLOYEE E ON ( CH.WRITER_NO = E.NO )
            WHERE
                CH.CLIENT_NO = #{cno}
            ORDER BY CH.NO DESC
            OFFSET #{pvo.offset} ROWS FETCH NEXT #{pvo.boardLimit} ROWS ONLY
            """)
    List<ClientHistoryVo> getHistoryVoListMini(String cno, PageVo pvo);

    @Insert("""
            INSERT INTO CLIENT_HISTORY
            (
                NO
                , CLIENT_NO
                , WRITER_NO
                , INQUIRY
                , REPLY
                , ENROLL_DATE
                , DEL_YN
            )
            VALUES
            (
                SEQ_CLIENT_HISTORY.NEXTVAL
                , #{cno}
                , #{eno}
                , #{vo.inquiry}
                , #{vo.reply}
                , SYSDATE
                , 'N'
            )
            """)
    int createHistory(ClientHistoryVo vo, String cno, String eno);

    @Select("""
            SELECT
                NO
                , CLIENT_NO
                , WRITER_NO
                , INQUIRY
                , REPLY
                , ENROLL_DATE
            FROM
                CLIENT_HISTORY
            WHERE
                NO = #{hno}
                AND DEL_YN = 'N'
            """)
    ClientHistoryVo getHistoryDetail(String hno);

    @Update("""
            UPDATE CLIENT_HISTORY
            SET
                CLIENT_NO = #{cno}
                , WRITER_NO = #{eno}
                , INQUIRY = #{vo.inquiry}
                , REPLY = #{vo.reply}
                , DEL_YN = 'N'
            WHERE
                NO = #{hno}
            """)
    int editHistory(ClientHistoryVo vo, String hno, String cno, String eno);

    int getFilteredClientCnt(String statusNo, String rankCode);

    List<ClientVo> getFilteredClientVoList(PageVo pvo, String statusNo, String rankCode);

//    List<ClientVo> getClientVoList(PageVo pvo, String searchType, String searchValue);
}
