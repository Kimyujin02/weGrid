package com.kh.wegrid.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("crm")
public class CrmController {

    @GetMapping("list")
    private String list(){
        return "crm/list";
    }
}