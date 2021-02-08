package com.aaa.dao;

import com.aaa.entity.C_YncomreplyGood;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C_YncomreplyGoodDAO extends Mapper<C_YncomreplyGood> {

    //判断是否点赞过该评论的回复
    @Select("select * from c_yncomreplygood where uid=#{param1} and vrid=#{param2}")
    C_YncomreplyGood queryByUidVrid(Integer uid, Integer vrid);

    //根据vrid查询uid
    @Select("select * from c_yncomreplygood where vrid=#{param1}")
    List<Integer> queryUidsByVrid(Integer vrid);
}
