package com.aaa.dao;

import com.aaa.entity.C_Folkopera;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C_FolkoperaDAO extends Mapper<C_Folkopera> {

    //查询最新番剧,根据fid倒叙，显示9条
    @Select("select * from c_folkopera  order by fid desc limit 0,9")
    List<C_Folkopera> findAll();
    //查询每周几更新的番剧,根据fid倒叙，显示9条
    @Select("select * from c_folkopera where workup like concat('%',#{param1},'%')  order by fid desc limit 0,9")
    List<C_Folkopera> findByWorkup(String workup);
    //根据点赞数查询番剧前8条
    @Select("select * from c_folkopera  order by Fabulous desc limit 0,8")
    List<C_Folkopera> queryByFabulous();
    //根据播放量查询最热番剧，显示前8条
    @Select("select * from c_folkopera  order by PlaybackValue desc limit 0,8")
    List<C_Folkopera> queryByPlaybackValue();
    //根据fid查询最新番剧，显示前8条
    @Select("select * from c_folkopera  order by fid desc limit 0,8")
    List<C_Folkopera> queryByFid();
}
