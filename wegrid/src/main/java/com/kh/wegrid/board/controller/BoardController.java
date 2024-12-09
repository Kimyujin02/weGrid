package com.kh.wegrid.board.controller;

import com.kh.wegrid.board.service.BoardService;
import com.kh.wegrid.board.vo.BoardAttachmentVo;
import com.kh.wegrid.board.vo.BoardVo;
import com.kh.wegrid.member.vo.MemberVo;
import com.kh.wegrid.member.vo.ReplyVo;
import com.kh.wegrid.util.FileUploader;
import com.kh.wegrid.util.page.PageVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @Value("#{pathInfo.getBoardAttachmentPath()}")
    private String path;

    @GetMapping("list")
    public String list(Model model, HttpSession session){

        if(session.getAttribute("loginMemberVo") == null){
            return "redirect:/member/login";
        }

        List<BoardVo> selectAllBoardList = service.getSelectAllBoardList();
        model.addAttribute("selectAllBoardList", selectAllBoardList);

        return "board/list";
    }



    // 게시글 목록 조회 (데이터)
    @GetMapping("list/data")
    @ResponseBody
    public HashMap getBoardVoList(HttpSession session,@RequestParam(name = "pno" , defaultValue = "1", required = false) int currentPage, String searchType, String searchTitleValue, String searchContentValue){

        // 로그인 여부 체크
        if (session.getAttribute("loginMemberVo") == null) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("message", "로그인이 필요합니다.");
            return map; // 로그인 안 되어 있으면 로그인 요청 메시지 반환
        }

        int listCount = service.getBoardCnt(searchType, searchTitleValue, searchContentValue);
        int pageLimit = 5;
        int boardLimit = 10;
        PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);

        List<BoardVo> boardVoList = service.getBoardVoList(pvo, searchType, searchTitleValue, searchContentValue);

        HashMap map = new HashMap();
        map.put("a", boardVoList);
        map.put("b", pvo);
        return map;

    }



    @GetMapping("insert")
    public String insert(HttpSession session){
        if(session.getAttribute("loginMemberVo") == null){
            return "redirect:/member/login";
        }
        return "board/insert";
    }

    @PostMapping("insert")
    public String insert(BoardVo bvo,
                         HttpSession session,
                         @RequestParam(name = "f", required = false) List<MultipartFile> fileList) throws IOException {

        // 파일 리스트가 null인 경우 빈 리스트로 초기화
        if (fileList == null) {
            fileList = new ArrayList<>();
        }

        List<String> changeNameList = new ArrayList<>();
        List<BoardAttachmentVo> attachmentVoList = new ArrayList<>();

        // 파일 처리
        for (MultipartFile f : fileList) {
            if (f.isEmpty()) continue; // 빈 파일이면 처리하지 않음
            String changeName = FileUploader.save(f, path);
            String originName = f.getOriginalFilename();

            BoardAttachmentVo attachVo = new BoardAttachmentVo();
            attachVo.setOriginName(originName);
            attachVo.setChangeName(changeName);

            attachmentVoList.add(attachVo);
        }

        // 로그인한 회원 정보
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        if (loginMemberVo == null) {
            return "redirect:/member/login"; // 로그인하지 않은 경우 리다이렉트
        }

        bvo.setWriterNo(loginMemberVo.getNo());
        bvo.setDeptNo(loginMemberVo.getDeptNo());


        // 서비스 호출
        int result = service.insert(bvo, attachmentVoList);
        if (result > 0) {
            return "redirect:/board/list";
        } else {
            return "redirect:/error";
        }
    }



    @GetMapping("detail")
    public String detail(HttpSession session, Model model, String bno){

        if(session.getAttribute("loginMemberVo") == null){
            return "redirect:/member/login";
        }

        BoardVo vo = service.getBoard(bno);
        List<BoardAttachmentVo> attachmentVoList = service.getAttachmentVoList(bno);
        model.addAttribute("vo", vo);
        model.addAttribute("attachmentVoList", attachmentVoList);

        return "board/detail";
    }


    @PostMapping("reply/write")
    @ResponseBody
    public int replyWrite(ReplyVo vo, HttpSession session){
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        vo.setWriterNo(loginMemberVo.getNo());
        int result = service.replyWrite(vo);
        return result;
    }

    //댓글 리스트 응답
    @GetMapping("reply/list")
    @ResponseBody
    public List<ReplyVo> getReplyList(String boardNo){
        List<ReplyVo> replyVoList = service.getReplyList(boardNo);
        return replyVoList;
    }

    //게시글 수정
    @GetMapping("edit")
    public void edit(Model model, String bno){
        BoardVo vo = service.getBoard(bno);
        List<BoardAttachmentVo> attachmentVoList = service.getAttachmentVoList(bno);
        model.addAttribute("vo", vo);
        model.addAttribute("attachmentVoList", attachmentVoList);
    }

    //게시글 수정
    @PostMapping("edit")
    public String edit(BoardVo vo, HttpSession session, @RequestParam(name = "f") List<MultipartFile> fileList) throws IOException {

        List<String> changeNameList = new ArrayList<>();
        for (MultipartFile f : fileList) {
            if (f.isEmpty()) {break;}
            String changeName = FileUploader.save(f, path);
            changeNameList.add(changeName);
        }

        service.update(vo, changeNameList);
        session.setAttribute("alertMsg", "게시글 수정 성공!");
        return "redirect:/board/list";
    }



    @PostMapping("attachment/del")
    @ResponseBody
    public int delAttachment(String ano, String fileName){
        log.info("======삭제되는 파일 정보======");
        log.info("ano = " + ano);
        log.info("fileName = " + fileName);

        // 첨부파일 삭제
        int result = service.delAttachment(ano);

        // 파일 삭제 (파일 시스템에서)
        File file = new File(path + fileName);
        if (file.exists()) {
            file.delete();
        }

        return result;
    }

    //게시글 삭제
    @GetMapping("del")
    public String del(String bno, HttpSession session){
        int result = service.del(bno);

        if (result != 1) {
            throw new IllegalStateException("게시글 삭제 실패");
        }

        session.setAttribute("alertMsg",    "게시글 삭제 성공");
        return "redirect:/board/list";
    }

}

