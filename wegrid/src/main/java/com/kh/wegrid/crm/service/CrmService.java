package com.kh.wegrid.crm.service;

import com.kh.wegrid.crm.mapper.CrmMapper;
import com.kh.wegrid.crm.vo.ClientRankVo;
import com.kh.wegrid.crm.vo.ClientStatusVo;
import com.kh.wegrid.crm.vo.ClientVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CrmService {

    private final CrmMapper mapper;

    public List<ClientVo> getClientVoList() {
        return mapper.getClientVoList();
    }

    public List<ClientRankVo> getClientRankVoList() {
        return mapper.getClientRankVoList();
    }

    public List<ClientStatusVo> getClientStatusVoList() {
        return mapper.getClientStatusVoList();
    }

    public List<ClientVo> getClientVoList(String searchType, String searchValue) {
        return mapper.getClientVoList(searchType, searchValue);
    }
}
