package com.kh.wegrid.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("board")
public class BoardController {

    @GetMapping("list")
    public String list(){
        return "board/list";
    }

    @GetMapping("insert")
    public String insert(){
        return "board/insert";
    }

    @GetMapping("detail")
    public String detail(){
        return "board/detail";
    }

    @GetMapping("edit")
    public String edit(){
        return "board/edit";
    }

}
