package com.aaa.dao;

import com.aaa.entity.C_VideoClassification;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C_VideoClassificationDAO extends Mapper<C_VideoClassification> {
    //查询视频所有分类
    @Select("select * from c_videoclassification where state=0")
    List<C_VideoClassification> query();
}
