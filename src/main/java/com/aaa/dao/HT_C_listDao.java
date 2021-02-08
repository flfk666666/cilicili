package com.aaa.dao;

import com.aaa.entity.C_list;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HT_C_listDao extends Mapper<C_list> {
    @Select("select * from c_list where ljoin=\n" +
            "(\n" +
            "select identity from c_userAdmin where uid=#{param1}\n" +
            ")")
    List<C_list> ht_findAll(Integer uid);

}
