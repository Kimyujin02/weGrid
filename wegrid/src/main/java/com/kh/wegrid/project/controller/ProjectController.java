package com.kh.wegrid.project.controller;

import com.kh.wegrid.project.service.ProjectService;
import com.kh.wegrid.project.vo.EmployeeVo;
import com.kh.wegrid.project.vo.ProjectMemberVo;
import com.kh.wegrid.project.vo.ProjectVo;
import com.kh.wegrid.util.page.PageVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("project")
@RequiredArgsConstructor
@Slf4j
public class ProjectController {

    private final ProjectService service;

    //프로젝트 메인 화면(카드형식)
    @GetMapping("card")
    public String cardList(Model model, @RequestParam(name = "pno" , required = false, defaultValue = "1") int currentPage, String searchValue){

        // 페이징
        int listCount = service.getProjectCnt();
        int pageLimit = 5;
        int boardLimit = 8;

        PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);

        List<ProjectVo> voList = service.getCardList(pvo ,searchValue);
        model.addAttribute("voList", voList); // 화면에 보여주기 위해 model에 담아줌
        model.addAttribute("pvo", pvo);
        model.addAttribute("searchValue", searchValue); // 검색한 새로운 화면에서도 검색 값을 보여줌

        return "project/card";
    }

    //프로젝트 화면 (리스트 형식)
    @GetMapping("list")
    public String list(Model model, String no, @RequestParam(name = "pno" , required = false, defaultValue = "1") int currentPage, String searchValue) {
       // 프로젝트 정보 가져오기
        ProjectVo vo = service.getProjectByNo(no);
        model.addAttribute("vo", vo);


        // 페이징
        int listCount = service.getProjectCnt();
        int pageLimit = 5;
        int boardLimit = 11;

        PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);

        List<ProjectVo> voList = service.getProjectList(pvo ,searchValue);
        model.addAttribute("voList", voList); // 화면에 보여주기 위해 model에 담아줌
        model.addAttribute("pvo", pvo);
        model.addAttribute("searchValue", searchValue); // 검색한 새로운 화면에서도 검색 값을 보여줌

        return "project/list";
    }

    // 신규 프로젝트 생성 화면
    @GetMapping("create")
    public String create(){
        return "project/create";
    }

    // 사원 검색
    @GetMapping("/employee/search")
    @ResponseBody
    public List<EmployeeVo> searchEmployees(String query) {
        return service.searchEmployees(query);
    }

    // 신규 프로젝트 생성 호출(요청처리)
    @PostMapping("create")
    public String create(ProjectVo vo){
        System.out.println("vo = " + vo);

        // 서비스 호출
        int result = service.create(vo);

        // 결과 처리
        if(result > 0){
            return "redirect:/project/card";
        }else{
            return "redirect:/error";
        }
    }

    //프로젝트 정보 수정 화면 / update
    @GetMapping("edit")
    public String edit(){
        return "project/edit";
    }


    // 프로젝트 상세조회 화면 1 (참여인력 조회)
    @GetMapping("people")
    public String peopleList(Model model,String no, @RequestParam(name = "pno", defaultValue = "1") int currentPage) {
        ProjectVo vo = service.getProjectByNo(no);
        model.addAttribute("vo", vo);

        // 페이징 처리
        int listCount = service.getMemberCnt();
        int pageLimit = 5;
        int boardLimit = 13;

        PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);

        List<ProjectMemberVo> voList = service.getPeopleList(pvo); // projectNo를 넘겨줌
        model.addAttribute("voList", voList);
        model.addAttribute("pvo", pvo);

        return "project/people";
    }


    // 프로젝트 상세 조회 화면 2 (첨부파일 조회)
    @GetMapping("attach")
    public String attachList(Model model, String no){
        //AttachVo vo = service.get
        return "project/attach";
    }
}
