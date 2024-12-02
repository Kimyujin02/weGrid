package com.kh.wegrid.calendar.service;

import com.kh.wegrid.calendar.mapper.CalendarMapper;
import com.kh.wegrid.calendar.vo.CalendarTypeVo;
import com.kh.wegrid.calendar.vo.CalendarVo;
import com.kh.wegrid.calendar.vo.EventVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CalendarService {

    private final CalendarMapper mapper;
    
    // 일정 추가
    public int write(CalendarVo vo){
        return mapper.write(vo);
    }//write

    // 이벤트 조회
    public List<EventVo> loadEvent(String date, int typeNo) {
        return mapper.loadEvent(date,typeNo);
    }//loadEvent
    
    // 캘린더 항목 별 정보 조회
    public List<CalendarTypeVo> getTypeInfo() {
        return mapper.getTypeInfo();
    }//getTypeInfo

}//class
