package com.kh.wegrid.businessTrip.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("trip")
@Slf4j
@RequiredArgsConstructor
public class BusinessController {

    @GetMapping("list")
    public void list(){

    }
    @GetMapping("detail")
    public void detail(){}
}
