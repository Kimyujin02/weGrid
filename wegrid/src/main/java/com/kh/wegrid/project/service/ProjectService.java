package com.kh.wegrid.project.service;

import com.kh.wegrid.project.mapper.ProjectMapper;
import com.kh.wegrid.project.vo.ProjectVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ProjectService {

    private final ProjectMapper mapper;

    public int create(ProjectVo vo) {
        return mapper.create(vo);
    }
}
