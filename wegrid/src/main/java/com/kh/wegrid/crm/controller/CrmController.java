package com.kh.wegrid.crm.controller;

import com.kh.wegrid.crm.service.CrmService;
import com.kh.wegrid.crm.vo.ClientRankVo;
import com.kh.wegrid.crm.vo.ClientStatusVo;
import com.kh.wegrid.crm.vo.ClientVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("edit")
    public String edit() { return "crm/clientEdit"; }
//  나중에 postmapping 추가

    @GetMapping("detail")
    private String detail() { return "crm/clientDetail"; }

    @GetMapping("history")
    private String history() { return "crm/clientHistory"; }
//    나중에 js로 탭클릭시 요소 변경?

    @GetMapping("history/create")
    private String historyCreate() { return "crm/createHistory"; }

    @GetMapping("history/edit")
    private String historyEdit() { return "crm/editHistory"; }
}