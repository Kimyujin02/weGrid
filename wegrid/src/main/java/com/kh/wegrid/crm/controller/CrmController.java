package com.kh.wegrid.crm.controller;

import com.kh.wegrid.crm.service.CrmService;
import com.kh.wegrid.crm.vo.ClientHistoryVo;
import com.kh.wegrid.crm.vo.ClientRankVo;
import com.kh.wegrid.crm.vo.ClientStatusVo;
import com.kh.wegrid.crm.vo.ClientVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("crm")
@Slf4j
@RequiredArgsConstructor
public class CrmController {

    private final CrmService service;

    // 목록 조회 (화면)
    @GetMapping("list")
    public String list(Model model){
        List<ClientRankVo> clientRankVoList = service.getClientRankVoList();
        List<ClientStatusVo> clientStatusVoList = service.getClientStatusVoList();
        model.addAttribute("clientRankVoList", clientRankVoList);
        model.addAttribute("clientStatusVoList", clientStatusVoList);
        return "crm/clientList";
    }

    // 목록 조회 (데이터)
    @GetMapping("list/data")
    @ResponseBody
    public List<ClientVo> getClientVoList(String searchType, String searchValue){
        List<ClientVo> ClientVoList = service.getClientVoListData(searchType, searchValue);

        return service.getClientVoListData(searchType, searchValue);
    }

    // 고객사 상세 정보
    @GetMapping("detail")
    private String detail(String cno, Model model, HttpSession session) {
        System.out.println("받은 cno 값: " + cno);
        ClientVo vo = service.getDetail(cno);
        session.setAttribute("cno", cno);
        model.addAttribute("vo" , vo);
        return "crm/clientDetail";
    }

    // 고객사 상세 정보 (프로젝트 데이터)
    @GetMapping("detail/data")
    @ResponseBody
    public List<ClientVo> getPrjVoList(String searchValue, HttpSession session){
        String cno = (String) session.getAttribute("cno");
        List<ClientVo> prjVoList = service.getPrjVoList(cno, searchValue);
        return service.getPrjVoList(cno, searchValue);
    }

    // 고객사 등록 (화면)
    @GetMapping("enroll")
    public String enroll(Model model) {
        List<ClientRankVo> clientRankVoList = service.getClientRankVoList();
        model.addAttribute("clientRankVoList", clientRankVoList);
        return "crm/clientEnroll";
    }

    // 고객사 등록
    @PostMapping("enroll")
    public String enroll(ClientVo vo) {
        // 도로명 주소와 상세 주소를 합쳐 address 필드에 저장
        vo.setAddress(vo.getRoadAddress() + " " + vo.getDetailAddress());
        int result = service.enroll(vo);
        return "redirect:/crm/list";
    }

    // 고객 수정 페이지 열기
    @GetMapping("/edit")
    public String editCustomer(String cno, Model model, HttpSession session) {

        session.setAttribute("cno", cno);

        List<ClientRankVo> clientRankVoList = service.getClientRankVoList();
        model.addAttribute("clientRankVoList", clientRankVoList);

        ClientVo vo = service.getDetail(cno);
        model.addAttribute("vo", vo);

        return "crm/clientEdit";
    }

    // 고객사 히스토리 탭
    @GetMapping("history")
    private String history(String cno, Model model, HttpSession session) {

        ClientVo vo = service.getDetail(cno);
        session.setAttribute("cno", cno);
        model.addAttribute("vo" , vo);
        return "crm/clientHistory";
    }

    @GetMapping("history/data")
    @ResponseBody
    private List<ClientHistoryVo> history(String cno, String searchValue) {
        List<ClientHistoryVo> historyVoList = service.getHistoryVoList(cno, searchValue);
        return historyVoList;
    }

//    @ResponseBody
//    public List<ClientVo> getPrjVoList(String searchValue, HttpSession session){
//        String cno = (String) session.getAttribute("cno");
//        List<ClientVo> prjVoList = service.getPrjVoList(cno, searchValue);
//        return service.getPrjVoList(cno, searchValue);
//    }

    @GetMapping("history/edit")
    private String historyEdit() { return "crm/editHistory"; }
}