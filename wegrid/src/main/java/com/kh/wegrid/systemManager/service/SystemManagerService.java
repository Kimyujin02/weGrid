package com.kh.wegrid.systemManager.service;

import com.kh.wegrid.member.vo.MemberVo;
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
//    public List<EmployeeVo> getEmployeeVoList(PageVo pvo, String searchValue) {
//        String str = "";
//        if(searchValue != null && searchValue.length() > 0){
//            str = "AND TITLE LIKE '%" + searchValue + "%'";
//        }
//        return mapper.getEmployeeVoList(pvo, str);
//    }

    public int getSystemCnt(String searchValue, String jobNo, String value) {
        return mapper.getSystemCnt(searchValue, jobNo, value);
    }
    public List<MemberVo> getMemberVoList(PageVo pvo, String deptNo,  String jobNo, String searchValue) {
        return mapper.getMemberVoList(pvo, deptNo, jobNo, searchValue);
    }


    public MemberVo getMemberVo(String no) {
        return mapper.getMemberVo(no);
    }


    public int accountEdit(MemberVo vo) {
        return mapper.accountEdit(vo);
    }

    public int resetPassword(String no, String newPassword) {
        return mapper.updatePassword(no, newPassword);
    }

    // 비밀번호 삭제하는 거임
    public int accountDelete(String no) {
        return mapper.accountDelete(no);
    }

    // 계정 자체 삭제

    public int delete(List<String> accountArr) {
        return mapper.delete(accountArr);
    }
}
