package com.kh.wegrid.approval.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("approval")
public class ApprovalController {

    @GetMapping("write")
    public void write(){

    }
    @GetMapping("submitList")
    public void submitList(){}

    @GetMapping("receiveList")
    public void receiveList(){}

}
