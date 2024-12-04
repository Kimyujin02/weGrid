package com.kh.wegrid.systemManager.service;

import com.kh.wegrid.member.vo.MemberVo;
import com.kh.wegrid.systemManager.mapper.SystemManergerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class SystemManagerSevice {

    private final SystemManergerMapper mapper;

    public int create(MemberVo vo) {
        return mapper.create(vo);
    }
}
