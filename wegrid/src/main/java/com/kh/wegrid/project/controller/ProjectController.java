package com.kh.wegrid.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("project")
public class ProjectController {

    //프로젝트 메인 화면(카드형식)
    @GetMapping("card")
    public String cardList(){
        return "project/card";
    }

    //프로젝트 화면 (리스트 형식)
    @GetMapping("list")
    public String List(){
        return "project/list";
    }

    // 프로젝트 생성 화면
    @GetMapping("create")
    public String create(){
        return "project/create";
    }
}
