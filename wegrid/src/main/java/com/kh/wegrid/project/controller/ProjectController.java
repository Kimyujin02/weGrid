package com.kh.wegrid.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("project")
public class ProjectController {

    //프로젝트 메인 화면(카드형식)
    @GetMapping("card")
    public String prjcardList(){
        return "project/card";
    }

    //프로젝트 화면 (리스트 형식)
    @GetMapping("prjlist")
    public String prjList(){
        return "project/list";
    }
}
