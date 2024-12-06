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

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class SystemPreferenceService {

    private final SystemPreferenceMapper mapper;


    public List<ClientRankVo> getClientRankList() {
        return mapper.getClientRankList();
    }

    public List<typeVo> getTripTypeList() {
        return mapper.getTripTypeList();
    }

    public List<DepartMentVo> getDepartmentList() {
        return mapper.getDepartMentList();
    }

    public List<JobInfoVo> getJobInfoList() {
        return mapper.getJobInfoList();
    }

    public List<VacationTypeVo> getVacationTypeList() {
        return mapper.getVacationTypeList();
    }

}
