package com.kh.wegrid.vacation.controller;

import com.kh.wegrid.vacation.service.VacationService;
import com.kh.wegrid.vacation.temp.vo.EmpVo;
import com.kh.wegrid.vacation.temp.vo.JobInfoVo;
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
    public String menu(Model model , String mno) {

        List<VacationVo1> selectAllVacationList = service.getSelectAllVacationList();
        List<VacationVo2> selectPersonalCnt = service.getSelectPersonalCnt();
        List<VacationVo3> selectPersonalCntInfo = service.getSelectPersonalCntInfo(mno);

        int totalUsed = 0;
        for (VacationVo3 vo3 : selectPersonalCntInfo) {
            totalUsed += Integer.parseInt(vo3.getUsedVacation());
        }

        model.addAttribute("selectAllVacationList", selectAllVacationList);
        model.addAttribute("selectPersonalCnt", selectPersonalCnt);
        model.addAttribute("totalUsed", totalUsed);
        model.addAttribute("name", selectPersonalCntInfo.get(0).getName());
        model.addAttribute("vacCnt", selectPersonalCntInfo.get(0).getVacCnt());

        return "vacation/menu";
    }

    @PostMapping("menu")
    public String menuInsert (Model model, VacationVo vo) {
        int insertNewVacation = service.insertNewVacation(vo);

        int updateVacation = service.updateVacation(vo);

        return "redirect:/vacation/menu";
    }


}
