package com.kh.wegrid.systemManager.service;

import com.kh.wegrid.member.vo.MemberVo;
import com.kh.wegrid.systemManager.mapper.SystemManergerMapper;
import com.kh.wegrid.systemManager.vo.DepartMentVo;
import com.kh.wegrid.systemManager.vo.JobInfoVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class SystemManagerSevice {

    private final SystemManergerMapper mapper;

    public int create(MemberVo vo) {
        return mapper.create(vo);
    }

    public List<JobInfoVo> getJobInfoVoList() {
        return mapper.getJobInfoVoList();
    }

    public List<DepartMentVo> getDepartmentVoList() {
        return mapper.getDepartmentVoList();
    }
}
