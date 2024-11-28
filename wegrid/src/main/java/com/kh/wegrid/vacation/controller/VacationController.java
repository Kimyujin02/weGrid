package com.kh.wegrid.vacation.controller;

import com.kh.wegrid.trip.service.TripService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequestMapping("vacation")
@RequiredArgsConstructor
public class VacationController {



    @GetMapping("enroll")
    public String enroll(){
        return "vacation/enroll";
    }

}
