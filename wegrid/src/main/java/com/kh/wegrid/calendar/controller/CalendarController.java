package com.kh.wegrid.calendar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("calendar")
@RequiredArgsConstructor
public class CalendarController {

    @GetMapping("personal")
    public void personalCalender(){

    }

}
