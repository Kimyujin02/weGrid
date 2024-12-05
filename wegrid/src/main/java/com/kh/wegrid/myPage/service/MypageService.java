package com.kh.wegrid.mypage.service;

import com.kh.wegrid.member.vo.MemberVo;
import com.kh.wegrid.mypage.mapper.MypageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}