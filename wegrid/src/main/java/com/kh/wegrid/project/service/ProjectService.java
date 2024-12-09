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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ProjectService {

    private final ProjectMapper mapper;


    // 프로젝트 생성
    public int create(ProjectVo vo , List<String> addMemberNo) {

        int result1 = mapper.create(vo);

        int result2 = 1;
        for(int i=0; i<addMemberNo.size(); i++){
            result2 = mapper.addMember(addMemberNo.get(i),vo.getStartDate(), vo.getEndDate());
            if(result2 != 1){
                break;
            }
        }


        if(result1 * result2 < 1){
            throw new IllegalStateException("ERROR- 프로젝트 생성 중 에러 발생함");
        }

        return result1 * result2;
    }


    // 프로젝트 수정
//    public int edit(ProjectVo vo, String projectNo, ProjectMemberVo pmVo) {
//        int result1 = mapper.edit(vo, projectNo);
//        int result2 = mapper.addMember(pmVo);
//        int result3 = mapper.removeMember(pmVo);
//
//        if (result1 != 1) {
//            throw new IllegalStateException("ERROR- 프로젝트 정보 수정 중 에러 발생함");
//        }
//
//        if (result3 < 0) { // 예시: 성공적으로 삭제된 멤버 수가 0일 경우 오류 처리
//            throw new IllegalStateException("ERROR- 멤버 삭제 중 에러 발생함");
//        }
//
//
//        return result1*result2*result3;
//    }


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


    public List<ProjectMemberVo> getPeopleList(String projectNo) {
        return mapper.getPeopleList(projectNo);
    }

    public int getMemberCnt() {
        return mapper.getMemberCnt();
    }

    public HashMap projectDetail(String projectNo) {
        ProjectVo vo = mapper.projectDetail(projectNo);
        List<StatusVo> statusVo = mapper.getStatusVoList();

        HashMap result = new HashMap<>();

        result.put("project", vo);
        result.put("statusList", statusVo);

        return result;
    }



    public List<StatusVo> getStatusVoList() {
        return mapper.getStatusVoList();
    }

    public List<ClientVo> searchClient(String clientName) {
        return mapper.searchClient(clientName);
    }


    public List<ProjectMemberVo> getAttachPeopleList(String projectNo) {
        return mapper.getAttachPeopleList(projectNo);
    }

    public int edit(ProjectVo vo, String projectNo, ProjectMemberVo pmVo) {
        return mapper.edit(vo, projectNo, pmVo);
    }
}
