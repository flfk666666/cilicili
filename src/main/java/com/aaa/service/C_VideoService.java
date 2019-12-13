package com.aaa.service;

import com.aaa.dao.C_VideoDAO;
import com.aaa.entity.C_Video;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class C_VideoService {


    @Resource
    C_VideoDAO c_videoDAO;

    //查询最热投稿
    public List<C_Video> queryByVcnamePlaybackValue(String vcname){
        return c_videoDAO.queryByVcnamePlaybackValue(vcname);
    }

    //查询最新投稿
    public List<C_Video> queryByVcnameVtime(String vcname){
        return c_videoDAO.queryByVcnameVtime(vcname);
    }

    //根据点赞量,查询热门投稿
    public List<C_Video> queryByVcnameFabulous(String vcname){
        return c_videoDAO.queryByVcnameFabulous(vcname);
    }
}
