package com.kh.wegrid.trip.service;

import com.kh.wegrid.trip.mapper.TripMapper;
import com.kh.wegrid.trip.vo.TripVo;
import com.kh.wegrid.trip.vo.typeVo;
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
        return mapper.write(vo);
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

    public TripVo edit(TripVo vo) {

        if(mapper.edit(vo) == 1){
            return mapper.editDetail(vo);
        }else {
            throw new IllegalStateException("수정 실패...");
        }
//        return mapper.edit(vo);


    }

    public List<typeVo> getTypeList() {
        return mapper.getTypeList();
    }

    public int delete(String no) {
        return mapper.delete(no);
    }

    public List<TripVo> getEndTripVoList(PageVo pvo, String searchType, String searchValue) {
        return mapper.getEndTripVoList(pvo , searchType , searchValue);
    }

    public int getEndTripCnt(String searchType, String searchValue) {
        return mapper.getEndTripCnt(searchType , searchValue);
    }
}
