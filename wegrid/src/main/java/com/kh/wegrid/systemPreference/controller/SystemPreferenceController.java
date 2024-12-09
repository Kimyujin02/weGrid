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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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
            return "redirect:/member/adminLogin";
        }

        try{

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
        }catch (Exception e){
            throw new IllegalStateException("환경설정 항목 조회 중 오류 발생");
        }

        return "system/preference/list";

    }

    // 항목 정보 추가
    @PostMapping("add")
    @ResponseBody
    public HashMap add(String type, String name,String sub){
        System.out.println("type = " + type);
        System.out.println("name = " + name);
        System.out.println("sub = " + sub);
        HashMap map = new HashMap();
        switch (type){
            case "clientRank" : map = service.addClientRank(name); break;
            case "tripType" : map = service.addTripType(name); break;
            case "department" : map = service.addDepartment(name,sub); break;
            case "jobInfo" :
                int vacCnt = Integer.parseInt(sub);
                map = service.addJobInfo(name,vacCnt); break;
            case "vacationType" : map = service.addVacationType(name); break;
            default:break;
        }

        return map;

    }

    // 항목 정보 수정
    @PostMapping("edit")
    @ResponseBody
    public int edit(String type, String no, String name){
        System.out.println("type = " + type);
        System.out.println("no = " + no);
        System.out.println("name = " + name);

        int result = 0;
        switch (type){
            case "clientRank" : result = service.editClientRank(no,name); break;
            case "tripType" : result = service.editTripType(no,name); break;
            case "department" : result = service.editDepartment(no,name); break;
            case "jobInfo" : result = service.editJobInfo(no,name); break;
            case "vacationType" : result = service.editVacationType(no,name); break;
            case "vacCnt" :
                int vacCnt = Integer.parseInt(name);
                result = service.editVacationCnt(no,vacCnt); break;
            default:break;
        }

        return result;

    }

    // 항목 정보 삭제
    @GetMapping("delete")
    @ResponseBody
    public int delete(String type, String no){
        System.out.println("type = " + type);
        System.out.println("no = " + no);

        int result = 0;
        switch (type){
            case "clientRank" : result = service.deleteClientRank(no); break;
            case "tripType" : result = service.deleteTripType(no); break;
            case "department" : result = service.deleteDepartment(no); break;
            case "jobInfo" : result = service.deleteJobInfo(no); break;
            case "vacationType" : result = service.VacationType(no); break;
            default:break;
        }

        return result;
    }

}
