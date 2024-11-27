package com.kh.wegrid.systemManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("system")
public class SystemManagerController {

    // 시스템 관리자 계정 생성 화면
    @GetMapping("create")
    public String create(){
        return "system/create";
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
