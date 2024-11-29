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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String list(Model model){
//        List<ClientVo> clientVoList = service.getClientVoList();
        List<ClientRankVo> clientRankVoList = service.getClientRankVoList();
        List<ClientStatusVo> clientStatusVoList = service.getClientStatusVoList();
//        model.addAttribute("clientVoList", clientVoList);
        model.addAttribute("clientRankVoList", clientRankVoList);
        model.addAttribute("clientStatusVoList", clientStatusVoList);
        return "crm/clientList";
    }

    // 목록 조회 (데이터)
    @GetMapping("list/data")
    @ResponseBody
    public List<ClientVo> getClientVoList(String searchType, String searchValue){
        List<ClientVo> ClientVoList = service.getClientVoList(searchType, searchValue);

        return service.getClientVoList(searchType, searchValue);
    }

    @GetMapping("enroll")
    public String enroll() { return "crm/clientEnroll"; }
//  나중에 postmapping 으로

    @GetMapping("edit")
    public String edit() { return "crm/clientEdit"; }
//  나중에 postmapping 으로

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