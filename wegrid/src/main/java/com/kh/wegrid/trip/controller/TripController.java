package com.kh.wegrid.trip.controller;

import com.kh.wegrid.trip.service.TripService;
import com.kh.wegrid.trip.vo.TripVo;
import com.kh.wegrid.util.page.PageVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("trip")
@Slf4j
@RequiredArgsConstructor
public class TripController {

    private final TripService service;

    @PostMapping("write")
    public String write(TripVo vo , HttpSession session){


        int result = service.write(vo);

        return "redirect:/trip/list";
    }

    @GetMapping("list")
    public void list(){

    }

    @GetMapping("list/data")
    @ResponseBody
    public HashMap getTripVoList(int pno){

        int currentPage = pno;
        int listCount = service.getTripCnt();
        int pageLimit = 5;
        int boardLimit = 15;
        System.out.println(currentPage);
        PageVo pvo = new PageVo(listCount , currentPage , pageLimit , boardLimit);
        List<TripVo> tripVoList = service.getTripVoList(pvo);
        HashMap map = new HashMap();
        map.put("a" , tripVoList);
        map.put("b" , pvo);


        return map;
    }
    @GetMapping("detail")
    public void detail(){}
}




















