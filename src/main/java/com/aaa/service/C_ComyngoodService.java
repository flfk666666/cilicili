package com.aaa.service;

import com.aaa.dao.C_ComyngoodDAO;
import com.aaa.entity.C_Comyngood;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class C_ComyngoodService {

    @Resource
    C_ComyngoodDAO c_comyngoodDAO;

    public int add(C_Comyngood c_comyngood){
        return c_comyngoodDAO.insert(c_comyngood);
    }

    //判断是否点赞过该评论
    public C_Comyngood queryByUidVcid(Integer uid,Integer vcid){
        return c_comyngoodDAO.queryByUidVcid(uid,vcid);
    }

    //根据vcid查询uid
    public List<Integer> queryUidByVcid(Integer vcid){
        return c_comyngoodDAO.queryUidByVcid(vcid);
    }
}
