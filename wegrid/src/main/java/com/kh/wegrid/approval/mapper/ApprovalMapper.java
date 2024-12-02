package com.kh.wegrid.approval.mapper;

import com.kh.wegrid.approval.vo.ApprovalVo;
import com.kh.wegrid.util.page.PageVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ApprovalMapper {


    int getSubmitApprovalCnt(String no, String statusFilter);



    List<ApprovalVo> getSubmitApprovalVoList(PageVo pvo, String statusFilter, String no);

    int getreceiveApprovalCnt(String no, String statusFilter);

    List<ApprovalVo> getReceiveApprovalVoList(PageVo pvo, String statusFilter, String no);
}
