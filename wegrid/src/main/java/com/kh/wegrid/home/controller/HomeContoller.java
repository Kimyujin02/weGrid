package com.kh.wegrid.home.controller;

import com.kh.wegrid.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeContoller {

    @GetMapping
    public String home(HttpSession session){

        // 접속한 사원의 사번 정보 수집
        MemberVo loginVo = (MemberVo)session.getAttribute("loginMemberVo");
        if(loginVo == null) {
            return "redirect:/member/login";
        }

        return "redirect:/project/card";
    }

}
