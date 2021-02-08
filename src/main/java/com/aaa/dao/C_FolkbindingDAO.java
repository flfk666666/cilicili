package com.aaa.dao;

import com.aaa.entity.C_Folkbinding;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface C_FolkbindingDAO extends Mapper<C_Folkbinding> {

    //查询番剧的弹幕总数
    @Select("select count(*) from c_folkbinding where fid=#{param1}")
    Integer queryBarrageNumByfid(Integer fid);
}
