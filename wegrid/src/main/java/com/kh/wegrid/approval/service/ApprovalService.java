package com.kh.wegrid.approval.service;

import com.kh.wegrid.approval.mapper.ApprovalMapper;
import com.kh.wegrid.approval.vo.ApprovalVo;
import com.kh.wegrid.util.page.PageVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ApprovalService {

    private final ApprovalMapper mapper;

    public int getSubmitApprovalCnt(String no, String statusFilter) {
        return mapper.getSubmitApprovalCnt(no , statusFilter);

    }


    public List<ApprovalVo> getSubmitApprovalVoList(PageVo pvo, String statusFilter, String no) {
        return mapper.getSubmitApprovalVoList(pvo , statusFilter ,no);
    }

    public int getreceiveApprovalCnt(String no, String statusFilter) {
        return mapper.getreceiveApprovalCnt(no , statusFilter);
    }

    public List<ApprovalVo> getReceiveApprovalVoList(PageVo pvo, String statusFilter, String no) {
        return mapper.getReceiveApprovalVoList(pvo , statusFilter , no);
    }
}
