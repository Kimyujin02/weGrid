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

    // 신규 프로젝트 생성 화면
    @GetMapping("create")
    public String create(){
        return "project/create";
    }

    //프로젝트 정보 수정 화면
    @GetMapping("edit")
    public String edit(){
        return "project/edit";
    }
    
    // 프로젝트 상세조회 화면 1 (참여인력 조회)
    @GetMapping("people")
    public String peopleList(){
        return "project/people";
    }

    // 프로젝트 상세 조회 화면 2 (첨부파일 조회)
    @GetMapping("attach")
    public String attachList(){
        return "project/attach";
    }
}
