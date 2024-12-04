package com.kh.wegrid.approval.controller;

import com.kh.wegrid.approval.service.ApprovalService;
import com.kh.wegrid.approval.vo.ApprovalVo;
import com.kh.wegrid.member.vo.MemberVo;
import com.kh.wegrid.trip.vo.TripVo;
import com.kh.wegrid.util.page.PageVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("approval")
@RequiredArgsConstructor
@Slf4j
public class ApprovalController {

    private final ApprovalService service;

    @GetMapping("write")
    public void write(){

    }
    @GetMapping("submitList")
    public void submitList(){}

    @GetMapping("submitList/data")
    @ResponseBody
    public HashMap getSubmitList(@RequestParam(name = "pno"
            , defaultValue = "1"
            , required = false) int currentPage
            , String statusFilter
            , HttpSession session){
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String no = loginMemberVo.getNo();

        int listCount = service.getSubmitApprovalCnt( no , statusFilter);
        int pageLimit = 5;
        int boardLimit = 15;
        PageVo pvo = new PageVo(listCount , currentPage , pageLimit , boardLimit);
        List<ApprovalVo> submitApprovalVoList = service.getSubmitApprovalVoList(pvo ,statusFilter ,no );
        HashMap map = new HashMap();
        map.put("a" , submitApprovalVoList);
        map.put("b" , pvo);



        return map;
    }

    @GetMapping("receiveList")
    public void receiveList(){}

    @GetMapping("receiveList/data")
    @ResponseBody
    public HashMap getreceiveList(@RequestParam(name = "pno"
            , defaultValue = "1"
            , required = false) int currentPage
            , String statusFilter
            , HttpSession session){
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String no = loginMemberVo.getNo();

        int listCount = service.getreceiveApprovalCnt( no , statusFilter);
        int pageLimit = 5;
        int boardLimit = 15;
        PageVo pvo = new PageVo(listCount , currentPage , pageLimit , boardLimit);
        List<ApprovalVo> receiveApprovalVoList = service.getReceiveApprovalVoList(pvo ,statusFilter ,no );
        HashMap map = new HashMap();
        map.put("a" , receiveApprovalVoList);
        map.put("b" , pvo);

        System.out.println("map = " + map);


        return map;
    }

    @GetMapping("detail")
    public void detail(){}

}
