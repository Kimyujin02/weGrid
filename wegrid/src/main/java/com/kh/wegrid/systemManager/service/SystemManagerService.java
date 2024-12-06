package com.kh.wegrid.systemManager.service;

import com.kh.wegrid.member.vo.MemberVo;
import com.kh.wegrid.project.vo.EmployeeVo;
import com.kh.wegrid.systemManager.mapper.SystemManagerMapper;
import com.kh.wegrid.systemManager.vo.DepartMentVo;
import com.kh.wegrid.systemManager.vo.JobInfoVo;
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
public class SystemManagerService {

    private final SystemManagerMapper mapper;

    // 계정 생성
    public int create(MemberVo vo) {
        return mapper.create(vo);
    }

    public List<JobInfoVo> getJobInfoVoList() {
        return mapper.getJobInfoVoList();
    }

    public List<DepartMentVo> getDepartmentVoList() {
        return mapper.getDepartmentVoList();
    }

    // 목록 조회
    public List<EmployeeVo> getEmployeeVoList(PageVo pvo, String searchValue) {
        String str = "";
        if(searchValue != null && searchValue.length() > 0){
            str = "AND TITLE LIKE '%" + searchValue + "%'";
        }
        return mapper.getEmployeeVoList(pvo, str);
    }

    public int getSystemCnt() {
        return mapper.getSystemCnt();
    }
}
