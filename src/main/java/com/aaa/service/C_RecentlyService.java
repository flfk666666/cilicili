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

    //添加播放历史
    public int addRecently(C_Recently c_recently){
        return c_recentlyDAO.insert(c_recently);
    }

    //判断是否存在
    public int pdRecently(int id,String type,int uid){
        return c_recentlyDAO.pdRecently(id, type, uid);
    }

    //如果存在就删删除之前的
    public int delRecently(int id,String type,int uid){
        return c_recentlyDAO.delRecently(id, type, uid);
    }


}
