package com.aaa.dao;

import com.aaa.entity.C_News;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C_NewsDAO extends Mapper<C_News> {

    //根据uid查询全部消息
    @Select("select * from c_news where uid=#{param1} order by datetime desc,nid desc")
    List<C_News> queryByUid(Integer uid);
    //根据uid和类型查询消息
    @Select("select * from c_news where uid=#{param1} and type=#{param2} order by datetime desc,nid desc")
    List<C_News> queryByUidAndType(Integer uid, String type);

    //根据uid和类型查询充值或消费消息
    @Select("select * from c_news where uid=#{param1} and type=#{param2}\n" +
            "and ncontext like concat('%',#{param3},'%') order by datetime desc,nid desc")
    List<C_News> queryByUidAndTypeAndCon(Integer uid, String type, String ncontext);
}
