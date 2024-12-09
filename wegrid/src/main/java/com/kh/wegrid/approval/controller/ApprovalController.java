package com.kh.wegrid.approval.controller;

import com.kh.wegrid.approval.service.ApprovalService;
import com.kh.wegrid.approval.vo.ApprovalAttachmentVo;
import com.kh.wegrid.approval.vo.ApprovalVo;
import com.kh.wegrid.approval.vo.DeptVo;
import com.kh.wegrid.approval.vo.MemberListVo;
import com.kh.wegrid.member.vo.MemberVo;
import com.kh.wegrid.util.FileUploader;
import com.kh.wegrid.util.page.PageVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("approval")
@RequiredArgsConstructor
@Slf4j
public class ApprovalController {

    @Value("#{pathInfo.getApprovalAttachmentPath}")
    private String path;

    private final ApprovalService service;

    @GetMapping("write")
    public void write(){

    }

    @PostMapping("write")
    public String write(ApprovalVo avo , HttpSession session
    ,@RequestParam(name = "approvalAttachment") List<MultipartFile> fileList ) throws IOException {


        List<String> changNameList = new ArrayList<>();
        ApprovalAttachmentVo attachVo = new ApprovalAttachmentVo();
        List<ApprovalAttachmentVo> attachmentVoList = new ArrayList<>();

        for(MultipartFile f : fileList){
            if(f.isEmpty()){break;}
            String changeName = FileUploader.save(f , path);
            String originName = f.getOriginalFilename();

            attachVo.setOriginName(originName);
            attachVo.setChangeName(changeName);

            attachmentVoList.add(attachVo);
//            changNameList.add(changeName);
//            changNameList.add(originName);
        }

        MemberVo loginMemverVo = (MemberVo) session.getAttribute("loginMemberVo");
        avo.setWriterNo(loginMemverVo.getNo());



        int result = service.insertApproval(avo , attachmentVoList);

        if(result>0){
            session.setAttribute("alertMsg" , "결재등록이 완료되었습니다.");
            return "redirect:/approval/submitList";
        }else{
            return "redirect:/error";
        }

    }
    @GetMapping("submitList")
    public void submitList(){}

    @GetMapping("submitList/data")
    @ResponseBody
    public HashMap getSubmitList(@RequestParam(name = "pno"
            , defaultValue = "1"
            , required = false) int currentPage
            , String statusFilter
            , HttpSession session){
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String no = loginMemberVo.getNo();

        int listCount = service.getSubmitApprovalCnt( no , statusFilter);
        int pageLimit = 5;
        int boardLimit = 15;
        PageVo pvo = new PageVo(listCount , currentPage , pageLimit , boardLimit);
        List<ApprovalVo> submitApprovalVoList = service.getSubmitApprovalVoList(pvo ,statusFilter ,no );
        HashMap map = new HashMap();
        map.put("a" , submitApprovalVoList);
        map.put("b" , pvo);



        return map;
    }

    @GetMapping("receiveList")
    public void receiveList(){}

    @GetMapping("receiveList/data")
    @ResponseBody
    public HashMap getreceiveList(@RequestParam(name = "pno"
            , defaultValue = "1"
            , required = false) int currentPage
            , String statusFilter
            , HttpSession session){
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String no = loginMemberVo.getNo();

        int listCount = service.getreceiveApprovalCnt( no , statusFilter);
        int pageLimit = 5;
        int boardLimit = 15;
        PageVo pvo = new PageVo(listCount , currentPage , pageLimit , boardLimit);
        List<ApprovalVo> receiveApprovalVoList = service.getReceiveApprovalVoList(pvo ,statusFilter ,no );
        HashMap map = new HashMap();
        map.put("a" , receiveApprovalVoList);
        map.put("b" , pvo);



        return map;
    }

    @GetMapping("detail")
    public String detail(String ano , Model model){
        List<ApprovalAttachmentVo> attachList = service.attDetail(ano);
        ApprovalVo avo = service.approvalDetail(ano);

        model.addAttribute("attVoList" , attachList);
        model.addAttribute("avo" , avo);
        System.out.println("avo = " + avo);


        return "approval/detail";
    }

    @GetMapping("/download")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@RequestParam String changeName) {
        try {
            // 파일 경로 생성
            Path filePath = Paths.get(path).resolve(changeName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            // 파일이 존재하고 읽을 수 있는지 확인
            if (resource.exists() && resource.isReadable()) {
                // 응답 헤더 설정: 파일 이름을 원본 이름으로 설정
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build(); // 파일이 없으면 404 반환
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build(); // 에러 발생 시 500 반환
        }
    }

    @GetMapping("emp/list/data")
    @ResponseBody
    public HashMap empList(@RequestParam(name = "pno"
            , defaultValue = "1"
            , required = false) int currentPage
            , String searchType
            , String searchValue){

        List<DeptVo> deptVoList = service.getDeptVoList();
        int listCount = service.getEmpListCnt(searchType , searchValue);
        int pageLimit = 5;
        int boardLimit = 10;
        PageVo pvo = new PageVo(listCount , currentPage , pageLimit , boardLimit);
        System.out.println("searchValue = " + searchValue);
        List<MemberListVo> memberVoList = service.getEmpVoList( pvo , searchType , searchValue);
        System.out.println("memberVoList = " + memberVoList);

        HashMap map = new HashMap();
        map.put("a",memberVoList);
        map.put("b",pvo);
        map.put("c",deptVoList);


        return map;

    }
    @PostMapping("delete")
    public String delete(String no , HttpSession session){

        int result = service.deleteApproval(no);

        return "approval/submitList";
    }

    @PostMapping("mline/allow")
    public String middelAllow(String no , HttpSession session){

        int result = service.middleAllow(no);
        return "approval/receiveList";

    }
    @PostMapping("mline/companion")
    public String middleCompanion(String no , HttpSession session){
        int result = service.middleCompanion(no);
        return "approval/receiveList";
    }
    @PostMapping("lline/allow")
    public String lastAllow(String no , HttpSession session){
        int result = service.lastAllow(no);
        return "approval/receiveList";
    }
    @PostMapping("lline/companion")
    public String lastCompanion(String no , HttpSession session){
        int result = service.lastCompanion(no);
        return "approval/receiveList";
    }



}
