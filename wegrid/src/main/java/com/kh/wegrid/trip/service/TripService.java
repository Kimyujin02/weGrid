package com.kh.wegrid.trip.service;

import com.kh.wegrid.trip.mapper.TripMapper;
import com.kh.wegrid.trip.vo.TripVo;
import com.kh.wegrid.util.page.PageVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class TripService {

    private final TripMapper mapper;

    public int write(TripVo vo) {
        int result = mapper.write(vo);

        if(result == 1){
            return result;
        }else{
            throw new IllegalStateException("출장등록 실패...");
        }

    }

    public List<TripVo> getTripVoList(PageVo pvo, String searchType, String searchValue) {
        return mapper.getTripVoList(pvo , searchType , searchValue);
    }

    public int getTripCnt(String searchType, String searchValue) {
        return mapper.getTripCnt( searchType , searchValue );
    }

    public TripVo detail(String tno) {
        return mapper.detail(tno);
    }
}
