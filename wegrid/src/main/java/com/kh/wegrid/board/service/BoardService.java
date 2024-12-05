package com.kh.wegrid.board.service;

import com.kh.wegrid.board.mapper.BoardMapper;
import com.kh.wegrid.board.vo.BoardAttachmentVo;
import com.kh.wegrid.board.vo.BoardVo;
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
}
