package com.kh.wegrid.vacation.service;

import com.kh.wegrid.vacation.mapper.VacationMapper;
import com.kh.wegrid.vacation.vo.VacationVo;
import com.kh.wegrid.vacation.vo.VacationVo1;
import com.kh.wegrid.vacation.vo.VacationVo2;
import com.kh.wegrid.vacation.vo.VacationVo3;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class VacationService {

    @Autowired
    private final VacationMapper mapper;


    public List<VacationVo1> getSelectAllVacationList() {
        return mapper.getSelectAllVacationList();
    }

    public int insertNewVacation(VacationVo vo) {
        return mapper.insertNewVacation(vo);
    }

    public List<VacationVo2> getSelectPersonalCnt(){
        return mapper.getSelectPersonalCnt();
    }


    public List<VacationVo3> getSelectPersonalCntInfo(String mno) {
        return mapper.getSelectPersonalCntInfo(mno);
    }


//    public int updateVacation(VacationVo vo) {
//        return mapper.updateVacation(vo);
//    }
}