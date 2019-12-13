package com.aaa.service;

import com.aaa.dao.C_BarrageHistoryDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class C_BarrageHistoryService {

    @Resource
    C_BarrageHistoryDAO c_barrageHistoryDAO;

    public List<Map<String,Object>> queryByUid(Integer uid){
        return c_barrageHistoryDAO.queryByUid(uid);
    }
}
