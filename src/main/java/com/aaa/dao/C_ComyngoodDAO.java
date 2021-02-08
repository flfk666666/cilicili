package com.aaa.dao;

import com.aaa.entity.C_Comyngood;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C_ComyngoodDAO extends Mapper<C_Comyngood> {

    //判断是否点赞过该评论
    @Select("select * from c_comyngood where uid=#{param1} and vcid=#{param2}")
    C_Comyngood queryByUidVcid(Integer uid, Integer vcid);

    //根据vcid查询uid
    @Select("select uid from c_comyngood where vcid=#{param1}")
    List<Integer> queryUidByVcid(Integer vcid);
}
