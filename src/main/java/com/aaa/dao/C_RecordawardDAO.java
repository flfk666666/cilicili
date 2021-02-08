package com.aaa.dao;

import com.aaa.entity.C_Recordaward;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface C_RecordawardDAO extends Mapper<C_Recordaward> {

    //根据uid查询获赏记录
    @Select("select cv.`*`,c.prices,c.datetime from c_recordaward c inner join c_video cv \n" +
            " on c.vid=cv.vid where c.uid=#{param1}")
    List<Map<String,Object>> queryByUid(Integer uid);

    //根据uid查询获赏总金额
    @Select("select sum(prices) from c_recordaward where uid=#{param1}")
    Integer queryTotalMoneyByUid(Integer uid);

    //判断是否打赏此视频
    @Select("select count(*) from C_Recordaward where vid=#{param1} and uid=#{param2}")
    int selrecordyn(int vid,int uid);
    //统计视频获赏总额
    @Select("select sum(prices) hsum from c_recordaward where vid=#{vid}")
    int selsumvideo(int vid);

}
