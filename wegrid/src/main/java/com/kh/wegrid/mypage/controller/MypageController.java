package com.kh.wegrid.mypage.controller;

import com.kh.wegrid.member.vo.MemberVo;

import com.kh.wegrid.mypage.service.MypageService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("mypage")
@RequiredArgsConstructor
public class MypageController {

    private final MypageService service;

    // 마이페이지 홈
    @GetMapping("home")
    public String home(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        // 로그인된 사용자가 없을 때 처리
        if (loginMemberVo == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "로그인 정보가 없습니다.");
            return "redirect:/member/login"; // 로그인 페이지로 리다이렉트
        }

        String eno = loginMemberVo.getNo();

        MemberVo vo = service.getInfo(eno);
        model.addAttribute("memberVo", vo);

        return "mypage/home";
    }

    // 프로필 이미지 업로드 처리
    @PostMapping("uploadProfileImage")
    @ResponseBody
    public Map<String, String> uploadProfileImage(@RequestParam("profileImage") MultipartFile file, HttpSession session) {
        Map<String, String> response = new HashMap<>();

        try {
            // 이미지 파일이 없으면 실패 처리
            if (file.isEmpty()) {
                response.put("success", "false");
                return response;
            }

            // 이미지 파일 저장 경로 설정
            String uploadDir = "D:/SemiPrjTeam2/wegrid/src/main/resources/static/img"; // 실제 서버 경로
            String originalFileName = file.getOriginalFilename();
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String newFileName = UUID.randomUUID().toString() + fileExtension;
            File dest = new File(uploadDir + "/" + newFileName);

            // 파일을 저장
            file.transferTo(dest);

            // 로그인된 사용자 정보 가져오기
            MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
            if (loginMemberVo != null) {
                String memberNo = loginMemberVo.getNo();
                // DB에 이미지 경로 업데이트 (정적 경로 /img/ 에 저장)
                service.updateProfileImage(memberNo, "/img/" + newFileName);
            }

            // 클라이언트로 성공한 이미지 경로 반환
            response.put("success", "true");
            response.put("imagePath", newFileName);
        } catch (IOException e) {
            response.put("success", "false");
        }

        return response;
    }


    // 비밀번호 변경
    @PostMapping("changePwd")
    public String changePwd(String pwd, String newPwd, String confirmPwd, HttpSession session, RedirectAttributes redirectAttributes) {
//        System.out.println("pwd = " + pwd);
//        System.out.println("newPwd = " + newPwd);
//        System.out.println("confirmPwd = " + confirmPwd);

        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String eno = loginMemberVo.getNo();
        String prevPwd = loginMemberVo.getPwd();

        String changeMsg = service.changePwd(prevPwd, pwd, newPwd, confirmPwd, eno);
        redirectAttributes.addFlashAttribute("changeMsg", changeMsg);

        return "redirect:/mypage/home";
    }

    @GetMapping("edit")
    public String edit(HttpSession session, Model model){
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String eno = loginMemberVo.getNo();

        MemberVo vo = service.getInfo(eno);
        model.addAttribute("vo", vo);

        return "mypage/edit";
    }


    @PostMapping("edit")
    public String edit(MemberVo vo, HttpSession session, RedirectAttributes redirectAttributes){
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String eno = loginMemberVo.getNo();

        System.out.println("vo = " + vo);
        int result = service.editInfo(eno, vo);

        if (result > 0) {
            redirectAttributes.addFlashAttribute("changeXoMsg", "변경 성공!");
        } else if (result == 0) {
            redirectAttributes.addFlashAttribute("changeXoMsg", "변경된 정보가 없습니다.");
        } else {
            redirectAttributes.addFlashAttribute("changeXoMsg", "변경 실패...");
        }

        return "redirect:/mypage/home";
    }

}
