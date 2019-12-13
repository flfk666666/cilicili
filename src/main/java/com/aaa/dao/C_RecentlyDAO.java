package com.aaa.dao;

import com.aaa.entity.C_Recently;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C_RecentlyDAO extends Mapper<C_Recently> {

    //根据uid查询全部播放历史
    @Select("select * from c_recently where uid=#{param1} order by datetime desc")
    List<C_Recently> queryByUid(Integer uid);
    //根据uid和type查询播放历史
    @Select("select * from c_recently where uid=#{param1} and type=#{param2} \n" +
            "order by datetime desc")
    List<C_Recently> queryByUidAndType(Integer uid, String type);
}
