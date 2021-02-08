package com.aaa.dao;

import com.aaa.entity.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface C_selFolkDao {

    //查看当前番剧
    @Select("select * from c_folkopera where fid=#{fid}")
    C_Folkopera selfolk(int fid);
    //查看番剧当前级数
    @Select("select * from c_folknumber where fid=#{fid}")
    List<C_Folknumber> selfolknumber(int fid);
    //查看当前集数
    @Select("select * from c_folknumber where fid=#{param1} and fnumber=#{param2}")
    C_Folknumber selfonenumber(int fid,int fnumber);

    //查询番剧弹幕
    @Select("select * from c_barrage where id in (SELECT id from C_Folkbinding where fid=#{param1} and fnumber=#{param2})")
    List<C_Barrage> selfolkdm(int fid,int fnumber);

    //弹幕和番剧添加关联
    @Insert("insert into c_folkbinding values (#{id},#{fid},#{fnumber})")
    int adddmfolk(C_Folkbinding c_folkbinding);

    //查看番剧相关推荐
    //查看番剧相关推荐
    @Select("select f.*,(select count(*) from c_folkbinding where fid=f.fid) cdm \n" +
            "from c_folkopera f where f.fid!=#{param1} and f.state='已上架'  LIMIT 0,8")
    List<Map<String,Object>> selxgfolk(Integer fid);

    //判断是否已追番
    @Select("select * from c_subscribe where uid=#{param1} and fid=#{param2}")
    C_Subscribe selzfyn(int uid,int fid);
    //追番
    @Insert("insert into c_subscribe(fid,uid,openYN,folkcover,folkintroduction,folkname,datetime) VALUES(#{fid},#{uid},#{openYN},#{folkcover},#{folkintroduction},#{folkname},now())")
    int zffolk(C_Subscribe c_subscribe);

    //取消追番
    @Delete("delete FROM c_subscribe WHERE fid=#{param1} and uid=#{param2}")
    int delzffolk(int fid,int uid);

    //查询番剧总弹幕
    @Select("select count(*) from c_folkbinding where fid=#{fid}")
    int folkdmcount(int fid);




}
