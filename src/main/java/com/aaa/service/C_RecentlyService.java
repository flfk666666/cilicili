package com.aaa.service;

import com.aaa.dao.C_RecentlyDAO;
import com.aaa.entity.C_Recently;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class C_RecentlyService {

    @Resource
    C_RecentlyDAO c_recentlyDAO;
    //根据uid查询全部播放历史
    public List<C_Recently> queryByUid(Integer uid){
        return c_recentlyDAO.queryByUid(uid);
    }

    //根据uid和type查询播放历史
    public List<C_Recently> queryByUidAndType(Integer uid,String type){
        return c_recentlyDAO.queryByUidAndType(uid,type);
    }
}
