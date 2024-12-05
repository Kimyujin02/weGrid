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
    public void mainCalender(){}
    
    // 이벤트 데이터 불러오기
    @GetMapping("load")
    @ResponseBody
    public HashMap loadCalendar(String date,String type,int typeNo,HttpSession session){

        // 접속한 사원의 사번 정보 수집
//        MemberVo loginVo = (MemberVo)session.getAttribute("loginMemberVo");
//        String writerNo = loginVo.getNo();
        String writerNo = "1";

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
    public CalendarVo getScheduleByNo(String no, Model model){
        
        // service 호출
        CalendarVo vo = service.getScheduleByNo(no);
        model.addAttribute("calendarVo", vo);

        // 결과 반환
        return vo;

    }//getScheduleByNo

    // 일정 추가
    @PostMapping("write")
    @ResponseBody
    public int write(CalendarVo vo, HttpSession session){
        
        // 작성자의 사번 정보 수집
//        MemberVo loginVo = (MemberVo)session.getAttribute("loginMemberVo");
//        vo.setWriterNo(loginVo.getNo());
        vo.setWriterNo("1");
        // service 호출
        int result = service.write(vo);
        
        // 결과 반환
        return result;
        
    }//write

    // 일정 수정
    @PostMapping("edit")
    @ResponseBody
    public int edit(CalendarVo vo, HttpSession session){
        // 작성자의 사번 정보 수집
//        MemberVo loginVo = (MemberVo)session.getAttribute("loginMemberVo");
//        vo.setWriterNo(loginVo.getNo());
        vo.setWriterNo("1");
        // service 호출
        int result = service.edit(vo);

        // 결과 반환
        return result;

    }//edit

    // 일정 삭제
    @GetMapping("delete")
    @ResponseBody
    public int delete(String no, HttpSession session){

        // 접속한 사원의 사원정보 수집
//        MemberVo loginVo = (MemberVo)session.getAttribute("loginMemberVo");
//        String writerNo = loginVo.getNo();
        String writerNo = "1";

        int result = service.delete(no , writerNo);

        return result;
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
    
    // 캘린더 항목 별 정보 조회
    @GetMapping("getTypeInfo")
    @ResponseBody
    public List<CalendarTypeVo> getTypeInfo(){
        return service.getTypeInfo();
    }//getTypeInfo

}//class
