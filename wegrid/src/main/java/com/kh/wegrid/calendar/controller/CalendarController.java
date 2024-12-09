package com.kh.wegrid.calendar.controller;

import com.kh.wegrid.calendar.service.CalendarService;
import com.kh.wegrid.calendar.vo.CalendarTypeVo;
import com.kh.wegrid.calendar.vo.CalendarVo;
import com.kh.wegrid.calendar.vo.EventVo;
import com.kh.wegrid.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("calendar")
@RequiredArgsConstructor
@Slf4j
public class CalendarController {

    private final CalendarService service;

    // 캘린더 화면으로 이동
    @GetMapping("mainCalendar")
    public String mainCalender(HttpSession session){
        // 접속한 사원의 사번 정보 수집
        MemberVo loginVo = (MemberVo)session.getAttribute("loginMemberVo");
        if(loginVo == null) {
            session.setAttribute("alertMsg","옳바르지 않은 접근 입니다. 로그인화면으로 이동합니다.");
            return "redirect:/member/login";
        }

        return "calendar/mainCalendar";

    }
    
    // 이벤트 데이터 불러오기
    @GetMapping("load")
    @ResponseBody
    public HashMap loadCalendar(String date,String type,int typeNo,HttpSession session){

        // 접속한 사원의 사번 정보 수집
        MemberVo loginVo = (MemberVo)session.getAttribute("loginMemberVo");
        String writerNo = loginVo.getNo();

        // service 호출
        List<EventVo> eventVoList = service.loadEvent(date,type,typeNo,writerNo);
        
        // 결과 변수 생성
        HashMap map = new HashMap();
        map.put("events",eventVoList);
        map.put("id",date+"-"+type);
        map.put("className",type+"-schedule");
        map.put( "textColor", "black");
        
        // 결과 반환
        return map;

    }//loadCalendar

    // 일정 상세정보 조회ByNo
    @GetMapping("detail")
    @ResponseBody
    public HashMap getScheduleByNo(String no,HttpSession session, Model model){

        // 접속한 사원의 사번 정보 수집
        MemberVo loginVo = (MemberVo)session.getAttribute("loginMemberVo");
        String writerNo = loginVo.getNo();
        
        // 검색 정보 배열 저장
        String[] searchKey = no.split("_");

        // service 호출
        CalendarVo vo = service.getScheduleByNo(searchKey,writerNo);

        HashMap map = new HashMap();
        map.put("vo",vo);
        map.put("loginInfo",loginVo);

        // 결과 반환
        return map;

    }//getScheduleByNo

    // 일정 추가
    @PostMapping("write")
    @ResponseBody
    public String write(CalendarVo vo, HttpSession session){

        // 접속한 사원의 사번 정보 수집
        MemberVo loginVo = (MemberVo)session.getAttribute("loginMemberVo");
        if(loginVo == null) {
            session.setAttribute("alertMsg","옳바르지 않은 접근 입니다. 로그인화면으로 이동합니다.");
            return "redirect:/member/login";
        }
        vo.setWriterNo(loginVo.getNo());

        // service 호출
        int result = service.write(vo);

        // 결과 반환
        if (result == 1){
            return "success";
        }else{
            return "fail";
        }
        
    }//write

    // 일정 수정
    @PostMapping("edit")
    @ResponseBody
    public String edit(CalendarVo vo, HttpSession session){

        // 작성자의 사번 정보 수집
        MemberVo loginVo = (MemberVo)session.getAttribute("loginMemberVo");
        if(loginVo == null) {
            session.setAttribute("alertMsg","옳바르지 않은 접근 입니다. 로그인화면으로 이동합니다.");
            return "redirect:/member/login";
        }
        vo.setWriterNo(loginVo.getNo());

        // service 호출
        int result = service.edit(vo);

        // 결과 반환
        if (result == 1){
            return "success";

        }else{
            return "fail";
        }

    }//edit

    // 일정 삭제
    @GetMapping("delete")
    @ResponseBody
    public String delete(String no, HttpSession session){

        // 접속한 사원의 사원정보 수집
        MemberVo loginVo = (MemberVo)session.getAttribute("loginMemberVo");
        if(loginVo == null) {
            session.setAttribute("alertMsg","옳바르지 않은 접근 입니다. 로그인화면으로 이동합니다.");
            return "redirect:/member/login";
        }
        String writerNo = loginVo.getNo();
        
        // service 호출
        int result = service.delete(no , writerNo);

        // 결과 반환
        if (result == 1){
            return "success";

        }else{
            return "fail";
        }

    }//delete

    // 캘린더 항목 , 일정종류 정보 조회
    @GetMapping("calendarInfo")
    @ResponseBody
    public HashMap getCalendarInfo(){

        // service 호출
        HashMap map = service.getCalendarInfo();

        // 결과 반환
        return map;

    }//getCalendarInfo

}//class
