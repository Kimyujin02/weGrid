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
    
    // 캘린더 데이터 불러오기
    @GetMapping("load")
    @ResponseBody
    public HashMap loadCalendar(String date,String type){
        System.out.println("컨트롤러 시작");
        System.out.println("date = " + date);
        System.out.println("type = " + type);
        HashMap map = new HashMap();

        List<EventVo> eventVoList = service.loadEvent(date,type);

        map.put("events",eventVoList);
        map.put("id",date+"_"+type);
        map.put("className",type+"_schedule");
        map.put( "textColor", "black");
        System.out.println("eventVoList = " + eventVoList);

        return map;
    }

    // 일정 상세정보 조회ByNo
    @GetMapping("detail")
    @ResponseBody
    public CalendarVo getScheduleByNo(String no, Model model){
        
        // service 호출
        CalendarVo vo = service.getScheduleByNo(no);
        model.addAttribute("calendarVo", vo);

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

        System.out.println("vo = " + vo);

        int result = service.write(vo);

        return result;
        
    }//write

    // 캘린더 항목 별 정보 조회
    @GetMapping("getTypeInfo")
    @ResponseBody
    public List<CalendarTypeVo> getTypeInfo(){
        return service.getTypeInfo();
    }//getTypeInfo

}//class
