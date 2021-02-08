package com.aaa.dao;

import com.aaa.entity.C_Scoring;
import com.aaa.entity.HT_C_Scoring;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface HT_C_ScoringDAO extends tk.mybatis.mapper.common.Mapper<HT_C_Scoring> {
    @Select("select c.sid,u.uid,c.Fraction,f.fid,c.vtime,c.scoringcontext from c_scoring c,\n" +
            "c_useradmin u,c_folkopera f where f.fid=c.fid and u.uid=c.uid order by c.vtime desc")
    List<Map<String,Object>>findAll();
    @Delete("delete from c_scoring where sid=#{sid}")
    int Del(int sid);
    @Select("select * from c_scoring order by vtime desc limit 0,3")
    List<C_Scoring>findPage();
}
