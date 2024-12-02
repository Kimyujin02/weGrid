package com.kh.wegrid.systemManager.controller;

import com.kh.wegrid.systemManager.service.SystemManagerSevice;
import com.kh.wegrid.systemManager.vo.SystemManagerVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("system")
@RequiredArgsConstructor
@Slf4j
public class SystemManagerController {

    private final SystemManagerSevice service;

    // 시스템 관리자 계정 생성 화면
    @GetMapping("create")
    public String create(){
        return "system/create";
    }

    // 계정 생성 요청
    @PostMapping("create")
    public String create(SystemManagerVo vo){
        int result = service.create(vo);

        if(result > 0){
        return "redirect:/system/list";
        }else{
            return "redirect:/common/error";
        }
    }

    // 시스템 관리자 계정 수정 화면
    @GetMapping("edit")
    public String edit(){
        return "system/edit";
    }

    // 시스템 관리자 상세 조회 화면
    @GetMapping("detail")
    public String detail(){
        return "system/detail";
    }

    // 시스템 관리자 목록 조회 화면
    @GetMapping("list")
    public String list(){
        return "system/list";
    }
}
