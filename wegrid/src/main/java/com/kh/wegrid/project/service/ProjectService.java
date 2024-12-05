package com.kh.wegrid.project.service;

import com.kh.wegrid.crm.vo.ClientVo;
import com.kh.wegrid.project.mapper.ProjectMapper;
import com.kh.wegrid.project.vo.EmployeeVo;
import com.kh.wegrid.project.vo.ProjectMemberVo;
import com.kh.wegrid.project.vo.ProjectVo;
import com.kh.wegrid.project.vo.StatusVo;
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
    public int create(ProjectVo vo , ProjectMemberVo pmVo) {
        int result1 = mapper.create(vo);
        int result2 = mapper.addMember(pmVo);


        if(result1 * result2 < 1){
            throw new IllegalStateException("ProjectService > create error");
        }

        return result1 * result2;
    }

    // 프로젝트 수정
//    public void editProjectAndMembers(ProjectVo vo, String projectNo, ProjectMemberVo pmVo) {
//        // 1. 프로젝트 정보 수정
//        int result1 = edit(vo, projectNo);
//
//        if (result1 != 1) {
//            throw new IllegalStateException("ERROR- 프로젝트 정보 수정 중 에러 발생함");
//        }
//
//        // 2. 멤버 수정
//        int result2 = removeMember(pmVo);
//
//        if (result2 < 0) { // 예시: 성공적으로 삭제된 멤버 수가 0일 경우 오류 처리
//            throw new IllegalStateException("ERROR- 멤버 삭제 중 에러 발생함");
//        }
//    }

    // 프로젝트 수정
    public int edit(ProjectVo vo, String projectNo, ProjectMemberVo pmVo) {
        int result1 = mapper.edit(vo, projectNo);
        int result2 = mapper.addMember(pmVo);
        int result3 = mapper.removeMember(pmVo);

        return result1*result2;
    }

    // 멤버 추가
    public int addMember(ProjectMemberVo pmVo) {
        return mapper.addMember(pmVo);
    }

    // 멤버 삭제
    public int removeMember(ProjectMemberVo pmVo) {
        return mapper.removeMember(pmVo);
    }

    // 사원 검색
    public List<EmployeeVo> searchEmployees(String name) {
        return mapper.searchEmployees(name);
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


    public List<ProjectMemberVo> getPeopleList(PageVo pvo, String projectNo) {
        return mapper.getPeopleList(pvo, projectNo);
    }

    public int getMemberCnt() {
        return mapper.getMemberCnt();
    }

    public ProjectVo projectDetail(String projectNo) {
        return mapper.projectDetail(projectNo);
    }
    

    public List<StatusVo> getStatusVoList() {
        return mapper.getStatusVoList();
    }

    public List<ClientVo> searchClient(String clientName) {
        return mapper.searchClient(clientName);
    }



   
}
