package com.kh.wegrid.systemManager.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.wegrid.member.vo.AdminVo;
import com.kh.wegrid.member.vo.MemberVo;
import com.kh.wegrid.systemManager.service.SystemManagerService;
import com.kh.wegrid.systemManager.vo.DepartMentVo;
import com.kh.wegrid.systemManager.vo.JobInfoVo;
import com.kh.wegrid.util.page.PageVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("system")
@RequiredArgsConstructor
@Slf4j
public class SystemManagerController {

    private final ObjectMapper objectMapper;
    private final SystemManagerService service;


    // 시스템 관리자 계정 생성 화면
    @GetMapping("create")
    public String create(Model model) {
        List<JobInfoVo> jobInfoVoList = service.getJobInfoVoList();
        List<DepartMentVo> departMentVoList = service.getDepartmentVoList();

        model.addAttribute("jobInfoVoList", jobInfoVoList); // JSP로 데이터 전달
        model.addAttribute("departMentVoList", departMentVoList);

//       System.out.println("departMentVoList = " + departMentVoList);
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
    public String list(
            Model model,
            HttpSession session,
            @RequestParam(value = "deptNo", required = false) String deptNo,
            @RequestParam(value = "jobNo", required = false) String jobNo,
            @RequestParam(name = "pno", required = false, defaultValue = "1") int currentPage,
            @RequestParam(value = "searchValue", required = false) String searchValue,
            RedirectAttributes redirectAttributes
    ) {

        // 로그인된 사용자가 없을 때 처리
        AdminVo loginAdminVo = (AdminVo) session.getAttribute("loginAdminVo");
        if(loginAdminVo == null){
            session.setAttribute("alertMsg","옳바르지 않은 접근 입니다. 관리자 로그인화면으로 이동합니다.");
            return "redirect:/member/adminLogin";

        }

        // 1. 부서 및 직급 리스트 가져오기
        List<JobInfoVo> jobInfoVoList = service.getJobInfoVoList();
        List<DepartMentVo> departMentVoList = service.getDepartmentVoList();
        model.addAttribute("jobInfoVoList", jobInfoVoList);
        model.addAttribute("departMentVoList", departMentVoList);

        // 2. 필터링 조건에 따른 총 데이터 개수 가져오기
        int listCount = service.getSystemCnt(deptNo, jobNo, searchValue);

        // 3. 페이징 처리
        int pageLimit = 5; // 한 번에 보여질 페이지 번호 개수
        int boardLimit = 11; // 한 페이지에서 보여질 데이터 개수
        PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);

        // 4. 필터링 및 페이징 조건으로 데이터 가져오기
        List<MemberVo> empVoList = service.getMemberVoList(pvo, deptNo, jobNo, searchValue);
        model.addAttribute("empVoList", empVoList);
        model.addAttribute("pvo", pvo);

        // 5. 필터 및 검색어 유지
        model.addAttribute("deptNo", deptNo);
        model.addAttribute("jobNo", jobNo);
        model.addAttribute("searchValue", searchValue);

        return "system/account/list";
    }


    //목록 삭제 처리(왜안돼 ㅇ웩)
    @DeleteMapping("delete")
    @ResponseBody
    public String delete(String accountArr) throws JsonProcessingException {
        System.out.println("accountArr = " + accountArr);
        List<String> noticeNoList = objectMapper.readValue(accountArr , List.class);
        int result = service.delete(noticeNoList);
        if(result == 0){
            return "bad";
        }
        return "good";
    }



    // 시스템 관리자 상세 조회 화면
    @GetMapping("detail")
    public String detail(Model model, @RequestParam(required = false) String no) {
        System.out.println("Received no: " + no); // 디버깅 로그
        if (no == null || no.isEmpty()) {
            System.out.println("No parameter is missing");
            return "redirect:/error"; // 에러 페이지로 리다이렉트
        }

        MemberVo vo = service.getMemberVo(no);
        if (vo == null) {
            System.out.println("No member found with no = " + no);
            return "redirect:/error"; // 데이터가 없으면 에러 처리
        }

        model.addAttribute("vo", vo);
        System.out.println("Member data: " + vo);
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

    // 패스워드 초기화
    @PostMapping("resetPassword")
    @ResponseBody
    public Map<String, Object> resetPassword(@RequestBody Map<String, String> request) {
        Map<String, Object> response = new HashMap<>();
        System.out.println("Received no: " + request.get("no"));

        try {
            String no = request.get("no");

            // 고정된 비밀번호로 초기화 (예: "newpassword123")
            String newPassword = "123456";
            // 비밀번호 초기화 처리
            int result = service.resetPassword(no, newPassword);

            if (result > 0) {
                response.put("success", true);
                response.put("newPassword", newPassword); // 클라이언트에 고정된 비밀번호 전달
            } else {
                response.put("success", false);
                response.put("message", "비밀번호 초기화에 실패했습니다.");
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
        }
        return response;
    }

    @PostMapping("/account/delete")
    @ResponseBody
    public Map<String, Object> deleteAccount(@RequestBody Map<String, String> request) {
        Map<String, Object> response = new HashMap<>();
        try {
            String no = request.get("no");

            // delYn을 N으로 업데이트
            int result = service.accountDelete(no);

            if (result > 0) {
                response.put("success", true);
            } else {
                response.put("success", false);
                response.put("message", "삭제할 데이터를 찾을 수 없습니다.");
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
        }
        return response;
    }

}
