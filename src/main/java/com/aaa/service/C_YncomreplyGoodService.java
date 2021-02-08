package com.aaa.service;

import com.aaa.dao.C_YncomreplyGoodDAO;
import com.aaa.entity.C_YncomreplyGood;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class C_YncomreplyGoodService {

    @Resource
    C_YncomreplyGoodDAO c_yncomreplyGoodDAO;

    public int add(C_YncomreplyGood c_yncomreplyGood){
        return c_yncomreplyGoodDAO.insert(c_yncomreplyGood);
    }
    //判断是否点赞过该评论的回复
    public C_YncomreplyGood queryByUidVrid(Integer uid,Integer vrid){
        return c_yncomreplyGoodDAO.queryByUidVrid(uid,vrid);
    }

    //根据vrid查询uid
    public List<Integer> queryUidsByVrid(Integer vrid){
        return c_yncomreplyGoodDAO.queryUidsByVrid(vrid);
    }
}
