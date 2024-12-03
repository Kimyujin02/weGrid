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

    public List<ClientVo> getClientVoList(PageVo pvo, String searchType, String searchValue) {
        return mapper.getClientVoList(pvo, searchType, searchValue);
    }

    public int getClientCnt() { return mapper.getClientCnt(); }

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

    public int enrollClient(ClientVo vo) {
        return mapper.enrollClient(vo);
    }

    public List<ClientHistoryVo> getHistoryVoList(String cno, String searchValue) {
        return mapper.getHistoryVoList(cno, searchValue);
    }

}
