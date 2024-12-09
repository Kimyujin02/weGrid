package com.kh.wegrid.systemPreference.service;

import com.kh.wegrid.crm.vo.ClientRankVo;
import com.kh.wegrid.systemManager.vo.DepartMentVo;
import com.kh.wegrid.systemManager.vo.JobInfoVo;
import com.kh.wegrid.systemPreference.mapper.SystemPreferenceMapper;
import com.kh.wegrid.trip.vo.TripVo;
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
    
    // 출장 유형 정보 추가
    public HashMap addTripType(String name) {

        HashMap map = new HashMap();

        int result = mapper.addTripType(name);

        typeVo vo = mapper.getTripTypeByNo();

        map.put("result",result);
        map.put("vo",vo);

        return map;

    }

    // 부서 정보 추가
    public HashMap addDepartment(String name, String code) {

        HashMap map = new HashMap();

        int result = mapper.addDepartment(name,code);

        DepartMentVo vo = mapper.getDepartmentByCode(code);

        map.put("result",result);
        map.put("vo",vo);

        return map;
        
    }

    // 직급 정보 추가
    public HashMap addJobInfo(String name, int vacCnt) {

        HashMap map = new HashMap();

        int result = mapper.addJobInfo(name,vacCnt);

        JobInfoVo vo = mapper.getJobInfoByNo();

        map.put("result",result);
        map.put("vo",vo);

        return map;

    }
    
    // 휴가 유형 정보 추가
    public HashMap addVacationType(String name) {

        HashMap map = new HashMap();

        int result = mapper.addVacationType(name);

        VacationTypeVo vo = mapper.getVacationByNo();

        map.put("result",result);
        map.put("vo",vo);

        return map;

    }

    // 고객사 등급 정보 수정
    public int editClientRank(String no, String name) {
        return mapper.editClientRank(no,name);
    }

    // 출장 유형 정보 수정
    public int editTripType(String no, String name) {
        return mapper.editTripType(no,name);
    }
    
    // 부서 정보 수정
    public int editDepartment(String code, String name) {
        return mapper.editDepartment(code,name);
    }

    // 직급 정보 수정
    public int editJobInfo(String no, String name) {
        return mapper.editJobInfo(no,name);
    }

    // 휴가 유형 정보 수정
    public int editVacationType(String no, String name) {
        return mapper.editVacationType(no,name);
    }

    // 직급 별 연차 개수 수정
    public int editVacationCnt(String no, int vacCnt){
        return mapper.editVacationCnt(no,vacCnt);
    }

    // 고객사 등급 정보 삭제
    public int deleteClientRank(String no) {
        return mapper.deleteClientRank(no);
    }

    // 출장 유형 정보 삭제
    public int deleteTripType(String no) {
        return mapper.deleteTripType(no);
    }

    // 부서 정보 삭제
    public int deleteDepartment(String code) {
        return mapper.deleteDepartment(code);
    }

    // 직급 정보 삭제
    public int deleteJobInfo(String no) {
        return mapper.deleteJobInfo(no);
    }

    // 휴가 유형 정보 삭제
    public int VacationType(String no) {
        return mapper.deleteVacationType(no);
    }

}//class
