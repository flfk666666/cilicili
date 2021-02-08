package com.aaa.dao;

import com.aaa.entity.C_Video;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface HT_C_VideoDAO {
    @Select("select vid,vname,videocover,state,fabulous,playbackvalue from c_video order by vid desc")
    List<C_Video>findAll();
    @Update("update c_video set state=#{state} where vid=#{vid}")
    int doUpdate(C_Video c_video);
}
