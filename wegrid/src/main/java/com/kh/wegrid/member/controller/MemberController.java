package com.kh.wegrid.member.controller;

import com.kh.wegrid.member.service.MemberService;
import com.kh.wegrid.member.vo.AdminVo;
import com.kh.wegrid.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService service;

    // 사원 로그인(화면)
    @GetMapping("login")
    public String login(){
        return "member/login";
    }

    // 사원 로그인
    @PostMapping("login")
    public String login(MemberVo vo, HttpSession session, Model model) {

        MemberVo loginMemberVo = service.login(vo);

        if (loginMemberVo == null) {
            // 아이디는 맞는데 비밀번호를 틀렸을 때,,,
            MemberVo member = service.getMemberById(vo.getId());
            if (member != null) {
                int failedAttempts = member.getFailedAttempts();

                // 계정 잠금
                if (failedAttempts >= 4) {
                    member.setIsLocked("Y");
                    service.updateIsLocked(member);

                    failedAttempts++;
                    member.setFailedAttempts(failedAttempts);
                    service.updateFailedAttempts(member);

                    model.addAttribute("loginFailed", "로그인 시도 횟수를 초과했습니다.");
                    return "member/login";
                }

                failedAttempts++;
                member.setFailedAttempts(failedAttempts);
                service.updateFailedAttempts(member);
            }

            model.addAttribute("loginFailed", "아이디 또는 비밀번호를 확인하세요.");
            return "member/login";
        }

        // 로그인 성공 시 실패 횟수 초기화
        service.resetFailedAttempts(vo.getId());
        session.removeAttribute("loginAdminVo");
        session.setAttribute("loginMemberVo", loginMemberVo);
        return "redirect:/project/card";
    }

    // 로그아웃
    @GetMapping("logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
        session.removeAttribute("loginMemberVo");
        redirectAttributes.addFlashAttribute("logoutMsg", "로그아웃 성공!");

        return "redirect:/member/login";
    }

    // 관리자 로그인 (화면)
    @GetMapping("adminLogin")
    public String adminLogin(){
        return "member/adminLogin";
    }

    // 관리자 로그인
    @PostMapping("adminLogin")
    public String adminLogin(AdminVo vo, HttpSession session, Model model){

        AdminVo loginAdminVo = service.adminLogin(vo);

        if(loginAdminVo == null) {
            session.setAttribute("alertMsg","아이디 또는 비밀번호를 확인하세요.");
            return "redirect:/member/adminLogin";
        }

        session.removeAttribute("loginMemberVo");
        session.setAttribute("loginAdminVo", loginAdminVo);
        return "redirect:/system/account/list";

    }

    @GetMapping("adminLogout")
    public String adminLogout(HttpSession session, RedirectAttributes redirectAttributes) {
        session.removeAttribute("loginAdminVo");
        redirectAttributes.addFlashAttribute("logoutMsg", "로그아웃 성공!");
        return "redirect:/member/adminLogin";
    }

}
