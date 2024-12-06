package com.kh.wegrid.board.service;

import com.kh.wegrid.board.mapper.BoardMapper;
import com.kh.wegrid.board.vo.BoardAttachmentVo;
import com.kh.wegrid.board.vo.BoardVo;
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
    public List<BoardVo> getBoardVoList(PageVo pvo, String searchType, String searchValue) {
        return mapper.getBoardVoList(pvo, searchType, searchValue);
    }

    //게시판 검색
    public int getBoardCnt(String searchType, String searchValue) {
        return mapper.getBoardCnt(searchType, searchValue);
    }

}
