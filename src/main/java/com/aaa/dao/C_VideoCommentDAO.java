package com.aaa.dao;

import com.aaa.entity.C_VideoComment;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface C_VideoCommentDAO extends Mapper<C_VideoComment> {

    //根据vid查询视频评论
    @Select("select cc.*,cu.alias,cu.Grade,cu.Headimg from c_videocomment cc inner join c_useradmin cu\n" +
            "on cu.uid=cc.uid where cc.vid=#{param1}")
    List<Map<String,Object>> queryByVid(Integer vid);

    //根据vid查询视频总评论(该视频的评论和回复)
    @Select("select count(*)+sum(replyCounts) from(  \n" +
            "select cc.*,(select count(*)  from c_videoreply cr\n" +
            " where cr.vcid =cc.vcid ) replyCounts from  c_videocomment \n" +
            " cc where cc.vid=#{param1}\n" +
            " ) t")
    Integer queryGeneralCommentByVid(Integer vid);

    //根据vcid点赞评论
    @Update("update c_videocomment set good=good+1 where vcid=#{param1}")
    Integer updateGood(Integer vcid);
}
