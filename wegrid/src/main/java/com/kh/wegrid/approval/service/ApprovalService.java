package com.kh.wegrid.approval.service;

import com.kh.wegrid.approval.mapper.ApprovalMapper;
import com.kh.wegrid.approval.vo.ApprovalAttachmentVo;
import com.kh.wegrid.approval.vo.ApprovalVo;
import com.kh.wegrid.approval.vo.DeptVo;
import com.kh.wegrid.approval.vo.MemberListVo;
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

    public List<DeptVo> getDeptVoList() {
        return mapper.getDeptVoList();
    }

    public int getEmpListCnt(String searchType, String searchValue) {
        return mapper.getEmpListCnt(searchType , searchValue);
    }

    public List<MemberListVo> getEmpVoList(PageVo pvo, String searchType, String searchValue) {
        return mapper.getEmpVoList(pvo , searchType , searchValue);
    }

    public int insertApproval(ApprovalVo avo , List<ApprovalAttachmentVo> attachmentVoList) {
        int result2 = 1;
        // 중간결재자가 존재 여부
        if(avo.getMline() != null && avo.getMline() != ""){
            avo.setMstatus("1");
            avo.setStatusNo("1");
        }else{
            avo.setMstatus("0");
            avo.setStatusNo("2");
        }
        int result1 = mapper.insertApproval(avo);
        if(attachmentVoList.size()>0){
            result2 = mapper.insertApprovalAttachment(attachmentVoList);
        }

        return result1*result2;
    }

    public ApprovalVo approvalDetail(String ano) {
        return mapper.approvalDetail(ano);
    }

    public List<ApprovalAttachmentVo> attDetail(String ano) {
        return mapper.attDetail(ano);
    }

    public int deleteApproval(String no) {
//        int result2 = 1;
        int result2 = mapper.deleteApprovalAttach(no);

        int result1 = mapper.deleteApproval(no);

        return result1;
    }

    public int middleAllow(String no) {
        return mapper.middleAllow(no);
    }

    public int middleCompanion(String no) {
        return mapper.middleCompanion(no);
    }

    public int lastAllow(String no) {
        return mapper.lastAllow(no);
    }

    public int lastCompanion(String no) {
        return mapper.lastCompanion(no);
    }
}

















