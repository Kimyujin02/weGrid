package com.kh.wegrid.systemManager.controller;

import com.kh.wegrid.member.vo.MemberVo;
import com.kh.wegrid.project.vo.EmployeeVo;
import com.kh.wegrid.systemManager.service.SystemManagerService;
import com.kh.wegrid.systemManager.vo.DepartMentVo;
import com.kh.wegrid.systemManager.vo.JobInfoVo;
import com.kh.wegrid.util.page.PageVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("system")
@RequiredArgsConstructor
@Slf4j
public class SystemManagerController {

    private final SystemManagerService service;


    // 시스템 관리자 계정 생성 화면
    @GetMapping("create")
    public String create(Model model) {
        List<JobInfoVo> jobInfoVoList = service.getJobInfoVoList();
        List<DepartMentVo> departMentVoList = service.getDepartmentVoList();

        model.addAttribute("jobInfoVoList", jobInfoVoList); // JSP로 데이터 전달
        model.addAttribute("departMentVoList", departMentVoList);
        return "system/create";
    }

    // 계정 생성 요청
    @PostMapping("create")
    public String create(MemberVo vo) {
        int result = service.create(vo);

        if (result != 1) {
            new IllegalStateException("[ERROR] - 계정 생성 중 오류 발생");
//            return "redirect:/common/error";
        } 
        
            return "redirect:/system/list";
    }

    // 시스템 관리자 목록 조회 화면(+검색이 될까...?)
    @GetMapping("list")
    public String list(Model model
            ,@RequestParam(name = "pno" , required = false, defaultValue = "1") int currentPage
            ,String searchValue)
    {

        List<DepartMentVo> departmentVoList = service.getDepartmentVoList();
        List<JobInfoVo> jobInfoVoList = service.getJobInfoVoList();

        model.addAttribute("DepartmentVoList", departmentVoList);
        model.addAttribute("JobInfoVoList", jobInfoVoList);

            int listCount = service.getSystemCnt();
            int pageLimit = 5;
            int boardLimit = 13;
        PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
        List<EmployeeVo> empVoList = service.getEmployeeVoList(pvo, searchValue);
        model.addAttribute("empVoList", empVoList);
        model.addAttribute("pvo", pvo);
        model.addAttribute("searchValue", searchValue);

        return "system/list";
    }

    //목록 삭제 처리
    @DeleteMapping("delete")
    @ResponseBody
    public String delete(String empNoArr){
//        List<String> employeeNoList = objectMapper.readValue(empNoArr, List.class);
//        int result = service.delete(employeeNoList);
//        if(result == 0){
//            return "bad";
//        }
//        return "good";
    }

    // 시스템 관리자 상세 조회 화면
    @GetMapping("detail")
    public String detail(){
        return "system/detail";
    }

    // 시스템 관리자 계정 수정 화면
    @GetMapping("edit")
    public String edit(){
        return "system/edit";
    }

}
