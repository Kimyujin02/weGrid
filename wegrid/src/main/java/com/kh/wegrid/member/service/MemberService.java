package com.kh.wegrid.member.service;

import com.kh.wegrid.member.mapper.MemberMapper;
import com.kh.wegrid.member.vo.AdminVo;
import com.kh.wegrid.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberService {

    private final MemberMapper mapper;

    // 로그인
    public MemberVo login(MemberVo vo) {
        return mapper.login(vo);
    }

    // 로그인 실패시 아이디만 받아옴
    public MemberVo getMemberById(String id) {
        return mapper.getMemberById(id);
    }

    // 로그인 실패 횟수 업데이트
    public int updateFailedAttempts(MemberVo member) {
        return mapper.updateFailedAttempts(member);
    }

    // 로그인 실패 횟수 초기화
    public int resetFailedAttempts(String id) {
        return mapper.resetFailedAttempts(id);
    }

    // 계정 잠금
    public int updateIsLocked(MemberVo member) {
        return mapper.updateIsLocked(member);
    }

    // 관리자 로그인
    public AdminVo adminLogin(AdminVo vo) {
        return mapper.adminLogin(vo);
    }
}
