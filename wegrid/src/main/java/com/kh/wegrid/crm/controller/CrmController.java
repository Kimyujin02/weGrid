package com.kh.wegrid.crm.controller;

import com.kh.wegrid.crm.service.CrmService;
import com.kh.wegrid.crm.vo.ClientHistoryVo;
import com.kh.wegrid.crm.vo.ClientRankVo;
import com.kh.wegrid.crm.vo.ClientStatusVo;
import com.kh.wegrid.crm.vo.ClientVo;
import com.kh.wegrid.member.vo.MemberVo;
import com.kh.wegrid.project.vo.ProjectVo;
import com.kh.wegrid.util.page.PageVo;
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
            ,String statusNo
            ,String rankCode
            ,String searchType
            ,String searchValue
            ,HttpSession session
            ,RedirectAttributes redirectAttributes
    ){
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        if (loginMemberVo == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "로그인 정보가 없습니다.");
            return "redirect:/member/login";
        }

        int listCount = service.getClientCnt(statusNo, rankCode, searchType, searchValue);

        int pageLimit = 5;
        int boardLimit = 15;
        PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);

        List<ClientVo> clientVoList = service.getClientVoList(pvo, statusNo, rankCode, searchType, searchValue);
        List<ClientRankVo> clientRankVoList = service.getClientRankVoList();
        List<ClientStatusVo> clientStatusVoList = service.getClientStatusVoList();

        model.addAttribute("clientVoList", clientVoList);
        model.addAttribute("clientRankVoList", clientRankVoList);
        model.addAttribute("clientStatusVoList", clientStatusVoList);
        model.addAttribute("pvo", pvo);
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchValue", searchValue);
        return "crm/clientList";
    }

    // 목록 조회 필터링
    @GetMapping("list/filtered")
    @ResponseBody
    public HashMap listFiltered(
            @RequestParam(name = "pno" , defaultValue = "1" , required = false) int currentPage
            , String searchType
            , String searchValue
            , String statusNo
            , String rankCode
    ) {
        int listCount = service.getFilteredClientCnt(statusNo, rankCode);
        int pageLimit = 5;
        int boardLimit = 15;
        PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);

        List<ClientVo> clientVoList = service.getClientVoList(pvo, statusNo, rankCode, searchType, searchValue);

        HashMap map = new HashMap();
        map.put("a" , clientVoList);
        map.put("b" , pvo);

        return map;
    }

    // 고객사 상세 정보
    @GetMapping("detail")
    private String detail(String cno, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        // 로그인된 사용자가 없을 때 처리
        if (loginMemberVo == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "로그인 정보가 없습니다.");
            return "redirect:/member/login"; // 로그인 페이지로 리다이렉트
        }
        ClientVo vo = service.getClientDetail(cno);
        model.addAttribute("vo" , vo);
        return "crm/clientDetail";
    }

    // 고객사 상세 정보 (데이터)
    @GetMapping("detail/data")
    @ResponseBody
    public HashMap getPrjVoList(
            @RequestParam(name = "pno" , defaultValue = "1" , required = false) int currentPage
            , String cno
            , String searchValue)
    {
        int listCount = service.getPrjCnt(cno, searchValue);
        int pageLimit = 5;
        int boardLimit = 10;
        PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);

        List<ProjectVo> projectVoList = service.getProjectVoList(cno, pvo, searchValue);

        HashMap map = new HashMap();
        map.put("a" , projectVoList);
        map.put("b" , pvo);
        return map;
    }

    // 고객사 등록 (화면)
    @GetMapping("enroll")
    public String enroll(Model model, RedirectAttributes redirectAttributes, HttpSession session) {
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        if (loginMemberVo == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "로그인 정보가 없습니다.");
            return "redirect:/member/login";
        }
        List<ClientRankVo> clientRankVoList = service.getClientRankVoList();
        model.addAttribute("clientRankVoList", clientRankVoList);
        return "crm/clientEnroll";
    }

    // 고객사 등록
    @PostMapping("enroll")
    public String enroll(ClientVo vo) {
        int result = service.enrollClient(vo);
        return "redirect:/crm/list";
    }

    // 고객사 정보 수정 (화면)
    @GetMapping("edit")
    public String editClient(String cno, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        if (loginMemberVo == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "로그인 정보가 없습니다.");
            return "redirect:/member/login";
        }

        List<ClientRankVo> clientRankVoList = service.getClientRankVoList();
        model.addAttribute("clientRankVoList", clientRankVoList);

        List<ClientStatusVo> clientStatusVoList = service.getClientStatusVoList();
        model.addAttribute("clientStatusVoList", clientStatusVoList);

        ClientVo vo = service.getClientDetail(cno);
        model.addAttribute("vo", vo);

        return "crm/clientEdit";
    }

    // 고객사 정보 수정
    @PostMapping("edit")
    public String edit(ClientVo vo) {
        int result = service.editClient(vo);
        return "redirect:/crm/list";
    }

    // 고객사 히스토리 탭 (화면)
    @GetMapping("history")
    private String history(String cno, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        if (loginMemberVo == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "로그인 정보가 없습니다.");
            return "redirect:/member/login";
        }
        ClientVo vo = service.getClientDetail(cno);
        model.addAttribute("vo" , vo);
        return "crm/clientHistory";
    }

    // 고객사 히스토리 탭 (데이터)
    @GetMapping("history/data")
    @ResponseBody
    public HashMap getHistoryVoList(
            @RequestParam(name = "pno" , defaultValue = "1" , required = false) int currentPage
            , String cno
            , String searchValue)
    {
        int listCount = service.getHistoryCnt(cno);
        int pageLimit = 5;
        int boardLimit = 10;
        PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);

        List<ClientHistoryVo> historyVoList = service.getHistoryVoList(cno, pvo, searchValue);

        HashMap map = new HashMap();
        map.put("a" , historyVoList);
        map.put("b" , pvo);
        return map;
    }


    // 고객사 히스토리 작성 탭 (화면)
    @GetMapping("history/create")
    private String historyCreate(String cno, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        ClientVo vo = service.getClientDetail(cno);

        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        if (loginMemberVo == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "로그인 정보가 없습니다.");
            return "redirect:/member/login";
        }

        model.addAttribute("vo" , vo);
        return "crm/createHistory";
    }
    
    // 고객사 히스토리 작성 탭 (데이터,작성페이지)
    @GetMapping("history/create/data")
    @ResponseBody
    public HashMap getHistoryVoList(
            @RequestParam(name = "pno" , defaultValue = "1" , required = false) int currentPage
            , String cno)
    {
        int listCount = service.getHistoryCnt(cno);
        int pageLimit = 5;
        int boardLimit = 5;
        PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);

        List<ClientHistoryVo> historyVoList = service.getHistoryVoListMini(cno, pvo);

        HashMap map = new HashMap();
        map.put("a" , historyVoList);
        map.put("b" , pvo);
        return map;
    }

    // 고객사 히스토리 작성 탭 (작성)
    @PostMapping("history/create")
    private String createHistory(ClientHistoryVo vo, String cno, HttpSession session) {
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String eno = loginMemberVo.getNo();

        int result = service.createHistory(vo, cno, eno);

        return "redirect:/crm/history?cno=" + cno;
    }

    // 고객사 히스토리 수정 (화면)
    @GetMapping("history/edit")
    private String historyEdit(String cno, String hno, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        if (loginMemberVo == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "로그인 정보가 없습니다.");
            return "redirect:/member/login";
        }

        ClientVo vo = service.getClientDetail(cno);
        ClientHistoryVo hvo = service.getHistoryDetail(hno);

        model.addAttribute("vo" , vo);
        model.addAttribute("hvo", hvo);
        return "crm/editHistory";
    }

    // 고객사 히스토리 수정 (데이터,작성페이지)
    @GetMapping("history/edit/data")
    @ResponseBody
    public HashMap getHistoryVoListEdit(
            @RequestParam(name = "pno" , defaultValue = "1" , required = false) int currentPage
            , String cno)
    {
        int listCount = service.getHistoryCnt(cno);
        int pageLimit = 5;
        int boardLimit = 5;
        PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);

        List<ClientHistoryVo> historyVoList = service.getHistoryVoListMini(cno, pvo);

        HashMap map = new HashMap();
        map.put("a" , historyVoList);
        map.put("b" , pvo);
        return map;
    }

    // 고객사 히스토리 수정 (동작)
    @PostMapping("history/edit")
    private String editHistory(ClientHistoryVo vo, String hno, String cno, HttpSession session, RedirectAttributes redirectAttributes) {
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        // 로그인된 사용자가 없을 때 처리
        if (loginMemberVo == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "로그인 정보가 없습니다.");
            return "redirect:/member/login"; // 로그인 페이지로 리다이렉트
        }
        String eno = loginMemberVo.getNo();

        int result = service.editHistory(vo, hno, cno, eno);

        return "redirect:/crm/history?cno=" + cno;
    }

    // 고객사 히스토리 상세조회
    @GetMapping("history/detail")
    private String historyDetail(String cno, String hno, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        if (loginMemberVo == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "로그인 정보가 없습니다.");
            return "redirect:/member/login";
        }
        ClientVo vo = service.getClientDetail(cno);
        ClientHistoryVo hvo = service.getHistoryDetail(hno);

        model.addAttribute("vo" , vo);
        model.addAttribute("hvo", hvo);
        return "crm/historyDetail";
    }

    // 고객사 히스토리 상세조회 (데이터)
    @GetMapping("history/detail/data")
    @ResponseBody
    public HashMap getHistoryVoListDetail(
            @RequestParam(name = "pno" , defaultValue = "1" , required = false) int currentPage
            , String cno)
    {
        int listCount = service.getHistoryCnt(cno);
        int pageLimit = 5;
        int boardLimit = 5;
        PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);

        List<ClientHistoryVo> historyVoList = service.getHistoryVoListMini(cno, pvo);

        HashMap map = new HashMap();
        map.put("a" , historyVoList);
        map.put("b" , pvo);
        return map;
    }
}