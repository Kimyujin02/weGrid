package com.kh.wegrid.systemPreference.service;

import com.kh.wegrid.crm.vo.ClientRankVo;
import com.kh.wegrid.systemManager.vo.DepartMentVo;
import com.kh.wegrid.systemManager.vo.JobInfoVo;
import com.kh.wegrid.systemPreference.mapper.SystemPreferenceMapper;
import com.kh.wegrid.trip.vo.typeVo;
import com.kh.wegrid.vacation.vo.VacationTypeVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class SystemPreferenceService {

    private final SystemPreferenceMapper mapper;

    // 고객사 등급 정보 조회
    public List<ClientRankVo> getClientRankList() {
        return mapper.getClientRankList();
    }

    // 출장 유형 정보 조회
    public List<typeVo> getTripTypeList() {
        return mapper.getTripTypeList();
    }

    // 부서 목록 조회
    public List<DepartMentVo> getDepartmentList() {
        return mapper.getDepartMentList();
    }

    // 직급 목록, 직급 별 연차 수량 조회
    public List<JobInfoVo> getJobInfoList() {
        return mapper.getJobInfoList();
    }

    // 휴가 유형 정보 조회
    public List<VacationTypeVo> getVacationTypeList() {
        return mapper.getVacationTypeList();
    }

    // 고객사 등급 정보 추가
    public HashMap addClientRank(String name) {

        HashMap map = new HashMap();

        int result = mapper.addClientRank(name);

        ClientRankVo vo = mapper.getClientRankByNo();

        map.put("result",result);
        map.put("vo",vo);

        return map;

    }



}
