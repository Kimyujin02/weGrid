package com.kh.wegrid.notice.service;

import com.kh.wegrid.board.mapper.BoardMapper;
import com.kh.wegrid.board.vo.BoardAttachmentVo;
import com.kh.wegrid.board.vo.BoardVo;
import com.kh.wegrid.notice.mapper.NoticeMapper;
import com.kh.wegrid.notice.vo.NoticeAttachmentVo;
import com.kh.wegrid.notice.vo.NoticeVo;
import com.kh.wegrid.util.page.PageVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class NoticeService {

    private final NoticeMapper mapper;


    public List<NoticeVo> getSelectAllNoticeList() {
        return mapper.getSelectAllNoticeList();
    }

    public int getNoticeCnt(String searchType, String searchTitleValue, String searchContentValue) {
        return mapper.getNoticeCnt(searchType, searchTitleValue, searchContentValue);
    }

    public List<NoticeVo> getNoticeVoList(PageVo pvo, String searchType, String searchTitleValue, String searchContentValue) {
        return mapper.getNoticeVoList(pvo, searchType, searchTitleValue, searchContentValue);
    }

    public int insert(NoticeVo nvo, List<NoticeAttachmentVo> attachmentVoList) {
        int result1 = mapper.insert(nvo);
        int result2 = 1;
        if (attachmentVoList.size() > 0) {
            result2 = mapper.insertNoticeAttachment(attachmentVoList);
        }

        return result1 * result2; //성공일 경우 :result1 ==1, result2 == 양수
    }


    public NoticeVo getNotice(String nno) {
        int result = mapper.increaseHit(nno);
        if (result != 1) {
            String errMsg = "NOTICE > SERVICE > 상세조회 > 조회수 증가 에러";
            log.error(errMsg);
            throw new IllegalStateException(errMsg);
        }
        return mapper.getNotice(nno);
    }

    public List<NoticeAttachmentVo> getAttachmentVoList(String nno) {
        return mapper.getAttachmentVoList(nno);
    }

    public int update(NoticeVo vo, List<String> changeNameList) {
        int result1 = mapper.update(vo);
        if (result1 != 1) {
            throw new IllegalStateException("ERROR ~ NOTICE > update > result1 error");    //Exception은 컴파일 - I~S~Exception은 런타임
        }
        int result2 = 1;
        if(!changeNameList.isEmpty()){
            result2 = mapper.updateNoticeAttachment(changeNameList, vo.getNo());
        }
        if (result2 < 1) {
            throw new IllegalStateException("ERROR ~ NOTICE > update > result2 error");
        }
        return result1 * result2;       //양수 성공 - 음수 실패 (업데이트 잘되면 1/인설트보드잘되면 1,2,3,...)
    }


    public int delAttachment(String ano) {
        return mapper.delAttachment(ano);
    }

    public int del(String nno) {
        return mapper.del(nno);
    }
}
