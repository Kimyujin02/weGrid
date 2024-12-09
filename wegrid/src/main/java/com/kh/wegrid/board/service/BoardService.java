package com.kh.wegrid.board.service;

import com.kh.wegrid.board.mapper.BoardMapper;
import com.kh.wegrid.board.vo.BoardAttachmentVo;
import com.kh.wegrid.board.vo.BoardVo;
import com.kh.wegrid.member.vo.ReplyVo;
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
public class BoardService {

    private final BoardMapper mapper;

    public int insert(BoardVo bvo, List<BoardAttachmentVo> attachmentVoList) {
        int result1 = mapper.insert(bvo);
        int result2 = 1;
        if (attachmentVoList.size() > 0) {
            result2 = mapper.insertBoardAttachment(attachmentVoList);
        }

        return result1 * result2; //성공일 경우 :result1 ==1, result2 == 양수
    }


    public List<BoardVo> getSelectAllBoardList() {
        return mapper.getSelectAllBoardList();
    }



    //게시판 페이징
    public List<BoardVo> getBoardVoList(PageVo pvo, String searchType, String searchTitleValue, String searchContentValue) {
        return mapper.getBoardVoList(pvo, searchType, searchTitleValue, searchContentValue);
    }

    //게시판 검색
    public int getBoardCnt(String searchType, String searchTitleValue, String searchContentValue) {
        return mapper.getBoardCnt(searchType, searchTitleValue, searchContentValue);
    }


    public BoardVo getBoard(String bno) {
        int result = mapper.increaseHit(bno);
        if (result != 1) {
            String errMsg = "BOARD > SERVICE > 상세조회 > 조회수 증가 에러";
            log.error(errMsg);
            throw new IllegalStateException(errMsg);
        }
        return mapper.getBoard(bno);
    }

    public List<BoardAttachmentVo> getAttachmentVoList(String bno) {
        return mapper.getAttachmentVoList(bno);
    }
    
    public int replyWrite(ReplyVo vo) {
        return mapper.replyWrite(vo);
    }

    public List<ReplyVo> getReplyList(String boardNo) {
        return mapper.getReplyList(boardNo);
    }


    public int update(BoardVo vo, List<String> changeNameList) {
        int result1 = mapper.update(vo);
        if (result1 != 1) {
            throw new IllegalStateException("ERROR ~ BOARD > update > result1 error");    //Exception은 컴파일 - I~S~Exception은 런타임
        }
        int result2 = 1;
        if(!changeNameList.isEmpty()){
            result2 = mapper.updateBoardAttachment(changeNameList, vo.getNo());
        }
        if (result2 < 1) {
            throw new IllegalStateException("ERROR ~ BOARD > update > result2 error");
        }
        return result1 * result2;       //양수 성공 - 음수 실패 (업데이트 잘되면 1/인설트보드잘되면 1,2,3,...)
    }

    public int del(String bno) {
        return mapper.del(bno);
    }

    public int delAttachment(String ano) {
        return mapper.delAttachment(ano);
    }


}
