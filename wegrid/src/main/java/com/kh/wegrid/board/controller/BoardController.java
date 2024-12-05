package com.kh.wegrid.board.controller;

import com.kh.wegrid.board.service.BoardService;
import com.kh.wegrid.board.vo.BoardAttachmentVo;
import com.kh.wegrid.board.vo.BoardVo;
import com.kh.wegrid.board.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;


    @GetMapping("list")
    public String list(){
        return "board/list";
    }

    @GetMapping("insert")
    public String insert(HttpSession session){
//        if(session.getAttribute("loginMemberVo") == null){
//            return "redirect:/member/login";
//        }
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

