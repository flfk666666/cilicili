package com.aaa.dao;

import com.aaa.entity.C_Subscribe;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C_SubscribeDAO extends Mapper<C_Subscribe> {

    //根据uid查询用户追的番剧
    @Select("select * from C_Subscribe where uid=#{uid}")
    List<C_Subscribe> selsub(int uid);


    //查询该番剧的追番人数
    @Select("select count(*) from c_subscribe where fid=#{param1}")
    Integer queryCountByFid(Integer fid);
}
