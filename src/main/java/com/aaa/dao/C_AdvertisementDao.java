package com.aaa.dao;

import com.aaa.entity.C_Advertisement;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C_AdvertisementDao extends Mapper<C_Advertisement> {


    //查询广告位
    @Select("select * from c_advertisement")
    List<C_Advertisement> seladvert();

    //修改广告位
    @Update("UPDATE c_advertisement set atitle=#{atitle},aurl=#{aurl},aimg=#{aimg},type=#{type} where aid=#{aid}")
    int upadvert(C_Advertisement c_advertisement);

}
