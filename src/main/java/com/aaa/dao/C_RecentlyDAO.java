package com.aaa.dao;

import com.aaa.entity.C_Recently;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface C_RecentlyDAO extends Mapper<C_Recently> {

    //根据uid查询全部播放历史
    @Select("select * from c_recently where uid=#{param1} order by crid desc")
    List<C_Recently> queryByUid(Integer uid);
    //根据uid和type查询播放历史
    @Select("select * from c_recently where uid=#{param1} and type=#{param2} \n" +
            "order by crid desc")
    List<C_Recently> queryByUidAndType(Integer uid, String type);

    //判断是否存在播放历史记录里
    @Select("select count(*) from C_Recently where id=#{param1} and type=#{param2} and uid=#{param3}")
    int pdRecently(int id,String type,int uid);

    //删除视频
    @Delete("DELETE from c_recently where id=#{param1} and type=#{param2} and uid=#{param3}")
    int delRecently(int id,String type,int uid);





}
