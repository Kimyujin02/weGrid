package com.kh.wegrid.myPage.service;

import com.kh.wegrid.member.vo.MemberVo;
import com.kh.wegrid.myPage.mapper.MyPageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MyPageService {

    private final MyPageMapper mapper;

    public MemberVo getInfo(String eno) {
        return mapper.getInfo(eno);
    }

    public void updateProfileImage(String eno, String imagePath) {
        mapper.updateProfileImage(eno, imagePath);
    }
}