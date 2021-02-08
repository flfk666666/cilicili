package com.aaa.service;

import com.aaa.dao.C_CreatoramountDAO;
import com.aaa.entity.C_Creatoramount;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class C_CreatoramountService {
    @Resource
    C_CreatoramountDAO c_creatoramountDAO;
    //根据uid查询提现记录
    public List<C_Creatoramount> queryByUid(Integer uid){
        return c_creatoramountDAO.queryByUid(uid);
    }

    //根据uid查询已提现的总金额
    public Integer queryTotalMoneyByUid(Integer uid){
        return c_creatoramountDAO.queryTotalMoneyByUid(uid);
    }
    //提现
    public int add(C_Creatoramount c_creatoramount){
        return c_creatoramountDAO.insert(c_creatoramount);
    }
}
