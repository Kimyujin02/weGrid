package com.kh.wegrid.project.service;

import com.kh.wegrid.project.mapper.ProjectMapper;
import com.kh.wegrid.project.vo.EmployeeVo;
import com.kh.wegrid.project.vo.ProjectMemberVo;
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
public class ProjectService {

    private final ProjectMapper mapper;


    // 프로젝트 생성
    public int create(ProjectVo vo) {
        return mapper.create(vo);
    }

    // 사원 검색
    public List<EmployeeVo> searchEmployees(String query) {
        return mapper.searchEmployees(query);
    }


    // 프로젝트 목록
    public List<ProjectVo> getProjectList(PageVo pvo, String searchType) {
        return mapper.getProjectList(pvo, searchType);
    }

    // 프로젝트 목록(카드형식)
    public List<ProjectVo> getCardList(PageVo pvo, String searchValue) {
        return mapper.getCardList(pvo, searchValue);
    }

    //프로젝트 갯수
    public int getProjectCnt() {
        return mapper.getProjectCnt();
    }


    // 프로젝트 상세조회
    public ProjectVo getProjectByNo(String no) {
        return mapper.getProjectByNo(no);
    }

    public List<ProjectMemberVo> getPeopleList(PageVo pvo) {
        return mapper.getPeopleList(pvo);
    }

    public ProjectVo getPeopleByNo(String no) {
        return mapper.getPeopleByNo(no);
    }

    public int getMemberCnt() {
        return mapper.getMemberCnt();
    }
}
