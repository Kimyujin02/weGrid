package com.kh.wegrid.crm.service;

import com.kh.wegrid.crm.mapper.CrmMapper;
import com.kh.wegrid.crm.vo.ClientHistoryVo;
import com.kh.wegrid.crm.vo.ClientRankVo;
import com.kh.wegrid.crm.vo.ClientStatusVo;
import com.kh.wegrid.crm.vo.ClientVo;
import com.kh.wegrid.project.vo.ProjectVo;
import com.kh.wegrid.util.page.PageVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CrmService {

    private final CrmMapper mapper;

    public List<ClientVo> getClientVoList(PageVo pvo, String statusNo, String rankCode, String searchType, String searchValue) {
        return mapper.getClientVoList(pvo, statusNo, rankCode, searchType, searchValue);
    }

    public int getClientCnt(String statusNo, String rankCode, String searchType, String searchValue) {
        return mapper.getClientCnt(statusNo, rankCode, searchType, searchValue);
    }

    public List<ClientRankVo> getClientRankVoList() {
        return mapper.getClientRankVoList();
    }

    public List<ClientStatusVo> getClientStatusVoList() {
        return mapper.getClientStatusVoList();
    }

    // 상세 조회
    public ClientVo getClientDetail(String cno) {
        return mapper.getClientDetail(cno);
    }

    // 프로젝트 카운트
    public int getPrjCnt(String cno, String searchValue) {
        return mapper.getPrjCnt(cno, searchValue);
    }

    // 상세 조회 데이터
    public List<ProjectVo> getProjectVoList(String cno, PageVo pvo, String searchValue) {
        return mapper.getProjectVoList(cno, pvo, searchValue);
    }

    // 고객사 등록
    public int enrollClient(ClientVo vo) {
        return mapper.enrollClient(vo);
    }

    // 고객사 정보 수정
    public int editClient(ClientVo vo) {
        return mapper.editClient(vo);
    }

    // 히스토리 카운트
    public int getHistoryCnt(String cno) {
        return mapper.getHistoryCnt(cno);
    }

    // 고객사 히스토리 목록
    public List<ClientHistoryVo> getHistoryVoList(String cno, PageVo pvo, String searchValue) {
        return mapper.getHistoryVoList(cno, pvo, searchValue);
    }

    // 고객사 히스토리 목록 (검색기능x)
    public List<ClientHistoryVo> getHistoryVoListMini(String cno, PageVo pvo) {
        return mapper.getHistoryVoListMini(cno, pvo);
    }

    // 고객사 히스토리 등록
    public int createHistory(ClientHistoryVo vo, String cno, String eno) {
        return mapper.createHistory(vo, cno, eno);
    }
    
    // 고객사 히스토리 정보
    public ClientHistoryVo getHistoryDetail(String hno) {
        return mapper.getHistoryDetail(hno);
    }

    // 고객사 히스토리 수정
    public int editHistory(ClientHistoryVo vo, String hno, String cno, String eno) {
        return mapper.editHistory(vo, hno, cno, eno);
    }

    // 필터링 카운트
    public int getFilteredClientCnt(String statusNo, String rankCode) {
        return mapper.getFilteredClientCnt(statusNo, rankCode);
    }

    // 필터링
    public List<ClientVo> getFilteredClientVoList(PageVo pvo, String statusNo, String rankCode) {
        return mapper.getFilteredClientVoList(pvo, statusNo, rankCode);
    }

}
