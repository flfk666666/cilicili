package com.aaa.service;

import com.aaa.dao.C_FolkoperaDAO;
import com.aaa.entity.C_Folkopera;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class C_FolkoperaService {

    @Resource
    C_FolkoperaDAO c_folkoperaDAO;
    //查询所有番剧
    public List<C_Folkopera> findAll(){
        return c_folkoperaDAO.findAll();
    }
    //查询每周几更新的番剧
    public List<C_Folkopera> findByWorkup(String workup){
        return c_folkoperaDAO.findByWorkup(workup);
    }

    //根据点赞数查询番剧前8条
    public List<C_Folkopera> queryByFabulous(){
        return c_folkoperaDAO.queryByFabulous();
    }

    //根据播放量查询最热番剧，显示前8条
    public List<C_Folkopera> queryByPlaybackValue(){
        return c_folkoperaDAO.queryByPlaybackValue();
    }

    //根据fid查询最新番剧，显示前8条
    public List<C_Folkopera> queryByFid(){
        return c_folkoperaDAO.queryByFid();
    }

}
