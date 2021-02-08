package com.aaa.dao;

import com.aaa.entity.C_Creatoramount;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C_CreatoramountDAO extends Mapper<C_Creatoramount> {

    //根据uid查询已提现的总金额
    @Select("select sum(money) from c_creatoramount where uid=#{param1}")
    Integer queryTotalMoneyByUid(Integer uid);

    //根据uid查询提现记录
    @Select("select * from c_creatoramount where uid=#{param1} order by vtime desc")
    List<C_Creatoramount> queryByUid(Integer uid);
}
