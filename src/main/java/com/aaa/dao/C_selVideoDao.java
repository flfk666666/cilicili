package com.aaa.dao;

import com.aaa.entity.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C_selVideoDao extends Mapper<C_Barrage> {

    //查询单个视频
    @Select("SELECT * from c_video where vid=#{vid}")
    C_Video selvideo(int vid);

    //查询视频弹幕
    @Select("select * from c_barrage where id in (select id from C_Barragebinding where vid=#{vid})")
    List<C_Barrage> selalldm(int vid);

    //查询最新添加的弹幕id
    @Select("select max(id) from c_barrage")
    int selnewdmid();

    //关联弹幕和视频
    @Insert("insert into c_barragebinding values(#{param1},#{param2});")
    int adddmvideo(int id,int vid);
    //添加历史弹幕表
    @Insert("insert into c_barragehistory values(#{id},#{text},#{uid},now());")
    int adduidolddm(C_BarrageHistory c_barrageHistory);
    //根据vid查询up主
    @Select("select * from c_useradmin where uid in (select uid from c_video where vid=#{vid})")
    C_UserAdmin selviduser(int vid);


    //查询视频相关推荐
    @Select("select cv.*,(SELECT uname from c_useradmin where uid=cv.uid) uname,(SELECT count(*) from c_barragebinding where vid=cv.vid) dmcount from c_video cv where vid !=#{vid} and vfid=(select vfid from c_video where vid=#{vid}) LIMIT 0,8")
    List<C_tjVideo> selxgvideo(int vid);


}
