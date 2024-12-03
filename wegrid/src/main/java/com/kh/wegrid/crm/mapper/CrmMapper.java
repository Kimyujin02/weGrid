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

import java.util.List;

@Mapper
public interface CrmMapper {

    List<ClientVo> getClientVoList(PageVo pvo, String searchType, String searchValue);

    @Select("""
            SELECT COUNT(*)
            FROM CLIENT
            """)
    int getClientCnt();

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

    int getPrjCnt(String cno, String searchValue);

    List<ProjectVo> getProjectVoList(String cno, PageVo pvo, String searchValue);

    @Select("""
            SELECT
                CH.NO,
                CH.CLIENT_NO,
                CH.WRITER_NO,
                E.NAME,
                CH.INQUIRY,
                CH.REPLY,
                CH.ENROLL_DATE
            FROM
                CLIENT_HISTORY CH
                LEFT JOIN EMPLOYEE E ON ( CH.WRITER_NO = E.NO )
            WHERE
                CH.CLIENT_NO = #{cno}
                AND CH.INQUIRY LIKE '%' || #{searchValue} || '%'
            """)
    List<ClientHistoryVo> getHistoryVoList(String cno, String searchValue);


}
