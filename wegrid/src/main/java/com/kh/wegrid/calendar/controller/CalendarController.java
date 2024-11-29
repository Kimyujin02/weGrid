package com.kh.wegrid.calendar.controller;

import com.kh.wegrid.calendar.service.CalendarService;
import com.kh.wegrid.calendar.vo.CalendarVo;
import com.kh.wegrid.calendar.vo.EventVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
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
    public HashMap loadCalendar(int typeNo,String date){

        HashMap map = new HashMap();

        List<EventVo> eventVoList = service.loadEvent(typeNo,date);
        map.put("events",eventVoList);
        map.put("id","personal");
        map.put("color","#ABE1FF");
        System.out.println("eventVoList = " + eventVoList);

        return map;
    }

    @PostMapping("write")
    public void write(CalendarVo vo){

    }

}
