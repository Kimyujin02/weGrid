package com.kh.wegrid.vacation.controller;

import com.kh.wegrid.member.vo.MemberVo;
import com.kh.wegrid.vacation.service.VacationService;
import com.kh.wegrid.vacation.vo.*;
import jakarta.servlet.http.HttpSession;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("vacation")
@RequiredArgsConstructor
public class VacationController {

    private final VacationService service;

    @GetMapping("menu")
    public String menu(HttpSession session, Model model, @RequestParam(value = "mno", required = false) String mno, VacationVo vo) {

        // 로그인 상태 확인
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        if (loginMemberVo == null) {
            return "redirect:/member/login";
        }

        // mno 파라미터가 없을 경우 세션에서 가져와 URL에 추가
        if (mno == null || mno.isEmpty()) {
            mno = loginMemberVo.getNo(); // 로그인 멤버의 사원 번호
            return "redirect:/vacation/menu?mno=" + mno;
        }

        // VacationVo 설정
        vo.setEmpNo(loginMemberVo.getNo());
        vo.setDeptNo(loginMemberVo.getDeptNo());

        // 서비스 호출 및 데이터 처리
        List<VacationVo1> selectAllVacationList = service.getSelectAllVacationList();
        List<VacationVo2> selectPersonalCnt = service.getSelectPersonalCnt();
        List<VacationVo3> selectPersonalCntInfo = service.getSelectPersonalCntInfo(mno);

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


}
