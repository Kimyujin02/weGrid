package com.kh.wegrid.mypage.service;

import com.kh.wegrid.member.vo.MemberVo;
import com.kh.wegrid.mypage.mapper.MypageMapper;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MypageService {

    private final MypageMapper mapper;

    public MemberVo getInfo(String eno) {
        return mapper.getInfo(eno);
    }

    public void updateProfileImage(String eno, String imagePath) {
        mapper.updateProfileImage(eno, imagePath);
    }

    public String changePwd(String prevPwd, String pwd, String newPwd, String confirmPwd, String eno) {
        // 로직
        String failedMsg = null;
        String successMsg = null;

        if(!prevPwd.equals(pwd)){
            failedMsg = "현재 비밀번호를 잘못 입력하셨습니다.";
        }else if(newPwd.length()<8){
            failedMsg = "비밀번호가 너무 짧습니다.";
        }else if(!newPwd.equals(confirmPwd)){
            failedMsg = "비밀번호 확인 실패";
        }else {
            mapper.changePwd(newPwd, eno);
            successMsg = "비밀번호 변경 성공!";
        }

        if(failedMsg != null) {
            return failedMsg;
        }else {
            return successMsg;
        }
    }

    public int editInfo(String eno, MemberVo vo) {
        return mapper.editInfo(eno, vo);
    }
}