package com.aaa.service;

import com.aaa.dao.C_NewsDAO;
import com.aaa.entity.C_News;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class C_NewsService {

    @Resource
    C_NewsDAO c_newsDAO;
    public List<C_News> queryByUid(Integer uid){
        return c_newsDAO.queryByUid(uid);
    }
    public List<C_News> queryByUidAndType(Integer uid,String type){
        return c_newsDAO.queryByUidAndType(uid,type);
    }

    //充值
    public int Recharge(C_News c_news){
        return c_newsDAO.insert(c_news);
    }
    //根据uid和类型查询充值或消费消息
    public List<C_News> queryByUidAndTypeAndCon(Integer uid, String type,String ncontext){
        return c_newsDAO.queryByUidAndTypeAndCon(uid,type,ncontext);
    }

}
