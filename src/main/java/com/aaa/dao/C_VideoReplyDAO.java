package com.aaa.dao;

import com.aaa.entity.C_VideoReply;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface C_VideoReplyDAO extends Mapper<C_VideoReply> {

    //根据vcid查询某条评论的回复
    @Select("select cr.*,cu.alias,cu.Grade,cu.Headimg from c_videoreply cr inner join c_useradmin cu\n" +
            "on cr.uid=cu.uid where cr.vcid=#{param1}")
    List<Map<String,Object>> query(Integer vcid);

    //根据vrid点赞评论的回复
    @Update("update c_videoreply set good=good+1 where vrid=#{param1}")
    Integer updateGood(Integer vrid);
}
