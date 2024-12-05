package com.kh.wegrid.board.mapper;

import com.kh.wegrid.board.vo.BoardAttachmentVo;
import com.kh.wegrid.board.vo.BoardVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    //게시글 insert
    @Insert("""
                NO
                , WRITER_NO
                , DEPT_NO
                , TITLE
                , CONTENT
                , VIEW_CNT
                , ENROLL_DATE
                , NOTICE_YN
            )
            VALUES
            (
                SEQ_BOARD.NEXTVAL
                , #{id}
                , #{deptNo}
                , #{title}
                , #{content}
                , #{view_cnt}
                , SYSDATE
                , #{noticeYn}
            )
            """)
    int insert(BoardVo bvo);

    int insertBoardAttachment(List<BoardAttachmentVo> attachmentVoList);


}
