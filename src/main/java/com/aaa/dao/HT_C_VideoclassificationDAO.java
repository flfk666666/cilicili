package com.aaa.dao;

import com.aaa.entity.C_VideoClassification;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HT_C_VideoclassificationDAO extends tk.mybatis.mapper.common.Mapper<C_VideoClassification> {
    @Select("select * from c_videoclassification where state=0")
    List<C_VideoClassification>query();
    @Delete("delete from c_videoclassification where vfid=#{vfid}")
    int Del(int vfid);
}
