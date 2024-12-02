package com.kh.wegrid.trip.controller;

import com.kh.wegrid.trip.service.TripService;
import com.kh.wegrid.trip.vo.TripVo;
import com.kh.wegrid.trip.vo.typeVo;
import com.kh.wegrid.util.page.PageVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

        System.out.println("vo = " + vo);
        int result = service.write(vo);

        return "redirect:/trip/list";
    }

    @GetMapping("list")
    public void list(Model model){
        List<typeVo> typeVoList = service.getTypeList();
        model.addAttribute("typeVoList" , typeVoList);

    }

    @GetMapping("list/data")
    @ResponseBody
    public HashMap getTripVoList(@RequestParam(name = "pno"
            , defaultValue = "1"
            , required = false) int currentPage
            , String searchType
            , String searchValue ){

        int listCount = service.getTripCnt(searchType , searchValue);
        int pageLimit = 5;
        int boardLimit = 15;
        PageVo pvo = new PageVo(listCount , currentPage , pageLimit , boardLimit);
        List<TripVo> tripVoList = service.getTripVoList(pvo , searchType , searchValue);
        HashMap map = new HashMap();
        map.put("a" , tripVoList);
        map.put("b" , pvo);

        System.out.println("pvo = " + pvo);

        return map;
    }
    @GetMapping("detail")
    public String detail(String tno , Model model){
        TripVo vo = service.detail(tno);
        List<typeVo> typeVoList = service.getTypeList();
        model.addAttribute("typeVoList" , typeVoList);

        String firstTwoAddress = vo.getRoadAddress().substring(0, 2);

        vo.setFirstTwoAddress(firstTwoAddress);
        model.addAttribute("tripVo" , vo);
        return "trip/detail";
    }



    @PostMapping("edit")
    public String edit(TripVo vo , Model model){

        TripVo tvo = service.edit(vo);
        String firstTwoAddress = tvo.getRoadAddress().substring(0, 2);
        tvo.setFirstTwoAddress(firstTwoAddress);
        model.addAttribute("tripVo" , tvo);

        return "trip/detail";
    }


}
