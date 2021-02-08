package com.aaa.dao;

import com.aaa.entity.C_CollectionVideo;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface C_CollectionVideoDAO extends Mapper<C_CollectionVideo> {

    //查询此用户是否收藏此视频
    @Select("select * from c_collectionvideo where vid=#{param1} and uid=#{param2}")
    C_CollectionVideo selcoll(int vid,int uid);


    //查询此用户视频的收藏类型
    @Select("select * from c_collectionvideo where uid=#{uid} GROUP BY type")
    List<C_CollectionVideo> selcollvideo(int uid);

    //查询他人视频的收藏类型
    @Select("select * from c_collectionvideo where uid=#{uid} and openYN=0 GROUP BY type")
    List<C_CollectionVideo> seltrcollvideo(int uid);

    //取消收藏
    @Select("delete from c_collectionvideo where vid=#{param1} and uid=#{param2}")
    void delsc(int vid,int uid);

    //根据type查询收藏的视频
    @Select("select * from c_collectionvideo where uid=#{param1} and type = #{param2}")
    List<C_CollectionVideo> seltype(int uid,String type);

    //设置收藏视频的类型
    @Update("update c_collectionvideo set openYN=#{param1} where uid=#{param2} and vid=#{param3}")
    int upcolltype(int type,int uid,int vid);

    //修改收藏名字
    @Update("UPDATE c_collectionvideo set type=#{param1} where type=#{param2}")
    int upcolltypename(String type,String cvid);

}
