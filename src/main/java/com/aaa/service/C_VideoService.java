package com.aaa.service;

import com.aaa.dao.C_VideoDAO;
import com.aaa.entity.C_Video;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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



    //判断是否点赞
    public int seldzyn(int uid,int vid){
        return c_videoDAO.seldzyn(uid, vid);
    }
    //点赞
    public int insdz(int uid,int vid){
        return c_videoDAO.insdz(uid, vid);
    }
    //增加播放量
    public int addbfl(int vid){
        return c_videoDAO.addbfl(vid);
    }


    //根据用户查询视频
    public List<C_Video> queryByUid(Integer uid){
        return c_videoDAO.queryByUid(uid);
    }

    //根据uid和vid删除视频(把state改为1)
    public int updateVideoState(Integer uid,Integer vid){
        return c_videoDAO.updateVideoState(uid,vid);
    }
    //用户发布视频
    public int ReleaseVideo(C_Video c_video){
        return c_videoDAO.insert(c_video);
    }
    //根据uid查询视频总播放量
    public Integer queryPlaybackValueByUid(Integer uid){
        return c_videoDAO.queryPlaybackValueByUid(uid);
    }

    //根据点赞量倒叙查询前6条
    public List<Map<String,Object>> queryByFabulous(){
        return c_videoDAO.queryByFabulous();
    }

    //查询分类为广告，按点赞数倒叙前4条
    public List<Map<String,Object>> queryByFabulousAndVfid(){
        return c_videoDAO.queryByFabulousAndVfid();
    }

    public List<Map<String,Object>> qt_queryvaguevaname(String vname){
        return c_videoDAO.qt_queryvaguevaname(vname);
    }

    public  List<Map<String ,Object>> findC_Video(){
        return c_videoDAO.qt_findC_Video();
    }

    //查询每个视频分类的数量
    public Map<String,Object> queryCateNum(){
        return c_videoDAO.queryCateNum();
    }

    public List<Map<String,Object>> queryTop5(){
        return c_videoDAO.queryTop5();
    }

}
