package com.kh.wegrid.systemManager.controller;

import com.kh.wegrid.member.vo.AdminVo;
import com.kh.wegrid.member.vo.MemberVo;
import com.kh.wegrid.systemManager.service.SystemManagerService;
import com.kh.wegrid.systemManager.vo.DepartMentVo;
import com.kh.wegrid.systemManager.vo.JobInfoVo;
import com.kh.wegrid.util.page.PageVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//        System.out.println("departMentVoList = " + departMentVoList);
//        System.out.println("jobInfoVoList = " + jobInfoVoList);

        return "system/create";
    }

    // 계정 생성 요청
    @PostMapping("create")
    public String create(MemberVo vo) {
//        System.out.println("vo = " + vo);
        int result = service.create(vo);

        if (result != 1) {
            new IllegalStateException("[ERROR] - 계정 생성 중 오류 발생");
        }
        
            return "redirect:/system/account/list";
    }


    // 시스템 관리자 목록 조회 화면(+검색이 될까...?)
    @GetMapping("account/list")
    public String list(Model model, HttpSession session
            ,@RequestParam(name = "pno" , required = false, defaultValue = "1") int currentPage
            ,String searchValue)
    {
        AdminVo loginAdminVo = (AdminVo) session.getAttribute("loginAdminVo");
        if(loginAdminVo == null){
            session.setAttribute("alertMsg","옳바르지 않은 접근 입니다. 관리자 로그인화면으로 이동합니다.");
            return "redirect:/member/admin";
        }

        List<JobInfoVo> jobInfoVoList = service.getJobInfoVoList();
        List<DepartMentVo> departMentVoList = service.getDepartmentVoList();

        model.addAttribute("jobInfoVoList", jobInfoVoList); // JSP로 데이터 전달
        model.addAttribute("departMentVoList", departMentVoList);

            int listCount = service.getSystemCnt();
            int pageLimit = 5;
            int boardLimit = 13;
        PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
        List<MemberVo> empVoList = service.getMemberVoList(pvo, searchValue);
        model.addAttribute("empVoList", empVoList);
//        System.out.println("empVoList = " + empVoList);
        model.addAttribute("pvo", pvo);
        model.addAttribute("searchValue", searchValue);

        return "system/account/list";
    }

    //목록 삭제 처리
    @DeleteMapping("delete")
    @ResponseBody
//    public String delete(String empNoArr){
////        List<String> employeeNoList = objectMapper.readValue(empNoArr, List.class);
////        int result = service.delete(employeeNoList);
////        if(result == 0){
////            return "bad";
////        }
////        return "good";
//    }

    // 시스템 관리자 상세 조회 화면
    @GetMapping("detail")
    public String detail(){
        return "system/detail";
    }

    // 시스템 관리자 계정 수정 화면
    @GetMapping("edit")
    public String edit(Model model, String no){
        MemberVo vo = service.getMemberVo(no);
        model.addAttribute("vo", vo);

        if (vo == null) {
            // vo가 null일 경우 오류 메시지 처리
            model.addAttribute("errorMessage", "회원 정보를 찾을 수 없습니다.");
            return "system/error";
        }

        List<JobInfoVo> jobInfoVoList = service.getJobInfoVoList();
        List<DepartMentVo> departMentVoList = service.getDepartmentVoList();

        model.addAttribute("jobInfoVoList", jobInfoVoList); // JSP로 데이터 전달
        model.addAttribute("departMentVoList", departMentVoList);

        return "system/edit";
    }

    // 시스템 관리자 계정수정 요청처리
    @PostMapping("edit")
    public String edit(MemberVo vo){
        System.out.println("수정 요청 데이터 vo: " + vo);
        int result = service.accountEdit(vo);
        System.out.println("수정 결과: " + result);

        if(result != 1){
            throw  new IllegalStateException("[ERROR] - 수정 중 에러 발생");
        }
        return "redirect:/system/account/list";
    }

    // 비밀번호 초기화
    @PostMapping("system/resetPassword")
    @ResponseBody
    public Map<String, Object> resetPassword(@RequestBody Map<String, String> request) {
        Map<String, Object> response = new HashMap<>();
        try {
            String no = request.get("no");

            // 고정된 비밀번호로 초기화 (예: "newpassword123")
            String newPassword = "newpassword123";

            // 비밀번호 초기화 처리
            int result = service.resetPassword(no, newPassword);

            if (result > 0) {
                response.put("success", true);
            } else {
                response.put("success", false);
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
        }
        return response;
    }

}
