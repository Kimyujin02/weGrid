package com.kh.wegrid.vacation.controller;

import com.kh.wegrid.member.vo.MemberVo;
import com.kh.wegrid.vacation.vo.DeptVo;
import com.kh.wegrid.util.page.PageVo;
import com.kh.wegrid.vacation.service.VacationService;
import com.kh.wegrid.vacation.vo.*;
import jakarta.servlet.http.HttpSession;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("vacation")
@RequiredArgsConstructor
public class VacationController {

    private final VacationService service;

    @GetMapping("menu")
    public String menu(HttpSession session, Model model, @RequestParam(value = "mno", required = false) String mno, VacationVo vo, @RequestParam(name = "pno", required = false, defaultValue = "1") int currentPage, String searchValue) {

        // 로그인 상태 확인
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        if (loginMemberVo == null) {
            return "redirect:/member/login";
        }
        mno = loginMemberVo.getNo();

        int listCount = service.getVacationCnt();
        int pageLimit = 5;
        int boardLimit = 10;

        PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
        List<VacationVo> voList = service.getVacationList(pvo, searchValue);
        model.addAttribute("voList", voList);
        model.addAttribute("pvo", pvo);
        model.addAttribute("searchValue", searchValue);

        System.out.println("voList = " + voList);
        
        // VacationVo 설정
        vo.setEmpNo(loginMemberVo.getNo());
        vo.setDeptNo(loginMemberVo.getDeptNo());

        // 서비스 호출 및 데이터 처리
        List<VacationVo1> selectAllVacationList = service.getSelectAllVacationList();
        List<VacationVo2> selectPersonalCnt = service.getSelectPersonalCnt();
        List<VacationVo3> selectPersonalCntInfo = service.getSelectPersonalCntInfo(mno);

        List<DeptVo> deptVoList = service.getDeptVoList();
        model.addAttribute("deptVoList", deptVoList);

        int totalUsed = 0;
        if (selectPersonalCntInfo != null && !selectPersonalCntInfo.isEmpty()) {
            for (VacationVo3 vo3 : selectPersonalCntInfo) {
                totalUsed += Integer.parseInt(vo3.getUsedVacation());
            }

            model.addAttribute("name", selectPersonalCntInfo.get(0).getName());
            model.addAttribute("vacCnt", selectPersonalCntInfo.get(0).getVacCnt());
        } else {
            model.addAttribute("name", "N/A");
            model.addAttribute("vacCnt", 0);
        }

        // 모델에 데이터 추가
        model.addAttribute("selectAllVacationList", selectAllVacationList);
        model.addAttribute("selectPersonalCnt", selectPersonalCnt);
        model.addAttribute("totalUsed", totalUsed);

        return "vacation/menu"; // JSP 파일 렌더링
    }


    @PostMapping("menu")
    public String menuInsert (HttpSession session, Model model, VacationVo vo) {


        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        if(session.getAttribute("loginMemberVo") == null){
            return "redirect:/member/login";
        }
        vo.setEmpNo(loginMemberVo.getNo());
        vo.setDeptNo(loginMemberVo.getDeptNo());

        int insertNewVacation = service.insertNewVacation(vo);

//        int updateVacation = service.updateVacation(vo);

        return "redirect:/vacation/menu";

    }

    @GetMapping("delete")
    public String deleteVacation(Model model, String no ) {

        int deleteVacationList = service.getDeleteVacationList(no);
        model.addAttribute("deleteVacationList", deleteVacationList);
        return "redirect:/vacation/menu";
    }



}
