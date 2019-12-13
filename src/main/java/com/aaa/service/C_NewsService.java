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
}
