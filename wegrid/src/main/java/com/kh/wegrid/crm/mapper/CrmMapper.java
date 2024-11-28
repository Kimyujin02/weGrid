package com.kh.wegrid.crm.mapper;

import com.kh.wegrid.crm.vo.ClientRankVo;
import com.kh.wegrid.crm.vo.ClientStatusVo;
import com.kh.wegrid.crm.vo.ClientVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CrmMapper {

    @Select("""
            SELECT
                C.NO
                , C.RANK_CODE
                , CR.NAME AS RANK_NAME
                , C.STATUS_NO
                , CS.NAME AS STATUS_NAME
                , C.NAME
                , C.ADDRESS
                , C.PRESIDENT_NAME
                , C.PRESIDENT_PHONE
                , C.PRESIDENT_EMAIL
                , C.START_DATE
            FROM
                CLIENT C
                JOIN CLIENT_RANK CR ON ( C.RANK_CODE = CR.NO )
                JOIN CLIENT_STATUS CS ON ( C.STATUS_NO = CS.NO )
            ORDER BY C.RANK_CODE ASC, C.NAME ASC
            """)
    List<ClientVo> getClientVoList();

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
}
