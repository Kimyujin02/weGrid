package com.kh.wegrid.manager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("manager")
public class ManagerController {

    @GetMapping("home")
    public String home(){
        return "manager/home";
    }

    @GetMapping("vacation/list")
    public String vacationList(){
        return "manager/vacation/list";
    }

    @GetMapping("vacation/detail")
    public String vacationDetail(){
        return "manager/vacation/detail";
    }

    @GetMapping("board/list")
    public String boardList(){
        return "manager/board/list";
    }

    @GetMapping("board/detail")
    public String boardDetail(){
        return "manager/board/detail";
    }

    @GetMapping("reply/list")
    public String replyList(){
        return "manager/reply/list";
    }

}


