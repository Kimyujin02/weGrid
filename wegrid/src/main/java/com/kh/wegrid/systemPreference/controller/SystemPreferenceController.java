package com.kh.wegrid.systemPreference.controller;

import com.kh.wegrid.crm.vo.ClientRankVo;
import com.kh.wegrid.member.vo.AdminVo;
import com.kh.wegrid.systemManager.vo.DepartMentVo;
import com.kh.wegrid.systemManager.vo.JobInfoVo;
import com.kh.wegrid.trip.vo.typeVo;
import com.kh.wegrid.systemPreference.service.SystemPreferenceService;
import com.kh.wegrid.vacation.vo.VacationTypeVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("systemPreference")
@RequiredArgsConstructor
@Slf4j
public class SystemPreferenceController {

    private final SystemPreferenceService service;

    // 환경설정 화면으로 이동
    @GetMapping("list")
    public String list(Model model, HttpSession session){

        AdminVo loginAdminVo = (AdminVo) session.getAttribute("loginAdminVo");
        if(loginAdminVo == null){
            session.setAttribute("alertMsg","옳바르지 않은 접근 입니다. 관리자 로그인화면으로 이동합니다.");
            return "redirect:/member/admin";
        }

        List<ClientRankVo> clientRankList = service.getClientRankList();
        List<typeVo> tripTypeList = service.getTripTypeList();
        List<DepartMentVo> departmentList = service.getDepartmentList();
        List<JobInfoVo> jobInfoList = service.getJobInfoList();
        List<VacationTypeVo> vacationTypeList = service.getVacationTypeList();

        model.addAttribute("clientRank",clientRankList);
        model.addAttribute("tripType",tripTypeList);
        model.addAttribute("department",departmentList);
        model.addAttribute("jobInfo",jobInfoList);
        model.addAttribute("vacationType",vacationTypeList);

        return "system/preference/list";

    }



}
