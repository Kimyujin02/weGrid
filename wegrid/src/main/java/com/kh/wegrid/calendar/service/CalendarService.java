package com.kh.wegrid.calendar.service;

import com.kh.wegrid.calendar.mapper.CalendarMapper;
import com.kh.wegrid.calendar.vo.CalendarVo;
import com.kh.wegrid.calendar.vo.EventVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CalendarService {

    private final CalendarMapper mapper;

    public List<EventVo> loadEvent(int typeNo, String date) {
        return mapper.loadEvent(typeNo,date);
    }
}
