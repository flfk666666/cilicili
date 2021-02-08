package com.aaa.service;

import com.aaa.dao.C_SubscribeDAO;
import com.aaa.entity.C_Subscribe;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class C_SubscribeService {
    @Resource
    C_SubscribeDAO c_subscribeDAO;

    public List<C_Subscribe> selsub(int uid){
        return c_subscribeDAO.selsub(uid);
    }

    //查询该番剧的追番人数
    public Integer queryCountByFid(Integer fid){
        return c_subscribeDAO.queryCountByFid(fid);
    }

}
