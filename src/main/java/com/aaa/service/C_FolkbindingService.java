package com.aaa.service;

import com.aaa.dao.C_FolkbindingDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class C_FolkbindingService {

    @Resource
    C_FolkbindingDAO c_folkbindingDAO;

    //查询番剧的弹幕总数
    public Integer queryBarrageNumByfid(Integer fid){
        return c_folkbindingDAO.queryBarrageNumByfid(fid);
    }
}
