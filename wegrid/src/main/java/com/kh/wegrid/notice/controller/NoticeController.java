package com.kh.wegrid.notice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("notice")
public class NoticeController {

    @GetMapping("list")
    public String list(){
        return "notice/list";
    }

    @GetMapping("insert")
    public String insert(){
        return "notice/insert";
    }

    @GetMapping("detail")
    public String detail(){
        return "notice/detail";
    }

    @GetMapping("edit")
    public String edit(){
        return "notice/edit";
    }

}
