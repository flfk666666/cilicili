package com.aaa.dao;

import com.aaa.entity.C_Scoring;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface C_ScoringDao extends Mapper<C_Scoring> {

    //点评
    @Insert("insert into c_scoring(uid,fraction,fid,uname,vtime,scoringcontext) values(#{uid},#{fraction},#{fid},#{uname},now(),#{scoringcontext})")
    public int adddp(C_Scoring c_scoring);

    //判断是否点评过
    @Select("SELECT * from C_Scoring where fid=#{param1} and uid=#{param2}")
    public C_Scoring seldpyn(int fid,int uid);

    //根据fid查找所有点评
    @Select("SELECT * from C_Scoring where fid=#{fid}")
    List<C_Scoring> selScoring(int fid);

    //根据fid查找所有点评
    @Select("SELECT c.*,(select Headimg from c_useradmin where uid=c.uid)himg from C_Scoring c where fid=#{fid} order by c.vtime desc")
    List<Map<String,Object>> selfjzxScoring(int fid);

}
