package com.kh.wegrid.crm.controller;

import com.kh.wegrid.crm.service.CrmService;
import com.kh.wegrid.crm.vo.ClientHistoryVo;
import com.kh.wegrid.crm.vo.ClientRankVo;
import com.kh.wegrid.crm.vo.ClientVo;
import com.kh.wegrid.project.vo.ProjectVo;
import com.kh.wegrid.util.page.PageVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("crm")
@Slf4j
@RequiredArgsConstructor
public class CrmController {

    private final CrmService service;

    // 목록 조회 (화면)
    @GetMapping("list")
    public String list(
            Model model
            ,@RequestParam(name = "pno" , required = false, defaultValue = "1") int currentPage
            ,String searchType
            ,String searchValue
    ){
        int listCount = service.getClientCnt();
        int pageLimit = 5;
        int boardLimit = 15;
        PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);

        List<ClientVo> clientVoList = service.getClientVoList(pvo, searchType, searchValue);
        model.addAttribute("clientVoList", clientVoList);
        model.addAttribute("pvo", pvo);
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchValue", searchValue);
        return "crm/clientList";
    }

//    // 고객사 상세 정보
//    @GetMapping("detail")
//    private String detail(String cno, Model model) {
//        ClientVo vo = service.getClientDetail(cno);
//        model.addAttribute("vo" , vo);
//        return "crm/clientDetail";
//    }
//
//    //게시글 목록조회 (데이터)
//    @GetMapping("detail/data")
//    @ResponseBody
//    public HashMap getPrjVoList(
//            @RequestParam(name = "pno" , defaultValue = "1" , required = false) int currentPage
//            , String cno
//            , String searchValue)
//    {
//        int listCount = service.getPrjCnt(cno, searchValue);
//        int pageLimit = 5;
//        int boardLimit = 10;
//        PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
//
//        List<ProjectVo> projectVoList = service.getProjectVoList(cno, pvo, searchValue);
//
//        HashMap map = new HashMap();
//        map.put("a" , projectVoList);
//        map.put("b" , pvo);
//        return map;
//    }
//
//    // 고객사 등록 (화면)
//    @GetMapping("enroll")
//    public String enroll(Model model) {
//        List<ClientRankVo> clientRankVoList = service.getClientRankVoList();
//        model.addAttribute("clientRankVoList", clientRankVoList);
//        return "crm/clientEnroll";
//    }
//
//    // 고객사 등록
//    @PostMapping("enroll")
//    public String enroll(ClientVo vo) {
//        vo.setAddress(vo.getPostAddress() + " " +vo.getRoadAddress() + " " + vo.getDetailAddress());
//        int result = service.enrollClient(vo);
//        return "redirect:/crm/list";
//    }
//
//    // 고객 수정 페이지 열기
//    @GetMapping("/edit")
//    public String editCustomer(String cno, Model model, HttpSession session) {
//
//        session.setAttribute("cno", cno);
//
//        List<ClientRankVo> clientRankVoList = service.getClientRankVoList();
//        model.addAttribute("clientRankVoList", clientRankVoList);
//
//        ClientVo vo = service.getClientDetail(cno);
//        model.addAttribute("vo", vo);
//
//        return "crm/clientEdit";
//    }
//
//    // 고객사 히스토리 탭
//    @GetMapping("history")
//    private String history(String cno, Model model, HttpSession session) {
//
//        ClientVo vo = service.getClientDetail(cno);
//        session.setAttribute("cno", cno);
//        model.addAttribute("vo" , vo);
//        return "crm/clientHistory";
//    }
//
//    @GetMapping("history/data")
//    @ResponseBody
//    private List<ClientHistoryVo> history(String cno, String searchValue) {
//        List<ClientHistoryVo> historyVoList = service.getHistoryVoList(cno, searchValue);
//        return historyVoList;
//    }
//
//    @GetMapping("history/edit")
//    private String historyEdit() { return "crm/editHistory"; }
}